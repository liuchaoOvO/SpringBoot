package com.lc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuchao02
 * @ClassName: TestTreadCountDownLatchAndCyclicBarrier
 * @Description: 线程 门栓和格栅
 * @date 2021/1/20 11:30
 */
public class TestTreadCountDownLatchAndCyclicBarrier {
    //
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
        System.out.println("朋友全部到了,才开始吃饭");
    });

    public static void main(String[] args) throws InterruptedException {

        /*
       //测试门栓的用途
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "i");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "其他线程执行完了 开始执行该线程了");
        */

        //测试格栅的用途
        for (int j = 0; j < 6; j++) {
            final int tempInt = j;
            new Thread(() -> {
                System.out.println(tempInt + "朋友到了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(j)).start();
        }
    }


//test CyclicBarrier 可重复性

    public static class CyclicBarrierDemo {

        static class TaskThread extends Thread {

            CyclicBarrier barrier;

            public TaskThread(CyclicBarrier barrier) {
                this.barrier = barrier;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(getName() + " 到达栅栏 A");
                    barrier.await();
                    System.out.println(getName() + " 冲破栅栏 A");

                    Thread.sleep(2000);
                    System.out.println(getName() + " 到达栅栏 B");
                    barrier.await();
                    System.out.println(getName() + " 冲破栅栏 B");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            int threadNum = 5;
            CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 完成最后任务------------");
                }
            });

            for (int i = 0; i < threadNum; i++) {
                new TaskThread(barrier).start();
            }
        }

    }
}