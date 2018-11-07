package com.luhanlin.easycoding.Chapter02;

/**
 * 类详细描述：重载测试类
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/7 10:28 AM
 */
public class OverloadTest {

    public static void main(String[] args) {
        // 此处变异报错，发现了两个可以match的方法签名
//        methodForOverload(11,23);
    }

    public static void methodForOverload(int param1, Integer param2){
        System.out.println("first overload method");
    }

    public static void methodForOverload(Integer param1, int param2){
        System.out.println("second overload method");
    }
}
