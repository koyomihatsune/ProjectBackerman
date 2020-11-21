package oop.koyomia.boomberman.GraphicComponent.State;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;

public class GraphicStateMoveable extends  GraphicStateDefault {
    protected HashMap<String, TiledMapTile> tileStates;
    public GraphicStateMoveable(GameObject self) {
        super(self);
        tileStates = new HashMap<>();
    }

    @Override
    public HashMap<String, TiledMapTile> getTileStates() {
        return this.tileStates;
    }

    public void putGraphicState(String key, TiledMapTile tile) {
        this.tileStates.put(key, tile);
    }
}
