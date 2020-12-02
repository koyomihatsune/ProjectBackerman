package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.DefaultPassiveEffectState;
import oop.koyomia.boomberman.PassiveEffectComponent.State.PassiveEffectState;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TimedSlowDownNonDup extends SlowDown {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        System.out.println("TimedSlowDownNonDup Called");
        super.execute(world, self);
        PassiveEffectState passiveEffectState = self.getPassiveEffectState();
        if (passiveEffectState instanceof DefaultPassiveEffectState) {
            List<Effect> effects = ((DefaultPassiveEffectState) passiveEffectState).getEffectList();
            AtomicBoolean isFirst = new AtomicBoolean(false);
            effects.forEach(i -> {
                if (i.getType().equals(EffectType.TIMED_SLOW_DOWN_NON_DUP)) {
                    if (isFirst.get())
                        i.setFinished(true);
                    else isFirst.set(true);
                }
            });
        }
    }
}
