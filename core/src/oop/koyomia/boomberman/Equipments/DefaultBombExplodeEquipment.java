package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.DefaultBombExplode;

public class DefaultBombExplodeEquipment extends Equipment {

    public DefaultBombExplodeEquipment(){
        super(new DefaultBombExplode());
    }

}
