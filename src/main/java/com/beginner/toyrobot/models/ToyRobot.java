package com.beginner.toyrobot.models;

import com.beginner.toyrobot.exceptions.RobotException;

public interface ToyRobot {
	void placeOnSurface(Surface surface, Position initialPosition) throws RobotException;
	void executeCommand(RobotCommand command) throws RobotException;
}
