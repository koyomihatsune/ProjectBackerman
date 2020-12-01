package oop.koyomia.boomberman.PassiveEffectComponent.System;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.DefaultPassiveEffectState;

import java.util.List;

public class DefaultPassiveEffectSystem implements PassiveEffectSystem {
    protected GameObject self;

    public DefaultPassiveEffectSystem(GameObject self) {
        this.self = self;
    }



    @Override
    public void update(List<GameObject> world, float delta) {
        List<Effect> currentEffecting = ((DefaultPassiveEffectState)self.getPassiveEffectState()).getEffectList();
        // Active Effect per frame
        for (Effect effect : currentEffecting) {
            effect.execute(this.self, world);
        }

        // Delete Effect finished
        currentEffecting.removeIf(Effect::isFinished);
    }
}
