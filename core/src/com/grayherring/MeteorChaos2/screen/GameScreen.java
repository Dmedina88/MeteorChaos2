package com.grayherring.MeteorChaos2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.grayherring.MeteorChaos2.GameController;
import com.grayherring.MeteorChaos2.MeteorChaosGame;
import com.grayherring.MeteorChaos2.gameobjects.Bullet;
import com.grayherring.MeteorChaos2.gameobjects.GameObject;
import com.grayherring.MeteorChaos2.gameobjects.GameObjectFactory;
import com.grayherring.MeteorChaos2.gameobjects.Meteorite;
import com.grayherring.MeteorChaos2.util.Assets;

import java.util.ArrayList;

/**
 * Created by David on 5/16/2015.
 */
public class GameScreen extends AbstractScreen {
    Texture img;
    public ArrayList<Meteorite> meteorite;
    public ArrayList<Bullet> bullets;
    public OrthographicCamera camera;
    public int testNum =20;
    private final String TAG = "GameScreen";

    public static final float WORLD_WIDTH =640;
    public static final float WORLD_HEIGHT = 480;
    GameController gameController;

    public GameScreen(MeteorChaosGame game) {
        super(game);
        gameController = new GameController(this);
        Assets.instance.init();
        meteorite = new ArrayList();
        bullets = new ArrayList();
        bullets.add(GameObjectFactory.CreateBullet(100, 100));
        bullets.get(0).setUpdater(null);
        bullets.add(GameObjectFactory.CreateBullet(12, 12));

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
        gameController.control();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for(int i = 0;i <meteorite.size();i++){
            meteorite.get(i).update(delta);
        }
        for(int i = 0;i <bullets.size();i++){
            bullets.get(i).update(delta);
        }
        bulletMeteoriteCollision();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
       // game.batch.draw(img, 0, 0);
        for(int i = 0;i <meteorite.size();i++){
            meteorite.get(i).render(game.batch);
        }
        for(int i = 0;i <bullets.size();i++){
            bullets.get(i).render(game.batch);
        }

        game.font.draw(game.batch, "1234567890-=!@#$%^&*()_+", 200, 200);

        game.batch.end();


    }


    public void bulletMeteoriteCollision(){
        Rectangle bulletRect;
        Rectangle meteoriteRect;
        ArrayList<Meteorite> removeM = new ArrayList();
        ArrayList<Bullet> removeB = new ArrayList();
        for(Bullet bullet :bullets){
             bulletRect = collisonBox(bullet);
            for(int j =0; j<meteorite.size();j++){
                meteoriteRect = collisonBox(meteorite.get(j));
                if(bulletRect.overlaps(meteoriteRect)){
                    //Gdx.app.log(TAG,""+ "hit");
                    removeM.add(meteorite.get(j));
                    removeB.add(bullet);
                }
            }
        }
        meteorite.removeAll(removeM);
        bullets.removeAll(removeB);

    }

    public Rectangle collisonBox(GameObject gameObject){
        return  new Rectangle(gameObject.position.x,gameObject.position.y,gameObject.bounds.width,gameObject.bounds.getHeight());
    }

    @Override
    public void dispose() {
        img.dispose();

        super.dispose();
    }

    /*
       public void control(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            meteorite.clear();
                for(int i = 0;i <testNum;i++){
                    meteorite.add(GameObjectFactory.CreateMeteorite());
                }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            for(int i = 0;i <meteorite.size();i++){
              //  Gdx.app.log("test", "" + meteorite.get(i).position.x);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
                Gdx.app.exit();
        }
        // test the adding
        if(Gdx.input.justTouched()){
                Vector3 vector3 = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
                vector3 = camera.unproject(vector3);
                bullets.add(GameObjectFactory.CreateBullet(vector3.x, vector3.y));
        }

    }
     */
}
