package com.mygame.TouchpadGame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygame.gameobjects.Block;
import com.mygame.gameworld.GameRenderer;
import com.mygame.gameworld.GameWorld;
import com.mygame.helpers.Touchpad;

/**
 * Created by HtooWaiYan on 2/25/2015.
 */
public class GameScreen implements Screen{

    private Touchpad touchpad;
    private Block block;
    private GameWorld world;
    private GameRenderer renderer;
    private Stage stage;
    //        For buttons
    TextButton buttonA;
    TextButton buttonB;
    TextButton buttonX;
    TextButton buttonY;
    TextButton.TextButtonStyle textButtonStyleA;
    TextButton.TextButtonStyle textButtonStyleB;
    TextButton.TextButtonStyle textButtonStyleX;
    TextButton.TextButtonStyle textButtonStyleY;
    Skin skin;
    TextureAtlas buttonAtlas;
    BitmapFont font;


    public GameScreen() {
        block=new Block("block.png");



//        Gdx.app.log("GameScreen", "Attached");

    }

    @Override
    public void render(float delta) {
        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
//        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
//        // Fills the screen with the selected color
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
//        world.update(delta);
        renderer.render();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {

        Gdx.app.log("GameScreen", "show called");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        touchpad=new Touchpad();
//        world=new GameWorld(midPointY);
        renderer=new GameRenderer(block,touchpad);
        renderer.create();
        stage=new Stage();
        stage.addActor(touchpad.getTouchpad());
        touchpad.getTouchpad().setBounds(15, 15, 200, 200);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("xbox-buttons/out/buttons.pack"));
        skin.addRegions(buttonAtlas);
        font = new BitmapFont();
        textButtonStyleA = new TextButton.TextButtonStyle();
        textButtonStyleB = new TextButton.TextButtonStyle();
        textButtonStyleX = new TextButton.TextButtonStyle();
        textButtonStyleY = new TextButton.TextButtonStyle();
        textButtonStyleA.font = font;
        textButtonStyleB.font = font;
        textButtonStyleX.font = font;
        textButtonStyleY.font = font;
        textButtonStyleA.up = skin.getDrawable("xbox-controller-a-button-md");
        textButtonStyleB.up = skin.getDrawable("xbox-controller-b-button-md");
        textButtonStyleX.up = skin.getDrawable("xbox-controller-x-button-md");
        textButtonStyleY.up = skin.getDrawable("xbox-controller-y-button-md");
        buttonA = new TextButton("Button1", textButtonStyleA);
        buttonB = new TextButton("Button2", textButtonStyleB);
        buttonX = new TextButton("Button3", textButtonStyleX);
        buttonY = new TextButton("Button4", textButtonStyleY);
        buttonA.setBounds(600,600,100,100);
        buttonB.setBounds(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,50,50);
        stage.addActor(buttonA);
        stage.addActor(buttonB);
        buttonB.addListener(new InputListener() {


        });
        buttonA.addListener(new InputListener(){



            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

//                Gdx.app.log("sdlkfjsd","Button touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("ButtonA","Button released");
                block.setTexture("touchKnob.png");
                renderer=new GameRenderer(block,touchpad);
                renderer.create();
            }
        });
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
        renderer.dispose();
        stage.dispose();

    }

}
