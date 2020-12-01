package oop.koyomia.boomberman.PassiveEffectComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.System.PassiveEffectSystem;

public interface PassiveEffectSystemFactory {
    PassiveEffectSystem createInstance(GameObject self);
}
