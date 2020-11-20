package oop.koyomia.boomberman.PhysicsComponent.State;

import oop.koyomia.boomberman.GameObject.GameObject;

public class PhysicsStateMoveable extends PhysicsStateDefault{
    PhysicsStateMoveable(GameObject self) {
        super(self);
    }

    @Override
    public float getXVel() {
        return this.x_vel;
    }

    @Override
    public float getYVel() {
        return this.y_vel;
    }

    // Only support one direction moving
    @Override
    public void setXVel(float x_vel) {
        this.x_vel = x_vel;
        this.y_vel = 0;
    }

    // Only support one direction moving
    @Override
    public void setYVel(float y_vel) {
        this.y_vel = y_vel;
        this.x_vel = 0;
    }

}
