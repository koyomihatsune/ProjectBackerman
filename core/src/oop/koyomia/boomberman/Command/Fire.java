package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class Fire implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        System.out.println("Fired!");
        self.getEquipmentState().useEquippedEquipment().getCommand().execute(world,self);
    }
}
