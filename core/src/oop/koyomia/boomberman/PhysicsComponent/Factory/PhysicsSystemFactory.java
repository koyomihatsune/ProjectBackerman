package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystem;

public interface PhysicsSystemFactory {
    PhysicsSystem createInstance(GameObject self);
}
