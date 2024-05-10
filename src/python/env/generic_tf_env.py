from tf_agents.environments import suite_gym

class GenericTfEnv():
  def __init__(self, env_name, params={}):
    #params
    self.env_name = env_name
    self.show_gui = params.get('show_gui', 'false') == 'true'

    self.env = suite_gym.load(env