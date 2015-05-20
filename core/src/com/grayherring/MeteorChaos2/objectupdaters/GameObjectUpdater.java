package com.grayherring.MeteorChaos2.objectupdaters;

import com.grayherring.MeteorChaos2.gameobjects.GameObject;

/**
 * Created by David on 5/20/2015.
 */
public abstract class GameObjectUpdater {
    protected   GameObject gameObject;

    public GameObjectUpdater(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public abstract void init();
    public  void setGameObject(GameObject gameObject){
        this.gameObject = gameObject;
    }
    public abstract void update(float deltaTime);
}
