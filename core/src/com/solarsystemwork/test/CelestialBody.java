package com.solarsystemwork.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CelestialBody extends Body {
    CelestialBody(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        super(texture, radius, mainBody, distanceFromMainBody, polarSpeed);
    }

    CelestialBody(Texture texture, Float radius) {
        super(texture, radius);
        this.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }
}
