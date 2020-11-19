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

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {

    }

}
