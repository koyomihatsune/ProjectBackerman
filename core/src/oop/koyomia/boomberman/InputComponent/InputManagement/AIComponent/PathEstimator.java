package oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent;

import com.badlogic.gdx.ai.pfa.Heuristic;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.GameObject.GameObject;


public class PathEstimator implements Heuristic<GameObject> {

    /**
     * Calculates an estimated cost to reach the goal node from the given node.
     *
     * @param startObject the start node
     * @param endObject the end node
     * @return the estimated cost
     */
    @Override
    public float estimate(GameObject startObject, GameObject endObject) {
        return Vector2.dst(startObject.getPhysicsState().getPhysicsBody().getX(), startObject.getPhysicsState().getPhysicsBody().getY(),
                endObject.getPhysicsState().getPhysicsBody().getX(), endObject.getPhysicsState().getPhysicsBody().getY());
    }
}
