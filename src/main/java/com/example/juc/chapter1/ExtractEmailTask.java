package com.example.juc.chapter1;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * 生产者线程
 * */
public class ExtractEmailTask extends Thread {
    private ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue;

    public ExtractEmailTask(ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue){
        this.emailQueue=emailQueue;
    }
    @Override
    public void run() {
        extractEmail();
    }
    protected List<Integer> extractEmail() {
        List<ExchangeEmailShallowDTO> allEmails =createEmail();
        if (allEmails == null) {
            return null;
        }
        for (ExchangeEmailShallowDTO exchangeEmailShallowDTO : allEmails) {
            emailQueue.offer(exchangeEmailShallowDTO);
            System.out.println("work queue offer "+exchangeEmailShallowDTO.toString());
        }
        return null;
    }

    /**
     * 模拟,假设是一个比较耗时的RPC调用
     * */
    protected List<ExchangeEmailShallowDTO> createEmail(){
        List<ExchangeEmailShallowDTO> resource=   new ArrayList<ExchangeEmailShallowDTO>();
        for (int i=0;i<10;i++){
            ExchangeEmailShallowDTO emailShallowDTO=new ExchangeEmailShallowDTO();
            emailShallowDTO.setAccount(Thread.currentThread().getName()+"_"+i);
            emailShallowDTO.setCount(1);
            resource.add(emailShallowDTO);

        }
        return resource;

    }

}
