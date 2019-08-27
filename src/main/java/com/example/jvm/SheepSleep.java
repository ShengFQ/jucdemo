package com.example.jvm;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年04月10日 下午12:41
 */
public class SheepSleep {
    public static void main(String[] args) {
        Thread t1=new Thread(new Thread1());
        t1.start();
        /*Thread t2=new Thread(new Thread2());
        t2.start();*/
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("print thread1");
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("print thread2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
