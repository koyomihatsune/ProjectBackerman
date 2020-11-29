package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.PassiveEffectState;

public interface PassiveEffectStateFactory {
    PassiveEffectState createInstance(GameObject self);
}
