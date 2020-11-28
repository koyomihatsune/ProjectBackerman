package oop.koyomia.boomberman;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GraphicComponent.Factory.GraphicStateFactory;
import oop.koyomia.boomberman.GraphicComponent.Factory.GraphicStateMoveableFactory;
import oop.koyomia.boomberman.GraphicComponent.Factory.GraphicSystemFactory;
import oop.koyomia.boomberman.GraphicComponent.Factory.GraphicSystemMoveableFactory;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicState;
import oop.koyomia.boomberman.GraphicComponent.State.GraphicStateDefault;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystem;
import oop.koyomia.boomberman.GraphicComponent.System.GraphicSystemDefault;
import oop.koyomia.boomberman.InputComponent.Factory.InputStateFactory;
import oop.koyomia.boomberman.InputComponent.Factory.InputStateMoveableFactory;
import oop.koyomia.boomberman.InputComponent.Factory.InputSystemFactory;
import oop.koyomia.boomberman.InputComponent.Factory.InputSystemMoveableFactory;
import oop.koyomia.boomberman.InputComponent.State.InputStateDefault;
import oop.koyomia.boomberman.InputComponent.System.InputSystemDefault;
import oop.koyomia.boomberman.PhysicsComponent.Factory.PhysicsStateMoveableFactory;
import oop.koyomia.boomberman.PhysicsComponent.Factory.PhysicsStateFactory;
import oop.koyomia.boomberman.PhysicsComponent.Factory.PhysicsSystemFactory;
import oop.koyomia.boomberman.PhysicsComponent.Factory.PhysicsSystemMoveableFactory;
import oop.koyomia.boomberman.PhysicsComponent.State.PhysicsStateDefault;
import oop.koyomia.boomberman.PhysicsComponent.System.PhysicsSystemDefault;

import java.util.ArrayList;
import java.util.List;

public class GameObjectFactory {
    public static List<GameObject> getGameObject(TiledMap map) {
        List<GameObject> world = new ArrayList<>();
        PhysicsStateFactory pstateF;
        PhysicsSystemFactory psystemF;
        GraphicStateFactory gstateF;
        GraphicSystemFactory gsystemF;
        InputStateFactory istateF;
        InputSystemFactory isystemF;
        for (MapLayer layer : map.getLayers()) {
            TiledMapTileLayerExt layerExt = (TiledMapTileLayerExt) layer;
            for (TiledMapTileLayerExt.FreeCell cell : layerExt.freeCells) {
                String type;
                GameObject gameObject = new GameObject(cell);
                try {
                    type = (String) cell.getTile().getProperties().get("type");
                } catch (Exception e) {
                    type = "";
                }
                if (type == null) type = "";
                switch (type) {
                    case "Main" :
                        pstateF = new PhysicsStateMoveableFactory();
                        psystemF = new PhysicsSystemMoveableFactory();
                        gstateF = new GraphicStateMoveableFactory();
                        gsystemF = new GraphicSystemMoveableFactory();
                        istateF = new InputStateMoveableFactory();
                        isystemF = new InputSystemMoveableFactory();

                        break;
                    default:
                        //throw new IllegalStateException("Unexpected value: " + type);
                        pstateF = self -> new PhysicsStateDefault(self);
                        psystemF = self -> new PhysicsSystemDefault(self);
                        gstateF = (self, tileSet) -> new GraphicStateDefault(self);
                        gsystemF = self -> new GraphicSystemDefault(self);
                        istateF = self -> new InputStateDefault(self);
                        isystemF = self -> new InputSystemDefault(self);
                }
                gameObject.setInputState(istateF.createInstance(gameObject));
                gameObject.setInputSystem(isystemF.createInstance(gameObject));
                gameObject.setGraphicState(gstateF.createInstance(gameObject, findTileSetById(cell.getTile().getId(), map)));
                gameObject.setGraphicSystem(gsystemF.createInstance(gameObject));
                gameObject.setPhysicsState(pstateF.createInstance(gameObject));
                gameObject.setPhysicsSystem(psystemF.createInstance(gameObject));
                gameObject.setType(type);
                world.add(gameObject);
            }
        }
        return world;
    }

    private static TiledMapTileSet findTileSetById(int id, TiledMap map) {
        TiledMapTileSet temp = null;
        for (TiledMapTileSet tileSet : map.getTileSets()) {
            if (id < (Integer) tileSet.getProperties().get("firstgid")) return temp;
            temp = tileSet;
        }
        return temp;
    }
}
