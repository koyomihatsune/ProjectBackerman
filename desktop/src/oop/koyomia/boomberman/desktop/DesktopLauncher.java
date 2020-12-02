package oop.koyomia.boomberman.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import oop.koyomia.boomberman.GameAplication;
import oop.koyomia.boomberman.GameScene;

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
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Backerman");
		config.setResizable(false);
		config.setWindowedMode(820,720);
		new Lwjgl3Application(new GameScene(), config);
	}
}