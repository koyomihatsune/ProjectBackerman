package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public interface Command {
//    void addCommand(String key, Command command);
//    void deleteCommand(String key);
//    void deleteCommand(Command command);
    void execute(List<GameObject> world, GameObject self);
}
