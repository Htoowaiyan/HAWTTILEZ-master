package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by User on 02/2/15.
 */
public class SomeGame extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
//    private OrthographicCamera camera;
//    private Stage stage;
//    private Touchpad touchpad;
//    private Touchpad.TouchpadStyle touchpadStyle;
//    private Skin touchpadSkin;
//    private Drawable touchBackground;
//    private Drawable touchKnob;
    private Texture blockTexture;
    private Sprite blockSprite;
    private float blockSpeed;
    private Rectangle bucket;
//    private float prevX;
//    private float prevY;
    private TestDpad dpad;



    public void create() {
        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
//        this.setScreen(new GameScreen(this));
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        bucket.width = 64;
        bucket.height = 64;
//        float aspectratio=(float) Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();
//        camera=new OrthographicCamera();
//        camera.setToOrtho(false,10f*aspectratio,10f);
//
//        //Create a touchpad skin
//        touchpadSkin = new Skin();
//        //Set background image
//        touchpadSkin.add("touchBackground", new Texture("touchBackground.png"));
//        //Set knob image
//        touchpadSkin.add("touchKnob", new Texture("touchKnob.png"));
//        //Create TouchPad Style
//        touchpadStyle = new Touchpad.TouchpadStyle();
//        //Create Drawable's from TouchPad skin
//        touchBackground = touchpadSkin.getDrawable("touchBackground");
//        touchKnob = touchpadSkin.getDrawable("touchKnob");
//        //Apply the Drawables to the TouchPad Style
//        touchpadStyle.background = touchBackground;
//        touchpadStyle.knob = touchKnob;
//        //Create new TouchPad with the created style
//        touchpad = new Touchpad(10, touchpadStyle);
//        //setBounds(x,y,width,height)
//        touchpad.setBounds(15, 15, 200, 200);
//
//        //Create a Stage and add TouchPad
//        stage = new Stage();
//        stage.addActor(touchpad);
//        Gdx.input.setInputProcessor(stage);

//        Gdx.input.setInputProcessor(new InputAdapter(){
//
//            @Override
//            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//
//                return true;
//            }
//
//            @Override
//            public boolean touchDragged(int screenX, int screenY, int pointer) {
//                // Can use a Vector2 Object to record the coordinates as well
//                bucket.x += screenX - prevX;
//                bucket.y -= screenY - prevY;
//                prevX = screenX;
//                prevY = screenY;
//
//                return true;
//            }
//
//            @Override
//            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//                // if is touching bucket, set the bucket to be the touched one, disable multiple touches?
//                prevX = screenX;
//                prevY = screenY;
//                Gdx.app.log("Game Screen : ", screenX + ", " + screenY);
//
//                return true;
//            }
//        });
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
//            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
//            bucket.x += 200 * Gdx.graphics.getDeltaTime();

        //Create block sprite
        blockTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        blockSprite = new Sprite(blockTexture);
        //Set position to centre of the screen
        blockSprite.setPosition(Gdx.graphics.getWidth()/2-blockSprite.getWidth()/2, Gdx.graphics.getHeight()/2-blockSprite.getHeight()/2);

        dpad=new TestDpad(blockSprite);
        blockSpeed = 5;


    }

    public void render() {
//        super.render(); //important!
        Gdx.gl.glClearColor(0.294f, 0.294f, 0.294f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        camera.update();

        //Move blockSprite with TouchPad
//        blockSprite.setX(blockSprite.getX() + touchpad.getKnobPercentX()*blockSpeed);
//        blockSprite.setY(blockSprite.getY() + touchpad.getKnobPercentY()*blockSpeed);

        dpad.render();

        //Draw
        batch.begin();
        blockSprite.draw(batch);
        this.font.draw(this.batch, "you suck", 480,480);
        batch.end();
//        stage.act(Gdx.graphics.getDeltaTime());
//        stage.draw();
//        dpad.update2();
    }

    public void dispose() {
//        batch.dispose();
//        font.dispose();
    }
}
