package oop.koyomia.boomberman.PhysicsComponent.System;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public interface PhysicsSystem {
//    List<GameObject> overlapList(List<GameObject> world);
    default List<GameObject> getOverlapList(Rectangle rec, List<GameObject> world, GameObject ignoreObj) {
        List<GameObject> overlapList = new ArrayList<>();
        world.forEach((i) -> {if (rec.overlaps(i.getPhysicsState().getPhysicsBody()) && i.getPhysicsState().getPhysicsBody().getWidth() != 0 && i.getPhysicsState().getPhysicsBody().getHeight() != 0) overlapList.add(i);});
        if (ignoreObj != null) overlapList.remove(ignoreObj);
        return overlapList;
    }
    void update(@NotNull List<GameObject> world, float delta);
}
