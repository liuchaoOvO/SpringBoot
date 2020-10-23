package com.lc;

/**
 * @author liuchao02
 * @ClassName: TestMulityThread
 * @Description:
 * @date 2020/10/22 20:19
 */
public class TestMulityThread {
    static Thread t1;
    static Thread t2;

    //循环打印abc abc abc
    public static void main(String[] args) throws InterruptedException {
        BusinessClass bc = new BusinessClass();
        t1 = new Thread(() -> {
            try {
                bc.print("hello t1", true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t2 = new Thread(() -> {
            try {
                bc.print("hello t2", false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        //线程的启动顺序无所谓 控制方交由同步方法控制
        t2.start();
        t1.start();
        Thread.sleep(1000);

    }
}

//先打印t1 线程 再打印t2线程的同步方法
class BusinessClass {

    public static boolean flag = true;

    public void print(String str, boolean flagParam) throws InterruptedException {
        synchronized (this) {
            while (flag != flagParam) {
                this.wait();
            }
            System.out.println("str--:" + str);
            flag = false;
            this.notify();

        }
    }

}
