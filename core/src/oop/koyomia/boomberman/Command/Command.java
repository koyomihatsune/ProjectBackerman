package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public interface Command {
    void execute(List<GameObject> world, GameObject self);
}
