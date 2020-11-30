package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class DefaultBombPut implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {

        System.out.println("Bomb put!");
    }
}
