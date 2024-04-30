import tensorflow as tf
import numpy as np

from tf_agents.environments import py_environment
from tf_agents.specs import array_spec
from tf_agents.trajectories import time_step as ts

class GenericEnv(py_environment.PyEnvironment):

  def __init__(self, actions, observations, initial_state):
    self._action_spec = actions
    self._observation_spec = observations
    self._initial_state = initial_state
    self.