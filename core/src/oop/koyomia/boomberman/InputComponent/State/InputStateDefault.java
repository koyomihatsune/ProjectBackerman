package oop.koyomia.boomberman.InputComponent.State;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;

import java.util.HashMap;

public class InputStateDefault implements InputState {
    protected HashMap<Integer, Command> listPressCommand;
    protected HashMap<Integer, Command> listKeyDownCommand;
    protected InputManager inputManager;
    protected GameObject self;

    @Override
    public InputManager getInputManager() {
        return this.inputManager;
    }

    public InputStateDefault(GameObject self) {
        this.self = self;
        this.listPressCommand = new HashMap<>();
        this.listKeyDownCommand = new HashMap<>();
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void addPressCommand(Integer key, Command command) {
        this.listPressCommand.put(key, command);
    }

    @Override
    public Command getPressCommand(Integer key) {
        return this.listPressCommand.get(key);
    }

    @Override
    public Command getKeyDownCommand(Integer key) {
        return this.listKeyDownCommand.get(key);
    }

    @Override
    public void addKeyDownCommand(Integer key, Command command) {
        this.listKeyDownCommand.put(key, command);
    }

    @Override
    public void deleteCommand(Integer key) {
        this.listPressCommand.remove(key);
    }
}
