package oop.koyomia.boomberman.InputComponent.State;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;

import java.util.HashMap;

public class InputStateDefault implements InputState {
    protected HashMap<Integer, Command> listCommand;
    protected InputManager inputManager;
    protected GameObject self;

    @Override
    public InputManager getInputManager() {
        return this.inputManager;
    }

    public InputStateDefault(GameObject self) {
        this.self = self;
        this.listCommand = new HashMap<>();
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void addCommand(Integer key, Command command) {
        this.listCommand.put(key, command);
    }

    @Override
    public Command getCommand(Integer key) {
        return this.listCommand.get(key);
    }

    @Override
    public void deleteCommand(Integer key) {
        this.listCommand.remove(key);
    }
}
