package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * Created by HtooWaiYan on 2/11/2015.
 */
public class ZBgame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBgame", "created");
        setScreen(new com.mygdx.screens.GameScreen());
    }
}
