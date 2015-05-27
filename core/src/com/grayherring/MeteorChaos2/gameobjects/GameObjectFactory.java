package com.grayherring.MeteorChaos2.gameobjects;

import com.grayherring.MeteorChaos2.objectupdaters.MoveInLine;
import com.grayherring.MeteorChaos2.objectupdaters.MoveInWave;
import com.grayherring.MeteorChaos2.util.Constants;

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

    public static Bullet CreateBullet(float destX,float destY){
        Bullet bullet = new Bullet();
        bullet.setUpdater(new MoveInLine(bullet));
        bullet.position.set((Constants.VIEWPORT_WIDTH/2)-(bullet.dimension.y/2),-bullet.dimension.y/2);
        bullet.velocity.set(destX-bullet.position.x , bullet.position.y-destY).nor();
        return bullet;
    }
}
