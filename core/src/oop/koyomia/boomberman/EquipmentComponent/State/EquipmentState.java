package oop.koyomia.boomberman.EquipmentComponent.State;

import oop.koyomia.boomberman.Equipments.Equipment;

import java.util.Stack;

public interface EquipmentState {

    Equipment useEquippedEquipment();
    void addEquipmentFromItem(Equipment equipmentToAdd);
    void restoreDefaultBomb();
    public boolean isCooldown();
    public void countdown();
    public void setCooldownTimer(float value);
}
