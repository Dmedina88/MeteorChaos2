package com.grayherring.MeteorChaos2.objectupdaters;

import com.badlogic.gdx.math.MathUtils;
import com.grayherring.MeteorChaos2.gameobjects.GameObject;
import com.grayherring.MeteorChaos2.screen.GameScreen;

/**
 * Created by David on 5/20/2015.
 */
public class MoveInLine extends GameObjectUpdater {
    public MoveInLine(GameObject gameObject) {
        super(gameObject);
    }
    public static float SPEED = 100;

    @Override
    public void init() {
        float endPoint = MathUtils.random(0.0f, GameScreen.WORLD_WIDTH -gameObject.dimension.x );
       // (gameObject.position.y/gameObject.position.x)-();
        gameObject.slope = MathUtils.atan2(gameObject.position.y , gameObject.position.x - endPoint);
        //gameObject.slope =  gameObject.slope / Constants.VIEWPORT_WIDTH;
        gameObject.velocity.set(endPoint-gameObject.position.x ,  gameObject.position.y).nor();


    }

    @Override
    public void update(float deltaTime) {
        gameObject.rotation = gameObject.rotation +(50*deltaTime);
        if(gameObject.rotation >360){
            gameObject.rotation =0;
        }
       //float  dx = MathUtils.cos(gameObject.slope * 25);
      // float  dy = MathUtils.sin(gameObject.slope *25);
       gameObject.position.x += gameObject.velocity.x*deltaTime *SPEED;
       gameObject.position.y += -gameObject.velocity.y*deltaTime *SPEED;



    }
}
