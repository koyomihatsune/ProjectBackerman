package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystem;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystemDefault;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystemMovable;

public class PhysicsSystemMoveableFactory implements PhysicsSystemFactory {
    @Override
    public PhysicsSystem createInstance(GameObject self) {
        return new PhysicsSystemMovable(self);
    }
}
