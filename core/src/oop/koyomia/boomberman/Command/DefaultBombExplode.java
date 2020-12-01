package oop.koyomia.boomberman.Command;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;

public class DefaultBombExplode implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        world.remove(self);
        ((TiledMapTileLayerExt)GameConfig.map.getLayers().get("Up items")).removeCell(self.getCell());
        System.out.println("Bomb explode!");
        ((GameObject)self.getProperties().get("owner")).getEquipmentState().restoreDefaultBomb();

    }
}
