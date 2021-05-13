package com.solarsystemwork.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;

public class MenuScreen extends ScreenAdapter {

    final SolarSystem solarSystem;
    public static Music spaceMusic;

    public MenuScreen(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
        spaceMusic = Gdx.audio.newMusic(Gdx.files.internal("spacemusic.mp3"));
        spaceMusic.setLooping(true);
    }

    @Override
    public void show() {
      spaceMusic.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        solarSystem.batch.begin();
        solarSystem.batch.draw(LoadResource.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        solarSystem.font.draw(solarSystem.batch, "Solar System, tap to continue", 240, Gdx.graphics.getHeight() / 2);
        solarSystem.batch.end();

        if (Gdx.input.isTouched()) {
            solarSystem.setScreen(new MainScreen(solarSystem));
            dispose();
        }
    }
}
