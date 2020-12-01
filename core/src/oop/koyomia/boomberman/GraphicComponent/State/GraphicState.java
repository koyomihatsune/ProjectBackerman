package oop.koyomia.boomberman.GraphicComponent.State;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;

/**
 * The interface Graphic state.
 */
public interface GraphicState {
    /**
     * Sets tile.
     *
     * @param tile the tile
     */
    void setTile(TiledMapTile tile);

    /**
     * Gets tile.
     *
     * @return the tile
     */
    TiledMapTile getTile();


    /**
     * Gets render region.
     *
     * @return the render region in Map
     */
    Rectangle getRenderRegion();

    HashMap<String, TiledMapTile> getTileStates();

    void setRenderPos(float x, float y);
}
