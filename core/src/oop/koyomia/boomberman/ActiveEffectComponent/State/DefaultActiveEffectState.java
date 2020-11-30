package oop.koyomia.boomberman.ActiveEffectComponent.State;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import oop.koyomia.boomberman.Effects.EffectType;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultActiveEffectState implements ActiveEffectState {
    protected List<EffectType> activeEffectList;
    protected GameObject self;

    public DefaultActiveEffectState(GameObject self) {
        this.self = self;
        this.activeEffectList = new ArrayList<>();
    }

    @Override
    public void addActiveEffect(EffectType effectType) {
        this.activeEffectList.add(effectType);
    }

    @Override
    public void removeActiveEffect(EffectType effectType) {
        this.activeEffectList.remove(effectType);
    }

    @Override
    public List<EffectType> getActiveEffectList() {
        return this.activeEffectList;
    }

    @Override
    public Rectangle getEffectRange() {
        Rectangle renderRec = self.getGraphicState().getRenderRegion();
        try {
            Rectangle offsetRec = ((RectangleMapObject) self.getCell().getTile().getObjects().get("effect_range")).getRectangle();
            return new Rectangle(renderRec.x + offsetRec.x, renderRec.y + offsetRec.y, offsetRec.width, offsetRec.height);
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Rectangle getEffectRange(EffectType effectType) {
        Rectangle renderRec = self.getGraphicState().getRenderRegion();
        try {
            Rectangle offsetRec = null; //= ((RectangleMapObject) self.getCell().getTile().getObjects().get("effect_range")).getRectangle();
            for (MapObject mapObj : self.getCell().getTile().getObjects()) {
                if (mapObj.getName().equals("effect_range") && mapObj.getProperties().get("effect_type").equals(effectType.toString())) {
                    offsetRec = ((RectangleMapObject) mapObj).getRectangle();
                    break;
                }
            }

            return new Rectangle(renderRec.x + offsetRec.x, renderRec.y + offsetRec.y, offsetRec.width, offsetRec.height);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
