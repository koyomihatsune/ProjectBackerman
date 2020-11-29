package oop.koyomia.boomberman.EquipmentComponent.State;

import oop.koyomia.boomberman.Equipments.DefaultBombPutEquipment;
import oop.koyomia.boomberman.Equipments.Equipment;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.Stack;

public class EquipmentStateDefault implements EquipmentState {
    GameObject self;
    Stack<Equipment> equipmentStack;

    public EquipmentStateDefault(GameObject gameObject){
        this.self = gameObject;
        this.equipmentStack = new Stack<>();
        this.restoreDefaultBomb();
    }

    public void addEquipmentFromItem(Equipment equipmentToAdd){
        if (equipmentStack.size()==2){
            //is conflicting between put remote bomb and explode remote bomb
            useEquippedEquipment();
        }
        equipmentStack.push(equipmentToAdd);
    }

    public Equipment useEquippedEquipment(){
        return equipmentStack.pop();
    }

    //whenever default bomb explode, put back to the first of stack
    public void restoreDefaultBomb(){
        equipmentStack.add(0, new DefaultBombPutEquipment());
    }
}
