package oop.koyomia.boomberman.PhysicsComponent.System;

import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;


public class PhysicsSystemDefault implements PhysicsSystem {

    protected GameObject self;

    public PhysicsSystemDefault(@NotNull GameObject self) {
        this.self = self;
    }


    @Override
    public List<GameObject> overlapList(List<GameObject> world) {
        List<GameObject> overlapList = new ArrayList<>();
        for (GameObject entity : world) {
            if (this.self.getPhysicsState().getPhysicsBody().overlaps(entity.getPhysicsState().getPhysicsBody()) && this.self != entity)
                overlapList.add(entity);
        }
        return overlapList;
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        List<GameObject> currentCollide = this.overlapList(world);
        List<GameObject> futureCollide = this.getOverlapList(this.self.getPhysicsState().getPhysicsBody(), world, this.self);
        if (futureCollide.size() != 0) {
            this.self.getPhysicsState().setXVel(0);
            this.self.getPhysicsState().setYVel(0);
        }
    }

}
