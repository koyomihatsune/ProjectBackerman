package oop.koyomia.boomberman.GameObject;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GraphicComponent.GraphicComponent;

import java.util.Comparator;
import java.util.List;

public abstract class GameObject {
    protected String type;
    protected GraphicComponent graphicComponent;
    protected TiledMapTileLayerExt.FreeCell cell;

    public GameObject(TiledMapTileLayerExt.FreeCell cell) {
        if (cell.getTile().getProperties().get("type") != null) type = (String) cell.getTile().getProperties().get("type");
        this.cell = cell;
    }

    public GraphicComponent getGraphicComponent() {
        return graphicComponent;
    }

    public void setGraphicComponent(GraphicComponent graphicComponent) {
        this.graphicComponent = graphicComponent;
    }

    public TiledMapTileLayerExt.FreeCell getCell() {
        return this.cell;
    }

    public abstract void update(List<GameObject> world, float delta);
}
