package com.beginner.toyrobot.simulator.models;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.beginner.toyrobot.exceptions.RobotException;
import com.beginner.toyrobot.models.Direction;
import com.beginner.toyrobot.models.Position;
import com.beginner.toyrobot.models.RobotCommand;
import com.beginner.toyrobot.models.Surface;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class ToyRobotSimulatorTest {

	@Injectable
	private Position currentPosition;
	@Injectable
	private Surface surface;

	@Test
	public void placeOnSurface_ShouldSetThePositionAsSupplied_IfSurfaceValidation_IsPassed() {
		new Expectations() {
			{
				surface.isValidCoOrdinate(anyInt, anyInt);
				returns(true);
			}
		};

		ToyRobotSimulator robot = new ToyRobotSimulator();
		Position initialPosition = new Position(1, 1, Direction.WEST);
		try {
			robot.placeOnSurface(surface, initialPosition);
		} catch (RobotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Position currentPosition = Deencapsulation.getField(robot, "currentPosition");
		assertEquals(initialPosition, currentPosition);
	}
	
	@Test
	public void executeCommand_ToMove_ShouldNotChangeCoordinates_IfSurfaceValidation_IsFailed() {
		new Expectations() {
			{
				surface.isValidCoOrdinate(anyInt, anyInt);
				returns(false);
			}
		};
		
		ToyRobotSimulator robot = new ToyRobotSimulator();
		int xPos = 1;
		currentPosition = new Position(xPos, 1, Direction.WEST);
		Deencapsulation.setField(robot, "currentPosition",currentPosition);
		Deencapsulation.setField(robot, "surface",surface);
		try {
			robot.executeCommand(RobotCommand.MOVE);
		} catch (RobotException e) {
			e.printStackTrace();
		}
		
		Position newPosition = Deencapsulation.getField(robot, "currentPosition");
		assertEquals(currentPosition.getX(),xPos);
	}
	
	
}
