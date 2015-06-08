package com.grayherring.MeteorChaos2.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Disposable;
import com.grayherring.MeteorChaos2.GameControler;
import com.grayherring.MeteorChaos2.screen.GameScreen;
import com.grayherring.MeteorChaos2.util.Assets;

/**
 * Created by David on 5/16/2015.
 */
public class Meteorite extends GameObject implements Disposable {


    public Meteorite(){
        init();
    }

    public void init(){
       // textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        textureRegion = Assets.instance.assetLargeMeteorite.largeMeteorite;
        dimension.set(32, 32);
        origin.set(dimension.x/2,dimension.y/2);
        scale.set(1,1);
        rotation = 0;
        velocity.set(20,-50);
        terminalVelocity.set(20,20);
        acceleration.set(2,2);
        bounds.set(0,0,32,32);
        position.set(MathUtils.random(0.0f, GameScreen.WORLD_WIDTH - (dimension.x * 2)), GameScreen.WORLD_HEIGHT - 1);

        if(updater!=null){
            updater.init();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(textureRegion, position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation);
    }

    @Override
    public void update (float deltaTime) {
        //do i really want to check thsi everytime?
        if(updater!=null){
            updater.update(deltaTime);
        }
    }


    @Override
    public void dispose() {
          textureAtlas.dispose();
    }


    @Override
    public void onCollision(GameControler gameController,GameObject otherObject) {
        this.setDead(true);
        otherObject.setDead(true);
        //anamite exploson
        //https://github.com/libgdx/libgdx/wiki/2D-Animation
        //gamecontroler incress bullet/
        //game controler incress core
    }

    @Override
    public void onDeath() {
        super.onDeath();
    }
}
