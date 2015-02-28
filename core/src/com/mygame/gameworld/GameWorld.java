package com.mygame.gameworld;

import com.mygame.gameobjects.Block;

/**
 * Created by HtooWaiYan on 2/25/2015.
 */
public class GameWorld {
    private Block block;
//    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    public GameWorld(int midPointY) {
        // Initialize bird here
//        block = new Block();
    }

    public void update(float delta) {
//        block.update(delta);
    }

    public Block getBlock(){
        return block;

    }
//        Gdx.app.log("GameWorld", "update");
//        rect.x++;
//        if (rect.x > 137) {
//            rect.x = 0;
//        }
//    }
//
//    public Rectangle getRect() {
//        return rect;
//    }
}
