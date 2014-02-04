package com.hfs.constants;

public class GameVars {

	// GENERAL SYSTEM VARIABLES
	
		// vibration controls
		public static final int VIBE_BUTTON = 50;
	
	
	// ACTIVITY/LAYOUT VARIABLES
		
		// Main Menu Options Variables (MainMenuActivity.java -> activity_main_menu.xml)
		
			// values for Hero/Villain name generation 
			public static final int HERO = 1;
			public static final int VILLAIN = 0;
	
	
	// DATABASE VARIABLES
		
		// Database Name and Version
		public static final String DB_NAME = "hsf.db";
		public static final int DB_VER = 1;
		
		// Database Tables
		public static final String TABLE_MANAGER = "manager";
		public static final String TABLE_TEAM = "team";
		public static final String TABLE_SUPERS = "supers";
		
		// Database Columns
			
			// shared columns
			public static final String COLUMN_ID = "_id";
			public static final String COLUMN_SUPER_ID = "super_id";
			
			// manager table columns
			public static final String COLUMN_MANAGER_NAME = "manager_name";
			public static final String COLUMN_GAME_TYPE = "type";
			public static final String COLUMN_MONEY = "money";
			
			// supers table columns
			public static final String COLUMN_SUPER_NAME = "super_name";
			public static final String COLUMN_SUPER_LEVEL = "super_level";
			public static final String COLUMN_SUPER_PRICE = "super_price";
			public static final String COLUMN_SUPER_TYPE = "super_type";
			public static final String COLUMN_SUPER_WEAKNESS = "super_weakness";
			public static final String COLUMN_ABILITY_FLY = "ability_fly";
			public static final String COLUMN_ABILITY_SPEED = "ability_speed";
			public static final String COLUMN_ABILITY_XRAY = "ability_xray";
			public static final String COLUMN_ABILITY_LASER = "ability_laser";
			public static final String COLUMN_ABILITY_STRENGTH = "ability_strength";
			public static final String COLUMN_ABILITY_ICE = "ability_ice";
			public static final String COLUMN_ABILITY_FIRE = "ability_fire";
			public static final String COLUMN_ABILITY_EARTH = "ability_earth";
			public static final String COLUMN_ABILITY_AIR = "ability_air";
			public static final String COLUMN_ABILITY_TECH = "ability_tech";
			public static final String COLUMN_ABILITY_INVINCIBLE = "ability_invincible";
			public static final String COLUMN_ABILITY_INSECT = "ability_insect";
			public static final String COLUMN_ABILITY_ANIMAL = "ability_animal";
			public static final String COLUMN_ABILITY_INTELLIGENCE = "ability_intelligence";
			
		// Database Helper Class Variables
		public static final String[] ABILITIES = {COLUMN_ABILITY_AIR, COLUMN_ABILITY_ANIMAL, COLUMN_ABILITY_EARTH, COLUMN_ABILITY_FIRE, COLUMN_ABILITY_FLY, COLUMN_ABILITY_ICE, COLUMN_ABILITY_INSECT, COLUMN_ABILITY_INTELLIGENCE, COLUMN_ABILITY_INVINCIBLE, COLUMN_ABILITY_LASER, COLUMN_ABILITY_SPEED, COLUMN_ABILITY_STRENGTH, COLUMN_ABILITY_TECH, COLUMN_ABILITY_XRAY};
		public static final int NUMBER_OF_WEAKNESSES = 4;
		public static final int SUPER_WEAKNESS_1 = 1;
		public static final int SUPER_WEAKNESS_2 = 2;
		public static final int SUPER_WEAKNESS_3 = 3;
		public static final int SUPER_WEAKNESS_4 = 4;
}