package com.leo.test.cosa.player;


public class Jugadores implements Runnable{
	
	static Player Jugador1 = new Player();
	static Player Jugador2 = new Player();
	
	public static void main(String[] args){
		createPlayers();
		combate(Jugador1, Jugador2 );
	
		
	}
	
	
	private static void combate(Player roco, Player leo) {
		System.out.println("Este es mi juego puto!:");
		while (!leo.isDead() && !roco.isDead()) {
			if (!roco.isDead()){
			System.out.println();
			imprimirVidas(roco, leo);
			System.out.println("Roco attactks Leo with:" + roco.getAttackDamage());
			roco.golpeFisico(leo);
			System.out.println("Roco ataco a leo!!");
			System.out.println("--------------------");
			roco.hechizar(leo);
			System.out.println("Roco hechizo a leo!!");
			System.out.println("--------------------");
			}
		

			if (!leo.isDead()){
			System.out.println();
			imprimirVidas(roco, leo);
			System.out.println("Leo attactks Roco with:" + leo.getAttackDamage());
			leo.golpeFisico(roco);
			System.out.println("Leo ataco a Roco!!");
			System.out.println("--------------------");
			leo.hechizar(roco);
			System.out.println("Leo hechizo a Roco!!");
			System.out.println("--------------------");
			
			
		
			}
		}
		if (roco.isDead()){
			System.out.println("Roco se cago muriendo");
		}
		if (leo.isDead()){
			System.out.println("Leo se cago muriendo");
		}
		
	}
	public static void imprimirVidas(Player roco, Player leo){
		System.out.println("RocoHP:" + roco.getHp());
		System.out.println("LeoHP:" + leo.getHp());
		
	}


	public static void createPlayers(){
		Jugador1.setHp(10000);
		Jugador1.setAttackDamage(2000);
		Jugador1.setDefense(560);
		Jugador1.setName("Roco");
		Jugador1.setMagicDamage(45);
		Jugador1.setMagicDefense(178);
		Jugador1.setSp(10);
		Jugador1.setSpeed(45);
		
		Jugador2.setHp(10000);
		Jugador2.setAttackDamage(1500);
		Jugador2.setDefense(800);
		Jugador2.setName("Leo");
		Jugador2.setMagicDamage(3500);
		Jugador2.setMagicDefense(1);
		Jugador2.setSp(4000);
		Jugador2.setSpeed(45);
		
	}

	public void run() {
		main(null);
		
	}
	

}
