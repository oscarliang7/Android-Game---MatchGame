package com.nativegame.match3game.game.layer.lock;

import com.nativegame.match3game.game.layer.LayerSystem;
import com.nativegame.match3game.level.Level;
import com.nativegame.nattyengine.engine.Engine;

public class LockSystem extends LayerSystem<Lock> {

    private final Lock[][] mLocke;

    public LockSystem(Engine engine) {
        super(engine);
        mLocke = new Lock[mTotalRow][mTotalCol];
        init(Level.LEVEL_DATA.getLock().toCharArray());
    }

    @Override
    public Lock[][] getChild() {
        return mLocke;
    }

    @Override
    public Lock getChildAt(int row, int col) {
        return mLocke[row][col];
    }

    private void init(char[] chars) {
        for (int i = 0; i < mTotalRow; i++) {
            for (int j = 0; j < mTotalCol; j++) {
                char c = chars[i * mTotalCol + j];
                if (c == 'e') {
                    // We skip the empty lock
                    continue;
                }
                LockType type = LockInitializer.getType(c);
                Lock lock = new Lock(mEngine, type.getTexture(), type);
                lock.setPosition(i, j);
                lock.addToGame();
                mLocke[i][j] = lock;
            }
        }
    }

}