package com.grayherring.MeteorChaos2.screen;

import com.badlogic.gdx.Screen;
import com.grayherring.MeteorChaos2.MeteorChaosGame;

/**
 * Created by David on 5/16/2015.
 */
public class AbstractScreen  implements Screen{

    protected MeteorChaosGame game;
    public AbstractScreen(MeteorChaosGame game) {
         this.game = game;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
