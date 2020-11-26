package oop.koyomia.boomberman.InputComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface InputSystem {
    void update(@NotNull List<GameObject> world, float delta);
}
