package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class FastUp implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getPhysicsState().setXVel(self.getPhysicsState().getXVel() * 1.5f);
        self.getPhysicsState().setYVel(self.getPhysicsState().getYVel() * 1.5f);
    }
}
