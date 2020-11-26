package oop.koyomia.boomberman.PhysicsComponent.State;

import com.badlogic.gdx.math.Rectangle;

public interface PhysicsState {


    /**
     * Get physics body in standard coordinate system
     *
     * @return the physics body
     */
    Rectangle getPhysicsBody();


    /**
     * Set physics body.
     *
     * @param rectangle the rectangle that x, y is offset to render coordinate in standard coordinate system (without mapping to unitScale coordinate system).
     */
    void setPhysicsBody(Rectangle rectangle);

    float getXVel();
    float getYVel();

    void setXVel(float x_vel);
    void setYVel(float y_vel);
}
