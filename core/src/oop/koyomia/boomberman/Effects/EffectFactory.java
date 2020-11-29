package oop.koyomia.boomberman.Effects;

public class EffectFactory {
    public static Effect createEffect(EffectType effectType) {
        switch (effectType) {
            case FAST_UP:
                return null;
            case EXPLOSION:
                return null;
            case FIRE_BURN:
                return null;
            case SLOW_DOWN:
                return new SlowDownEffect();
            default:
                return null;
        }
    }
}
