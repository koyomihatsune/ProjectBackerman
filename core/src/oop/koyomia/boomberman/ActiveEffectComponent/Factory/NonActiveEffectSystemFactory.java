package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.System.ActiveEffectSystem;
import oop.koyomia.boomberman.ActiveEffectComponent.System.NonActiveEffectSystem;
import oop.koyomia.boomberman.GameObject.GameObject;

public class NonActiveEffectSystemFactory implements ActiveEffectSystemFactory{
    @Override
    public ActiveEffectSystem createInstance(GameObject self) {
        return new NonActiveEffectSystem();
    }
}
