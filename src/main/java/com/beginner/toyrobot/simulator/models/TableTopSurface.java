package com.beginner.toyrobot.simulator.models;

import com.beginner.toyrobot.models.Surface;

public class TableTopSurface implements Surface{
	int width;
	int length;

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public TableTopSurface(int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}

	public boolean isValidCoOrdinate(int x, int y) {
		return (x >= 0 && x < width) && (y >= 0 && y < length);
	}
}
