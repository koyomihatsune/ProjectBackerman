package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Gdx;

public class TimerBombInputManager extends BombInputManager {
    public float wait_time;
    public TimerBombInputManager(float wait_time) {
        super();
        this.wait_time = wait_time;
    }

    public void update() {
        if (wait_time <= 0) this.setActiveExplode(true);
        wait_time-=Gdx.graphics.getDeltaTime();
    }
}
