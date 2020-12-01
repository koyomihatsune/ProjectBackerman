package oop.koyomia.boomberman.GraphicComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystem;

public interface GraphicSystemFactory {
    GraphicSystem createInstance(GameObject self);
}
