package oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.GameObject.GameObject;


public class Path implements Connection<GameObject> {

    GameObject startObject;
    GameObject endObject;
    float cost;

    public Path(GameObject startObject, GameObject endObject) {
        this.startObject = startObject;
        this.endObject = endObject;
        cost = Vector2.dst(startObject.getPhysicsState().getPhysicsBody().getX(), startObject.getPhysicsState().getPhysicsBody().getY(),
                endObject.getPhysicsState().getPhysicsBody().getX(), endObject.getPhysicsState().getPhysicsBody().getY());
    }

    /**
     * Returns the non-negative cost of this connection
     */
    @Override
    public float getCost() {
        return cost;
    }

    /**
     * Returns the node that this connection came from
     */
    @Override
    public GameObject getFromNode() {
        return startObject;
    }

    /**
     * Returns the node that this connection leads to
     */
    @Override
    public GameObject getToNode() {
        return endObject;
    }
}
