package oop.koyomia.boomberman.GameObject;

import com.badlogic.gdx.graphics.Texture;
import oop.koyomia.boomberman.GraphicComponent.GraphicComponent;

import java.util.Comparator;

public abstract class GameObject {
    protected GraphicComponent graphicComponent;
    // protected GameObject particles;

    protected int layerLevel;

    public GameObject() {
        this.graphicComponent = new GraphicComponent();
    }

    public GraphicComponent getGraphicComponent() {
        return graphicComponent;
    }

    public void setGraphicComponent(GraphicComponent graphicComponent) {
        this.graphicComponent = graphicComponent;
    }

    public static Comparator<GameObject> sortByLayer() {
        return (o1, o2) -> Integer.compare(o1.layerLevel, o2.layerLevel);
    }
}
