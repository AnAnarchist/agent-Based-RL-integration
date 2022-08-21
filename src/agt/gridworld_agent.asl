rl_algorithm(reach_finish, sarsa).

rl_parameter(policy, egreedy).
rl_parameter(alpha, 0.26).
rl_parameter(gamma, 0.9).
rl_parameter(epsilon, 0.4).
rl_parameter(epsilon_decay, 0.9999).
rl_parameter(epsilon_min, 0).

rl_observe(reach_finish