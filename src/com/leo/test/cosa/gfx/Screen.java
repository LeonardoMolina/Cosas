package com.leo.test.cosa.gfx;

import javax.print.attribute.standard.SheetCollate;

public class Screen {
	
	public int WIDTH;
	public int HEIGHT;
	public static final int MapWidth = 64;
	public static final int MapWidthMask = MapWidth -1;
	
	public int[] tiles = new int[MapWidth * MapWidth];
	public int[] colours = new int[MapWidth * MapWidth*4];
	
	public int xOffset = 0;
	public int yOffset = 0;
	
	public SpriteSheet spriteSheet;
	
	public Screen(int width, int height,  SpriteSheet sheet){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.spriteSheet = sheet;
		
		for (int i = 0; i < MapWidth * MapWidth; i++){
			colours[i*4+0] = 0xff00ff;
			colours[i*4+1] = 0x00ffff;
			colours[i*4+2] = 0xffff00;
			colours[i*4+3] = 0xffffff;
		}
	}
	
	public void render(int[] pixels, int offset, int row ){
		
		for(int yTile = yOffset>>3; yTile <= (yOffset + HEIGHT)>> 3; yTile++){
			int yMin = yTile * 8 - yOffset;
			int yMax = yMin +8;
			if (yMin <0) yMin = 0;
			if (yMax > HEIGHT) yMax = HEIGHT;
			for(int xTile = xOffset>>3; xTile <= (xOffset + WIDTH)>> 3; xTile++){
				int xMin = xTile * 8 - xOffset;
				int xMax = xMin +8;
				if (xMin <0) xMin = 0;
				if (xMax > WIDTH) xMax = WIDTH;
				
				int tileIndex = (xTile & (MapWidthMask)) + (yTile& (MapWidthMask) * MapWidth );
				for (int y = yMin; y < yMax; y++){
					int sheetPixel = ((y + yOffset) & 7) * spriteSheet.width + ((xMin + xOffset) & 7);
					int tilePixel = offset  + xMin + y * row;
					for (int x = xMin; x < xMax; x++){
						int color = tileIndex * 4 + spriteSheet.pixels[sheetPixel++];
						pixels[tilePixel++] = colours[color];
					}
				}
				
			}
			
		}
		
	}

}
