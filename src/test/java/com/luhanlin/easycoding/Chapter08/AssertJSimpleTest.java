package com.luhanlin.easycoding.Chapter08;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

/**
 * 类详细描述：AssertJ 测试
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 2:24 AM
 */
public class AssertJSimpleTest {

    @Test
    public void testUsingAssertJ(){
        // string test
        String s = "abcde";
        Assertions.assertThat(s).as("字符串长度判断：判断首尾及长度")
                .startsWith("ab").endsWith("de").hasSize(5);

        // number test
        Integer i = 50;
        Assertions.assertThat(i).as("数字判断：数字大小比较")
                .isGreaterThan(0).isLessThan(100);

        // date test
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertThat(date1).as("日期判断：容器大小比较")
                .isBefore(date2).isAfter(date3);

        // list test
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Assertions.assertThat(list).as("list 判断：首、尾元素及长度")
                    .startsWith("a").endsWith("d").hasSize(4);

        // map test
        HashMap<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        Assertions.assertThat(map).as("Map 的判断：长度及ksy值")
                .hasSize(4).containsKeys("A", "B", "C", "D");


    }
}
