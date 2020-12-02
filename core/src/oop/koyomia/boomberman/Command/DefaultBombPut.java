package oop.koyomia.boomberman.Command;

import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GameObjectFactory;

import java.util.List;

public class DefaultBombPut implements Command {
    public GameObject getBombObj() {
        return bombObj;
    }

    public void setBombObj(GameObject bombObj) {
        this.bombObj = bombObj;
    }

    private GameObject bombObj;
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        Vector2 coor = GameConfig.getSquareCoor(self);
        TiledMapTileLayerExt.FreeCell newCell = GameConfig.createNewFreeCell
        (
                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("bomb")),
                GameConfig.tile_width * coor.x, GameConfig.tile_height * coor.y
        );

        GameObject newGameObj = GameObjectFactory.getGameObject(newCell);
        newGameObj.getProperties().put("owner", self);
        this.bombObj = newGameObj;
        world.add(newGameObj);
        GameConfig.addCellToCharLayer(newCell);
        System.out.println("Bomb put!");
    }
}
