package oop.koyomia.boomberman.GraphicComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystem;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystemMoveable;

public class GraphicSystemMoveableFactory implements GraphicSystemFactory {
    @Override
    public GraphicSystem createInstance(GameObject self) {
        return new GraphicSystemMoveable(self);
    }
}
