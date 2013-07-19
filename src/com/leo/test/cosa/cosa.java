package com.leo.test.cosa;

import static java.lang.Thread.currentThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cosa {

	private static final int MAX_THREADS = 10;

	public static void main(String[] args) {
		System.out.println("Hey! Soy el thread " + currentThread().getId()
				+ " corriendo desde main()!");
		ExecutorService thread = Executors.newFixedThreadPool(MAX_THREADS);
		for (int t = 0 ; t < MAX_THREADS + 20; t++)
			thread.execute(new ble2("Usando Executors!"));
		Thread newThread = new Thread(new ble2("Usando Thread (clase!)!"));
		try {
			newThread.start();
		} catch (Throwable t) {
		}
	}
}

class ble2 extends Thread { //implements Runnable {

	private String name;

	public ble2(String string) {
		this.name = string;
	}

	public void run() {
		while (true) {
			System.out.println("Hey! Soy el thread " + currentThread().getId() + ". Init: " + name);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
