package oop.koyomia.boomberman.ActiveEffectComponent.Factory;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import oop.koyomia.boomberman.ActiveEffectComponent.State.ActiveEffectState;
import oop.koyomia.boomberman.ActiveEffectComponent.State.DefaultActiveEffectState;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;
import org.jetbrains.annotations.NotNull;

public class DefaultActiveEffectStateFactory implements ActiveEffectStateFactory {

    @Override
    public ActiveEffectState createInstance(@NotNull GameObject self) {
        ActiveEffectState activeEffectState = new DefaultActiveEffectState(self);
//        return new DefaultActiveEffectState(self);
        TiledMapTile tile = self.getCell().getTile();
        for (MapObject mapObj : tile.getObjects()) {
            if (mapObj.getName().equals("effect_range")) {
                for (EffectType effectType : EffectType.values()) {
                    if (mapObj.getProperties().get("effect_type") != null && mapObj.getProperties().get("effect_type").equals(effectType.toString()))
                        activeEffectState.addActiveEffect(effectType);
                }
            }
        }
        return activeEffectState;
    }

}
