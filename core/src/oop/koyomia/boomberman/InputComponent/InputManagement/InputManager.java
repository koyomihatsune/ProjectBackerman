package oop.koyomia.boomberman.InputComponent.InputManagement;

import java.util.List;

public interface InputManager {
    List<Integer> getKeyDown();
    List<Integer> getKeyUp();
    void clear();
}
