package oop.koyomia.boomberman.PhysicsComponent;

public class PhysicsComponent {
    protected int physics_x;
    protected int physics_y;
    protected int physics_width;
    protected int physics_height;

    public int getPhysics_height() {
        return physics_height;
    }

    public int getPhysics_width() {
        return physics_width;
    }

    public int getPhysics_x() {
        return physics_x;
    }

    public int getPhysics_y() {
        return physics_y;
    }

    public void setPhysics_x(int physics_x) {
        this.physics_x = physics_x;
    }

    public void setPhysics_y(int physics_y) {
        this.physics_y = physics_y;
    }

    public void setPhysics_height(int physics_height) {
        this.physics_height = physics_height;
    }

    public void setPhysics_width(int physics_width) {
        this.physics_width = physics_width;
    }
}
