package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 类详细描述：CountDownLatch
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/9 11:09 AM
 */
public class CountDownLatchTest {
    
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);

        new TranslateThread("first content ",count).start();
        new TranslateThread("second content ",count).start();
        new TranslateThread("third content ",count).start();

        try {
            count.await(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完成！");
    }

    private static class TranslateThread extends Thread{

        private String content;
        private CountDownLatch count;

        public TranslateThread(String content, CountDownLatch count) {
            this.content = content;
            this.count = count;
        }

        @Override
        public void run() {
            if (Math.random() > 0.5){
                throw new RuntimeException("编译出现异常");
            }

            count.countDown();
            System.out.println(content + " 编译完成！");
        }
    }
}
