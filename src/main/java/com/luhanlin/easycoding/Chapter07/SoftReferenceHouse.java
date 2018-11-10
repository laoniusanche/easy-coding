package com.luhanlin.easycoding.Chapter07;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * 类详细描述：软引用测试
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/10 11:05 PM
 */
public class SoftReferenceHouse {

    public static void main(String[] args) {

        ArrayList<House> houses = new ArrayList<House>();

        // 剧情反转注释处
//        ArrayList<SoftReference> houses = new ArrayList<>();

        int i = 0;
        while(true){
             houses.add(new House());

            // 剧情反转注释处
//            SoftReference<House> buyer2 = new SoftReference<House>(new House());

//            houses.add(buyer2);

            System.out.println("i = "+ ++i);
        }


    }

    private static class House {

        private static final Integer DOOR_NUMBER = 2000;

        private Door[] doors = new Door[DOOR_NUMBER];

        class Door{}
    }
}
