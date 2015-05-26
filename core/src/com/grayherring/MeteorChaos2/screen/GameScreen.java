package com.grayherring.MeteorChaos2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.grayherring.MeteorChaos2.MeteorChaosGame;
import com.grayherring.MeteorChaos2.gameobjects.Bullet;
import com.grayherring.MeteorChaos2.gameobjects.GameObjectFactory;
import com.grayherring.MeteorChaos2.gameobjects.Meteorite;
import com.grayherring.MeteorChaos2.util.Assets;
import com.grayherring.MeteorChaos2.util.Constants;

import java.util.ArrayList;

/**
 * Created by David on 5/16/2015.
 */
public class GameScreen extends AbstractScreen {
    Texture img;
    ArrayList<Meteorite> meteorite;
    ArrayList<Bullet> bullets;
    OrthographicCamera camera;
    int testNum =560;
    private final String TAG = "GameScreen";

    public static final float WORLD_WIDTH =640;
    public static final float WORLD_HEIGHT = 480;

    public GameScreen(MeteorChaosGame game) {
        super(game);
        Assets.instance.init();
        meteorite = new ArrayList();
        bullets = new ArrayList();
        bullets.add(GameObjectFactory.CreateBullet((Constants.VIEWPORT_WIDTH/2),(Constants.VIEWPORT_HEIGHT/2)));
        bullets.add(GameObjectFactory.CreateBullet(12,12));
        for(int i = 0;i <testNum;i++){
            meteorite.add(GameObjectFactory.CreateMeteorite());
        }


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
        for(int i = 0;i <testNum;i++){
            meteorite.get(i).update(delta);
        }
        for(int i = 0;i <bullets.size();i++){
            bullets.get(i).update(delta);
        }

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
       // game.batch.draw(img, 0, 0);
        for(int i = 0;i <testNum;i++){
            meteorite.get(i).render(game.batch);
        }
        for(int i = 0;i <bullets.size();i++){
            bullets.get(i).render(game.batch);
        }

        game.batch.end();


    }
    public void control(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            for(int i = 0;i <testNum;i++){
                meteorite.get(i).init();
            }

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            for(int i = 0;i <testNum;i++){
              //  Gdx.app.log("test", "" + meteorite.get(i).position.x);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            for(int i = 0;i <testNum;i++){
                Gdx.app.exit();
            }
        }
        // test the adding
        if(Gdx.input.justTouched()){
            for(int i = 0;i <testNum;i++){
                bullets.add(GameObjectFactory.CreateBullet(Gdx.input.getX(),Gdx.input.getY()));
                Gdx.app.log(TAG,""+ bullets.size());
            }
        }

    }


    @Override
    public void dispose() {
        img.dispose();

        super.dispose();
    }
}
