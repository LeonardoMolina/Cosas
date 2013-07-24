package com.leo.test.cosa.level.tile;

import com.leo.test.cosa.gfx.Screen;
import com.leo.test.cosa.level.Level;

public class BasicTile extends Tile{
	
	protected int tileId;
	protected int tileColour;

	public BasicTile(int id,int x, int y, int tileColour) {
		super(id, false, false);
		this.tileId = x + y;
		this.tileColour = tileColour;
	}


	public void render(Screen screen, Level level, int x, int y) {
		screen.render(x, x, tileId, tileColour);
	}
	

}
