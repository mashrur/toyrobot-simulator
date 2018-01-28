package com.beginner.toyrobot.simulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.beginner.toyrobot.models.Direction;
import com.beginner.toyrobot.models.Position;
import com.beginner.toyrobot.models.RobotCommand;

public class CommandParserTest {

	@DisplayName("Should be able to parse string into appropriate robot command type")
	@ParameterizedTest(name = "{index} => \"{0}\" should be parsed as {1}")
	@MethodSource("parseRobotCommandTestDataProvider")
	public void parseRobotCommandTest(String command, RobotCommand expectedRobotCommand) {
		CommandParser parser = new CommandParser();
		RobotCommand rcommand = parser.parseRobotCommand(command);

		assertEquals(expectedRobotCommand, rcommand);
	}
	
	private static Stream<Arguments> parseRobotCommandTestDataProvider() {
        return Stream.of(
                Arguments.of("LEFT",RobotCommand.LEFT),
                Arguments.of("RIGHT" ,RobotCommand.RIGHT),
                Arguments.of("MOVE",RobotCommand.MOVE),
                Arguments.of("REPORT",RobotCommand.REPORT),
                Arguments.of("PLACE xyz",RobotCommand.PLACE)
        );
    }
	
	@DisplayName("Should return null when inappropriate command value passed for parsing")
	@ParameterizedTest(name = "{index} => \"{0}\" should not be parsed")
	@ValueSource(strings = { "Hello", "xyz sadl", "" })
	public void anythingOtherThanAppropriateCommandShouldBeParsedAsNull(String command) {
		CommandParser parser = new CommandParser();
		RobotCommand rcommand = parser.parseRobotCommand(command);
		assertNull(rcommand);
	}

	@Test
	public void parsePositionFromPlaceCommandTestForValidPositionData() {
		CommandParser parser = new CommandParser();
		String placeCommand= "PLACE 1,0,WEST";
		Position position = parser.parsePositionFromPlaceCommand(placeCommand);
		assertEquals(1, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.WEST, position.getDirection());
	}
	
}
