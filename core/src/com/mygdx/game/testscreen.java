package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


/**
 * Created by HtooWaiYan on 2/10/2015.
 */
public class testscreen implements Screen {


    Sprite joyBase,joyKnob;
    SpriteBatch batch;
    Boolean show=false;

    private Circle knobBounds = new Circle(0, 0, 0);
    private Circle deadzoneBounds = new Circle(0, 0, 0);
    private Vector2 knobPercent = new Vector2();


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//        world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATIONS);
//        ...
//
//        if(show==true){
//            batch.setProjectionMatrix(camera.combined);
//            camera.update();
//
//            batch.begin();
//            joyBase.draw(batch);
//            joyKnob.draw(batch);
//            batch.end();
//        }
//        debugRenderer.render(world, camera.combined);
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
        batch.dispose();

    }


    @Override
    public void show() {
//        loadSprites();
//
//        Gdx.input.setInputProcessor(new InputController() {
//
//            @Override
//            public boolean touchDown(int sX, int sY, int pointer,
//                                     int button) {
//                show=true;
//                Vector3 wc=new Vector3(sX,sY,0);
//                camera.unproject(wc);
//                joyBase.setPosition(wc.x-joyBase.getWidth()/2, wc.y-joyBase.getHeight()/2);
//                joyKnob.setPosition(wc.x-joyKnob.getWidth()/2, wc.y-joyKnob.getHeight()/2);
//                deadzoneBounds=new Circle(wc.x, wc.y, 1.5f);
//                knobBounds=new Circle(wc.x,wc.y,1.5f);
//                return false;
//            }
//
////            @Override
////            public boolean touchDragged(int sX, int sY, int pointer) {
////                Vector3 wc=new Vector3(sX,sY,0);
////                camera.unproject(wc);
////                updateKnobPosition(wc.x,wc.y);
////                return false;
////            }
//
//            public void updateKnobPosition(float x,float y){
//
//                if(deadzoneBounds.contains(x,y)){
//                    joyKnob.setPosition(x-joyKnob.getWidth()/2, y-joyKnob.getHeight()/2);
//                }else{
//                    knobPercent.set((-(joyKnob.getX()+joyKnob.getWidth()/2) + x) / knobBounds.radius,
//                            (-(joyKnob.getY()+joyKnob.getHeight()/2) + y) / knobBounds.radius);
//                    float length = knobPercent.len();
//                    if (length > 1){
//                        knobPercent.scl(1 / length);
//                        System.out.println("scaled");
//                    }
//                    if (knobBounds.contains(x, y)) {
//                        joyKnob.setPosition(x-joyKnob.getWidth()/2, y-joyKnob.getHeight()/2);
//                        System.out.println("1");
//                    } else {
//                        Vector2 t=new Vector2();
//                        t=(knobPercent).nor().scl(knobBounds.radius)
//                                .add(knobBounds.x, knobBounds.y);
//                        joyKnob.setPosition(t.x-joyKnob.getWidth()/2,t.y-joyKnob.getHeight()/2);
//                        System.out.println("2");
//                    }
//                }
            }



//            @Override
//            public boolean touchUp(int screenX, int screenY, int pointer,
//                                   int button) {
//                show=false;
//                return false;
//            }
//        });


//    }


    public void loadSprites() {

        batch=new SpriteBatch();

        Texture base=new Texture(Gdx.files.internal("touchBackground.png"));
        Texture knob=new Texture(Gdx.files.internal("touchKnob.png"));

        joyBase=new Sprite(base);
        joyBase.setSize(3, 3);
        joyBase.setOrigin(joyBase.getWidth()/2, joyBase.getHeight()/2);


        joyKnob=new Sprite(knob);
        joyKnob.setSize(1, 1);
        joyKnob.setOrigin(joyKnob.getWidth()/2, joyKnob.getHeight()/2);

        System.out.println("added");
    }
}
