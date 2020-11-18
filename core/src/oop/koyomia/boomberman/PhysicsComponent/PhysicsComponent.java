package oop.koyomia.boomberman.PhysicsComponent;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;


public abstract class PhysicsComponent {

    protected GameObject self;

    public PhysicsComponent(@NotNull GameObject self) {
        this.self = self;
    }

    public Rectangle getRectangleBody() {
        RectangleMapObject recBody =(RectangleMapObject) this.self.getCell().getTile().getObjects().get("collision");
        return recBody.getRectangle();
    }

    public boolean isCollided(RectangleMapObject otherBody) {
        return otherBody.getRectangle().overlaps(this.getRectangleBody());
    }

    public void setRectangleBody(@NotNull Rectangle otherRec) {
        this.getRectangleBody().set(otherRec);
    }

    public abstract void update(List<GameObject> world, float delta);

}
