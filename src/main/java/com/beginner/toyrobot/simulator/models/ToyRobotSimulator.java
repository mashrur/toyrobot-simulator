package com.beginner.toyrobot.simulator.models;

import com.beginner.toyrobot.exceptions.RobotException;
import com.beginner.toyrobot.models.Position;
import com.beginner.toyrobot.models.ToyRobot;
import com.beginner.toyrobot.models.RobotCommand;
import com.beginner.toyrobot.models.Surface;

public class ToyRobotSimulator implements ToyRobot{
	private Position currentPosition;
	private Surface surface;
		
	public void placeOnSurface(Surface surface, Position initialPosition) throws RobotException{
		if(surface==null)
			throw new RobotException("Invalid surface");;
		this.surface = surface;
		if(surface.isValidCoOrdinate(initialPosition.getX(), initialPosition.getY())){
			this.currentPosition = initialPosition;
		}
	}
	
	public void executeCommand(RobotCommand command) throws RobotException{
		if(currentPosition!=null){
			switch (command) {
			case MOVE:
				moveForward();
				break;
			case LEFT:
				currentPosition.turnLeft();
				break;
			case RIGHT:
				currentPosition.turnRight();
				break;
			case REPORT:
				showReport();
				break;
			default:
				break;
			}
		}
		else
			throw new RobotException("Invalid position");
	}
	
	private void moveForward() {
		currentPosition.moveToNextPosition(p -> surface.isValidCoOrdinate(p.getX(), p.getY()));
	}

	public void showReport() {
		if(currentPosition!=null)
			System.out.println(currentPosition);
		else
			System.out.println("Invalid position");
	}
}
