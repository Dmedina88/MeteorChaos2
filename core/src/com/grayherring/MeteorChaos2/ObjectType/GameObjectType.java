package com.grayherring.MeteorChaos2.ObjectType;

import com.grayherring.MeteorChaos2.GameControler;
import com.grayherring.MeteorChaos2.gameobjects.GameObject;

/**
 * Created by David on 6/7/2015.
 */

//dont think I need this any more with the fdirecton I am going
public abstract class GameObjectType {

   //GameObjectType public enum Type {
  //      LARGE, NORMAL,BULLET;
  //  }
   GameObject gameObject;

   public abstract void onCollision( GameControler gameController);
   public abstract void onDeath();
}
