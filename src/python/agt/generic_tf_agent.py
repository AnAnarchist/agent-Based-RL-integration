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
    self.replay_buffer_capacity 