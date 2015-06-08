package com.grayherring.MeteorChaos2.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;


/**
 * Created by David on 5/25/2015.
 */
public class Assets implements Disposable,AssetErrorListener {

    public static final String TAG = Assets.class.getSimpleName();

    public  static final Assets instance = new Assets();
    private AssetManager assetManager;

    public AssetLargeMeteorite assetLargeMeteorite;
    public AssetBullet asetBullet;
    public AssetCannon assetCannon;
    private Assets() {

    }

    //public void init(AssetManager assetManager)
    public void init(){
        this.assetManager =new AssetManager();
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);

        //textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        //textureRegion = new TextureRegion();
        assetLargeMeteorite = new AssetLargeMeteorite(atlas);
        asetBullet = new AssetBullet(atlas);
        assetCannon = new AssetCannon(atlas);
    }

    public class AssetLargeMeteorite{
        public final TextureRegion largeMeteorite;

        public AssetLargeMeteorite(TextureAtlas atlas) {
            largeMeteorite = atlas.findRegion(Constants.LARGE_METEORITE);
        }
    }
    public class AssetBullet{
        public final TextureRegion bullet;
        public AssetBullet(TextureAtlas atlas) {
            bullet = atlas.findRegion(Constants.BALL);
        }
    }
    public class AssetCannon {
        public final TextureRegion cannon;
        public AssetCannon(TextureAtlas atlas) {
            cannon = atlas.findRegion(Constants.CANNON);
        }
    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "FAILLLL" +asset.fileName);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
