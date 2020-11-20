package oop.koyomia.boomberman.GraphicComponent.State;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;

public class GraphicStateMoveable extends  GraphicStateDefault {
    protected HashMap<String, TiledMapTile> graphicStates;
    public GraphicStateMoveable(GameObject self) {
        super(self);
        graphicStates = new HashMap<>();
    }
    public HashMap<String, TiledMapTile> getGraphicStates() {
        return this.graphicStates;
    }
    public void putGraphicState(String key, TiledMapTile tile) {
        this.graphicStates.put(key, tile);
    }
}
