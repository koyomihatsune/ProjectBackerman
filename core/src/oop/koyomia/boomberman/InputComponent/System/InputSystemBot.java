package oop.koyomia.boomberman.InputComponent.System;

import com.badlogic.gdx.Gdx;
import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.EnemyInputManager;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InputSystemBot extends InputSystemDefault {

    float updateCooldown;
    public InputSystemBot(@NotNull GameObject self) {
        super(self);
        updateCooldown = 4;
    }

    public void update(@NotNull List<GameObject> world, float delta) {
        if (updateCooldown <= 0){
            ((EnemyInputManager) self.getInputState().getInputManager()).updateWorld(world);
            updateCooldown = 1;
        }
        updateCooldown -= Gdx.graphics.getDeltaTime();
       super.update(world, delta);
    }
}
