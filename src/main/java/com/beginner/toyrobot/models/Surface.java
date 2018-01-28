package com.beginner.toyrobot.models;

public interface Surface {
	
	int getWidth();

	int getLength();

	boolean isValidCoOrdinate(int x, int y);
}
