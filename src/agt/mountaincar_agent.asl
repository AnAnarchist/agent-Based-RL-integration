rl_algorithm(reach_top, dqn).

rl_parameter(learning_rate, 0.0008).
rl_parameter(gamma, 0.99).
rl_parameter(epsilon, 0.1).
rl_parameter(epsilon_decay, 1).
rl_parameter(fc_layer_params, '(256, 256)').
rl_parameter(batch_size, 64).
rl_parameter(replay_buffer_capacity, 100000).
rl_parameter(initial_collect_steps, 0).
rl_parameter(collect_steps_per_iteration, 0).

rl_observe(r