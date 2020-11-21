package oop.koyomia.boomberman.GDXLibExtend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.*;
import com.badlogic.gdx.math.Rectangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.badlogic.gdx.graphics.g2d.Batch.*;

public class OrthogonalTiledMapRendererExt extends OrthogonalTiledMapRenderer {
    private boolean debugMode = true;
    public OrthogonalTiledMapRendererExt(TiledMap map) {
        super(map);
    }

    public OrthogonalTiledMapRendererExt(TiledMap map, Batch batch) {
        super(map, batch);
    }

    public OrthogonalTiledMapRendererExt(TiledMap map, float unitScale) {
        super(map, unitScale);
    }

    public OrthogonalTiledMapRendererExt(TiledMap map, float unitScale, Batch batch) {
        super(map, unitScale, batch);
    }

    public void renderTileLayer(TiledMapTileLayer layer) {
        if (layer instanceof TiledMapTileLayerExt) {
            TiledMapTileLayerExt layerExt = (TiledMapTileLayerExt) layer;
            final Color batchColor = batch.getColor();
            final float color = Color.toFloatBits(batchColor.r, batchColor.g, batchColor.b, batchColor.a * layer.getOpacity());

            final int layerWidth = layer.getWidth();
            final int layerHeight = layer.getHeight();

            final float layerTileWidth = layer.getTileWidth() * unitScale;
            final float layerTileHeight = layer.getTileHeight() * unitScale;

            final float layerOffsetX = layer.getRenderOffsetX() * unitScale;
            // offset in tiled is y down, so we flip it
            final float layerOffsetY = -layer.getRenderOffsetY() * unitScale;
//            for (TiledMapTileLayerExt.FreeCell cell:layerExt.freeCells) {
//                float x = cell.x + layerOffsetX;
//                float y = cell.y + layerOffsetY;
//                drawCell(cell, x, y, color);
//            }

            final int col1 = Math.max(0, (int)((viewBounds.x - layerOffsetX) / layerTileWidth));
            final int col2 = Math.min(layerWidth,
                    (int)((viewBounds.x + viewBounds.width + layerTileWidth - layerOffsetX) / layerTileWidth));

            final int row1 = Math.max(0, (int)((viewBounds.y - layerOffsetY) / layerTileHeight));
            final int row2 = Math.min(layerHeight,
                    (int)((viewBounds.y + viewBounds.height + layerTileHeight - layerOffsetY) / layerTileHeight));
            float y = row2 * layerTileHeight + layerOffsetY;
            float xStart = col1 * layerTileWidth + layerOffsetX;
            final float[] vertices = this.vertices;
//            List<TiledMapTileLayerExt.FreeCell> cellList = new ArrayList<>();
//            int freeCellRendered = 0;
//            for (int row = row2; row >= row1; row--) {
//                float x = xStart;
//                for (int col = col1; col < col2; col++) {
//                    final TiledMapTileLayer.Cell cell = layer.getCell(col, row);
//                    if (cell == null) {
//                        x += layerTileWidth;
//                        continue;
//                    }
//                    cellList.add(new TiledMapTileLayerExt.FreeCell(cell, x, y));
//                    x += layerTileWidth;
//                }
//                y -= layerTileHeight;
//            }
            Collections.sort(((TiledMapTileLayerExt) layer).freeCells);
            for (TiledMapTileLayerExt.FreeCell freeCell : ((TiledMapTileLayerExt) layer).freeCells) {
                drawCell(freeCell, freeCell.getX() * unitScale + layerOffsetX, freeCell.getY() * unitScale + layerOffsetY, color);
            }
        } else
            super.renderTileLayer(layer);
    }
    private void drawCell(TiledMapTileLayer.Cell cell, float x, float y, float color) {
        final TiledMapTile tile = cell.getTile();

        if (tile != null) {
            final boolean flipX = cell.getFlipHorizontally();
            final boolean flipY = cell.getFlipVertically();
            final int rotations = cell.getRotation();

            TextureRegion region = tile.getTextureRegion();

            float x1 = x + tile.getOffsetX() * unitScale;
            float y1 = y + tile.getOffsetY() * unitScale;
            float x2 = x1 + region.getRegionWidth() * unitScale;
            float y2 = y1 + region.getRegionHeight() * unitScale;

            float u1 = region.getU();
            float v1 = region.getV2();
            float u2 = region.getU2();
            float v2 = region.getV();

            vertices[X1] = x1;
            vertices[Y1] = y1;
            vertices[C1] = color;
            vertices[U1] = u1;
            vertices[V1] = v1;

            vertices[X2] = x1;
            vertices[Y2] = y2;
            vertices[C2] = color;
            vertices[U2] = u1;
            vertices[V2] = v2;

            vertices[X3] = x2;
            vertices[Y3] = y2;
            vertices[C3] = color;
            vertices[U3] = u2;
            vertices[V3] = v2;

            vertices[X4] = x2;
            vertices[Y4] = y1;
            vertices[C4] = color;
            vertices[U4] = u2;
            vertices[V4] = v1;

            if (flipX) {
                float temp = vertices[U1];
                vertices[U1] = vertices[U3];
                vertices[U3] = temp;
                temp = vertices[U2];
                vertices[U2] = vertices[U4];
                vertices[U4] = temp;
            }
            if (flipY) {
                float temp = vertices[V1];
                vertices[V1] = vertices[V3];
                vertices[V3] = temp;
                temp = vertices[V2];
                vertices[V2] = vertices[V4];
                vertices[V4] = temp;
            }
            if (rotations != 0) {
                switch (rotations) {
                    case TiledMapTileLayer.Cell.ROTATE_90: {
                        float tempV = vertices[V1];
                        vertices[V1] = vertices[V2];
                        vertices[V2] = vertices[V3];
                        vertices[V3] = vertices[V4];
                        vertices[V4] = tempV;

                        float tempU = vertices[U1];
                        vertices[U1] = vertices[U2];
                        vertices[U2] = vertices[U3];
                        vertices[U3] = vertices[U4];
                        vertices[U4] = tempU;
                        break;
                    }
                    case TiledMapTileLayer.Cell.ROTATE_180: {
                        float tempU = vertices[U1];
                        vertices[U1] = vertices[U3];
                        vertices[U3] = tempU;
                        tempU = vertices[U2];
                        vertices[U2] = vertices[U4];
                        vertices[U4] = tempU;
                        float tempV = vertices[V1];
                        vertices[V1] = vertices[V3];
                        vertices[V3] = tempV;
                        tempV = vertices[V2];
                        vertices[V2] = vertices[V4];
                        vertices[V4] = tempV;
                        break;
                    }
                    case TiledMapTileLayer.Cell.ROTATE_270: {
                        float tempV = vertices[V1];
                        vertices[V1] = vertices[V4];
                        vertices[V4] = vertices[V3];
                        vertices[V3] = vertices[V2];
                        vertices[V2] = tempV;

                        float tempU = vertices[U1];
                        vertices[U1] = vertices[U4];
                        vertices[U4] = vertices[U3];
                        vertices[U3] = vertices[U2];
                        vertices[U2] = tempU;
                        break;
                    }
                }
            }
            batch.draw(region.getTexture(), vertices, 0, NUM_VERTICES);

        }
    }
}

