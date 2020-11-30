package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsStateMovable;

public class PhysicsStateMovableFactory implements PhysicsStateFactory {

    @Override
    public PhysicsState createInstance(GameObject self) {
        return new PhysicsStateMovable(self);
    }
}
