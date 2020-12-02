package oop.koyomia.boomberman.Effects;

import oop.koyomia.boomberman.Command.*;

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
            case FAST_UP_NON_DUP:
                FastUpEffect fastUpEffect = new FastUpEffect();
                fastUpEffect.setCommand(new FastUpNonDup());
                fastUpEffect.setType(EffectType.FAST_UP_NON_DUP);
                return fastUpEffect;
            case TIMED_SLOW_DOWN_NON_DUP:
                SlowDownEffect timedSlowDownEffect = new SlowDownEffect();
                timedSlowDownEffect.setCommand(new TimedSlowDownNonDup());
                timedSlowDownEffect.setType(EffectType.TIMED_SLOW_DOWN_NON_DUP);
                return timedSlowDownEffect;
            case TIMED_FAST_UP_NON_DUP:
                FastUpEffect timedFastUpEffect = new FastUpEffect();
                timedFastUpEffect.setCommand(new TimedFastUpNonDup());
                timedFastUpEffect.setType(EffectType.TIMED_FAST_UP_NON_DUP);
                return timedFastUpEffect;
            default:
                return null;
        }
    }
}
