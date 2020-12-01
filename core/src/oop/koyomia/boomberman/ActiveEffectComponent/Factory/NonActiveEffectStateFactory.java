package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.ActiveEffectComponent.State.NonActiveEffectState;
import oop.koyomia.boomberman.GameObject.GameObject;

public class NonActiveEffectStateFactory implements ActiveEffectStateFactory {

    @Override
    public ActiveEffectState createInstance(GameObject self) {
        return new NonActiveEffectState(self);
    }
}
