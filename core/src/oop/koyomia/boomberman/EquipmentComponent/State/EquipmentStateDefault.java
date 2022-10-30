package oop.koyomia.boomberman.EquipmentComponent.State;

import oop.koyomia.boomberman.Command.DefaultBombPut;
import oop.koyomia.boomberman.Equipments.DefaultBombPutEquipment;
import oop.koyomia.boomberman.Equipments.EmptyEquipment;
import oop.koyomia.boomberman.Equipments.Equipment;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.Stack;

public class EquipmentStateDefault implements EquipmentState {
    GameObject self;
    Stack<Equipment> equipmentStack;

    public EquipmentStateDefault(GameObject gameObject){
        this.self = gameObject;
        this.equipmentStack = new Stack<>();
        this.equipmentStack.push(new DefaultBombPutEquipment());
    }

    public void addEquipmentFromItem(Equipment equipmentToAdd){
        if (equipmentStack.size() == 2){
            // is conflicting between put remote bomb and explode remote bomb
            equipmentStack.pop().onPop();
        }
        equipmentStack.push(equipmentToAdd);
    }

    public Equipment useEquippedEquipment(){
        if (equipmentStack.peek().isStillValidate())
            return equipmentStack.peek();
        else equipmentStack.pop();
        return equipmentStack.peek();
    }

    public Stack<Equipment> getEquipmentStack() {
        return equipmentStack;
    }

    //whenever default bomb explode, put back to the first of stack
    public void restoreDefaultBomb(){
        ((DefaultBombPutEquipment)equipmentStack.get(0)).incBombRemain();
    }

    @Override
    public boolean isCooldown() {
        return false;
    }

    @Override
    public void countdown() {

    }

    @Override
    public void setCooldownTimer(float value) {

    }
}
