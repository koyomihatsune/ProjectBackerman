package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsStateMoveable;

public class PhysicsStateMoveableFactory implements PhysicsStateFactory {
    @Override
    public PhysicsState createInstance(GameObject self) {
        return new PhysicsStateMoveable(self);
    }
}
