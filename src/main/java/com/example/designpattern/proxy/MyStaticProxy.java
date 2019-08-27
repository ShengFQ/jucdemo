package com.example.designpattern.proxy;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月24日 上午8:26
 */
public class MyStaticProxy implements ISubject {
    ISubject subject;

    public void afterRequest(){
        System.out.println("afterRequest() invoke");
    }

    public void preRequest(){
        System.out.println("preRequest() invoke");

    }
    @Override
    public void request() {
        preRequest();
        subject.request();
        afterRequest();
    }

    public MyStaticProxy(){
        subject=new RealSubject();
    }
}
