package oop.koyomia.boomberman.GameObject;

import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;

import java.util.List;

public class Bomb extends TouchableObject{
    private boolean bombState;
    private boolean effectedState;

    public Bomb(TiledMapTileLayerExt.FreeCell cell) {
        super(cell);
    }

    @Override
    public void update(List<GameObject> world, float delta) {

    }
}
