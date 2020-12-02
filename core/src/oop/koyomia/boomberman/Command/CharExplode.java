package oop.koyomia.boomberman.Command;

import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.NonInputSystem;

import java.util.List;

public class CharExplode implements Command {
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        self.getGraphicState().setTile(new AnimatedTiledMapTileExt((AnimatedTiledMapTile) self.getGraphicState().getTileStates().get("died"),"Once"));
        self.setInputSystem(new NonInputSystem(self));
    }
}
