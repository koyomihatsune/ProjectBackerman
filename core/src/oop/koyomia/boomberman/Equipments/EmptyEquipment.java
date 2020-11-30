package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.DoNothing;
import oop.koyomia.boomberman.Command.RemoteBombExplode;

public class EmptyEquipment extends Equipment {
    public EmptyEquipment(){
        super(new DoNothing());
    }
}
