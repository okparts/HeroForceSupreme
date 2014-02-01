package com.hfs.constants;

public class GameVars {

	// GENERAL SYSTEM VARIABLES
	
		// vibration controls
		public static final int VIBE_BUTTON = 50;
	
	
	// ACTIVITY/LAYOUT VARIABLES
		
		// Main Menu Options Variables (MainMenuActivity.java -> activity_main_menu.xml)
		
			// values for Hero/Villain name generation 
			public static final boolean HERO = true;
			public static final boolean VILLAIN = false;
	
	
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
}