rl_algorithm(reach_top, dqn).

rl_parameter(learning_rate, 0.0008).
rl_parameter(gamma, 0.99).
rl_parameter(epsilon, 0.1).
rl_parameter(epsilon_decay, 1).
rl_parameter(fc_layer_params, '(256, 256)').
rl_parameter(batch_size, 64).
rl_parameter