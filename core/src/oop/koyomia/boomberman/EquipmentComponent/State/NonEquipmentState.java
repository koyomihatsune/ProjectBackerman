package oop.koyomia.boomberman.EquipmentComponent.State;

import oop.koyomia.boomberman.Equipments.EmptyEquipment;
import oop.koyomia.boomberman.Equipments.Equipment;

public class NonEquipmentState implements EquipmentState {
    @Override
    public Equipment useEquippedEquipment() {
        return new EmptyEquipment();
    }

    @Override
    public void addEquipmentFromItem(Equipment equipmentToAdd) {

    }

    @Override
    public void restoreDefaultBomb() {

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
