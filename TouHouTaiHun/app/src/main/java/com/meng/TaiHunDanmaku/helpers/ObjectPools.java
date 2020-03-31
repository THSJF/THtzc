package com.meng.TaiHunDanmaku.helpers;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;
import com.meng.TaiHunDanmaku.baseObjects.bullets.enemy.*;
import com.meng.TaiHunDanmaku.baseObjects.bullets.myPlane.*;
import com.meng.TaiHunDanmaku.baseObjects.bullets.subPlane.*;
import com.meng.TaiHunDanmaku.baseObjects.dropItems.*;
import com.meng.TaiHunDanmaku.baseObjects.effects.*;

public final class ObjectPools{
  
  public static RandomXS128 randomPool=new RandomXS128(9961);
  
        public static Pool<EnemyBullet> enemyBulletPool=new Pool<EnemyBullet>(8192){
        @Override
        protected EnemyBullet newObject(){
            return new EnemyBullet();
        }
    };

    public static Pool<DropItem> itemPool=new Pool<DropItem>(512){
        @Override
        protected DropItem newObject(){
            return new DropItem();
        }
    };

    public static Pool<ReimuSpell> reimuBombPool=new Pool<ReimuSpell>(64){
        @Override
        protected ReimuSpell newObject(){
            return new ReimuSpell();
        }
    };
    public static Pool<ReimuShoot> reimuShootPool=new Pool<ReimuShoot>(64){
        @Override
        protected ReimuShoot newObject(){
            return new ReimuShoot();
        }
    };

    public static Pool<ReimuSubPlaneBulletStraight> reimuSubPlaneBulletStraightPool=new Pool<ReimuSubPlaneBulletStraight>(64){
        @Override
        protected ReimuSubPlaneBulletStraight newObject(){
            return new ReimuSubPlaneBulletStraight();
        }
    };

    public static Pool<ReimuSubPlaneBulletInduce> reimuSubPlaneBulletInducePool=new Pool<ReimuSubPlaneBulletInduce>(64){
        @Override
        protected ReimuSubPlaneBulletInduce newObject(){
            return new ReimuSubPlaneBulletInduce();
        }
    };

    public static Pool<Effect> effectPool=new Pool<Effect>(4096){
        @Override
        protected Effect newObject(){
            return new Effect();
        }
    };
}
