package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类详细描述：ThreadLocal 脏数据测试
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 1:08 AM
 */
public class DirtyDataInThreadLocal {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        // 进行线程的复用
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 6; i++) {
            threadPool.execute(new MyThread());
        }
    }

    private static class MyThread extends Thread {
        private static Boolean flag = true;

        @Override
        public void run() {
            if (flag) {
                System.out.println(this.getName() + " 进行了set操作");
                threadLocal.set(this.getName() + ", session info !");
                flag = false;
            }

            System.out.println(this.getName() + " 线程是 " + threadLocal.get());

            // 每次使用完ThreadLocal后调用remove() 方法，防止内存泄漏
//            threadLocal.remove();

        }
    }
}
