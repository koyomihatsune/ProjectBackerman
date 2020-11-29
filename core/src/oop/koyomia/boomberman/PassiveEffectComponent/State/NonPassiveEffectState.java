package oop.koyomia.boomberman.PassiveEffectComponent.State;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.GameObject.GameObject;

public class NonPassiveEffectState implements PassiveEffectState {

    public NonPassiveEffectState(GameObject self) {};

    @Override
    public void addPassiveEffect(Effect effect) {
        // Do Nothing
    }

    @Override
    public void delPassiveEffect(Effect effect) {
        // Do Nothing
    }
}
