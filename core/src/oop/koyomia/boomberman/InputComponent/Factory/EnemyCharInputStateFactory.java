package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.EnemyInputManager;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;

public class EnemyCharInputStateFactory implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState newInputState = new InputStateMovableFactory().createInstance(self);
        newInputState.setInputManager(new EnemyInputManager(self));
        return newInputState;
    }
}
