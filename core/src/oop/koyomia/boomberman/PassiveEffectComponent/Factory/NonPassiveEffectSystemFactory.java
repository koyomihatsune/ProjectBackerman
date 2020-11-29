package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.System.NonPassiveEffectSystem;
import oop.koyomia.boomberman.PassiveEffectComponent.System.PassiveEffectSystem;

public class NonPassiveEffectSystemFactory implements PassiveEffectSystemFactory {
    @Override
    public PassiveEffectSystem createInstance(GameObject self) {
        return new NonPassiveEffectSystem();
    }
}
