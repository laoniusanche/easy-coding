package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/9 5:27 PM
 */
public class UserThreadPool {

    public static void main(String[] args) {
        // 设置固定长度，快速触发 rejectHandler
        LinkedBlockingQueue queue= new LinkedBlockingQueue(2);

        // 创建两个线程组
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectHandler userRejectHandler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f1, userRejectHandler);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f2, userRejectHandler);

        Task task = new Task();

        // 创建400个任务线程
        for (int i = 0; i < 200; i++) {
            threadPoolExecutor1.execute(task);
            threadPoolExecutor2.execute(task);
        }
    }
}
