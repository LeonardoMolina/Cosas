package com.leo.test.cosa.gfx;

public class Screen {
	
	public int width;
	public int height;
	public static final int MapWidth = 64;
	public static final int MapWidthMask = MapWidth -1;
	
	public int[] pixels;
	
	public int xOffset = 0;
	public int yOffset = 0;
	
	public SpriteSheet spriteSheet;
	
	public Screen(int width, int height,  SpriteSheet sheet){
		this.width = width;
		this.height = height;
		this.spriteSheet = sheet;
		pixels = new int[width * height];
	}
	public void render(int xPos, int yPos, int tile, int color){
		 render(xPos,yPos,  tile, color, false, false);
		
	}
	public void render(int xPos, int yPos, int tile, int color, boolean mirrorX, boolean mirrorY){
		xPos -= xOffset;
		yPos -= yOffset;
		int xTile = tile % 32;
		int yTile = tile / 32;
		int tileOffset = (xTile << 3) + (yTile << 3) * spriteSheet.width;
		for (int y = 0; y < 8; y++) {
			int ySheet = y;
			if (mirrorY) ySheet = 7 - y;
			if (y + yPos <0 || y + yPos >= height) continue;
			for (int x = 0; x < 8; x++){
				if (x + xPos <0 || x + xPos >= width) continue;
				int xSheet = x;
				if (mirrorX) xSheet = 7 - x;
				int col = (color >> (spriteSheet.pixels[xSheet + ySheet * spriteSheet.width + tileOffset] *8)) & 255;
				if (col < 255) pixels[(x + xPos) + (y + yPos) * width] = col;
			} 	
		}
	}
}
