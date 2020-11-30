package oop.koyomia.boomberman.EquipmentComponent.Factory;


import oop.koyomia.boomberman.EquipmentComponent.State.EquipmentState;
import oop.koyomia.boomberman.EquipmentComponent.State.EquipmentStateDefault;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsStateMoveable;

public class EquipmentStateMovableFactory implements EquipmentStateFactory {
    @Override
    public EquipmentState createInstance(GameObject self) {
        return new EquipmentStateDefault(self);
    }
}
