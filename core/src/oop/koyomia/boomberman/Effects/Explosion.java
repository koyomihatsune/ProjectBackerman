package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.Explode;

public class Explosion extends Effect {

    public Explosion(Command command) {
        super(EffectType.EXPLOSION_NON_DUP, new Explode());
    }

}
