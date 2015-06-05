package com.grayherring.MeteorChaos2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.grayherring.MeteorChaos2.screen.GameScreen;

/**
 * Created by David on 5/26/2015.
 */
public class GameController  extends InputAdapter {
    private  static  final String TAG = GameController.class.getName();
    private GameScreen gameScreen;

    public GameController(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode ==Input.Keys.SPACE){
            for(int i = 0;i <gameScreen.testNum;i++){
                //gameScreen.meteorite.get(i).init();
            }
        }
        if(keycode == Input.Keys.ENTER){
            for(int i = 0;i <gameScreen.testNum;i++){
                //  Gdx.app.log("test", "" + meteorite.get(i).position.x);
            }
        }
        if(keycode == Input.Keys.ESCAPE){
            for(int i = 0;i <gameScreen.testNum;i++){
                Gdx.app.exit();
            }
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }
}
