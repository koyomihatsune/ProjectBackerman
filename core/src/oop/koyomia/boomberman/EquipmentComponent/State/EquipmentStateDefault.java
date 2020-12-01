package oop.koyomia.boomberman.EquipmentComponent.State;

import com.badlogic.gdx.Gdx;
import oop.koyomia.boomberman.Equipments.DefaultBombPutEquipment;
import oop.koyomia.boomberman.Equipments.EmptyEquipment;
import oop.koyomia.boomberman.Equipments.Equipment;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.Stack;

public class EquipmentStateDefault implements EquipmentState {
    GameObject self;
    Stack<Equipment> equipmentStack;
    boolean cooldown;
    float cooldownTimer;

    public EquipmentStateDefault(GameObject gameObject){
        this.self = gameObject;
        this.equipmentStack = new Stack<>();
        this.restoreDefaultBomb();
        this.cooldown = false;
    }

    public void addEquipmentFromItem(Equipment equipmentToAdd){
        if (equipmentStack.size()==2){
            useEquippedEquipment();
        }
        equipmentStack.push(equipmentToAdd);
    }

    public Equipment useEquippedEquipment(){
        if (equipmentStack.size()!=0 && !cooldown){
            setCooldownTimer(1);
            return equipmentStack.pop();
        }
        return new EmptyEquipment();
    }

    //whenever default bomb explode, put back to the first of stack
    public void restoreDefaultBomb(){
        System.out.println("Bomb equipment restored.");
        equipmentStack.add(0, new DefaultBombPutEquipment());
    }

    public boolean isCooldown() {
        return cooldown;
    }

    public void setCooldownTimer(float value){
        System.out.println("Cooldown start.");
        cooldown = true;
        cooldownTimer = value;
    }

    public void countdown() {
        cooldownTimer -= Gdx.graphics.getDeltaTime();
        if (cooldownTimer <=0) {
            System.out.println("Cooldown end.");
            cooldownTimer = 0;
            cooldown = false;
        }
    }
}
