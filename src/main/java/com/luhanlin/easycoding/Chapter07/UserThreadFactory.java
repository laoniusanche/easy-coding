package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类详细描述：自定义线程工厂类
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/9 5:05 PM
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namefix;
    private final AtomicInteger nextid = new AtomicInteger(1);

    // 线程组前缀，在使用jstack来排查线程问题时非常有用
    public UserThreadFactory(String whatFeatureOfGroup) {
        namefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namefix + nextid.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

}
