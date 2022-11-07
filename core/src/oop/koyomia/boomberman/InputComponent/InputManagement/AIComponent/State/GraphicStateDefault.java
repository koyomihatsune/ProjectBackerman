package oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent.State;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;


/**
 * The type Graphic state default.
 */
public class GraphicStateDefault implements GraphicState {
    protected GameObject self;

    public GraphicStateDefault(GameObject self) {
        this.self = self;
    }

    @Override
    public void setTile(TiledMapTile tile) {
        self.getCell().setTile(tile);
    }

    @Override
    public TiledMapTile getTile() {
        return self.getCell().getTile();
    }

    /**
     * Gets render region.
     *
     * @return the render region in Map without multiply for unitScale
     */
    @Override
    public Rectangle getRenderRegion() {
        return new Rectangle(self.getCell().getX(),
                self.getCell().getY(),
                self.getCell().getTile().getTextureRegion().getRegionWidth(),
                self.getCell().getTile().getTextureRegion().getRegionHeight());
    }

    @Override
    public HashMap<String, TiledMapTile> getTileStates() {
        throw new UnsupportedOperationException();
    }


    /**
     * Sets render pos.
     *
     * @param x and @param y the x and y coordinate without mapping to unitScale multiplied coordinate system
     */
    public void setRenderPos(float x, float y) {
        this.self.getCell().setX(x);
        this.self.getCell().setY(y);
    }
}
