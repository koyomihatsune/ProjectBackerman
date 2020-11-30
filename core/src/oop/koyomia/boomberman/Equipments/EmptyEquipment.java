package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.DoNothing;

public class EmptyEquipment extends Equipment {
    public EmptyEquipment(){
        super(new DoNothing());
    }
}
