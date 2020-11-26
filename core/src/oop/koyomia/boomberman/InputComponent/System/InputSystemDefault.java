package oop.koyomia.boomberman.InputComponent.System;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.System.InputSystem;
import org.jetbrains.annotations.NotNull;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;
import java.util.List;

public class InputSystemDefault implements InputSystem {
    protected GameObject self;

    public InputSystemDefault(@NotNull GameObject self) {
        this.self = self;
    }

    public void update(@NotNull List<GameObject> world, float delta) {
        InputState inputState = this.self.getInputState();
        PlayerInputManager playerInputManager = PlayerInputManager.getInstance();
        for (Integer keycode : playerInputManager.getKeyDown()) {
            Command excuteCommand;
            excuteCommand = inputState.getCommand(keycode);
            if (excuteCommand != null) excuteCommand.execute(world, self);
        }
    }
}
