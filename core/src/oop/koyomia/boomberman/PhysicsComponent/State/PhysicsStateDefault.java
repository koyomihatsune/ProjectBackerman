package oop.koyomia.boomberman.PhysicsComponent.State;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;

// Unmoveable State
public class PhysicsStateDefault implements PhysicsState {
    protected GameObject self;
    protected float x_vel = 0;
    protected float y_vel = 0;

    PhysicsStateDefault(GameObject self) {
        this.self = self;
    }
    /**
     * Get physics body in standard coordinate system
     *
     * @return the physics body
     */
    @Override
    public Rectangle getPhysicsBody() {
        Rectangle renderRec = self.getGraphicState().getRenderRegion();
        try {
            Rectangle offsetRec = ((RectangleMapObject) self.getCell().getTile().getObjects().get("collision")).getRectangle();
            return new Rectangle(renderRec.x + offsetRec.x, renderRec.y + offsetRec.y, offsetRec.width, offsetRec.height);
        } catch (NullPointerException e) {
            return new Rectangle(0, 0, 0, 0);
        }
    }

    /**
     * Set physics body.
     *
     * @param rectangle the rectangle that x, y is offset to render coordinate in standard coordinate system (without mapping to unitScale coordinate system).
     */
    @Override
    public void setPhysicsBody(Rectangle rectangle) {
        try {
            ((RectangleMapObject) this.self.getCell().getTile().getObjects().get("collision")).getRectangle().set(rectangle);
        } catch (NullPointerException e) {
            System.err.println("ko the set physics body cho 1 doi tuong khong co collision object");
            e.printStackTrace();
        }
    }

    @Override
    public float getXVel() {
        return 0;
    }

    @Override
    public float getYVel() {
        return 0;
    }

    @Override
    public void setXVel(float x_vel) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setYVel(float y_vel) {
        throw new UnsupportedOperationException();
    }
}
