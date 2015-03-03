package com.mygame.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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

        final Rectangle bounds = blockSprite.getBoundingRectangle();

        // Get the bounding rectangle that our screen.  If using a camera you would create this based on the camera's
        // position and viewport width/height instead.
        final Rectangle screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        final Rectangle screenBounds = new Rectangle(0, 0, cam.viewportWidth,cam.viewportHeight);

        // Sprite
        float left = bounds.getX();
        float bottom = bounds.getY();
        float top = bottom + bounds.getHeight();
        float right = left + bounds.getWidth();


        // Screen
        float screenLeft = screenBounds.getX();
        float screenBottom = screenBounds.getY();
        float screenTop = screenBottom + screenBounds.getHeight();
        float screenRight = screenLeft + screenBounds.getWidth();

        float newX=bounds.getX()+ touchpad.getTouchpad().getKnobPercentX()*blockSpeed;
        float newY=bounds.getY()+ touchpad.getTouchpad().getKnobPercentY() * blockSpeed;

        if(newX>screenLeft && newX+bounds.getWidth()<screenRight){
            blockSprite.setX(newX);
        }
        if(newY>screenBottom && newY+bounds.getHeight()<screenTop){
            blockSprite.setY(newY);
        }

//        blockSprite.setX(blockSprite.getX() + touchpad.getTouchpad().getKnobPercentX()*blockSpeed);
//
//
//
//        blockSprite.setY(blockSprite.getY() + touchpad.getTouchpad().getKnobPercentY() * blockSpeed);


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

        float aspectratio=(float)(16/9); //Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();

        cam.setToOrtho(false, 10f * aspectratio, 10f);

    }

    public void dispose(){
       batch.dispose();

    }

    public void update(Block newblock){
        this.block=newblock.getTexture();

    }

}
