package oop.koyomia.boomberman.EquipmentComponent.System;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.EquipmentComponent.EquipmentType;
import oop.koyomia.boomberman.EquipmentComponent.State.EquipmentState;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EquipmentSystemDefault implements EquipmentSystem {
    protected GameObject self;

    public EquipmentSystemDefault(@NotNull GameObject self) {
        this.self = self;
    }

//    public Command certainEquipmentFire(){
//        EquipmentState equipmentState = this.self.getEquipmentState();
//        //EquipmentType certainEquipmentType = equipmentState.
//    }

    public void update(@NotNull List<GameObject> world, float delta) {

    }
}
