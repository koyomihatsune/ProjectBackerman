package oop.koyomia.boomberman.EquipmentComponent.Factory;

import oop.koyomia.boomberman.EquipmentComponent.System.EquipmentSystemDefault;
import oop.koyomia.boomberman.GameObject.GameObject;

public interface EquipmentSystemFactory {
    public EquipmentSystemDefault createInstance(GameObject self);
}
