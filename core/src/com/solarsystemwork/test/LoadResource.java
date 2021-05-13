package com.solarsystemwork.test;

import com.badlogic.gdx.graphics.Texture;

public class LoadResource {

    public static Texture background;
    public static Texture sun;
    public static Texture earth;
    public static Texture mars;
    public static Texture moon;
    public static Texture pause;

    public static Texture loadTexture (String file) {
        return new Texture(file);
    }

    public static void load() {
        background = loadTexture("space.png");
        sun = loadTexture("sunpng.png");
        earth = loadTexture("earthpng.jpg");
        mars = loadTexture("marspng.png");
        moon = loadTexture("moonpng.png");
        pause = loadTexture("play.png");
    }

    public static void dispose() {
        background.dispose();
        sun.dispose();
        earth.dispose();
        mars.dispose();
        moon.dispose();
        pause.dispose();
    }
}
