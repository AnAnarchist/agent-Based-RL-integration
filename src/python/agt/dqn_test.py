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