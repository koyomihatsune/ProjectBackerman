package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.Explode;
import oop.koyomia.boomberman.Command.SlowDownNonDup;

public class EffectFactory {
    public static Effect createEffect(EffectType effectType) {
        switch (effectType) {
            case FAST_UP:
                return null;
            case EXPLOSION_NON_DUP:
                return new Explosion(new Explode());
            case FIRE_BURN:
                return null;
            case SLOW_DOWN:
                return new SlowDownEffect();
            case SLOW_DOWN_NON_DUP:
                SlowDownEffect slowDownEffect = new SlowDownEffect();
                slowDownEffect.setCommand(new SlowDownNonDup());
                slowDownEffect.setType(EffectType.SLOW_DOWN_NON_DUP);
                return slowDownEffect;
            default:
                return null;
        }
    }
}
