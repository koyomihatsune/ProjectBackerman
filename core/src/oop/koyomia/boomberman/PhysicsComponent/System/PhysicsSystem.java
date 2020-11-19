package oop.koyomia.boomberman.PhysicsComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PhysicsSystem {
    void update(@NotNull List<GameObject> world, float delta);
}
