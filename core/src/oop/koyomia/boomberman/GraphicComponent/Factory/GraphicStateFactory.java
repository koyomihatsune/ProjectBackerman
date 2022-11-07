package oop.koyomia.boomberman.GraphicComponent.Factory;

import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent.State.GraphicState;

public interface GraphicStateFactory {
    GraphicState createInstance(GameObject self, TiledMapTileSet tileSet);
}
