package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.DoNothing;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class Effect {
    protected Command command;
    protected EffectType type;
    protected boolean isFinished;
    public Effect(EffectType type, Command command) {
        this.type = type;
        this.command = command;
        this.isFinished = false;
    }

    public void execute(GameObject target, List<GameObject> world) {
        if (isFinished) this.command = new DoNothing();
        this.command.execute(world, target);
    };

    public boolean isFinished() {
        return isFinished;
    }

    public EffectType getType() {
        return type;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setType(EffectType type) {
        this.type = type;
    }
}
