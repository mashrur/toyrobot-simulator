package com.beginner.toyrobot.simulator;

import java.util.Scanner;

import com.beginner.toyrobot.exceptions.RobotException;
import com.beginner.toyrobot.factories.ToyRobotFactory;
import com.beginner.toyrobot.factories.SurfaceFactory;
import com.beginner.toyrobot.models.Position;
import com.beginner.toyrobot.models.ToyRobot;
import com.beginner.toyrobot.simulator.factories.TableTopSurfaceFacotry;
import com.beginner.toyrobot.simulator.factories.ToyRobotSimulatorFactory;
import com.beginner.toyrobot.models.RobotCommand;
import com.beginner.toyrobot.models.Surface;

public class Main {

	public static void main(String[] arguments) {
		
		System.out.println("Toy Robot Simulator");
		showInstructions();

		
		Scanner in = new Scanner(System.in);
		ToyRobot robot = getRobot();
		Surface surface = getSurface();
		while (true) {
			String commandString = in.nextLine();
			if ("QUIT".equals(commandString)) {
				break;
			} else {
				if(commandString.trim().isEmpty())
					continue;
				RobotCommand command = CommandParser.parseRobotCommand(commandString);
				if (command != null) {
					if (command.equals(RobotCommand.PLACE)) {
						Position position = CommandParser.parsePositionFromPlaceCommand(commandString);
						if (position != null)
							try {
								robot.placeOnSurface(surface, position);
							} catch (RobotException e) {
								System.out.println(e.getMessage());
							}
						else
							System.out.println("Invalid PATH command. Format should be: \'PLACE X,Y,NORTH|SOUTH|EAST|WEST\'");
					} else
						try {
							robot.executeCommand(command);
						} catch (RobotException e) {
							System.out.println(e.getMessage());
						}
				}
				else{
					System.out.println("Invalid Command");
					showInstructions();
				}
					
			}
		}

	}

	public static void showInstructions() {
		System.out.println("Please type a valid robot command, possible commands are:");
		System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT");
		System.out.println("Type QUIT to exit.");
	}

	private static Surface getSurface() {
		SurfaceFactory surfaceFactory = new TableTopSurfaceFacotry();
		return surfaceFactory.createSurface();
	}

	private static ToyRobot getRobot() {
		ToyRobotFactory robotFactory = new ToyRobotSimulatorFactory();
		return robotFactory.createToyRobot();
	}

}
