package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.DefaultBombPut;
import oop.koyomia.boomberman.Command.DoNothing;

public class DefaultBombPutEquipment extends Equipment {
    public int bombRemain = 2;
    public DefaultBombPutEquipment(){
        super(new DefaultBombPut());
    }

    @Override
    public Command getCommand() {
        if (bombRemain > 0) {
            bombRemain--;
            return super.getCommand();
        } else return new DoNothing();
    }

    public void incBombRemain() {
        this.bombRemain++;
    }
}
