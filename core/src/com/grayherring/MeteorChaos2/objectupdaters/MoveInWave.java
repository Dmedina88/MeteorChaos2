package com.grayherring.MeteorChaos2.objectupdaters;

import com.badlogic.gdx.math.MathUtils;
import com.grayherring.MeteorChaos2.gameobjects.GameObject;
import com.grayherring.MeteorChaos2.screen.GameScreen;

/**
 * Created by David on 5/24/2015.
 */
public class MoveInWave extends GameObjectUpdater {
    public MoveInWave(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void init() {
        float endPoint = MathUtils.random(0.0f, GameScreen.WORLD_WIDTH);
        // (gameObject.position.y/gameObject.position.x)-();

        //gameObject.velocity.set(endPoint-gameObject.position.x ,  gameObject.position.y).nor();
        gameObject.velocity.set(12, 12);
    }

    @Override
    public void update(float deltaTime) {
        gameObject.rotation = gameObject.rotation +(50*deltaTime);
        if(gameObject.rotation >360){
            gameObject.rotation =0;
        }

        //float  dx = MathUtils.cos(gameObject.slope * 25);
        // float  dy = MathUtils.sin(gameObject.slope *25);

        gameObject.position.y += -gameObject.velocity.y*deltaTime *12;
        gameObject.position.x += MathUtils.cos(gameObject.position.y/10)*12;



    }
}
