package com.mygame.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygame.gameobjects.Block;
import com.mygame.helpers.Touchpad;

/**
 * Created by HtooWaiYan on 2/25/2015.
 */
public class GameRenderer {
    private OrthographicCamera cam;
    private GameWorld myWorld;
    private Touchpad touchpad;

    private Texture block;
    private SpriteBatch batch;
    private Sprite blockSprite;

    private int midPointY;
    private int gameHeight;
    private int blockSpeed;

    public GameRenderer(Block block, Touchpad touchpad) {
        this.touchpad=touchpad;

        this.block=block.getTexture();
        cam = new OrthographicCamera();






    }

    public void render() {

        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        blockSprite.setX(blockSprite.getX() + touchpad.getTouchpad().getKnobPercentX()*blockSpeed);
        blockSprite.setY(blockSprite.getY() + touchpad.getTouchpad().getKnobPercentY()*blockSpeed);
        batch.begin();
        blockSprite.draw(batch);
        batch.end();
    }

    public void create(){
        blockSprite = new Sprite(block);
        batch=new SpriteBatch();

        blockSpeed=5;
        //Set position to centre of the screen
        blockSprite.setPosition(Gdx.graphics.getWidth()/2-blockSprite.getWidth()/2, Gdx.graphics.getHeight()/2-blockSprite.getHeight()/2);
        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        float aspectratio=(float) Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();

        cam.setToOrtho(false, 10f * aspectratio, 10f);

    }

    public void dispose(){
       batch.dispose();

    }

    public void update(Block newblock){
        this.block=newblock.getTexture();

    }

}
