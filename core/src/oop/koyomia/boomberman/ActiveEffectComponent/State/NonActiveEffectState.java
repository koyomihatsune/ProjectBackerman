package oop.koyomia.boomberman.ActiveEffectComponent.State;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class NonActiveEffectState implements ActiveEffectState {

    public NonActiveEffectState(GameObject self) {

    }

    @Override
    public void addActiveEffect(EffectType effectType) {
        // Do Nothing
    }

    @Override
    public void removeActiveEffect(EffectType effectType) {
        // Do Nothing
    }

    @Override
    public List<EffectType> getActiveEffectList() {
        return null;
    }

    @Override
    public Rectangle getEffectRange() {
        return null;
    }

    @Override
    public Rectangle getEffectRange(EffectType effectType) {
        return null;
    }
}
