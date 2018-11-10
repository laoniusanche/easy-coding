package com.luhanlin.easycoding.Chapter08;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * 类详细描述：使用JUnit的断言
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 2:10 AM
 */
public class JUnitSimpleTest {

    @Test
    public void testUsingJunitAssertThat(){
        // 字符串判断
        String s = "abcde";
        Assertions.assertTrue(s.startsWith("ab"));
        Assertions.assertTrue(s.endsWith("de"));
        Assertions.assertEquals(5, s.length());

        // 数字判断
        Integer i = 50;
        Assertions.assertTrue(i > 0);
        Assertions.assertTrue(i < 100);

        // 日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertTrue(date1.before(date2));
        Assertions.assertTrue(date1.after(date3));

        // list 判断
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Assertions.assertEquals("a",list.get(0));
        Assertions.assertEquals(4,list.size());
        Assertions.assertEquals("d",list.get(list.size() - 1));

        // map 判断
        HashMap<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        Set<String> keys = map.keySet();
        Assertions.assertEquals(4, map.size());
        Assertions.assertTrue(keys.containsAll(Arrays.asList("A", "B", "C")));
    }
}
