package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.DefaultPassiveEffectState;
import oop.koyomia.boomberman.PassiveEffectComponent.State.PassiveEffectState;

public class DefaultPassiveEffectStateFactory implements PassiveEffectStateFactory {
    @Override
    public PassiveEffectState createInstance(GameObject self) {
        return new DefaultPassiveEffectState(self);
    }
}
