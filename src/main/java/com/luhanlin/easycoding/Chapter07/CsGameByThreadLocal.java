package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 类详细描述：thread local 测试
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 12:30 AM
 */
public class CsGameByThreadLocal {

    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;
    // 用来展示每个对象的不同的数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

//    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL
//            = ThreadLocal.withInitial(() -> BULLET_NUMBER);
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL
            = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL
            = ThreadLocal.withInitial(() -> KILLED_ENEMIES);

    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL
            = ThreadLocal.withInitial(() -> LIFE_VALUE);

    private static final ThreadLocal<Integer> TOTAL_PLAYERS_THREADLOCAL
            = ThreadLocal.withInitial(() -> TOTAL_PLAYERS);

    private static class Player extends Thread{

        @Override
        public void run() {
            int bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            int killEnemis = KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS / 2);
            int lifeValuse = LIFE_VALUE_THREADLOCAL.get() + RANDOM.nextInt(LIFE_VALUE);

            System.out.println(getName() + ", BULLET_NUMBER is " + bullets);
            System.out.println(getName() + ", KILLED_ENEMIES is " + killEnemis);
            System.out.println(getName() + ", LIFE_VALUE is " + lifeValuse + "\n");

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
