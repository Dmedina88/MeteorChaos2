package com.grayherring.MeteorChaos2.objectupdaters;

import com.grayherring.MeteorChaos2.gameobjects.GameObject;

/**
 * Created by David on 5/20/2015.
 */
public class MoveInLine extends GameObjectUpdater {
    public MoveInLine(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float deltaTime) {
        gameObject.rotation = gameObject.rotation +(50*deltaTime);
        if(gameObject.rotation >360){
            gameObject.rotation =0;
        }
        gameObject.velocity.y += -20*deltaTime;
        gameObject.position.y +=(gameObject.velocity.y*deltaTime);
    }
}
