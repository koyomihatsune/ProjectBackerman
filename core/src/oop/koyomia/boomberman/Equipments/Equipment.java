package oop.koyomia.boomberman.Equipments;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.DoNothing;

public class Equipment {
    protected boolean stillValidate = true;
    Command command;
    public Equipment(Command c){
        this.command = c;
    }
    public Command getCommand(){
        if (!stillValidate) return new DoNothing();
        return this.command;
    }

    public void setStillValidate(boolean stillValidate) {
        this.stillValidate = stillValidate;
    }

    public boolean isStillValidate() {
        return stillValidate;
    }

    public void onPop() {

    }
}
