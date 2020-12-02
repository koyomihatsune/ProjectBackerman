package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.DefaultPassiveEffectState;
import oop.koyomia.boomberman.PassiveEffectComponent.State.PassiveEffectState;

import java.util.List;

public class FastUpNonDup extends FastUp {

    @Override
    public void execute(List<GameObject> world, GameObject self) {
        super.execute(world, self);
        PassiveEffectState passiveEffectState = self.getPassiveEffectState();
        if (passiveEffectState instanceof DefaultPassiveEffectState) {
            List<Effect> effects = ((DefaultPassiveEffectState) passiveEffectState).getEffectList();
            effects.forEach(i -> {
                if (i.getType().equals(EffectType.FAST_UP_NON_DUP)) {
                    i.setFinished(true);
                }
            });
        }
    }

}