package gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameobjects.Bird;

/**
 * Created by HtooWaiYan on 2/11/2015.
 */
public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY - 5, 17, 12);
    }


    public void update(float delta) {

    }
    public Bird getBird(){
        return bird;
    }
}
