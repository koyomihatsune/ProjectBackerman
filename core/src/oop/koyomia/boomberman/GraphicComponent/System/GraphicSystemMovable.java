package oop.koyomia.boomberman.GraphicComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GraphicSystemMovable extends GraphicSystemDefault{
    public GraphicSystemMovable(@NotNull GameObject self) {
        super(self);
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        super.update(world, delta);
        GraphicState graphicState = this.self.getGraphicState();
        if (this.self.getPhysicsState().getXVel() > 0) graphicState.setTile(graphicState.getTileStates().get("go_right"));
        if (this.self.getPhysicsState().getXVel() < 0) graphicState.setTile(graphicState.getTileStates().get("go_left"));
        if (this.self.getPhysicsState().getYVel() > 0) graphicState.setTile(graphicState.getTileStates().get("go_up"));
        if (this.self.getPhysicsState().getYVel() < 0) graphicState.setTile(graphicState.getTileStates().get("go_down"));
        if (this.self.getPhysicsState().getXVel() == 0 && this.self.getPhysicsState().getYVel() == 0) graphicState.setTile(graphicState.getTileStates().get("idle"));
        this.self.getGraphicState().setRenderPos(self.getPhysicsState().getXVel() + self.getGraphicState().getRenderRegion().getX(), self.getPhysicsState().getYVel() + self.getGraphicState().getRenderRegion().getY());
    }
}
