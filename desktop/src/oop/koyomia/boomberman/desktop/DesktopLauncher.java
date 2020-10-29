package oop.koyomia.boomberman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import oop.koyomia.boomberman.GameAplication;

/**
 * The type Desktop launcher.
 */
public class DesktopLauncher {
	/**
	 * The entry point of application.
	 *
	 * @param arg the input arguments
	 */
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.forceExit = false;
		new LwjglApplication(new GameAplication(), config);
	}
}
