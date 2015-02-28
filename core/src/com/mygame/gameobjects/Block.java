package com.mygame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by HtooWaiYan on 2/25/2015.
 */
public class Block {

    private Texture blockTexture;



    public Block(String path) {
        blockTexture = new Texture(Gdx.files.internal(path));

    }

    public Texture getTexture(){
        return blockTexture;
    }

    public void setTexture(String path){
        blockTexture = new Texture(Gdx.files.internal(path));
    }



}
