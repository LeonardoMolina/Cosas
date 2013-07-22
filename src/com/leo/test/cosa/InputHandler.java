package com.leo.test.cosa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener{
	
	public InputHandler(Game game){
		game.addKeyListener(this);
		
	}
	
	public class Key{
		private int numTimesPressed =0; 
		private boolean pressed = false;
		public boolean isPressed(){ return this.pressed;}
		public void toggle(boolean isPressed){
			pressed = isPressed;			
			if (pressed){numTimesPressed++;
			}
		}
		public int getNumTimes(){
			return numTimesPressed;
		}
	}
	
	public List<Key> keys = new ArrayList<Key>();
	
	// -- Controls --
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}
	
	public void toggleKey(int keyCode, boolean isPressed){
		if (keyCode == KeyEvent.VK_W) {up.toggle(isPressed);}
		if (keyCode == KeyEvent.VK_S) {down.toggle(isPressed);}
		if (keyCode == KeyEvent.VK_A) {left.toggle(isPressed);}
		if (keyCode == KeyEvent.VK_D) {right.toggle(isPressed);}			
	}
	
}