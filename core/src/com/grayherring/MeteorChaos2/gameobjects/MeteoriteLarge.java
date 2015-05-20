package com.grayherring.MeteorChaos2.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Disposable;
import com.grayherring.MeteorChaos2.screen.GameScreen;
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
        rotation = 0;
        velocity.set(5,-50);
        terminalVelocity.set(20,20);
        acceleration.set(2,2);
        bounds.set(0,0,32,32);
        position.set(MathUtils.random(0.0f, GameScreen.WORLD_WIDTH - (dimension.x*2)), GameScreen.WORLD_HEIGHT -1);
        Gdx.app.log("test", "x " + position.x + "y " +position.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(textureRegion, position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation);


    }

    @Override
    public void update (float deltaTime) {
        this.rotation = this.rotation +(50*deltaTime);
        if(this.rotation >360){
            this.rotation =0;
        }
        velocity.y += -20*deltaTime;
        position.y +=(velocity.y*deltaTime);
    }


    @Override
    public void dispose() {

          textureAtlas.dispose();
    }

}
