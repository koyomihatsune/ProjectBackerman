package oop.koyomia.boomberman.PhysicsComponent.State;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

public class BombPhysicsState extends PhysicsStateMovable {
    protected List<GameObject> acceptThrough;
    public BombPhysicsState(GameObject self) {
        super(self);
    }
    public List<GameObject> getAcceptThrough() {
        return this.acceptThrough;
    }

    public void setAcceptThrough(List<GameObject> acceptThrough) {
        this.acceptThrough = acceptThrough;
    }
}
