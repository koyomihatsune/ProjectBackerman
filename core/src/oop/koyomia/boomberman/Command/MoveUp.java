package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

import static oop.koyomia.boomberman.GameConfig.CHARACTER_VELOCITY;

public class MoveUp implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getPhysicsState().setYVel(CHARACTER_VELOCITY);
    }
}
