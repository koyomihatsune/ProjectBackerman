package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.RemoveObj;

public class SuddenDeath extends Effect {
    public SuddenDeath() {
        super(EffectType.SUDDEN_DEATH, new RemoveObj());
    }
}
