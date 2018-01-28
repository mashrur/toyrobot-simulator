package com.beginner.toyrobot.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest {

	@DisplayName("Should move the position depending on direction")
	@ParameterizedTest(name = "{index} => if moved from {2}, it should {5} {6} co-ordinate by one")
	@MethodSource("nextPositioTestDataProvider")
	public void moveToNextPositionTest(int initialX, int initialY, Direction direction, int expectedX, int expectedY,  String increaseOrDecrease, String coordinate) {
		Position position = new Position(initialX, initialY, direction);
		position.moveToNextPosition(p -> true);

		assertEquals(expectedX, position.getX());
		assertEquals(expectedY, position.getY());
	}
	
	private static Stream<Arguments> nextPositioTestDataProvider() {
        return Stream.of(
                Arguments.of(3, 3, Direction.WEST,2,3, "decrease", "x"),
                Arguments.of(3, 3, Direction.EAST,4,3, "increase", "X"),
                Arguments.of(3, 3, Direction.NORTH,3,4, "increase", "y")
        );
    }
	
	@DisplayName("Should move the direction depending on existing direction when turning LEFT")
	@ParameterizedTest(name = "{index} => if moved left from {0}-ward, it should should end up facing :{1}")
	@MethodSource("turnLeftTestDataProvider")
	public void turnLeftTest(Direction initDirection, Direction expectedDirection) {
		Position position = new Position(3, 3, initDirection);
		position.turnLeft();

		assertEquals(expectedDirection, position.getDirection());
	}
	
	private static Stream<Arguments> turnLeftTestDataProvider() {
        return Stream.of(
                Arguments.of(Direction.WEST,Direction.SOUTH),
                Arguments.of(Direction.SOUTH,Direction.EAST),
                Arguments.of(Direction.EAST,Direction.NORTH),
                Arguments.of(Direction.NORTH,Direction.WEST)
        );
    }
	
	@DisplayName("Should move the direction depending on existing direction when turning RIGHT")
	@ParameterizedTest(name = "{index} => if moved left from {0}-ward, it should should end up facing :{1}")
	@MethodSource("turnRightTestDataProvider")
	public void turnRightTest(Direction initDirection, Direction expectedDirection) {
		Position position = new Position(3, 3, initDirection);
		position.turnRight();

		assertEquals(expectedDirection, position.getDirection());
	}
	
	private static Stream<Arguments> turnRightTestDataProvider() {
        return Stream.of(
                Arguments.of(Direction.WEST,Direction.NORTH),
                Arguments.of(Direction.NORTH,Direction.EAST),
                Arguments.of(Direction.EAST,Direction.SOUTH),
                Arguments.of(Direction.SOUTH,Direction.WEST)
        );
    }
}
