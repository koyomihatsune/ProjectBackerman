package oop.koyomia.boomberman.GameObject;

import oop.koyomia.boomberman.PhysicsComponent.PhysicsComponent;

public class TouchableObject extends GameObject {
    protected PhysicsComponent physicsComponent;

    public PhysicsComponent getPhysicsComponent() {
        return physicsComponent;
    }

    public boolean checkCollision(TouchableObject other) {
        PhysicsComponent this_ = this.getPhysicsComponent();
        PhysicsComponent that_ = other.getPhysicsComponent();
        return this_.getPhysics_x() < that_.getPhysics_x() + that_.getPhysics_width() &&
                this_.getPhysics_x() + this_.getPhysics_width() > that_.getPhysics_x() &&
                this_.getPhysics_y() < that_.getPhysics_y() + that_.getPhysics_height() &&
                this_.getPhysics_y() + this_.getPhysics_height() > that_.getPhysics_y();
    }
}
