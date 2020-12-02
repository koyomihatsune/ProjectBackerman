package oop.koyomia.boomberman.Command;

import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.Equipments.RemoteBombExplodeEquipment;
import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GameObjectFactory;
import oop.koyomia.boomberman.InputComponent.Factory.RemoteBombInputStateFactory;

import java.util.List;

public class RemoteBombPut extends DefaultBombPut {
    public void execute(List<GameObject> world, GameObject self) {
        super.execute(world,self);
        this.getBombObj().setInputState(new RemoteBombInputStateFactory().createInstance(this.getBombObj()));
        self.getEquipmentState().addEquipmentFromItem(new RemoteBombExplodeEquipment(this.getBombObj()));
    }
}
