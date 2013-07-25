package com.leo.test.cosa.player;

public class Player {
	
	private int hp = 0;
	private int sp = 0;
	private String Name = "NoName";
	
	private int AttackDamage = 0;
	private int MagicDamage = 0;
	private int Speed = 0;
	private int Defense = 0;
	private int MagicDefense = 0;
	private int indiceDeRegeneración = 1;
	private int resAFrio;
	private int resAVeneneo;
	private int resAFuego;
	private int resARayos;
	
	private boolean isDead = false;
	
	public Player(){
		
		
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public void setAttackDamage(int attackDamage) {
		AttackDamage = attackDamage;
	}
	public int getAttackDamage() {
		return AttackDamage;
	}
	public int getMagicDamage() {
		return MagicDamage;
	}
	public void setMagicDamage(int magicDamage) {
		MagicDamage = magicDamage;
	}
	public int getSpeed() {
		return Speed;
	}
	public int getSp() {
		return sp;
	}

	public int getDefense() {
		return Defense;
	}

	public void setDefense(int defense) {
		Defense = defense;
	}

	public int getMagicDefense() {
		return MagicDefense;
	}

	public void setMagicDefense(int magicDefense) {
		MagicDefense = magicDefense;
	}	
	public void golpeFisico(Player player){
		if (player.getDefense() >= AttackDamage){
			System.out.println("Anda a levelear ni cosquillas me haces!");
		}else
		{
			player.setHp(player.getHp() - (AttackDamage - player.getDefense()));
				if (player.getHp() <= 0){
					player.setDead();
		}
		}
	}
	
	public boolean isDead(){
		return this.isDead;
	}
	
	public void setDead(){
		this.isDead = true;
		
	}
	
	public void hechizar(Player player){
	 if (this.sp <= 0 || this.sp < MagicDamage){ System.out.println("No hay mana suficiente");}
	 else{
		if (player.getMagicDefense() >= MagicDamage){
			System.out.println("NO hubo daño magico");
		}else
		{   this.sp = sp - MagicDamage;
			player.setHp(player.getHp() - (MagicDamage - player.getMagicDefense()));
			if (player.getHp() <= 0){
					player.setDead();
		}
		}
		}
	 }
}
