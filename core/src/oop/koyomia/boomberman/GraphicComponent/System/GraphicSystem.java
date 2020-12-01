package oop.koyomia.boomberman.GraphicComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface GraphicSystem {
    void update(@NotNull List<GameObject> world, float delta);
}
