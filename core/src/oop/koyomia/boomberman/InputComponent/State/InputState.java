package oop.koyomia.boomberman.InputComponent.State;

import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;

public interface InputState {
    void addPressCommand(Integer key, Command command);
    void addKeyDownCommand(Integer key, Command command);
    Command getPressCommand(Integer key);
    Command getKeyDownCommand(Integer key);
    void deleteCommand(Integer key);
    void setInputManager(InputManager inputManager);
    InputManager getInputManager();
}
