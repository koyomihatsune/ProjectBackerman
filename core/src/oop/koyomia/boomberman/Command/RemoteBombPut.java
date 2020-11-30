package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.Equipments.RemoteBombExplodeEquipment;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class RemoteBombPut implements Command {
    public void execute(List<GameObject> world, GameObject self){
        self.getEquipmentState().addEquipmentFromItem(new RemoteBombExplodeEquipment());
    }
}
