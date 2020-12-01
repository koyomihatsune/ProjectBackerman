package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.System.ActiveEffectSystem;
import oop.koyomia.boomberman.GameObject.GameObject;

public interface ActiveEffectSystemFactory {
    ActiveEffectSystem createInstance(GameObject self);

}
