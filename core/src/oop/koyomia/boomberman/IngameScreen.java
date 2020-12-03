package oop.koyomia.boomberman;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.GDXLibExtend.OrthogonalTiledMapRendererExt;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IngameScreen implements Screen, InputProcessor {
    GameScene game;
    PlayerInputManager playerInputManager;
    boolean isContinue = true;
    private List<GameObject> world = new ArrayList<>();
    private OrthographicCamera camera;
    private TiledMap map;
    private TiledMapRenderer renderer;
    private ShapeRenderer shapeRenderer;

    public IngameScreen(GameScene game){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        shapeRenderer = new ShapeRenderer();
        this.game = game;
        playerInputManager = PlayerInputManager.getInstance();
        map = GameConfig.newGameInit(world, 0);
        renderer = new OrthogonalTiledMapRendererExt(map, GameConfig.unitScale);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int world_size = world.size();
        for (int i = 0; i < world_size; i++) {
            world.get(i).update(world, delta);
        }
        camera.update();
        renderer.setView(camera);
        renderer.render();
        game.batch.begin();
        // GameUtils.renderFrame(game.batch, world);
        // game.font.draw(game.batch, "Ingame Screen on!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        game.batch.end();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

//        for (GameObject gameObject : world) {
//            Rectangle physicsRect = gameObject.getPhysicsState().getPhysicsBody();
//            OrthogonalTiledMapRendererExt or = (OrthogonalTiledMapRendererExt)renderer;
//            float unitScale = or.getUnitScale();
//            shapeRenderer.rect(physicsRect.x * unitScale, physicsRect.y * unitScale, physicsRect.width * unitScale, physicsRect.height * unitScale);
//        }

        shapeRenderer.end();
        world.removeIf(i -> {
            if (!(Boolean) i.getProperties().get("isAlive")) {
                for (MapLayer layer : GameConfig.map.getLayers()) {
                    ((TiledMapTileLayerExt) layer).removeCell(i.getCell());
                }
                return true ;
            }
            return false;
        });
        this.playerInputManager.getKeyDown().clear();
        boolean remainMain = false;
        boolean remainEnemy = false;
        for (GameObject gameObject : world){
            if (gameObject.getType().equals("Main")){
                remainMain = true;
            }
            if (gameObject.getType().equals("Main")){
                remainEnemy = true;
            }
        }

        if (!remainEnemy) {
            MenuScreen menuScreen = new MenuScreen(game,"Player 2 Won!");
            game.setScreen(menuScreen);
            //Gdx.input.setInputProcessor(menuScreen);
        }
        if (!remainMain) {
            MenuScreen menuScreen = new MenuScreen(game,"Player 1 Won!");
            game.setScreen(menuScreen);
            //Gdx.input.setInputProcessor(menuScreen);
        }
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

    /**
     * Called when a key was pressed
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {
        this.playerInputManager.getKeyPress().add(keycode);
        this.playerInputManager.getKeyDown().add(keycode);
        //System.out.println(keycode + " dang duoc bam");
        return false;
    }

    /**
     * Called when a key was released
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyUp(int keycode) {
        this.playerInputManager.getKeyPress().remove(new Integer(keycode));
        return false;
    }

    /**
     * Called when a key was typed
     *
     * @param character The character
     * @return whether the input was processed
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Called when a finger or the mouse was dragged.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @return whether the input was processed
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     *
     * @param screenX
     * @param screenY
     * @return whether the input was processed
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Called when the mouse wheel was scrolled. Will not be called on iOS.
     *
     * @param amount the scroll amount, -1 or 1 depending on the direction the wheel was scrolled.
     * @return whether the input was processed.
     */
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
