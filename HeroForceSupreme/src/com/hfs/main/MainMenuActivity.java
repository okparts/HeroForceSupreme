package com.hfs.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.hfs.constants.GameVars;
import com.hfs.database.DBHelper;
import com.hfs.utils.NameGen;

public class MainMenuActivity extends Activity {
	
	// system variables
	private Vibrator vibe = null;
	
	// UI element variables
	private ViewFlipper flipper = null;
	private EditText playerName = null;
	private ImageView startBtn = null;
	private ImageView heroBtn = null;
	private ImageView villainBtn = null;
	private ImageView nameBtn = null;
	
	// processing variables
	private NameGen ng = null;
	private DBHelper db = null;
	private String character = "";
	private int type = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    
	    // initialize vibration
	    vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    ng = new NameGen();
	    db = new DBHelper(this);
		
	    // activate the main menu layout
		setContentView(R.layout.activity_main_menu);
		
		// initialize view flipper
		flipper = (ViewFlipper) findViewById(R.id.mainMenu);
		playerName = (EditText) findViewById(R.id.enterName);
		startBtn = (ImageView) findViewById(R.id.startBtn);
		heroBtn = (ImageView) findViewById(R.id.heroBtn);
		villainBtn = (ImageView) findViewById(R.id.villainBtn);
		nameBtn = (ImageView) findViewById(R.id.nameBtn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		if (flipper.getDisplayedChild() == 1 || flipper.getDisplayedChild() == 2 || flipper.getDisplayedChild() == 3) {
			// button press vibration
			vibe.vibrate(GameVars.VIBE_BUTTON);
			
			// reset all buttons to unpressed state
			startBtn.setImageResource(R.drawable.start_btn);
			heroBtn.setImageResource(R.drawable.hero_btn);
			villainBtn.setImageResource(R.drawable.villains_btn);
			nameBtn.setImageResource(R.drawable.name_btn);
			
			// flip back to previous options view
			flipper.setInAnimation(this, R.anim.in_from_left);
			flipper.setOutAnimation(this, R.anim.out_to_right);
			flipper.showPrevious();
		} else {
			// if on the start option, exit the game
			super.onBackPressed();
		}
	}

	// when the user presses the start button
	public void startGame(View view) {
		// button press vibration
		vibe.vibrate(GameVars.VIBE_BUTTON);
		
		// change start button image to pressed state
		startBtn.setImageResource(R.drawable.start_btn_pressed);
		
		// TODO - implement check for existing game
		// if game exists, load existing game (separate activity)
		
		if (db.tableIsEmpty(GameVars.TABLE_MANAGER)) {
			// if no game exists, continue on through viewflipper options to create a new game
			flipper.setInAnimation(this, R.anim.in_from_right);
			flipper.setOutAnimation(this, R.anim.out_to_left);
			flipper.showNext();
		} else {
			// if game exists, load game data and start the main game activity
			// TODO - implement main game activity
		}
	}
	
	// if the user presses the Heroes button
	public void setHero(View view) {
		// button press vibration
		vibe.vibrate(GameVars.VIBE_BUTTON);
		
		// change hero button image to pressed state
		heroBtn.setImageResource(R.drawable.hero_btn_pressed);
		
		// Hero game type selected
		type = GameVars.HERO;
		
		// character = ng.generateName(type);
		// playerName.setText(character);
		
		// slide to next game option
		flipper.setInAnimation(this, R.anim.in_from_right);
		flipper.setOutAnimation(this, R.anim.out_to_left);
		flipper.showNext();
	}
	
	// if the user presses the Villains button
	public void setVillain(View view) {
		// button press vibration
		vibe.vibrate(GameVars.VIBE_BUTTON);
		
		// change villain button image to pressed state
		villainBtn.setImageResource(R.drawable.villains_btn_pressed);
		
		// Villain game type selected
		type = GameVars.VILLAIN;
		// this.character = ng.generateName(this.type); 
		// playerName.setText(this.character);
		
		// slide to next game option
		flipper.setInAnimation(this, R.anim.in_from_right);
		flipper.setOutAnimation(this, R.anim.out_to_left);
		flipper.showNext();
	}
	
	// if the user presses the Name button
	public void buildGame(View view) {
		if (!playerName.getText().toString().trim().isEmpty()) {
		
			// button press vibration
			vibe.vibrate(GameVars.VIBE_BUTTON);
			
			// change villain button image to pressed state
			nameBtn.setImageResource(R.drawable.name_btn_pressed);
			
			// slide to next game option
			flipper.setInAnimation(this, R.anim.in_from_right);
			flipper.setOutAnimation(this, R.anim.out_to_left);
			flipper.showNext();
			
			// TODO - build database, tables, and game data
			
		} else {
			Toast.makeText(this, R.string.manager_name_error_blank, Toast.LENGTH_LONG).show();
		}
	}
	
	// after the game builds, begin the game
	public void beginGame(View view) {
		// button press vibration
		vibe.vibrate(GameVars.VIBE_BUTTON);
		
		// send the user into the game
		
	}
}