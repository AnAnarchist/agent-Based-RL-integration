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
    self._state = initial_state
    self._is_episode_end = False
    self._episode_ended = False

  def action_spec(self):
    return self._action_spec

  def observation_spec(self):
    return self._observation_spec

  def _reset(self):
    self._episode_ended = False
    self._is_episode_end = False
  