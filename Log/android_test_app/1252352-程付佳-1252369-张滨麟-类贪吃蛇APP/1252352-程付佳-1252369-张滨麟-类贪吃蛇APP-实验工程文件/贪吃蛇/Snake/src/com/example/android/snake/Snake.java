/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.snake;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Snake: a simple game that everyone can enjoy.
 */
public class Snake extends Activity {

	private SnakeView mSnakeView;

	private Button mStart;

	private static String ICICLE_KEY = "snake-view";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.snake_layout);

		mSnakeView = (SnakeView) findViewById(R.id.snake);

		mSnakeView.setTextView((TextView) findViewById(R.id.text));
		mSnakeView.setStartButton((Button) findViewById(R.id.start));
		mSnakeView.setControlButton((Button) findViewById(R.id.left), (Button) findViewById(R.id.right),
				(Button) findViewById(R.id.top), (Button) findViewById(R.id.bottom));

		// 判断下数据是否有保存，没有的话，就重新开始游戏
		if (savedInstanceState == null) {
			// We were just launched -- set up a new game
			mSnakeView.setMode(SnakeView.READY);
		} else {
			// We are being restored
			Bundle map = savedInstanceState.getBundle(ICICLE_KEY);
			if (map != null) {
				mSnakeView.restoreState(map);
			} else {
				mSnakeView.setMode(SnakeView.PAUSE);
			}
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Pause the game along with the activity
		mSnakeView.setMode(SnakeView.PAUSE);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Store the game state
		outState.putBundle(ICICLE_KEY, mSnakeView.saveState());
	}
}
