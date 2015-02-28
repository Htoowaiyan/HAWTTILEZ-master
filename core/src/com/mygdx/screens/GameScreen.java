package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import gameworld.GameRenderer;
import gameworld.GameWorld;

/**
 * Created by HtooWaiYan on 2/11/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;



    public GameScreen(){
//        Gdx.app.log("GameScreen", "Attached");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        world = new GameWorld(midPointY); // initialize world
        renderer = new GameRenderer(world); // initialize renderer
    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
//        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
//        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
//        // Fills the screen with the selected color
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        world.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
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
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");

    }

    @Override
    public void dispose() {
//        Gdx.app.log("GameScreen", "pause called");
    }
}
