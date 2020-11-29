package oop.koyomia.boomberman.ActiveEffectComponent.System;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class NonActiveEffectSystem implements ActiveEffectSystem {
    @Override
    public void update(List<GameObject> world, float delta) {
        // Do Nothing
    }
}
