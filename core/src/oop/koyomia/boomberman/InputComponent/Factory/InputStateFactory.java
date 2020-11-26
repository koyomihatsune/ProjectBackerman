package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.State.InputState;

public interface InputStateFactory {
    InputState createInstance(GameObject self);
}
