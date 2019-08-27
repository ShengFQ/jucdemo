package com.example.juc.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用waitNotify模型
 *
 * @author sheng
 * @date 20190310
 */
public class WaitNotifyModel implements Model {
    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<Task>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public WaitNotifyModel(int cap) {
        this.cap = cap;
    }

    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {

        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == 0) {
                    BUFFER_LOCK.wait();//TODO 当前线程阻塞
                }
                Task task = buffer.poll(); //TODO 非阻塞调用
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {

        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == cap) {
                    BUFFER_LOCK.wait(); //TODO 当前线程阻塞
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task); //TODO 非阻塞调用
                System.out.println("produce: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<Thread>();
        Thread t1 = null, t2 = null;
        Model model = new WaitNotifyModel(3);
        for (int i = 0; i < 4; i++) {
            t1 = new Thread(model.newRunnableConsumer());
            t1.start();
            list.add(t1);
        }
        for (int i = 0; i < 4; i++) {
            t2 = new Thread(model.newRunnableProducer());
            t2.start();
            list.add(t2);
        }
        try {
            for (Thread t : list) {
                if (t != null) {
                    t.join();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread shutdown!");
    }
}
