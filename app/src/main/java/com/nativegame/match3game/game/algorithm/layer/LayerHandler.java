package com.nativegame.match3game.game.algorithm.layer;

import com.nativegame.match3game.game.algorithm.target.TargetHandlerManager;
import com.nativegame.match3game.game.layer.tile.Tile;

public interface LayerHandler {

    void initLayer(Tile[][] tiles, int row, int col);

    void updateLayer(TargetHandlerManager targetHandlerManager, Tile[][] tiles, int row, int col);

    void removeLayer(Tile[][] tiles, int row, int col);

}