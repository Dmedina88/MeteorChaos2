package com.grayherring.MeteorChaos2.gameobjects;

/**
 * Created by David on 5/16/2015.
 */

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.grayherring.MeteorChaos2.GameControler;
import com.grayherring.MeteorChaos2.objectupdaters.GameObjectUpdater;

public abstract class GameObject {

    public Vector2 position;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation;
    public Vector2 velocity;
    public Vector2 terminalVelocity;
    //public Vector2 friction;
    public Vector2 acceleration;
    public Rectangle bounds;
    public GameObjectUpdater updater;
   // public OnCollisionListener onCollisionListener;

    protected boolean dead;
//
    protected TextureRegion textureRegion;
    protected TextureAtlas textureAtlas;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }



    public void setUpdater(GameObjectUpdater updater) {
        this.updater = updater;
    }

    public GameObject() {
        position = new Vector2();
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation = 0;
        velocity = new Vector2();
        terminalVelocity = new Vector2(1, 1);
       // friction = new Vector2();
        acceleration = new Vector2();
        bounds = new Rectangle();
    }


    public abstract void render (SpriteBatch batch);
    public abstract void update (float deltaTime);

    public void  onCollision( GameControler gameController,GameObject otherObject){
        
    }
    public  void onDeath(){

    }
}
