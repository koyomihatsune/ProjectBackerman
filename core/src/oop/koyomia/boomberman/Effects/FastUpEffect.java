package oop.koyomia.boomberman.Effects;

import com.badlogic.gdx.Gdx;
import oop.koyomia.boomberman.Command.TimedFastUpNonDup;
import oop.koyomia.boomberman.Command.TimedSlowDownNonDup;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class FastUpEffect extends Effect {

    boolean check = false;
    float timer = 0;

    public FastUpEffect() {
        super(EffectType.FAST_UP, new TimedFastUpNonDup());
    }

    @Override
    public void execute(GameObject target, List<GameObject> world) {
        timer += Gdx.graphics.getDeltaTime();
        System.out.println(this.hashCode() + "executed " + timer );
        super.execute(target, world);
        if (timer >= 5)
            this.setFinished(true);
    }
}
