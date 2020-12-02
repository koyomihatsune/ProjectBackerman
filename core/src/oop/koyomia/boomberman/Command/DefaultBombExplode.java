package oop.koyomia.boomberman.Command;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GDXLibExtend.AnimatedTiledMapTileExt;
import oop.koyomia.boomberman.GDXLibExtend.TiledMapTileLayerExt;
import oop.koyomia.boomberman.GameConfig;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.GameObjectFactory;
import java.util.List;

public class DefaultBombExplode implements Command {
    protected int exLength = 1;
    @Override
    public void execute(List<GameObject> world, GameObject self) {
        world.remove(self);
        ((TiledMapTileLayerExt)GameConfig.map.getLayers().get("Up items")).removeCell(self.getCell());
        System.out.println("Bomb explode!");
        Vector2 center = GameConfig.getSquareCoor(self);
        TiledMapTileLayerExt.FreeCell newCell = GameConfig.createNewFreeCell
                (
                        new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("center_explosion"), "Once"),
                        GameConfig.tile_width * center.x, GameConfig.tile_height * center.y
                );
        GameObject newGameObj = GameObjectFactory.getGameObject(newCell);
        world.add(newGameObj);
        GameConfig.addCellToCharLayer(newCell);
        int max_left = 0;
        int max_right = 0;
        int max_up = 0;
        int max_down = 0;
        for (max_left = 1; max_left <= exLength; max_left++) {
            if (!GameConfig.validateSquareCoor(new Vector2(center.x - max_left, center.y))) break;
            newCell = GameConfig.createNewFreeCell
                    (
                            new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("horizontal_explosion"), "Once"),
                            GameConfig.tile_width * (center.x - max_left), GameConfig.tile_height * center.y
                    );
            newGameObj = GameObjectFactory.getGameObject(newCell);
            List<GameObject> checkList = GameConfig.getOverlapList(newGameObj.getActiveEffectState().getEffectRange(EffectType.EXPLOSION_NON_DUP), world, null);
            checkList.removeIf(i -> {
                if (i.getProperties().get("breakable") == null) return false;
                if ((Boolean)i.getProperties().get("breakable"))
                    return true;
                return false;
            });
            if (checkList.size() != 0) {
                max_left--;
                break;
            }
        }
        if (max_left >= exLength) max_left = exLength;

        for (max_right = 1; max_right <= exLength; max_right++) {
            if (!GameConfig.validateSquareCoor(new Vector2(center.x + max_right, center.y))) break;
            newCell = GameConfig.createNewFreeCell
                    (
                            new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("horizontal_explosion"), "Once"),
                            GameConfig.tile_width * (center.x + max_right), GameConfig.tile_height * center.y
                    );
            newGameObj = GameObjectFactory.getGameObject(newCell);
            List<GameObject> checkList = GameConfig.getOverlapList(newGameObj.getActiveEffectState().getEffectRange(EffectType.EXPLOSION_NON_DUP), world, null);
            checkList.removeIf(i -> {
                if (i.getProperties().get("breakable") == null) return false;
                if ((Boolean)i.getProperties().get("breakable"))
                    return true;
                return false;
            });
            if (checkList.size() != 0) {
                max_right--;
                break;
            }
        }
        if (max_right >= exLength) max_right = exLength;

        for (max_up = 1; max_up <= exLength; max_up++) {
            if (!GameConfig.validateSquareCoor(new Vector2(center.x, center.y + max_up))) break;
            newCell = GameConfig.createNewFreeCell
                    (
                            new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("vertical_explosion"), "Once"),
                            GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y + max_up)
                    );
            newGameObj = GameObjectFactory.getGameObject(newCell);
            List<GameObject> checkList = GameConfig.getOverlapList(newGameObj.getActiveEffectState().getEffectRange(EffectType.EXPLOSION_NON_DUP), world, null);
            checkList.removeIf(i -> {
                if (i.getProperties().get("breakable") == null) return false;
                if ((Boolean)i.getProperties().get("breakable"))
                    return true;
                return false;
            });
            if (checkList.size() != 0){
                max_up--;
                break;
            }
        }
        if (max_up >= exLength) max_up = exLength;

        for (max_down = 1; max_down <= exLength; max_down++) {
            if (!GameConfig.validateSquareCoor(new Vector2(center.x, center.y - max_down))) break;
            newCell = GameConfig.createNewFreeCell
                    (
                            new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("vertical_explosion"), "Once"),
                            GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y - max_down)
                    );
            newGameObj = GameObjectFactory.getGameObject(newCell);
            List<GameObject> checkList = GameConfig.getOverlapList(newGameObj.getActiveEffectState().getEffectRange(EffectType.EXPLOSION_NON_DUP), world, null);
            checkList.removeIf(i -> {
                if (i.getProperties().get("breakable") == null) return false;
                if ((Boolean)i.getProperties().get("breakable"))
                    return true;
                return false;
            });
            if (checkList.size() != 0) {
                max_down--;
                break;
            }
        }
        if (max_down >= exLength) max_down = exLength;

        for (int i = 1; i <= max_left; i++) {
            if (i == max_left) {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("left_explosion"), "Once"),
                                GameConfig.tile_width * (center.x - i), GameConfig.tile_height * center.y
                        );
            } else {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("horizontal_explosion"), "Once"),
                                GameConfig.tile_width * (center.x - i), GameConfig.tile_height * center.y
                        );
            }
            newGameObj = GameObjectFactory.getGameObject(newCell);
            world.add(newGameObj);
            GameConfig.addCellToCharLayer(newCell);
        }
        for (int i = 1; i <= max_right; i++) {
            if (i == max_right) {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("right_explosion"), "Once"),
                                GameConfig.tile_width * (center.x + i), GameConfig.tile_height * center.y
                        );
            } else {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("horizontal_explosion"), "Once"),
                                GameConfig.tile_width * (center.x + i), GameConfig.tile_height * center.y
                        );
            }
            newGameObj = GameObjectFactory.getGameObject(newCell);
            world.add(newGameObj);
            GameConfig.addCellToCharLayer(newCell);
        }
        for (int i = 1; i <= max_up; i++) {
            if (i == max_up) {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("top_explosion"), "Once"),
                                GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y + i)
                        );
            } else {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("vertical_explosion"), "Once"),
                                GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y + i)
                        );
            }
            newGameObj = GameObjectFactory.getGameObject(newCell);
            world.add(newGameObj);
            GameConfig.addCellToCharLayer(newCell);
        }
        for (int i = 1; i <= max_down; i++) {
            if (i == max_down) {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("bottom_explosion"), "Once"),
                                GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y - i)
                        );
            } else {
                newCell = GameConfig.createNewFreeCell
                        (
                                new AnimatedTiledMapTileExt((AnimatedTiledMapTile) GameConfig.mapSpecialTile.get(GameConfig.map.getTileSets().getTileSet("bomb2")).get("vertical_explosion"), "Once"),
                                GameConfig.tile_width * center.x, GameConfig.tile_height * (center.y - i)
                        );
            }
            newGameObj = GameObjectFactory.getGameObject(newCell);
            world.add(newGameObj);
            GameConfig.addCellToCharLayer(newCell);
        }
        ((GameObject)self.getProperties().get("owner")).getEquipmentState().restoreDefaultBomb();
    }
}
