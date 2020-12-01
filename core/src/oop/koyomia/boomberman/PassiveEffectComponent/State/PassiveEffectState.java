package oop.koyomia.boomberman.PassiveEffectComponent.State;

import oop.koyomia.boomberman.Effects.Effect;

public interface PassiveEffectState {
    void addPassiveEffect(Effect effect);
    void delPassiveEffect(Effect effect);
}
