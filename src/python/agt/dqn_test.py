import numpy as np
from random import randint

from tf_agents.specs import array_spec

from generic_environment import GenericEnv
from dqn_agent import DqnAgent

#params
num_episode = 2000  # @param
board_size = 9

#env
dqn = DqnAgent(
    array_spec.BoundedArraySpec(
        shape=(), dtype=np.int32, minimum=0, maximum=3, name='action'),
    array_spec.BoundedArraySpec(
        shape=(2,), dtype=np.int32, minimum=0, maximum=board_size, name='observation'),
        np.array([0, 0], dtype=np.int32))

#[row, column]
state = np.array([0, 0], dtype=np.int32)

episode_count = 0
step_count