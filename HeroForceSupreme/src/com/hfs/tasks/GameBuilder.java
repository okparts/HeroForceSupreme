package com.hfs.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.hfs.database.DBHelper;
import com.hfs.utils.NameGen;

public class GameBuilder extends AsyncTask<String, Integer, Boolean> {

	// builder utilities
	private static NameGen ng = new NameGen();
	private DBHelper db = null;
	private Context context = null;
	private ProgressBar loader = null;
	private LinearLayout contBtn = null;
	
	@Override
	protected Boolean doInBackground(String... arg0) {
		
		return null;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {

		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(Boolean result) {

		super.onPostExecute(result);
	}
}