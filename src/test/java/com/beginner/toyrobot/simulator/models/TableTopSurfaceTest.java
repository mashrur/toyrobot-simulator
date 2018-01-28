package com.beginner.toyrobot.simulator.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class TableTopSurfaceTest {

	@Test
	public void isValidCoordinate_Should_Return_False_For_X_Coordinate_ValuesLessThanZero() {
		TableTopSurface surface = new TableTopSurface(5,5);
		assertFalse(surface.isValidCoOrdinate(-1,0));
	}
	
	@Test
	public void isValidCoordinate_Should_Return_False_For_Y_Coordinate_ValuesLessThanZero() {
		TableTopSurface surface = new TableTopSurface(5,5);
		assertFalse(surface.isValidCoOrdinate(2,-2));
	}
	
	@Test
	public void isValidCoordinate_Should_Return_False_For_X_Coordinate_ValueGreaterThanOrEqualsToTablesWidth() {
		TableTopSurface surface = new TableTopSurface(5,5);
		assertFalse(surface.isValidCoOrdinate(5,1));
		assertFalse(surface.isValidCoOrdinate(6,1));
	}
	
	@Test
	public void isValidCoordinate_Should_Return_False_For_Y_Coordinate_ValueGreaterThanOrEqualsToTablesLength() {
		TableTopSurface surface = new TableTopSurface(5,5);
		assertFalse(surface.isValidCoOrdinate(1,5));
		assertFalse(surface.isValidCoOrdinate(1,6));
	}
	
	@DisplayName("isValidCoordinate should return true for both coordinate values Less than tables width and length and greater than zero")
	@ParameterizedTest(name = "{index} => For {0} and {1} values should return \"true\"")
	@CsvSource({ "0, 1", "0, 4", "4, 0", "4, 4", "2, 2", "1, 1" })
	public void isValidCoordinate_Should_Return_True_For_Both_Coordinate_ValueLessThanOrEqualsToTablesLength(int x, int y) {
		TableTopSurface surface = new TableTopSurface(5, 5);
		assertTrue(surface.isValidCoOrdinate(x, y));
	}
}
