package oop.koyomia.boomberman.InputComponent;

import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GameObject.ObjectType;

import java.util.List;

public abstract class InputComponent {
    protected GameObject self;

    public InputComponent(@NotNull GameObject self) {
        this.self = self;
    }

    public abstract void update(@NotNull List<GameObject> world, float delta);

}
