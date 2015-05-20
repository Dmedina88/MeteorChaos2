package com.grayherring.MeteorChaos2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.grayherring.MeteorChaos2.MeteorChaosGame;
import com.grayherring.MeteorChaos2.gameobjects.MeteoriteLarge;

/**
 * Created by David on 5/16/2015.
 */
public class GameScreen extends AbstractScreen {
    Texture img;
    MeteoriteLarge meteoriteLarge;
    OrthographicCamera camera;

    public static final float WORLD_WIDTH =640;
    public static final float WORLD_HEIGHT = 480;

    public GameScreen(MeteorChaosGame game) {
        super(game);
        img = new Texture("badlogic.jpg");
         meteoriteLarge = new MeteoriteLarge();
       //float aspectRatio = (float) Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(WORLD_WIDTH, WORLD_HEIGHT);
        camera.translate(WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        camera.update();
    }



    @Override
    public void render(float delta) {
        control();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        meteoriteLarge.update(delta);

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
       // game.batch.draw(img, 0, 0);
        meteoriteLarge.render(game.batch);
        game.batch.end();


    }
    public void control(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            meteoriteLarge.init();
        }
    }

    @Override
    public void dispose() {
        img.dispose();

        super.dispose();
    }
}
