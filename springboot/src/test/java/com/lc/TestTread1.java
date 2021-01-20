package com.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liuchao02
 * @ClassName: TestTread1
 * @Description: 交替打印 1A2B3C
 * @date 2021/1/20 11:13
 */
public class TestTread1 {
    public static  Thread a = null;
    public static  Thread b = null;

    public static void main(String[] args) {
        lockSupport();

    }
    public  static  void  lockSupport(){
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(()->{
            for (char val : dataOne){
                System.out.print(val);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        });
        b = new Thread(()->{
            for (char val : dataTwo) {
                LockSupport.park();
                System.out.print(val);
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
    }



}
