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
    private Assets() {

    }

    //public void init(AssetManager assetManager)
    public void init(){
        this.assetManager =new AssetManager();
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        for(String a:assetManager.getAssetNames()){
            Gdx.app.error(TAG,"asset:" + a);
        }

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);

        //textureAtlas = new TextureAtlas(Gdx.files.internal(Constants.TEXTURE_ATLAS));
        //textureRegion = new TextureRegion();
        assetLargeMeteorite = new AssetLargeMeteorite(atlas);
        asetBullet = new AssetBullet(atlas);
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




    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "FAILLLL" +asset.fileName);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
