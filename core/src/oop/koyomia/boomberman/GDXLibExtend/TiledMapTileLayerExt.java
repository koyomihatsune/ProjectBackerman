package oop.koyomia.boomberman.GDXLibExtend;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
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
        final int row2 = tiledMapTileLayer.getHeight();
        final int row1 = 0;
        final int col1 = 0;
        final int col2 = tiledMapTileLayer.getWidth();
        float xStart = 0;
        float y = row2 * tiledMapTileLayer.getTileHeight();
        for (int row = row2; row >= row1; row--) {
            float x = xStart;
            for (int col = col1; col < col2; col++) {
                final TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(col, row);
                if (cell == null) {
                    x += tiledMapTileLayer.getTileWidth();
                    continue;
                }
                TiledMapTileLayerExt.FreeCell newCell = new TiledMapTileLayerExt.FreeCell(cell, x, y);
                super.setCell(col, row, newCell);
                this.addFreeCell(newCell);
                x += tiledMapTileLayer.getTileWidth();
            }
            y -= tiledMapTileLayer.getTileHeight();
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
        private boolean isValidated = false;
        public FreeCell(Cell cell, float x, float y) {
            this.x = x;
            this.y = y;

            this.setFlipHorizontally(cell.getFlipHorizontally());
            this.setFlipVertically(cell.getFlipVertically());
            this.setRotation(cell.getRotation());
            if (cell.getTile().getObjects().get("collision") == null) {
                RectangleMapObject tempRec = new RectangleMapObject(0,0, 0,0);
                tempRec.setName("collision");
                cell.getTile().getObjects().add(tempRec);
                this.isValidated = true;
            }
//            else if (!isValidated) {
//                MapObject originRec = cell.getTile().getObjects().get("collision");
//                RectangleMapObject temp = (RectangleMapObject) originRec;
//                Rectangle castedRec = temp.getRectangle();
//                if (castedRec.getX() != 0 || castedRec.getY() != 0 || castedRec.getHeight() != 0 || castedRec.getWidth() != 0) {
//                    Rectangle tempRec = new Rectangle(temp.getRectangle().getX(), (float) cell.getTile().getTextureRegion().getRegionHeight() - temp.getRectangle().getY() - temp.getRectangle().getHeight(), temp.getRectangle().getWidth(), temp.getRectangle().getHeight());
//                    temp.getRectangle().set(tempRec);
//                }
//                this.isValidated = true;
//            }
            this.setTile(cell.getTile());
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
            RectangleMapObject thisMapObj = (RectangleMapObject)FreeCell.this.getTile().getObjects().get("collision");
            RectangleMapObject thatMapObj = (RectangleMapObject)o.getTile().getObjects().get("collision");
            return -Float.compare(getY() + thisMapObj.getRectangle().getY(), o.getY() + thatMapObj.getRectangle().getY());
        }
    }
    public void addFreeCell(FreeCell freeCell) {
        freeCells.add(freeCell);
    }

    public void delFreeCells(FreeCell freeCell) {
        freeCells.remove(freeCell);
    }

    /**
     * Sets the {@link Cell} at the given coordinates.
     *
     * @param x    X coordinate in map coordinate system
     * @param y    Y coordinate in map coordinate system
     * @param cell the {@link Cell} to set at the given coordinates.
     */
    @Override
    public void setCell(int x, int y, Cell cell) {
        Cell changeCell = super.getCell(x, y);
        changeCell.setTile(cell.getTile());
        changeCell.setFlipHorizontally(cell.getFlipHorizontally());
        changeCell.setFlipVertically(cell.getFlipVertically());
        changeCell.setRotation(cell.getRotation());
    }
}
