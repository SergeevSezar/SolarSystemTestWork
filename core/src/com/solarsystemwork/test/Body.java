package com.solarsystemwork.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Body {
    private Texture texture;
    private Float radius;
    private Body mainBody = null;
    private float distanceFromMainBody = 0f;
    private float polarAngle = 0f;
    private float polarSpeed = 0f;

    Body(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        this.texture = texture;
        this.radius = radius;
        this.mainBody = mainBody;
        this.distanceFromMainBody = distanceFromMainBody;
        this.polarSpeed = polarSpeed;
    }

    Body(Texture texture, Float radius) {
        this.texture = texture;
        this.radius = radius;
    }

    protected Vector2 position = new Vector2(0, 0);

    public void update() {
        if (MainScreen.RUN_GAME) {
            polarAngle += polarSpeed;
            if (polarAngle >= 2 * Math.PI) {
                polarAngle -= 2 * Math.PI;
            }
        }
        if (mainBody != null) {
            position.set(newPosition());
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - radius,
                position.y - radius,
                radius * 2,
                radius * 2);
    }

    private Vector2 newPosition() {
        return new Vector2(distanceFromMainBody * (float) Math.cos(polarAngle),
                distanceFromMainBody * (float) Math.sin(polarAngle)).add(mainBody.position);
    }
}
