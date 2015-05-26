package com.grayherring.MeteorChaos2.gameobjects;

import com.grayherring.MeteorChaos2.objectupdaters.MoveInWave;

/**
 * Created by David on 5/24/2015.
 */
public class GameObjectFactory {

    public static Meteorite CreateMeteorite(){
        Meteorite meteorite = new Meteorite();
        meteorite.setUpdater(new MoveInWave(meteorite));
        meteorite.updater.init();
        return meteorite;
    }

    public static Bullet CreateBullet(float startX,float startY){
        Bullet bullet = new Bullet();
      //  bullet.setUpdater(new MoveInLine(bullet));
        bullet.position.set(startX -(bullet.dimension.x/2),startY);
        return bullet;
    }
}
