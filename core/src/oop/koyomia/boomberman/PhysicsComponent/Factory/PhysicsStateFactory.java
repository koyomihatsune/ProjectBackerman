package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;

public interface PhysicsStateFactory {
    PhysicsState createInstance(GameObject self);
}
