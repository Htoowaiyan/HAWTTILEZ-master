package com.mygame.TouchpadGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygame.TouchpadGame.Screens.GameScreen;


/**
 * Created by HtooWaiYan on 2/25/2015.
 */
public class TouchpadGame extends Game{
    @Override
    public void create() {
        Gdx.app.log("Touchpadgame","Created");
//        AssestLoader.update();
        setScreen(new GameScreen());
    }

    public void dispose(){
        super.dispose();
//        AssestLoader.dispose();
    }
}
