# Reinforcement Learning Integrated with BDI Agents

This project showcases a proof of concept (PoC) for the framework proposed in:

***From Programming Agents to Educating Agents – A Jason-based Framework for Integrating Learning in the Development of Cognitive Agents***
[[DOI](https://doi.org/10.1007/978-3-030-51417-4_9)]
[[pre-print (free access)](https://cgi.csc.liv.ac.uk/~lad/emas2019/accepted/EMAS2019_paper_33.pdf)]
[[talk slides](https://www.slideshare.net/AnAnarchist/emas-2019-from-programming-agents-to-educating-agents)]

Originally proposed by Michael Bosello, Alessandro Ricci and now maintained by AnAnarchist.

If you utilize this repository, please cite their *EMAS'19* paper.

```
@InProceedings{10.1007/978-3-030-51417-4_9,
author="Bosello, Michael
and Ricci, Alessandro",
editor="Dennis, Louise A.
and Bordini, Rafael H.
and Lesp{\'e}rance, Yves",
title="From Programming Agents to Educating Agents -- A Jason-Based Framework for Integrating Learning in the Development of Cognitive Agents",
booktitle="Engineering Multi-Agent Systems",
year="2020",
publisher="Springer International Publishing",
address="Cham",
pages="175--194"
}
```

___

This is an integration of BDI agents and Reinforcement Learning, based on [Jason](http://jason.sourceforge.net/wp/) (Actually, it is a [JaCaMo](http://jacamo.sourceforge.net/) project).

The basic idea is that a developer could write some plans and let the agent itself learn other plans and use them in a, this not being exclusively for specific ad hoc problems but as a general feature of the agent platform.

In short, the aim of the framework is to enable the developer to define the learning components with high-level abstractions similar to BDI components. Subsequently, these elements injected by the developers are employed by the agent to learn how to fulfill different tasks.
The work of the developer transitions from writing plans to defining a learning phase.

## Framework usage
Comprehensive description of the framework, and how to use it, is provided in the original paper (and in the slides linked above).

Developers can create Jason agents and environments as usual and make use of *"soft plans"* when necessary (along with the appropriate belief). The framework handles the rest of the process.

### Quick start
To run the agent system:

	./gradlew run

For using an algorithm implemented in python, don't forget to run the python agent server _before_ the agent system.

You can use the following commands to start running the python service:

	./gradlew --stop
	./gradlew runPythonAgent

For environments implemented in python, the python environment server must be run _before_ the agent system.

To run the python service, use the following commands:

	./gradlew --stop
	./gradlew runPythonEnv
