package com.leo.test.cosa.gfx;

public class Screen {
	
	public int WIDTH = 0;
	public int HEIGHT = 0;
	public static final int MapWidth = 64;
	public static final int MapWidthMask = MapWidth -1;
	
	public int[] tiles = new int[MapWidth * MapWidth];
	public int[] colours = new int[MapWidth * MapWidth*4];
	
	public int xOffset = 0;

}
