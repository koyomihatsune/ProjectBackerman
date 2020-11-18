package oop.koyomia.boomberman;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.AtlasTmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class GameConfig {

    public static TiledMap newGameInit(List<GameObject> world, int level) {
        TiledMap map = new TmxMapLoader().load("BackermanMap" + level + ".tmx");

        // replace all TiledMapTileLayer with our TiledMapTileLayerExt.
        MapLayer[] willBeDeleteLayer = new TiledMapTileLayer[map.getLayers().getCount()];
        int count = 0;
        for (MapLayer layer : map.getLayers()) {
            map.getLayers().add(new TiledMapTileLayerExt((TiledMapTileLayer) layer));
            willBeDeleteLayer[count++] = layer;
        }
        for (MapLayer layer : willBeDeleteLayer) {
            map.getLayers().remove(layer);
        }


        // Load all the things are visible on map, init game object from its type and add it to game world.


        return map;
    }

}
