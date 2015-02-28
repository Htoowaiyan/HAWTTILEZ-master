package com.mygame.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by HtooWaiYan on 2/26/2015.
 */
public class AssestLoader {

    public static Texture blockTexture;
    public static void load(){
        blockTexture = new Texture(Gdx.files.internal("block.png"));
    }
    public static void dispose(){
        blockTexture.dispose();
    }
}
