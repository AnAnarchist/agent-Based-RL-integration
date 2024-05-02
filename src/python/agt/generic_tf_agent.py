import IPython

import tensorflow as tf
import numpy as np
import random
import ast
from abc import ABC, abstractmethod

from tf_agents.environments import tf_py_environment
from tf_agents.replay_buffers import tf_uniform_replay_buffer
from tf_agents.trajectories 