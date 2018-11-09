package com.luhanlin.easycoding.Chapter07;

import java.util.concurrent.Semaphore;

/**
 * 类详细描述：乘客窗口检查
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/9 12:28 PM
 */
public class CustomCheckWindow {

    public static void main(String[] args) {
        // 每次只允许三个乘客进行检车
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread{
        private int i;
        private Semaphore semaphore;

        public SecurityCheckThread(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("乘客 No." + i + " 正在接受检查");

                if (i % 2 == 0){
                    Thread.sleep(1000);
                    System.out.println("乘客 No." + i + " 身份可疑，不能出国");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("乘客 No." + i + " 已完成受检");
            }

        }
    }
}
