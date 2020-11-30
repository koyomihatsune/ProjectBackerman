package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.System.ActiveEffectSystem;
import oop.koyomia.boomberman.ActiveEffectComponent.System.DefaultActiveEffectSystem;
import oop.koyomia.boomberman.GameObject.GameObject;

public class DefaultActiveEffectSystemFactory implements ActiveEffectSystemFactory {
    @Override
    public ActiveEffectSystem createInstance(GameObject self) {
        return new DefaultActiveEffectSystem(self);
    }
}
