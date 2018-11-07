package com.luhanlin.easycoding.Chapter02;

/**
 * 类详细描述：泛型测试类
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/7 10:33 AM
 */
public class GenericTest<T> {
    // 此处定义中，方法参数都是泛型 返回类型也是泛型 idea中的颜色可以方便的分辨
    static <String, T, Luhanlin> String get(String string,Luhanlin luhanlin){
        return string;
    }

    static <T> T heat(T food){
        System.out.println(food + " is done ");
        return food;
    }

    public static void main(String[] args) {
        String first = "22俄";
        Long second = 222L;
        System.out.println(get(first,second));  // 22俄

    }

}
