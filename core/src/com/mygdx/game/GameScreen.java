package com.mygdx.game;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
public class GameScreen implements Screen{
    private OrthographicCamera camera;
    private Stage stage;
    private SpriteBatch batch;
    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;
    private Texture blockTexture;
    private Sprite blockSprite;
    private float blockSpeed;
    private float prevX;
    private float prevY;
    private static final String TAG = "Game Screen";
    final SomeGame game;
    Texture img;
    Rectangle bucket;
    public GameScreen(SomeGame game) {
        this.game = game;
        img = new Texture(Gdx.files.internal("badlogic.jpg"));
        // create a Rectangle to logically represent the bucket
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        bucket.width = 64;
        bucket.height = 64;
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();
        game.batch.draw(img,bucket.x,bucket.y);
        game.font.draw(game.batch, "you suck", 480,480);
        game.batch.end();

        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                // Can use a Vector2 Object to record the coordinates as well
                bucket.x += screenX - prevX;
                bucket.y -= screenY - prevY;
                prevX = screenX;
                prevY = screenY;

                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                // if is touching bucket, set the bucket to be the touched one, disable multiple touches?
                prevX = screenX;
                prevY = screenY;
                Gdx.app.log(TAG, screenX + ", " + screenY);

                return true;
            }
        });
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();

//        if (Gdx.input.isKeyJustPressed(Input.Keys.))

    }



    @Override
    public void resize(int width, int height) {

    }



    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private class DragProcessor implements InputProcessor{
        private int prevX;
        private int prevY;
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

        public void loadSprite(){
            batch =new SpriteBatch();
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            // if is touching bucket, set the bucket to be the touched one, disable multiple touches?
            prevX = screenX;
            prevY = screenY;
            Gdx.app.log(TAG, screenX + ", " + screenY);

            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            Gdx.app.log(TAG, "Previous: "+prevX + ", " + prevY);
            Gdx.app.log(TAG, "Bucket: "+bucket.x + ", " + bucket.y);
            bucket.x += screenX - prevX;
            bucket.y += 480 - screenY + prevY;
            Gdx.app.log(TAG, "1 "+prevX + ", " + prevY);
            prevX = (int) bucket.x;
            prevY = (int) bucket.y;
            Gdx.app.log(TAG, "2 "+prevX + ", " + prevY);


            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return false;
        }
    }
}
