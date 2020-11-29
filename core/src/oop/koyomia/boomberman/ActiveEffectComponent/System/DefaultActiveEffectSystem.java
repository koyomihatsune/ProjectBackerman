package oop.koyomia.boomberman.ActiveEffectComponent.System;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.Effects.EffectFactory;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

public class DefaultActiveEffectSystem implements ActiveEffectSystem {
    GameObject self;

    public DefaultActiveEffectSystem(GameObject self) {
        this.self = self;
    }

    @Override
    public void update(List<GameObject> world, float delta) {
        ActiveEffectState activeEffectState = this.self.getActiveEffectState();
        Rectangle effectRange; // =  activeEffectState.getEffectRange();
        List<GameObject> overlapList = new ArrayList<>(); // = this.getOverlapList(effectRange, world, this.self);
        if (activeEffectState.getActiveEffectList() != null) {
            for (EffectType effectType : activeEffectState.getActiveEffectList()) {
                effectRange = activeEffectState.getEffectRange(effectType);
                if (effectRange != null) overlapList = this.getOverlapList(effectRange, world, this.self);
                Effect effect = EffectFactory.createEffect(effectType);
                overlapList.forEach(obj -> {
                    obj.getPassiveEffectState().addPassiveEffect(effect);
                });
            }
        }
    }
}
