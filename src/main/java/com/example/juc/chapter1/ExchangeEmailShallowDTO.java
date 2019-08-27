package com.example.juc.chapter1;
/**
 * 共享资源
 * */
public class ExchangeEmailShallowDTO {

    private int count;
    private String account;

    /**
     * 获取邮件数
     * */
    public int getCount(){
        return this.count;
    }
    /**
     * 收件箱自增
     * */
    public void addCount(){
        count++;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "账号:"+account+" 收件箱邮件:"+count;
    }
}
