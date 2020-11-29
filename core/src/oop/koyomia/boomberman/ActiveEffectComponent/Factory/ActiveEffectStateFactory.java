package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.GameObject.GameObject;

public interface ActiveEffectStateFactory {
    ActiveEffectState createInstance(GameObject self);
}
