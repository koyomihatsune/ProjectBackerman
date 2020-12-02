package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class RemoteBombExplode extends DefaultBombExplode {
    public void execute(List<GameObject> world, GameObject self){
        super.execute(world,self);
    }
}
