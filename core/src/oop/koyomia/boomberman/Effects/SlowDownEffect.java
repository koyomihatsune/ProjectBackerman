package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.SlowDown;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class SlowDownEffect extends Effect {
    public SlowDownEffect() {
        super(EffectType.SLOW_DOWN, new SlowDown());
    }

    @Override
    public void execute(GameObject target, List<GameObject> world) {
        this.command.execute(world, target);
        this.isFinished = true;
    }
}
