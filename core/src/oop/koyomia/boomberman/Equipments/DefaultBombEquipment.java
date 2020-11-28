package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.DefaultBombPut;

public class DefaultBombEquipment extends Equipment {

    public DefaultBombEquipment(){
        super(new DefaultBombPut());
    }

}
