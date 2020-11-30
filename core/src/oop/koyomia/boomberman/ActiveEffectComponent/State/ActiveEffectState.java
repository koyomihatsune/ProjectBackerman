package oop.koyomia.boomberman.ActiveEffectComponent.State;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public interface ActiveEffectState {
    void addActiveEffect(EffectType effectType);
    void removeActiveEffect(EffectType effectType);
    List<EffectType> getActiveEffectList();
    Rectangle getEffectRange();
    Rectangle getEffectRange(EffectType effectType);
}
