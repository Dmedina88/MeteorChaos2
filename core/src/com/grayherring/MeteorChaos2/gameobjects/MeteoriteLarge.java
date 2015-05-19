package com.grayherring.MeteorChaos2.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.grayherring.MeteorChaos2.util.Constants;

/**
 * Created by David on 5/16/2015.
 */
public class MeteoriteLarge extends AbstractGameObject implements Disposable {
    protected TextureRegion textureRegion;
    protected  TextureAtlas textureAtlas;

    public MeteoriteLarge(){
        init();
    }

    public void init(){
        textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        textureRegion = new TextureRegion();
        textureRegion.setRegion(textureAtlas.findRegion("big"));


        dimension.set(32, 32);
        origin.set(dimension.x/2,dimension.y/2);
        scale.set(1,1);
        rotation = 90;
        velocity.set(10,10);
        terminalVelocity.set(20,20);
        acceleration.set(2,2);
        bounds.set(0,0,32,32);
        position.set(100,480-dimension.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(textureRegion,position.x,position.y,origin.x,origin.y,dimension.x,dimension.y,scale.x,scale.y,rotation);


    }

    public  void  update(Float deltaTime){

    }

    @Override
    public void dispose() {

          textureAtlas.dispose();
    }
}
