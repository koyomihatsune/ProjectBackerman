package oop.koyomia.boomberman;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;

public class GameObjectFactory {
    public static GameObject getGameObject(TiledMap map) {

        for (MapLayer layer : map.getLayers()) {
            TiledMapTileLayerExt layerExt = (TiledMapTileLayerExt) layer;
            for (TiledMapTileLayerExt.FreeCell cell : layerExt.freeCells) {
                String type;
                try {
                    type = (String) cell.getTile().getProperties().get("type");
                } catch (Exception e) {
                    type = "";
                }
                switch (type) {
                    case "Main" :
                        break;
                    case "Wall" :
                        break;
                }
            }
        }
        return null;
    }
}
