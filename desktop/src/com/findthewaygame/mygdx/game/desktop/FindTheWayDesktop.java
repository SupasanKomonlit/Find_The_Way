package com.findthewaygame.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.findthewaygame.mygdx.game.MainGame;

public class FindTheWayDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 700;
		new LwjglApplication(new MainGame(config.width, config.height), config);
	}
}
