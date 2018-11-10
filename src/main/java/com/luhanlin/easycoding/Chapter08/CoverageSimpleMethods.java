package com.luhanlin.easycoding.Chapter08;

/**
 * 类详细描述：被测试类
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 1:27 AM
 */
public class CoverageSimpleMethods {

    public Boolean testMethod(int a, int b, int c){
        boolean result = false;
        if (a ==1 && b == 2 || c ==3){
            result = true;
        }

        return result;
    }

}
