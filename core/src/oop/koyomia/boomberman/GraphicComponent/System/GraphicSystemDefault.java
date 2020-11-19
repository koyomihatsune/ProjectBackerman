package oop.koyomia.boomberman.GraphicComponent.System;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystem;
import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class GraphicSystemDefault implements GraphicSystem {
    protected GameObject self;
    public GraphicSystemDefault(@NotNull GameObject self) {
        this.self = self;
    }

    public float getX() {
        return this.self.getCell().getX();
    }

    public float getY() {
        return this.self.getCell().getY();
    }

    public void setX(float x) {
        this.self.getCell().setX(x);
    }

    public void setY(float y) {
        this.self.getCell().setY(y);
    }

    public TiledMapTile getTile() {
        return this.self.getCell().getTile();
    }

    public void update(@NotNull List<GameObject> world, float delta) {

    };

}
