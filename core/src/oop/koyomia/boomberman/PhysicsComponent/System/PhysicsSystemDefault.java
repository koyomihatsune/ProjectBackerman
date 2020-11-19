package oop.koyomia.boomberman.PhysicsComponent.System;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystem;
import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.List;


public class PhysicsSystemDefault implements PhysicsSystem {

    protected GameObject self;

    public PhysicsSystemDefault(@NotNull GameObject self) {
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

    public void update(List<GameObject> world, float delta) {

    };

}
