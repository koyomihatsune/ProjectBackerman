package oop.koyomia.boomberman.Effects;

import com.badlogic.gdx.Gdx;
import oop.koyomia.boomberman.Command.DoNothing;
import oop.koyomia.boomberman.Command.TimedSlowDownNonDup;
import oop.koyomia.boomberman.Equipments.RemoteBombPutEquipment;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class AddRemoteBombEquipmentEffect extends Effect {

    public AddRemoteBombEquipmentEffect() {
        super(EffectType.ADD_REMOTE_BOMB_EQUIPMENT, new DoNothing());
    }

    @Override
    public void execute(GameObject target, List<GameObject> world) {
        target.getEquipmentState().addEquipmentFromItem(new RemoteBombPutEquipment());
            this.setFinished(true);
    }
}
