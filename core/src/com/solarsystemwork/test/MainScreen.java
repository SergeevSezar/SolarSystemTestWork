package com.solarsystemwork.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

public class MainScreen extends ScreenAdapter {

    final SolarSystem solarSystem;

    private static final float SUN_RADIUS = 180f;
    private static final float EARTH_RADIUS = 25f;
    private static final float MARS_RADIUS = 15f;
    private static final float MOON_RADIUS = 5f;

    private static final float DISTANCE_EARTH_SUN = 120f;
    private static final float DISTANCE_MARS_SUN = 200f;
    private static final float DISTANCE_MOON_EARTH = 30f;

    private static final float SPEED_EARTH = (float) Math.PI / 600;
    private static final float SPEED_MARS = (float) Math.PI / 600;
    private static final float SPEED_MOON = (float) Math.PI / 250;

    private CelestialBody sun;
    private CelestialBody earth;
    private CelestialBody mars;
    private CelestialBody moon;

    public static boolean RUN_GAME = true;
    private float deltaTime = 0f;
    private Rectangle pauseButton;



    public MainScreen(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;

        sun = new CelestialBody(LoadResource.sun, SUN_RADIUS);
        earth = new CelestialBody(LoadResource.earth,EARTH_RADIUS, sun, DISTANCE_EARTH_SUN,SPEED_EARTH);
        mars = new CelestialBody(LoadResource.mars, MARS_RADIUS, sun, DISTANCE_MARS_SUN, SPEED_MARS);
        moon = new CelestialBody(LoadResource.moon,MOON_RADIUS, earth, DISTANCE_MOON_EARTH, SPEED_MOON);

        pauseButton = new Rectangle(20f, 20f, 50f, 50f);
    }

    @Override
    public void render(float delta) {
        deltaTime += delta;
        if (deltaTime >= 0.016f) {
            deltaTime = 0f;
            sun.update();
            earth.update();
            mars.update();
            moon.update();
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        solarSystem.batch.begin();
        solarSystem.batch.draw(LoadResource.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        solarSystem.batch.draw(LoadResource.pause ,0, 0, 50, 50);
        sun.render(solarSystem.batch);
        earth.render(solarSystem.batch);
        mars.render(solarSystem.batch);
        moon.render(solarSystem.batch);
        solarSystem.batch.end();

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
           public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                if (pauseButton.contains(screenX, screenY)) {
                    MainScreen.RUN_GAME = !MainScreen.RUN_GAME;
                    MenuScreen.spaceMusic.pause();
                }
                return true;
            }
        });
    }
}
