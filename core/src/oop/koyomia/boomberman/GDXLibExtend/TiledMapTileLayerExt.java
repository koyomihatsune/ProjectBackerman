package oop.koyomia.boomberman.GDXLibExtend;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class TiledMapTileLayerExt extends TiledMapTileLayer {
    public List<FreeCell> freeCells;
    /**
     * Creates TiledMap layer
     *
     * @param width      layer width in tiles
     * @param height     layer height in tiles
     * @param tileWidth  tile width in pixels
     * @param tileHeight tile height in pixels
     */
    public TiledMapTileLayerExt(int width, int height, int tileWidth, int tileHeight) {
        super(width, height, tileWidth, tileHeight);
        freeCells = new ArrayList<>();
    }

    public TiledMapTileLayerExt(TiledMapTileLayer tiledMapTileLayer) {
        super(tiledMapTileLayer.getWidth(), tiledMapTileLayer.getHeight(), tiledMapTileLayer.getTileWidth(), tiledMapTileLayer.getTileHeight());
        freeCells = new ArrayList<>();
        for (int i = 0; i < tiledMapTileLayer.getWidth(); i++) {
            for (int j = 0; j < tiledMapTileLayer.getHeight(); j++) {
                this.setCell(i, j, tiledMapTileLayer.getCell(i, j));
            }
        }
        this.setName(tiledMapTileLayer.getName());
        this.setOffsetX(tiledMapTileLayer.getOffsetX());
        this.setOffsetY(tiledMapTileLayer.getOffsetY());
        this.setOpacity(tiledMapTileLayer.getOpacity());
        this.setParent(tiledMapTileLayer.getParent());
        this.setVisible(tiledMapTileLayer.isVisible());
    }

    public static class FreeCell extends Cell implements Comparable<FreeCell>{
        private float x;
        private float y;

        public FreeCell(Cell cell, float x, float y) {
            this.x = x;
            this.y = y;
            this.setTile(cell.getTile());
            this.setFlipHorizontally(cell.getFlipHorizontally());
            this.setFlipVertically(cell.getFlipVertically());
            this.setRotation(cell.getRotation());
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getX() {
            return x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getY() {
            return y;
        }

        @Override
        public int compareTo(FreeCell o) {
            return -Float.compare(y, o.y);
        }
    }
    public void addFreeCells(FreeCell freeCell) {
        freeCells.add(freeCell);
    }

    public void delFreeCells(FreeCell freeCell) {
        freeCells.remove(freeCell);
    }

}
