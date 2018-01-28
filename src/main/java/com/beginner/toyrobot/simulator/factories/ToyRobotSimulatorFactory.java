package com.beginner.toyrobot.simulator.factories;

import com.beginner.toyrobot.factories.ToyRobotFactory;
import com.beginner.toyrobot.models.ToyRobot;
import com.beginner.toyrobot.simulator.models.ToyRobotSimulator;

public class ToyRobotSimulatorFactory implements ToyRobotFactory{
	@Override
	public ToyRobot createToyRobot() {
		return new ToyRobotSimulator();
	}
}
