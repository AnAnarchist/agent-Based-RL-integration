import IPython

import tensorflow as tf
import numpy as np
import random
import ast
from abc import ABC, abstractmethod

from tf_agents.environments import tf_py_environment
from tf_agents.replay_buffers import tf_uniform_replay_buffer
from tf_agents.trajectories import trajectory
from tf_agents.utils import common
from tf_agents.specs import array_spec
from tf_agents.policies import random_tf_policy

from generic_environment import GenericEnv

tf.compat.v1.enable_v2_behavior()

class GenericTfAgent(ABC):
  def __init__(self, action_specification, observation_specification, initial_state, params={}):
    #params
    self.replay_buffer_capacity = int(params.get('replay_buffer_capacity', 100000))
    self.fc_layer_params = ast.literal_eval(params.get('fc_layer_params', '(100, )'))
    self.learning_rate = float(params.get('learning_rate', 1e-3))
    self.epsilon = float(params.get('epsilon', 0.1))
    self.epsilon_decay = float(params.get('epsilon_decay', 1))
    self.gamma = float(params.get('gamma', 1))
    #env
    self.train_py_env = GenericEnv(action_specification, observation_specification, initial_state)
    self.env = tf_py_environment.TFPyEnvironment(self.train_py_env)
    #agent initialization
    self.optimizer = tf.compat.v1.train.AdamOptimizer(learning_rate=self.learning_rate)
    self.train_step_counter = tf.compat.v2.Variable(0)
    self.create_agent()
    self.tf_agent.initialize()
    self.random_policy = random_tf_policy.RandomTFPolicy(time_step_spec=self.env.time_step_spec(), action_spec=self.env.action_spec())

    self.replay_buffer = tf_uniform_replay_buffer.TFUniformReplayBuffer(
      data_spec=self.tf_agent.collect_data_spec,
      batch_size=self.env.batch_size,
      max_length=self.replay_buffer_capacity)

    # (Optional) Optimize by wrapping some of the code in a graph using TF function.
