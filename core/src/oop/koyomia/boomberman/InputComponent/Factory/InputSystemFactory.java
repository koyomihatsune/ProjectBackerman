package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.NonInputSystem;

public interface InputSystemFactory {
    NonInputSystem createInstance(GameObject self);
}
