package com.meng.TaiHunDanmaku.baseObjects.planes.myPlane;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;
import com.meng.TaiHunDanmaku.*;
import com.meng.TaiHunDanmaku.baseObjects.bullets.*;
import com.meng.TaiHunDanmaku.baseObjects.planes.*;
import com.meng.TaiHunDanmaku.baseObjects.planes.subPlane.*;
import com.meng.TaiHunDanmaku.helpers.*;
import com.meng.TaiHunDanmaku.ui.*;

public abstract class BaseMyPlane extends BaseGameObject {

    public static BaseMyPlane instance;

    public int unmatchedTime;
    public boolean onUnmatched = false;
    public int bombTime;
    public boolean onBomb = false;

    public JudgeCircleAnimation animation = null;
    public JudgeCircleAnimation2 animation2 = null;

    private float playerLastX = 270;
    public boolean slow = false;
    public AnimationManager animationManager;
    public BaseSubPlane subPlane1, subPlane2, subPlane3, subPlane4;

    public GameMain gameMain;

    public void init(GameMain gameMain) {
        instance = this;
        this.gameMain = gameMain;
        animation = new JudgeCircleAnimation();
        animation.init();
        animation2 = new JudgeCircleAnimation2();
        animation2.init();
        existTime = 0;
        objectCenter.set(gameMain.width / 2, 80);
        image.setSize(30, 46);
        image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
        unmatchedTime = 1;
        onUnmatched = true;
        FightScreen.instence.groupNormal.addActor(image);
        image.setZIndex(Data.zIndexMyPlane);
    }

    public void kill() {

    }

    public void update() {
        super.update();
        animFlag++;
        objectCenter = new Vector2(MathUtils.clamp(objectCenter.x, 10, 376), MathUtils.clamp(objectCenter.y, 10, 440));
        if (image.getRotation() != 0) {
            image.setRotation(0);
        }
        image.setPosition(objectCenter.x, objectCenter.y, Align.center);
        shoot();
        judge();
        if (onBomb) {
            onUnmatched = true;
            bomb();
            bombTime--;
        }
        if (onUnmatched) {
            unmatchedTime--;
        }
        if (bombTime == 0) {
            onBomb = false;
            bombTime = Data.ReimuBombTime;
        }
        if (unmatchedTime == 0) {
            onUnmatched = false;
            unmatchedTime = Data.ReimuUnmatchedTime;
        }

        if (objectCenter.x > playerLastX) {
            playerLastX = objectCenter.x;
            animationManager.setStatus(MoveStatus.moveRight);
        } else if (objectCenter.x < playerLastX) {
            playerLastX = objectCenter.x;
            animationManager.setStatus(MoveStatus.moveLeft);
        } else {
            animationManager.setStatus(MoveStatus.stay);
        }

        animationManager.update();
        image.toBack();
        animation2.update();
        animation.update();
    }

    public void incPower(int p) {
        FightScreen.instence.gameMain.power += p;
        onPowerInc();
    }

    public void decPower(int p) {
        FightScreen.instence.gameMain.power -= p;
        onPowerDec();
    }

    public void judge() {
        for (BaseEnemyBullet baseBullet : BaseEnemyBullet.instances) {
            if (baseBullet.getCollisionArea().contains(objectCenter)) {
                baseBullet.killByJudge();
                kill();
            }
        }
    }

    public abstract void bomb();

    public abstract void shoot();

    public abstract void onPowerInc();

    public abstract void onPowerDec();
}
