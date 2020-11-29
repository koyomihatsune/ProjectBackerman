package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public abstract class Effect {
    protected Command command;
    protected EffectType type;
    protected boolean isFinished;
    public Effect(EffectType type, Command command) {
        this.type = type;
        this.command = command;
        this.isFinished = false;
    }
    public abstract void execute(GameObject target, List<GameObject> world);

    public boolean isFinished() {
        return isFinished;
    }
}
