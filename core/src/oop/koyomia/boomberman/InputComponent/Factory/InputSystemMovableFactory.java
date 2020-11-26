package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.InputSystemDefault;

public class InputSystemMovableFactory implements InputSystemFactory {
    @Override
    public InputSystemDefault createInstance(GameObject self) {
        return new InputSystemDefault(self);
    }
}
