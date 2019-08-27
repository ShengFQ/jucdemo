package com.example.designpattern.proxy;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的作用就是中介,中介就是满足客户的需求,办理了所有的事情.
 * 中间隔离：某些情况下，客户端不想或者不能直接引用一个目标对象，而代理类可以在客户端和目标类之前起到中介作用
 *
 * 开闭原则，扩展功能：代理类除了是客户类和目标类的中介，还可以通过给代理类增加额外的功能来扩展目标类的功能，这样我们只需要修改代理类而不需要再修改目标类，符合代码设计的开闭原则（对扩展开放，对修改关闭）。
 * 代理类主要负责为目标类预处理消息、过滤消息、把消息转发给目标类，以及事后对返回结果的处理等。
 * 代理类本身并不真正实现服务，而是同过调用目标类的相关方法，来提供特定的服务。真正的业务功能还是由目标类来实现，但是可以在业务功能执行的前后加入一些公共的服务。例如我们想给项目加入缓存、日志这些功能，我们就可以使用代理类来完成，而没必要打开已经封装好的目标类。
 *
 * 代理模式可以认为是Mybatis的核心使用的模式，正是由于这个模式，我们只需要编写Mapper.java接口，
 * 不需要实现，由Mybatis后台帮我们完成具体SQL的执行。
 *
 * 代理模式(MyStaticProxy Pattern) ：给某一个对象提供一个代 理，并由代理对象控制对原对象的引用。
 * 代理模式的英 文叫做Proxy或Surrogate，它是一种对象结构型模式。
 *----------------------------------------------------------------
 * 使用代理模式的场景:aop,ioc,mybatis的mapper接口与xml配置对象实例化,rpc
 * 给遗留系统做:全局日志,全局异常处理,参数校验,不用修改已经编译的代码.
 *
 *
 * @author fuqiang.sheng
 * @date 2019年08月24日 上午8:03
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //静态代理,代理类需要显示的实现接口,调用目标类的实现.
        ISubject subject=new MyStaticProxy();
        subject.request();
        //动态代理,由jdk实现创建代理对象,解析接口的class信息,从目标对象中找实现方法,验证下
        System.out.println();
        ISubject proxy=(ISubject)SubjectProxy.loadProxy1(new UserSubject());
        proxy.request();
        System.out.println();
        ISubject proxy2=(ISubject)SubjectProxy.loadProxy2(new UserSubject());
        proxy2.request();

        System.out.println("输出自动生成的代理类");
        SubjectProxy.write(new UserSubject());

    }



}
