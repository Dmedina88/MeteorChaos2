package com.grayherring.MeteorChaos2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grayherring.MeteorChaos2.MeteorChaosGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Meteor Chaos 2";
		new LwjglApplication(new MeteorChaosGame(), config);
	}
}
