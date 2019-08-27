package com.example.juc.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * 消费者线程
 * */
public class InsertToWikiTask extends Thread {
    private ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue;
    public InsertToWikiTask(ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue){
        this.emailQueue=emailQueue;
    }

    @Override
    public void run() {
        try {
            insertToWiki();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void insertToWiki() throws InterruptedException {
        while (true) {
            //2 秒内取不到就退出
            ExchangeEmailShallowDTO email = (ExchangeEmailShallowDTO) emailQueue.poll(2, TimeUnit.SECONDS);
            if (email == null) {
                System.out.println("out of email queue");
                break;
            }
            email.addCount();
            System.out.println("workQueue.poll("+email.toString()+")");

        }

    }
}
