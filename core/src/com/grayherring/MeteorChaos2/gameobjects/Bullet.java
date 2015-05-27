package com.grayherring.MeteorChaos2.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.grayherring.MeteorChaos2.screen.GameScreen;
import com.grayherring.MeteorChaos2.util.Assets;

/**
 * Created by David on 5/25/2015.
 */
public class Bullet extends GameObject {


    public Bullet() {
        init();
    }
    public void init(){
        // textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        textureRegion = Assets.instance.asetBullet.bullet;
        dimension.set(32, 32);
        origin.set(dimension.x/2,dimension.y/2);
        scale.set(1,1);
        rotation = 0;
        velocity.set(20,-50);
        terminalVelocity.set(20,20);
        acceleration.set(2,2);
        bounds.set(0,0,32,32);
        position.set(MathUtils.random(0.0f, GameScreen.WORLD_WIDTH - (dimension.x * 2)), GameScreen.WORLD_HEIGHT - 1);

//        if(updater!=null){
//            updater.init();
//        }
    }


    @Override
    public void render(SpriteBatch batch) {
        batch.draw(textureRegion, position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation);
    }

    @Override
    public void update(float deltaTime) {
        if(updater!=null){
            updater.update(deltaTime);
        }
    }
}
