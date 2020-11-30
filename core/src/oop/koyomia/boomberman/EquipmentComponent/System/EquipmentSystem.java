package oop.koyomia.boomberman.EquipmentComponent.System;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface EquipmentSystem {

//    Command certainEquipmentFire();

    void update(@NotNull List<GameObject> world, float delta);
}
