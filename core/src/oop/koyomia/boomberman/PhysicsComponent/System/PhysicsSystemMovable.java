package oop.koyomia.boomberman.PhysicsComponent.System;

import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PhysicsSystemMovable extends PhysicsSystemDefault {

    public PhysicsSystemMovable(@NotNull GameObject self) {
        super(self);
    }

    @Override
    public void update(@NotNull List<GameObject> world, float delta) {
        Rectangle futureRec = new Rectangle(self.getPhysicsState().getPhysicsBody());
        futureRec.setPosition(futureRec.x + self.getPhysicsState().getXVel(), futureRec.y + self.getPhysicsState().getYVel());
        List<GameObject> futureCollide = this.getOverlapList(futureRec, world, this.self);
        if (futureCollide.size() != 0) {
            this.self.getPhysicsState().setXVel(0f);
            this.self.getPhysicsState().setYVel(0f);
        }
//       else System.out.println(futureRec);
    }
}
