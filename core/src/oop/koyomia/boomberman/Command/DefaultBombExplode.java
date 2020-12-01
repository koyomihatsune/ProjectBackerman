package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class DefaultBombExplode implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getEquipmentState().restoreDefaultBomb();
        world.remove(self);
        System.out.println("Bomb explode!");
    }
}
