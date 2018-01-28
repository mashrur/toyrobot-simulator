package com.beginner.toyrobot.simulator;

import com.beginner.toyrobot.models.Direction;
import com.beginner.toyrobot.models.Position;
import com.beginner.toyrobot.models.RobotCommand;


public class CommandParser {
	public static RobotCommand parseRobotCommand(String command) {
		RobotCommand rcommand = null;
		
		String[] args = command.split(" ");
		if(args.length>0){
			try {
				rcommand = RobotCommand.valueOf(args[0].trim());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return rcommand;
	}
	
	public static Position parsePositionFromPlaceCommand(String placeCommand){
		String[] args = placeCommand.split(" ");
		if (args.length > 1) {
			String[] params = args[1].split(",");
			if (params.length > 2) {
				int x = Integer.parseInt(params[0]);
				int y = Integer.parseInt(params[1]);
				Direction commandDirection = Direction.valueOf(params[2]);
				return new Position(x, y, commandDirection);
			}
		}
		return null;
	}
}
