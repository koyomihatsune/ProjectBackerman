package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class BoxExplode implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getCellLayer().removeCell(self.getCell());
        self.getProperties().put("isAlive", false);
    }
}
