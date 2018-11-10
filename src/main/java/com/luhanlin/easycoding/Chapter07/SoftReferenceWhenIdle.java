package com.luhanlin.easycoding.Chapter07;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 类详细描述：没有触发OOM软引用是否会被回收测试
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/10 11:31 PM
 */
public class SoftReferenceWhenIdle {

    public static void main(String[] args) {
        House house = new House();

//        SoftReference<House> houses = new SoftReference<>(house);
        WeakReference<House> houses = new WeakReference<>(house);

        house = null;

        long start = System.nanoTime();
        int count = 0;
        while (true){
            // 下面代码建议JVM进行垃圾回收
//            System.gc();
//            System.runFinalization();

            if (houses.get() == null) {
                long duration = (System.nanoTime() - start) / (1000 * 1000);
                System.out.println(" house is null and exited time = " + duration + "ms");
                break;
            } else {
                System.out.println(" still there . count = " + (count++ ));
            }

        }

    }

    private static class House {

        private static final Integer DOOR_NUMBER = 2000;

        private Door[] doors = new Door[DOOR_NUMBER];

        class Door{}
    }
}
