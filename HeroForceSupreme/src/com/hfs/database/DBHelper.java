package com.hfs.database;

import java.util.Random;
import java.util.UUID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hfs.constants.GameVars;
import com.hfs.utils.NameGen;

public class DBHelper extends SQLiteOpenHelper {
	
	// Table Create Statements
	// MANAGER table create statement
	private static final String CREATE_TABLE_MANAGER = "CREATE TABLE IF NOT EXISTS " + GameVars.TABLE_MANAGER + "("
			+ GameVars.COLUMN_ID + " INTEGER PRIMARY KEY,"
			+ GameVars.COLUMN_MANAGER_NAME + " TEXT,"
			+ GameVars.COLUMN_GAME_TYPE + " INTEGER,"
			+ GameVars.COLUMN_MONEY + " INTEGER"
			+ ");";
	
	// TEAM table create statement
	private static final String CREATE_TABLE_TEAM = "CREATE TABLE IF NOT EXISTS " + GameVars.TABLE_TEAM + "("
			+ GameVars.COLUMN_ID + " INTEGER PRIMARY KEY,"
			+ GameVars.COLUMN_SUPER_ID + " INTEGER"
			+ ");";
	
	private static final String CREATE_TABLE_SUPERS = "CREATE TABLE IF NOT EXISTS " + GameVars.TABLE_SUPERS + "("
			+ GameVars.COLUMN_ID + " INTEGER PRIMARY KEY,"
			+ GameVars.COLUMN_SUPER_ID + " TEXT,"
			+ GameVars.COLUMN_SUPER_NAME + " TEXT,"
			+ GameVars.COLUMN_SUPER_LEVEL + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_SUPER_PRICE + " INTEGER,"
			+ GameVars.COLUMN_SUPER_TYPE + " INTEGER,"
			+ GameVars.COLUMN_SUPER_WEAKNESS + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_FLY + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_SPEED + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_XRAY + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_LASER + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_STRENGTH + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_ICE + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_FIRE + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_EARTH + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_AIR + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_TECH + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_INVINCIBLE + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_INSECT + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_ANIMAL + " INTEGER DEFAULT 0,"
			+ GameVars.COLUMN_ABILITY_INTELLIGENCE + " INTEGER DEFAULT 0"
			+ ");";
	
	// constructor
	public DBHelper(Context context) {
		super(context, GameVars.DB_NAME, null, GameVars.DB_VER);
	}

	// create game tables 
	@Override
	public void onCreate(SQLiteDatabase db) {
		// create tables
		db.execSQL(CREATE_TABLE_MANAGER);
		db.execSQL(CREATE_TABLE_TEAM);
		db.execSQL(CREATE_TABLE_SUPERS);
	}

	// delete and recreate game tables
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// drop old tables on upgrade
		db.execSQL("DROP TABLE IF EXISTS " + GameVars.TABLE_MANAGER);
		db.execSQL("DROP TABLE IF EXISTS " + GameVars.TABLE_TEAM);
		db.execSQL("DROP TABLE IF EXISTS " + GameVars.TABLE_SUPERS);
		
		// create new tables on upgrade
		onCreate(db);
	}
	
	/*
	 * check if the given table is populated
	 * used for ANY table
	 */
	public boolean tableIsEmpty(String table) {
		boolean check = false;
		String checkDB = "SELECT COUNT(*) FROM " + table;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(checkDB, null);
		if (c != null) {
			c.moveToFirst();
			if (c.getInt(0) == 0) {
				check = true;
			}
		}
		return check;
	}
	
	/*
	 * build a new manager table
	 * used for GameVars.TABLE_MANAGER table
	 */
	public long newManager(String name, int type) {
		// database initializations
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		// setup content to build manager table
		cv.put(GameVars.COLUMN_MANAGER_NAME, name);
		cv.put(GameVars.COLUMN_GAME_TYPE, type);
		cv.put(GameVars.COLUMN_MONEY, 1000);
		
		// write manager table
		long id = db.insert(GameVars.TABLE_MANAGER, null, cv);
		
		// return table row id
		return id;
	}
	
	public long addSuper(NameGen ng, int type, int superLevel) {
		// database initializations
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		Random random = new Random();
		
		// super name generation
		String superName = ng.generateName(type);
		
		// super id hash generation
		String superID = UUID.randomUUID().toString();
		
		// random weakness generator
		int weakness = (random.nextInt(GameVars.NUMBER_OF_WEAKNESSES)) + 1;
		
		// setup content to add a new super row
		cv.put(GameVars.COLUMN_SUPER_NAME, superName);
		cv.put(GameVars.COLUMN_SUPER_ID, superID);
		cv.put(GameVars.COLUMN_SUPER_WEAKNESS, weakness);
		
		// random ability generator - based on super level
		// one extra ability for every 5 levels
		// 0-4 - 1 ability, 5-9 - 2 abilities, so on ...
		int randomIndex; 
		String[] randomAbilities = new String[superLevel];
		for (int i = 0; i <= superLevel; i++) {
			if (i > 0) {
				randomIndex = random.nextInt(GameVars.ABILITIES.length);
				randomAbilities[i] = GameVars.ABILITIES[randomIndex];
				// if the random ability is a duplicate, then regenerate
				while (checkDuplicates(randomAbilities, i)) {
					randomIndex = random.nextInt(GameVars.ABILITIES.length);
					randomAbilities[i] = GameVars.ABILITIES[randomIndex];
				}
			} else {
				randomIndex = random.nextInt(GameVars.ABILITIES.length);
				randomAbilities[i] = GameVars.ABILITIES[randomIndex];
			}
		}
		
		for (String ability: randomAbilities) {
			cv.put(ability, 1);
		}
		
		// write new super to super table
		long id = db.insert(GameVars.TABLE_SUPERS, null, cv);
		
		// return table row id
		return id;
	}

	private boolean checkDuplicates(String[] abilities, int index) {
		String value = abilities[index];
		if (value != null && !value.equals("")) {
			for (int i = 0; i < index; i++) {
				if (value.equals(abilities[i])) {
					return true;
				}
			}
		}
		return false;
	}
}