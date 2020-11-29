package oop.koyomia.boomberman.PassiveEffectComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public interface PassiveEffectSystem {
    void update(List<GameObject> world, float delta);
}
