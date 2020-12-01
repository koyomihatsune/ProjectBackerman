package oop.koyomia.boomberman.GraphicComponent.Factory;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicState;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicStateMovable;

import java.util.Iterator;

public class GraphicStateMovableFactory implements GraphicStateFactory {
    @Override
    public GraphicState createInstance(GameObject self, TiledMapTileSet tileSet) {
        TiledMapTile curTile = self.getCell().getTile();
        String ignoreProperty = "|tileheight|imageheight|tilewidth|spacing|imagesource|firstgid|margin|imagewidth|";
        int firstgid = (int)tileSet.getProperties().get("firstgid");
        if (curTile == null || self.getCell() == null) throw new IllegalArgumentException("Tile Null or Cell null");
        GraphicStateMovable graphicState = new GraphicStateMovable(self);
        for (Iterator<String> it = tileSet.getProperties().getKeys(); it.hasNext(); ) {
            String curKey = it.next();
            if (!ignoreProperty.contains(curKey))
                graphicState.putGraphicState(curKey, tileSet.getTile((Integer) tileSet.getProperties().get(curKey) + firstgid));
        }
        return graphicState;
    }
}
