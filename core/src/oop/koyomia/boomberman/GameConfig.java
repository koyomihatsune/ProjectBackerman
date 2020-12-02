package oop.koyomia.boomberman;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicStateMovable;
import oop.koyomia.boomberman.PhysicsComponent.Factory.PhysicsSystemFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameConfig {
    public static final float unitScale = 3.0f;
    public static final float CHARACTER_VELOCITY = 2.0f;
    public static int map_width;
    public static int map_height;
    public static int tile_width;
    public static int tile_height;
    public static TiledMap map;
    public static HashMap<TiledMapTileSet, HashMap<String, TiledMapTile>> mapSpecialTile = new HashMap<>();
    public static TiledMap newGameInit(List<GameObject> world, int level) {
        TiledMap map = new TmxMapLoader().load("BackermanMap1.tmx");
        GameConfig.map = map;
        GameConfig.map_width = (int) map.getProperties().get("width");
        GameConfig.map_height = (int) map.getProperties().get("height");
        GameConfig.tile_height = (int) map.getProperties().get("tileheight");
        GameConfig.tile_width = (int) map.getProperties().get("tilewidth");
        // replace all TiledMapTileLayer with our TiledMapTileLayerExt.
        MapLayer[] willBeDeleteLayer = new TiledMapTileLayer[map.getLayers().getCount()];
        int count = 0;
        for (int i = 0; i < willBeDeleteLayer.length; i++) {
            map.getLayers().add(new TiledMapTileLayerExt((TiledMapTileLayer) map.getLayers().get(i)));
            willBeDeleteLayer[count++] = map.getLayers().get(i);
        }
        for (MapLayer layer : willBeDeleteLayer) {
            map.getLayers().remove(layer);
        }
        // Load all the things are visible on map, init game object from its type and add it to game world.
        world.addAll(GameObjectFactory.getGameObject(map));
        GameConfig.loadSpecialTile(map);
        return map;
    }
    public static Vector2 getSquareCoor(GameObject gameObject) {
        Rectangle body = gameObject.getPhysicsState().getPhysicsBody();
        Vector2 particularCoor = new Vector2(body.x + body.getWidth() / 2, body.y + body.getHeight() / 2);
        Vector2 coor = new Vector2((int) (particularCoor.x / (tile_width)), (int) (particularCoor.y / (tile_height)));
        if (!validateSquareCoor(coor)) throw new ArrayIndexOutOfBoundsException("Coor.x : " + coor.x + "Coor.y : " + coor.y);
        return coor;
    }

    public static void addCellToCharLayer(TiledMapTileLayerExt.FreeCell freeCell) {
        ((TiledMapTileLayerExt)map.getLayers().get("Up items")).addFreeCell(freeCell);
    }

    public static TiledMapTileLayerExt.FreeCell createNewFreeCell(TiledMapTile tile, float x, float y) {
        TiledMapTileLayer.Cell newCell = new TiledMapTileLayer.Cell();
        newCell.setTile(tile);
        newCell.setRotation(0);
        newCell.setFlipHorizontally(false);
        newCell.setFlipVertically(false);
        return new TiledMapTileLayerExt.FreeCell(newCell, x, y);
    }

    public static void loadSpecialTile(TiledMap map) {
        for (TiledMapTileSet tileSet : map.getTileSets()) {
            String ignoreProperty = "|tileheight|imageheight|tilewidth|spacing|imagesource|firstgid|margin|imagewidth|";
            HashMap<String, TiledMapTile> tempMap = new HashMap<>();
            int firstgid = (int)tileSet.getProperties().get("firstgid");
            for (Iterator<String> it = tileSet.getProperties().getKeys(); it.hasNext(); ) {
                String curKey = it.next();
                if (!ignoreProperty.contains(curKey)) {
                    tempMap.put(curKey, tileSet.getTile((Integer) tileSet.getProperties().get(curKey) + firstgid));
                    mapSpecialTile.put(tileSet, tempMap);
                }
            }
        }
    }

    public static Vector2 getParticularCoor(Vector2 squareCoor) {
        return new Vector2(squareCoor.x * GameConfig.tile_width, squareCoor.y * GameConfig.tile_height);
    }

    public static List<GameObject> getOverlapList(Rectangle rec, List<GameObject> world, GameObject ignoreObj) {
        List<GameObject> overlapList = new ArrayList<>();
        world.forEach((i) -> {if (rec.overlaps(i.getPhysicsState().getPhysicsBody()) && i.getPhysicsState().getPhysicsBody().getWidth() != 0 && i.getPhysicsState().getPhysicsBody().getHeight() != 0) overlapList.add(i);});
        if (ignoreObj != null) overlapList.remove(ignoreObj);
        return overlapList;
    }

    public static boolean validateSquareCoor(Vector2 squareCoor) {
        if (squareCoor.x >= map_width || squareCoor.x < 0 || squareCoor.y >= map_height || squareCoor.y < 0) return false;
        return true;
    }


}
