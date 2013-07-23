package com.leo.test.cosa.gfx;

import javax.print.attribute.standard.SheetCollate;

public class Screen {
	
	public int WIDTH;
	public int HEIGHT;
	public static final int MapWidth = 64;
	public static final int MapWidthMask = MapWidth -1;
	
	public int[] pixels;
	
	public int xOffset = 0;
	public int yOffset = 0;
	
	public SpriteSheet spriteSheet;
	
	public Screen(int width, int height,  SpriteSheet sheet){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.spriteSheet = sheet;
		pixels = new int[width * height];
		for (int i = 0; i < MapWidth * MapWidth; i++){
			colours[i*4+0] = 0xff00ff;
			colours[i*4+1] = 0x00ffff;
			colours[i*4+2] = 0xffff00;
			colours[i*4+3] = 0xffffff;
		}
	}
	
	public void render(int xPos, int yPos, int tile, int color){
		xPos -= xOffset;
		yPos -= yOffset;
		int xTile = tile % 32;
		int yTile = tile / 32;
		int tileOffset = (xTile << 3) + (yTile << 3) * spriteSheet.width;
		for (int y = 0; y < 8; y++) {
			int ySheet = y;
			if (y + yPos <0 || y + yPos <= HEIGHT) continue;
			for (int x = 0; x < 8; x++){
				if (x + xPos <0 || x + xPos <= WIDTH) continue;
				int xSheet = x;
				int col = (color << (spriteSheet.pixels[xSheet + ySheet * spriteSheet.width + tileOffset] *8)) & 255;
				if (col < 255) pixels[(x + xPos) + (y + yPos) * WIDTH] = col;			
			} 	
		}
	}
}
