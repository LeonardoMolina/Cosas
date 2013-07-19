package com.leo.test.cosa;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	/**
	 *  Jugando con Threads :D
	 */
	private static final long serialVersionUID = 1L;
    public boolean running = false;
	private static final long Version = 1L;
	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Cositas";
	
	private JFrame  frame;
	
	public Game() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));
		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		int ticks = 0;
		int frames = 0;
		long lastTimer = 	System.currentTimeMillis();
	    double delta = 0;	
		
	while (running) {
		    long now = System.nanoTime();
		    delta += (now - lastTime) / nsPerTick;
		    lastTime = now;
		    boolean shouldRender = true;
		    while (delta >= 1){
		    	ticks++;
		    	tick();
		    	delta -= 1;
		    	shouldRender = true;
		    }
		    if (shouldRender) {
		    	frames++;
		    	render();
		    }
		    if (System.currentTimeMillis() - lastTimer > 1000){
		    	lastTimer += 1000;
		    	System.out.println("frames" + frames + ", " + "ticks" +  ticks);
		    	frames = 0;
		    	ticks = 0;
		    }
		    
		}
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}

	public static long getVersion() {
		return Version;
	}
	
	public synchronized void Start(){
		running = true;
		new Thread(this).start();	
	}

	public synchronized void Stop(){
		running = false;
	}
	
	public static void main(String[] args){
		new Game().Start();
	}

}
