package oop.koyomia.boomberman.GameObject;
import oop.koyomia.boomberman.EquipmentComponent.State.EquipmentState;
import oop.koyomia.boomberman.EquipmentComponent.System.EquipmentSystem;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicState;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystem;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.System.InputSystem;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsState;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystem;

import java.util.List;

public class GameObject {
    protected String type;
    protected GraphicState graphicState;
    protected PhysicsState physicsState;
    protected InputState inputState;
    protected GraphicSystem graphicSystem;
    protected PhysicsSystem physicsSystem;
    protected InputSystem inputSystem;
    protected EquipmentSystem equipmentSystem;
    protected EquipmentState equipmentState;

     protected TiledMapTileLayerExt.FreeCell cell;

    public GameObject(TiledMapTileLayerExt.FreeCell cell ) {
        if (cell.getTile().getProperties().get("type") != null) type = (String) cell.getTile().getProperties().get("type");
        this.cell = cell;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public EquipmentState getEquipmentState() { return equipmentState; }

    public void setEquipmentSystem(EquipmentSystem equipmentSystem) {
        this.equipmentSystem = equipmentSystem;
    }

    public EquipmentSystem getEquipmentSystem() {
        return equipmentSystem;
    }

    public GraphicState getGraphicState() {
        return graphicState;
    }

    public void setGraphicState(GraphicState graphicState) {
        this.graphicState = graphicState;
    }

    public PhysicsState getPhysicsState() {
        return physicsState;
    }

    public void setPhysicsState(PhysicsState physicsState) {
        this.physicsState = physicsState;
    }

    public InputState getInputState() {
        return inputState;
    }

    public void setInputState(InputState inputState) {
        this.inputState = inputState;
    }

    public PhysicsSystem getPhysicsSystem() {
        return physicsSystem;
    }

    public void setPhysicsSystem(PhysicsSystem physicsSystem) {
        this.physicsSystem = physicsSystem;
    }

    public InputSystem getInputSystem() {
        return inputSystem;
    }

    public void setInputSystem(InputSystem inputSystem) {
        this.inputSystem = inputSystem;
    }

    public void setCell(TiledMapTileLayerExt.FreeCell cell) {
        this.cell = cell;
    }

    public GraphicSystem getGraphicSystem() {
        return graphicSystem;
    }

    public void setGraphicSystem(GraphicSystem graphicSystem) {
        this.graphicSystem = graphicSystem;
    }



    public TiledMapTileLayerExt.FreeCell getCell() {
        return this.cell;
    }

    public void update(List<GameObject> world, float delta) {
        this.inputSystem.update(world, delta);
        this.physicsSystem.update(world, delta);
        this.graphicSystem.update(world, delta);
    }


}
