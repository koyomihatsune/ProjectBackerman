package oop.koyomia.boomberman.GraphicComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GraphicSystemMoveable extends GraphicSystemDefault{
    public GraphicSystemMoveable(@NotNull GameObject self) {
        super(self);
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        super.update(world, delta);
        this.self.getGraphicState().setRenderPos(self.getPhysicsState().getXVel() + self.getGraphicState().getRenderRegion().getX(), self.getPhysicsState().getYVel() + self.getGraphicState().getRenderRegion().getY());
    }
}
