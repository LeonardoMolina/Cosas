package com.leo.test.cosa.player;

public class Player {
	
	private int hp;
	private int sp;
	private String Name;
	private int AttackDamage;
	private int MagicDamage;
	private int Speed;
	private int Defense;
	private int MagicDefense;
	
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

}
