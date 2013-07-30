package com.leo.test.cosa.player;

public class Personaje {
	
	
	// Atributos basicos
	private String nombre = "";
	
	// Stats ofensivos
    private int MinAttackDamage;
    private int MaxAttackDamage;
    private int CriticalChance;
    private int CriticalDamage;
    private int CriticalMultiplier;
    private int AbilityPower;
    private int MagicPenetration;
    private int ArmorPenetration;
	
	// Stats pasivos
	private int hp;
	private int currentHp;
	private int rateHp;
	private int mana;
	private int currentMana;
	private int rateSp;
	private int energy;
	private int currentEnegery;
	private int rateEnegergy;
	private int rage;
	private int currentRage;
	private int rateRage;
	private int speed;
	private int attackSpeed;
	private int range;
	
	  // Stats defensivos
    private int armor;
    private int MagicResistance;
    private int dodge;
    private int block;
    private int parry;
	
	private String tipo;

}
