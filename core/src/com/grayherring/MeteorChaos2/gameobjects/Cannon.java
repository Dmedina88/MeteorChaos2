package com.grayherring.MeteorChaos2.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.grayherring.MeteorChaos2.util.Assets;
import com.grayherring.MeteorChaos2.util.Constants;

/**
 * Created by David on 5/16/2015.
 */
public class Cannon extends GameObject implements Disposable {


    public Cannon(){
        init();
    }

    public void init(){
       // textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        textureRegion = Assets.instance.assetCannon.cannon;
        dimension.set(128, 64);
        origin.set(dimension.x/2,dimension.y/2);
        scale.set(1,1);
        rotation = 90;
        velocity.set(20,-50);
        terminalVelocity.set(20,20);
        acceleration.set(2,2);
        bounds.set(0,0,32,32);
        position.set((Constants.VIEWPORT_WIDTH / 2) -dimension.x/2 , -dimension.y);

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

}
