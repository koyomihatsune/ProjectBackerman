package oop.koyomia.boomberman.GraphicComponent.System;

import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BoxGraphicSystem extends GraphicSystemDefault {
    public BoxGraphicSystem(GameObject self) {
        super(self);
    }
    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        try {
            if (((AnimatedTiledMapTileExt)this.self.getGraphicState().getTile()).isAnimationFinished()) {
                self.getProperties().put("isAlive", false);
            }
        } catch (ClassCastException e) {

        }
    }
}
