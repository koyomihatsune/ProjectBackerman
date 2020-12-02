package oop.koyomia.boomberman.GDXLibExtend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;

public class AnimatedTiledMapTileExt extends AnimatedTiledMapTile {
    private String loopType = "Default";
    private float timer;
    private long currFrameId = -1;
    private int loopDuration;
    private int id;
    private MapProperties properties;
    private MapObjects objects;
    private boolean animationFinished = false;
    /**
     * Creates an animated tile with the given animation interval and frame tiles.
     *
     * @param interval   The interval between each individual frame tile.
     * @param frameTiles An array of {@link StaticTiledMapTile}s that make up the animation.
     */
    public AnimatedTiledMapTileExt(float interval, Array<StaticTiledMapTile> frameTiles) {
        super(interval, frameTiles);
        this.timer = 0;
    }

    /**
     * Creates an animated tile with the given animation intervals and frame tiles.
     *
     * @param intervals  The intervals between each individual frame tile in milliseconds.
     * @param frameTiles An array of {@link StaticTiledMapTile}s that make up the animation.
     */
    public AnimatedTiledMapTileExt(IntArray intervals, Array<StaticTiledMapTile> frameTiles) {
        super(intervals, frameTiles);
        this.timer = 0;
        for (int i = 0; i < intervals.size; i++) {
            this.loopDuration += intervals.items[i];
        }
    }

    public AnimatedTiledMapTileExt(AnimatedTiledMapTile animatedTiledMapTile) {
        super(new IntArray(animatedTiledMapTile.getAnimationIntervals()), new Array<StaticTiledMapTile>(animatedTiledMapTile.getFrameTiles()));
        this.timer = 0;
        for (int i = 0; i < animatedTiledMapTile.getAnimationIntervals().length; i++) {
            this.loopDuration += animatedTiledMapTile.getAnimationIntervals()[i];
        }
        this.id = animatedTiledMapTile.getId();
        this.properties = animatedTiledMapTile.getProperties();
        this.objects = animatedTiledMapTile.getObjects();
    }
    public AnimatedTiledMapTileExt(AnimatedTiledMapTile animatedTiledMapTile, String loopType) {
        super(new IntArray(animatedTiledMapTile.getAnimationIntervals()), new Array<StaticTiledMapTile>(animatedTiledMapTile.getFrameTiles()));
        this.timer = 0;
        for (int i = 0; i < animatedTiledMapTile.getAnimationIntervals().length; i++) {
            this.loopDuration += animatedTiledMapTile.getAnimationIntervals()[i];
        }
        this.id = animatedTiledMapTile.getId();
        this.properties = animatedTiledMapTile.getProperties();
        this.objects = animatedTiledMapTile.getObjects();
        this.loopType = loopType;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public MapProperties getProperties() {
        return this.properties;
    }

    @Override
    public MapObjects getObjects() {
        return this.objects;
    }

    @Override
    public int getCurrentFrameIndex() {
        switch (loopType) {
            case "Default" :
                int currentTime = (int)(timer * 1000 % loopDuration);
                for (int i = 0; i < this.getAnimationIntervals().length; ++i) {
                    int animationInterval = this.getAnimationIntervals()[i];
                    if (currentTime <= animationInterval) {
                        if (Gdx.graphics.getFrameId() != this.currFrameId) {
                            this.timer = (this.timer + Gdx.graphics.getDeltaTime()) % ((float)(loopDuration) / 1000);
                            this.currFrameId = Gdx.graphics.getFrameId();
                        }
                        return i;
                    }
                    currentTime -= animationInterval;
                }
                break;
            case "Once" :
                currentTime = (int) timer;
                if (timer > loopDuration) {
                    this.animationFinished = true;
                    return this.getAnimationIntervals().length - 1;
                }
                for (int i = 0; i < this.getAnimationIntervals().length; ++i) {
                    int animationInterval = this.getAnimationIntervals()[i];
                    if (currentTime <= animationInterval) {
                        if (Gdx.graphics.getFrameId() != this.currFrameId) {
                            this.timer += (Gdx.graphics.getDeltaTime() * 1000);
                            this.currFrameId = Gdx.graphics.getFrameId();
                        }
                        return i;

                    }
                    currentTime -= animationInterval;
                }
                break;
        }

        throw new GdxRuntimeException(
                "Could not determine current animation frame in AnimatedTiledMapTile.  This should never happen.");
    }

    public boolean isAnimationFinished() {
        return animationFinished;
    }
}
