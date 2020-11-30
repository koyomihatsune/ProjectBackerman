package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.DefaultBombPut;

public class DefaultBombPutEquipment extends Equipment {

    public DefaultBombPutEquipment(){
        super(new DefaultBombPut());
    }

}
