package oop.koyomia.boomberman.EquipmentComponent.Factory;

import oop.koyomia.boomberman.EquipmentComponent.State.EquipmentState;
import oop.koyomia.boomberman.GameObject.GameObject;

public interface EquipmentStateFactory {
    public EquipmentState createInstance(GameObject self);
}
