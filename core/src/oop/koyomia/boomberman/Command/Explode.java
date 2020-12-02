package oop.koyomia.boomberman.Command;

import oop.koyomia.boomberman.Effects.Effect;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PassiveEffectComponent.State.DefaultPassiveEffectState;

import java.util.List;

public class Explode implements Command {
    protected Command concreteCommand;
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        switch (self.getType()) {
            case "Main" :
                if (concreteCommand == null) concreteCommand = new CharExplode();

                break;
            case "Bomb" :
                if (concreteCommand == null) concreteCommand = new DefaultBombExplode();
                break;
            case "Flower" :
                if (concreteCommand == null) concreteCommand = new BoxExplode();
                break;
        }
        concreteCommand.execute(world, self);
        for (Effect effect : ((DefaultPassiveEffectState)self.getPassiveEffectState()).getEffectList()) {
            if (effect.getType().toString().equals(EffectType.EXPLOSION_NON_DUP.toString())) effect.setFinished(true);
        }
    }
}
