package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class SlowDown implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getPhysicsState().setXVel(self.getPhysicsState().getXVel() * 0.2f);
        self.getPhysicsState().setYVel(self.getPhysicsState().getYVel() * 0.2f);
    }
}
