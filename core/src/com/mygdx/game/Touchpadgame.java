package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;


/**
 * Created by HtooWaiYan on 2/10/2015.
 */
public class Touchpadgame extends Game {

    SpriteBatch batch;
    private OrthographicCamera camera;
    private Stage stage;
    private Touchpad touchpad;
    public Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;
    private Texture blockTexture;
    private Sprite blockSprite;
    private float blockSpeed;
    private InputProcessor inputprocessor;

    private float prevX;
    private float prevY;
    @Override
    public void create() {
        blockTexture = new Texture(Gdx.files.internal("block.png"));
        blockSprite = new Sprite(blockTexture);
        //Set position to centre of the screen
        blockSprite.setPosition(Gdx.graphics.getWidth()/2-blockSprite.getWidth()/2, Gdx.graphics.getHeight()/2-blockSprite.getHeight()/2);

        blockSpeed = 5;
        batch=new SpriteBatch();
//        mario=new Texture(Gdx.files.internal("badlogic.jpg"));
//        position= new Vector2(640,360);

        float aspectratio=(float) Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();
        camera=new OrthographicCamera();
        camera.setToOrtho(false,10f*aspectratio,10f);

        //Create a touchpad skin
        touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture("touchBackground.png"));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture("touchKnob.png"));
        touchpadSkin.add("none", new Texture("badlogic.jpg"));
        //Create TouchPad Style
        touchpadStyle = new Touchpad.TouchpadStyle();
        //Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;

        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(15, 15, 200, 200);
//        touchpad.setBounds(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 100, 100);

        //Create a Stage and add TouchPad
        stage = new Stage();
        stage.addActor(touchpad);
        inputprocessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(blockSprite.getY()>screenY && screenY>blockSprite.getY()-blockSprite.getHeight()) {
                    blockSprite.setY(blockSprite.getY() + 5f);
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
//                blockSprite.setX(blockSprite.getX()+screenX-prevX);
//                blockSprite.setY(blockSprite.getY()-screenY+prevY);
                prevX = screenX;
//                prevY = screenY;
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
//        Gdx.input.setInputProcessor(inputprocessor);
        Gdx.input.setInputProcessor(stage);


        //Create block sprite


    }

    public void dispose(){

    }

    public void render(){
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            blockSprite.setY(blockSprite.getY()+1f);
            System.out.println("The block is at X: "+blockSprite.getX()+" and Y: "+blockSprite.getY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            blockSprite.setX(blockSprite.getX()-1f);
//            position.x-=1f;
            System.out.println("The block is at X: "+blockSprite.getX()+" and Y: "+blockSprite.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            blockSprite.setY(blockSprite.getY()-1f);
//            position.y-=1f;
            System.out.println("The block is at X: "+blockSprite.getX()+" and Y: "+blockSprite.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            blockSprite.setX(blockSprite.getX()+1f);
//            position.x+=1f;
            System.out.println("The block is at X: "+blockSprite.getX()+" and Y: "+blockSprite.getY());
        }





        //Move blockSprite with TouchPad
//        if(touchpad.getKnobPercentX()>touchpad.getKnobPercentY()){
            blockSprite.setX(blockSprite.getX() + touchpad.getKnobPercentX()*blockSpeed);
//            Gdx.app.log(""+touchpad.getKnobPercentX());
//        }
//        e lse if(touchpad.getKnobPercentX()<touchpad.getKnobPercentY()) {
            blockSprite.setY(blockSprite.getY() + touchpad.getKnobPercentY()*blockSpeed);
//        }
//          if (touchpad.getKnobPercentY()>0.8){
//              blockSprite.setY(blockSprite.getY()+5f);
//          }
//        else if (touchpad.getKnobPercentY()<-0.8){
//            blockSprite.setY(blockSprite.getY()-5f);
//        }
//        else if (touchpad.getKnobPercentX()>0.8){
//            blockSprite.setX(blockSprite.getX() + 5f);
//        }
//        else if (touchpad.getKnobPercentX()<-0.8){
//            blockSprite.setX(blockSprite.getX() - 5f);
//
//        }
//
//        blockSprite.setX(blockSprite.getX() + touchpad.getKnobPercentX()*blockSpeed);
//        blockSprite.setY(blockSprite.getY() + touchpad.getKnobPercentY()*blockSpeed);
//        System.out.println("X: "+touchpad.getKnobPercentX()+" and Y: "+touchpad.getKnobPercentY());
        //Draw
        batch.begin();
        blockSprite.draw(batch);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }
}
