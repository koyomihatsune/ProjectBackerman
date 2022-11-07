package oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent.State;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;

public class GraphicStateMovable extends  GraphicStateDefault {
    protected HashMap<String, TiledMapTile> tileStates;
    public GraphicStateMovable(GameObject self) {
        super(self);
        tileStates = new HashMap<>();
    }

    @Override
    public HashMap<String, TiledMapTile> getTileStates() {
        return this.tileStates;
    }

    public void putGraphicState(String key, TiledMapTile tile) {
        if (tile.getObjects().get("collision") == null) {
            RectangleMapObject tempRec = new RectangleMapObject(0, 0, 0, 0);
            tempRec.setName("collision");
            tile.getObjects().add(tempRec);
        }
        this.tileStates.put(key, tile);
    }
}
