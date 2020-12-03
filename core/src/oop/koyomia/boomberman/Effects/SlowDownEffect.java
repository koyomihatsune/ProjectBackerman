package oop.koyomia.boomberman.Effects;

import com.badlogic.gdx.Gdx;
import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.Command.SlowDown;
import oop.koyomia.boomberman.Command.TimedSlowDownNonDup;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class SlowDownEffect extends Effect {

    boolean check = false;
    float timer = 0;

    public SlowDownEffect() {
        super(EffectType.SLOW_DOWN, new TimedSlowDownNonDup());
    }

    @Override
    public void execute(GameObject target, List<GameObject> world) {
        timer += Gdx.graphics.getDeltaTime();
        //System.out.println(this.hashCode() + "executed " + timer );
        super.execute(target, world);
        if (timer >= 5)
            this.setFinished(true);
    }
}
