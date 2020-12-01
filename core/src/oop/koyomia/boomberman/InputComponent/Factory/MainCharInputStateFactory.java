package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.State.InputStateDefault;

public class MainCharInputStateFactory implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState newInputState = new InputStateMovableFactory().createInstance(self);
        newInputState.setInputManager(PlayerInputManager.getInstance());
        return newInputState;
    }
}
