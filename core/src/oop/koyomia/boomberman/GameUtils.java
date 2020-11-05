package oop.koyomia.boomberman;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.Arrays;
import java.util.Collections;

public class GameUtils {
    public static void renderFrame(SpriteBatch batch, GameObject[] gameObjects) {
        Arrays.sort(gameObjects, GameObject.sortByLayer());
        batch.begin();
        for (GameObject entity: gameObjects) {
            batch.draw(entity.getGraphicComponent().getTexture(), entity.getGraphicComponent().getX(), entity.getGraphicComponent().getY(), entity.getGraphicComponent().getWidth(), entity.getGraphicComponent().getHeight());
        }
        batch.end();
    }
}
