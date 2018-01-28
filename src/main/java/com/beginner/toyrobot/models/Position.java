package com.beginner.toyrobot.models;

import java.util.function.Predicate;

public class Position {
	private int x;
	private int y;
	private Direction direction;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return direction;
	}

	public Position(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	
	public void moveToNextPosition(Predicate<Position> verifyPosition) {
		int newX = x, newY = y;
		if (this.direction != null) {
			switch (this.direction) {
			case NORTH:
				newY++;
				break;
			case SOUTH:
				newY--;
				break;
			case EAST:
				newX++;
				break;
			case WEST:
				newX--;
				break;
			}
		}

		if (verifyPosition.test(new Position(newX, newY, this.direction))) {
			x = newX;
			y = newY;
		}
	}

	public void turnRight() {
		int nextOrdinal = direction.ordinal()<3?direction.ordinal()+1:0;
		direction = Direction.values()[nextOrdinal];
	}

	public void turnLeft() {
		int nextOrdinal = direction.ordinal()>0?direction.ordinal()-1:3;
		direction = Direction.values()[nextOrdinal];
	}
	
	public String toString() {
		return getX() + "," + getY() + "," + getDirection();
	}
}
