
from tf_agents.agents.dqn import dqn_agent
from tf_agents.networks import q_network

from generic_tf_agent import GenericTfAgent

class DqnAgent(GenericTfAgent):
  def __init__(self, action_specification, observation_specification, initial_state, params={}):
    #params