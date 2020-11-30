package oop.koyomia.boomberman.PassiveEffectComponent.State;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

public class DefaultPassiveEffectState implements PassiveEffectState {
    protected GameObject self;
    protected List<Effect> effectList;

    public DefaultPassiveEffectState(GameObject self) {
        this.self = self;
        this.effectList = new ArrayList<>();
    }

    @Override
    public void addPassiveEffect(Effect effect) {
        this.effectList.add(effect);
    }

    @Override
    public void delPassiveEffect(Effect effect) {
        this.effectList.remove(effect);
    }

    public List<Effect> getEffectList() {
        return effectList;
    }
}
