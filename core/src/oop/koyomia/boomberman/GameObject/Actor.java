package oop.koyomia.boomberman.GameObject;

import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.InputComponent.InputComponent;

import java.util.List;

public class Actor extends TouchableObject {
    protected InputComponent inputComponent;
    public Actor(TiledMapTileLayerExt.FreeCell cell) {
        super(cell);
    }

    @Override
    public void update(List<GameObject> world, float delta) {
        this.inputComponent.update(world, delta);
    }
}
