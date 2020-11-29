package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.System.DefaultPassiveEffectSystem;
import oop.koyomia.boomberman.PassiveEffectComponent.System.PassiveEffectSystem;

public class DefaultPassiveEffectSystemFactory implements PassiveEffectSystemFactory {
    @Override
    public PassiveEffectSystem createInstance(GameObject self) {
        return new DefaultPassiveEffectSystem(self);
    }
}
