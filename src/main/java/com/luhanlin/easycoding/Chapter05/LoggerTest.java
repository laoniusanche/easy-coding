package com.luhanlin.easycoding.Chapter05;

import lombok.extern.log4j.Log4j2;

/**
 * 类详细描述：日志测试类
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/7 9:06 PM
 */
@Log4j2
public class LoggerTest {

    public static void main(String[] args) {
        log.info("这里尝试使用占位符形式打印日志，输出结果为：{}, {}", "result","test");

        try {
            throw new RuntimeException("test RuntimeException");
        } catch (RuntimeException e) {
            log.error("test error log ,message : {}",e.getMessage(),e);
        }
    }
}
