package oop.koyomia.boomberman.ActiveEffectComponent.System;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.Effects.EffectFactory;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.Effects.SuddenDeath;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ItemActiveEffectSystem implements ActiveEffectSystem {
    GameObject self;
    List<EffectType> listTemp;
    public ItemActiveEffectSystem(GameObject self) {
        this.self = self;
        listTemp = new ArrayList<>(this.self.getActiveEffectState().getActiveEffectList());
    }

    @Override
    public void update(List<GameObject> world, float delta) {
        ActiveEffectState activeEffectState = this.self.getActiveEffectState();
        Rectangle effectRange; // =  activeEffectState.getEffectRange();
        List<GameObject> overlapList = new ArrayList<>(); // = this.getOverlapList(effectRange, world, this.self);
        if (activeEffectState.getActiveEffectList() != null) {
            for (EffectType effectType : activeEffectState.getActiveEffectList()) {
                if (!listTemp.contains(effectType)) continue;
                effectRange = activeEffectState.getEffectRange(effectType);
                if (effectRange != null) overlapList = this.getOverlapList(effectRange, world, this.self);
                Effect effect = EffectFactory.createEffect(effectType);
                if (overlapList.size() > 0 && overlapList.get(0) != null) {
                    for (GameObject gameObject : overlapList) {
                        if (!gameObject.getType().equals("Box")) {
                            gameObject.getPassiveEffectState().addPassiveEffect(effect);
                            listTemp.remove(effectType);
                        }
                    }
                }
            }
        }
        if (listTemp.size() == 0) this.self.getPassiveEffectState().addPassiveEffect(new SuddenDeath());
    }
}
