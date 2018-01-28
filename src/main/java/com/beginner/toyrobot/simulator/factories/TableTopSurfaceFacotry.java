package com.beginner.toyrobot.simulator.factories;

import com.beginner.toyrobot.factories.SurfaceFactory;
import com.beginner.toyrobot.models.Surface;
import com.beginner.toyrobot.simulator.models.TableTopSurface;

public class TableTopSurfaceFacotry implements SurfaceFactory {

	@Override
	public Surface createSurface() {
		return new TableTopSurface(5, 5);
	}

}
