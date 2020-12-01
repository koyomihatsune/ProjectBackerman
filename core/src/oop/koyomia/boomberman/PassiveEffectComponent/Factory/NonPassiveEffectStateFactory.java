package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.NonPassiveEffectState;
import oop.koyomia.boomberman.PassiveEffectComponent.State.PassiveEffectState;

public class NonPassiveEffectStateFactory implements PassiveEffectStateFactory{
    @Override
    public PassiveEffectState createInstance(GameObject self) {
        return new NonPassiveEffectState(self);
    }
}
