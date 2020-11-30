package oop.koyomia.boomberman.EquipmentComponent.Factory;

import oop.koyomia.boomberman.EquipmentComponent.System.EquipmentSystemDefault;
import oop.koyomia.boomberman.GameObject.GameObject;

public class EquipmentSystemMovableFactory implements EquipmentSystemFactory {
    @Override
    public EquipmentSystemDefault createInstance(GameObject self){
        return new EquipmentSystemDefault(self);
    }
}
