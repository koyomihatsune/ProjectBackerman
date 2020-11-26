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

    public void update(@NotNull List<GameObject> world, float delta) {
        // No Chance
    }

}
