package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.awt.*;
import java.util.List;

public class RemoteBombExplode extends DefaultBombExplode {
    protected GameObject realSelf;
    public RemoteBombExplode(GameObject realSelf) {
        this.realSelf = realSelf;
    }
    public void execute(List<GameObject> world, GameObject self) {
        super.execute(world,realSelf);
    }
}
