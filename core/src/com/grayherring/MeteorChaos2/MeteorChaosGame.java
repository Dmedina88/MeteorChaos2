package com.grayherring.MeteorChaos2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.grayherring.MeteorChaos2.screen.GameScreen;
import com.grayherring.MeteorChaos2.util.Assets;
import com.grayherring.MeteorChaos2.util.Constants;

public class MeteorChaosGame extends Game {
	public SpriteBatch batch;
	public BitmapFont font;

	
	@Override
	public void create () {

       //font = new BitmapFont(Gdx.files.internal(Constants.FONT));
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 14;
		parameter.color =Color.WHITE;
		parameter.borderColor = Color.BLACK;
		 font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();


		Assets.instance.init();
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}


}
