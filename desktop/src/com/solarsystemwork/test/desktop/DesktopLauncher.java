package com.solarsystemwork.test.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.solarsystemwork.test.SolarSystem;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Solar System";
		config.width = 640;
		config.height = 700;
		new LwjglApplication(new SolarSystem(), config);
	}
}
