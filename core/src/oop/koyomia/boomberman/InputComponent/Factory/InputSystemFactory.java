package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.InputSystemDefault;

public interface InputSystemFactory {
    InputSystemDefault createInstance(GameObject self);
}
