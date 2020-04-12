package com.meng.TaiHunDanmaku.control;

import com.badlogic.gdx.*;
import com.badlogic.gdx.files.*;
import com.badlogic.gdx.math.*;
import com.meng.TaiHunDanmaku.baseObjects.planes.myPlane.*;
import com.meng.TaiHunDanmaku.helpers.*;
import com.meng.TaiHunDanmaku.ui.*;

public class ReplayManager {
    public static boolean onReplay = false;
  	private static Replay replay;

    public static void init(GameMain gameMain, long seed) {
        ReplayManager.onReplay = gameMain.onReplay;
		if (onReplay) {
			replay = Replay.decode(Gzip.unCompress(Gdx.files.external(gameMain.replayFileName).readBytes()));
			gameMain.charaFlag = replay.readString();
            gameMain.equipmentFlag = replay.readString();
            gameMain.difficultFlag = replay.readString();
            gameMain.stageFlag = replay.readString();
            gameMain.power = replay.readInt();
            ObjectPools.randomPool = new RandomXS128(replay.getSeed());
		} else {
            ObjectPools.randomPool = new RandomXS128(seed);
			replay = Replay.encode(seed);
			replay.write(gameMain.charaFlag).write(gameMain.equipmentFlag).write(gameMain.difficultFlag).write(gameMain.stageFlag).write(gameMain.power);
        }
    }

    public static void update(int gameTime) {
        if (onReplay) {
            BaseMyPlane.instance.objectCenter.x = replay.readFloat();
            BaseMyPlane.instance.objectCenter.y = replay.readFloat();
            BaseMyPlane.instance.slow = replay.readBoolean();
            BaseMyPlane.instance.onBomb = replay.readBoolean();
            FightScreen.instence.replayFPS = replay.readInt();
        } else {
			replay.write(BaseMyPlane.instance.objectCenter.x).write(BaseMyPlane.instance.objectCenter.y).write(BaseMyPlane.instance.slow).write(BaseMyPlane.instance.onBomb).write(FightScreen.instence.nowFps);
        }
    }

    public static void saveRepaly() {
        if (onReplay) return;
		FileHandle fh = Gdx.files.external(FightScreen.instence.gameMain.replayFileName);
		fh.writeBytes(Gzip.compress(replay.getData()), false);
    }
}
