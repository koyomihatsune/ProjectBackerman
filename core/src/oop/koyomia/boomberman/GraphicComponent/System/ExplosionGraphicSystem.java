package oop.koyomia.boomberman.GraphicComponent.System;

import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExplosionGraphicSystem extends GraphicSystemDefault{
    public ExplosionGraphicSystem(@NotNull GameObject self) {
        super(self);
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        super.update(world, delta);
        if (((AnimatedTiledMapTileExt)self.getGraphicState().getTile()).isAnimationFinished()) {
            self.getProperties().put("isAlive", false);
        }
    }
}
