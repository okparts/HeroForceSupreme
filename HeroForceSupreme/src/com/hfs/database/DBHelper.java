package com.hfs.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hfs.constants.GameVars;

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
			+ GameVars.COLUMN_SUPER_ID + " INTEGER,"
			+ GameVars.COLUMN_SUPER_NAME + " TEXT,"
			+ GameVars.COLUMN_ABILITY_FLY + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_SPEED + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_XRAY + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_LASER + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_STRENGTH + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_ICE + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_FIRE + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_EARTH + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_AIR + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_TECH + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_INVINCIBLE + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_INSECT + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_ANIMAL + " INTEGER,"
			+ GameVars.COLUMN_ABILITY_INTELLIGENCE + " INTEGER"
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
}
