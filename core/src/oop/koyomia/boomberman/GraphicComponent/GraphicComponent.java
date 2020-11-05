package oop.koyomia.boomberman.GraphicComponent;

import com.badlogic.gdx.graphics.Texture;

public class GraphicComponent {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Texture texture;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int physics_height) {
        this.height = height;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
