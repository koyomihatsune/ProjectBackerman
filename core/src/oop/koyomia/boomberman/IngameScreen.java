package oop.koyomia.boomberman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GameObject.UntouchableObject;

import java.util.ArrayList;
import java.util.List;

public class IngameScreen implements Screen {
    GameScene game;

    List<GameObject> world = new ArrayList<>();

    public IngameScreen(GameScene game){
            this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        // GameUtils.renderFrame(game.batch, world);
        //game.font.draw(game.batch, "Ingame Screen on!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
    }
}
