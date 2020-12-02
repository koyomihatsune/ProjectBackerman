package oop.koyomia.boomberman.PhysicsComponent.System;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.BombPhysicsState;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BombPhysicsSystem extends PhysicsSystemMovable{
    public BombPhysicsSystem(@NotNull GameObject self) {
        super(self);
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        super.update(world, delta);
        BombPhysicsState bombPhysicsState =(BombPhysicsState) self.getPhysicsState();
        if (bombPhysicsState.getAcceptThrough() == null) bombPhysicsState.setAcceptThrough(bombPhysicsState.currentCollide);
        else {
            bombPhysicsState.getAcceptThrough().removeIf(i -> !bombPhysicsState.currentCollide.contains(i));
        }
    }
}
