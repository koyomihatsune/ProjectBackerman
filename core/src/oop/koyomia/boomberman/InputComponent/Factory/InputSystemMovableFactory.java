package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.NonInputSystem;
import oop.koyomia.boomberman.InputComponent.System.InputSystemDefault;

public class InputSystemMovableFactory implements InputSystemFactory {
    @Override
    public NonInputSystem createInstance(GameObject self) {
        return new InputSystemDefault(self);
    }
}
