package com.grayherring.MeteorChaos2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grayherring.MeteorChaos2.screen.GameScreen;

public class MeteorChaosGame extends Game {
	public SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}


}
