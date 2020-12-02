package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.RemoteBombExplode;
import oop.koyomia.boomberman.GameObject.GameObject;

public class RemoteBombExplodeEquipment extends Equipment {
    public RemoteBombExplodeEquipment(GameObject realSelf) {
        super(new RemoteBombExplode(realSelf));
    }
}
