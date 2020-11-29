package oop.koyomia.boomberman.InputComponent.System;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InputSystemMovable extends InputSystemDefault {

    public InputSystemMovable(@NotNull GameObject self) {
        super(self);
    }

    public void update(@NotNull List<GameObject> world, float delta) {
        InputState inputState = this.self.getInputState();
        InputManager inputManager = this.self.getInputState().getInputManager();
        for (Integer keycode : inputManager.getKeyPress()) {
            Command executeCommand;
            executeCommand = inputState.getCommand(keycode);
            if (executeCommand != null) executeCommand.execute(world, self);
        }
    }

}
