package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by HtooWaiYan on 2/26/2015.
 */
public class ButtonExample extends Game {

    Stage stage;
    TextButton buttonA;
    TextButton buttonB;
    TextButton buttonX;
    TextButton buttonY;
    TextButton.TextButtonStyle textButtonStyleA;
    TextButton.TextButtonStyle textButtonStyleB;
    TextButton.TextButtonStyle textButtonStyleX;
    TextButton.TextButtonStyle textButtonStyleY;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("xbox-buttons/out/buttons.pack"));
        skin.addRegions(buttonAtlas);
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
        stage.addActor(buttonA);
        stage.addActor(buttonB);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        super.render();
        stage.draw();
    }
}
