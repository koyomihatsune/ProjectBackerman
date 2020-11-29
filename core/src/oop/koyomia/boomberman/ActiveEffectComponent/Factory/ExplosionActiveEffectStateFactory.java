package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.ActiveEffectComponent.State.DefaultActiveEffectState;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;

public class ExplosionActiveEffectStateFactory implements ActiveEffectStateFactory {
    @Override
    public ActiveEffectState createInstance(GameObject self) {
        ActiveEffectState activeEffectState = new DefaultActiveEffectStateFactory().createInstance(self);
        activeEffectState.addActiveEffect(EffectType.EXPLOSION);
        return activeEffectState;
    }
}
