package oop.koyomia.boomberman.PhysicsComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsStateMovable;

<<<<<<< HEAD:core/src/oop/koyomia/boomberman/PhysicsComponent/Factory/PhysicStatesMovableFactory.java
public class PhysicStatesMovableFactory implements PhysicsStateFactory {
=======
public class PhysicsStateMoveableFactory implements PhysicsStateFactory {
>>>>>>> StableReview_VietAnh:core/src/oop/koyomia/boomberman/PhysicsComponent/Factory/PhysicsStateMoveableFactory.java
    @Override
    public PhysicsState createInstance(GameObject self) {
        return new PhysicsStateMovable(self);
    }
}
