package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类详细描述：任务执行体
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/9 5:21 PM
 */
public class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(1L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
