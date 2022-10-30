package oop.koyomia.boomberman.InputComponent.InputManagement.AIComponent;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import oop.koyomia.boomberman.GameObject.GameObject;


import java.util.List;

public class PathGraph implements IndexedGraph<GameObject> {

    protected List<GameObject> world;

    PathEstimator pathHeuristic = new PathEstimator();
    Array<GameObject> objectList = new Array<GameObject>();
    Array<Path> paths = new Array<Path>();

    ObjectMap<GameObject, Array<Connection<GameObject>>> pathMap = new ObjectMap<GameObject, Array<Connection<GameObject>>>();

    private int lastNodeIndex = 0;

    public void addGameObject(GameObject object) {
        object.setIndex(lastNodeIndex);
        objectList.add(object);
        lastNodeIndex++;
    }

    public void connectObject(GameObject startObject, GameObject endObject) {
        Path path = new Path(startObject,endObject);

        if (!pathMap.containsKey(startObject)){
            pathMap.put(startObject, new Array<Connection<GameObject>>());
        }
        pathMap.get(startObject).add(path);
        paths.add(path);
    }

    public GraphPath<GameObject> findPath(GameObject initObj, GameObject goalObj){
//        System.out.println("Find path PathGraph");
//        System.out.println("Init object:" + initObj.getIndex());
//        System.out.println("Goal object:" + goalObj.getIndex());
        GraphPath<GameObject> onMapPath = new DefaultGraphPath<GameObject>();
        new IndexedAStarPathFinder<>(this).searchNodePath(initObj,goalObj,pathHeuristic,onMapPath);
        return onMapPath;
    }

    /**
     * Returns the unique index of the given node.
     *
     * @param node the node whose index will be returned
     * @return the unique index of the given node.
     */
    @Override
    public int getIndex(GameObject node) {
        return node.index;
    }

    /**
     * Returns the number of nodes in this graph.
     */
    @Override
    public int getNodeCount() {
        return lastNodeIndex;
    }

    /**
     * Returns the connections outgoing from the given node.
     *
     * @param fromNode the node whose outgoing connections will be returned
     * @return the array of connections outgoing from the given node.
     */
    @Override
    public Array<Connection<GameObject>> getConnections(GameObject fromNode) {
        if (pathMap.containsKey(fromNode)){
            return pathMap.get(fromNode);
        }
        return new Array<>(0);
    }

}
