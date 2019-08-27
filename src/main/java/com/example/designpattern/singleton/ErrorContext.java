package com.example.designpattern.singleton;
/**
 * spring容器中的实例默认是单例饿汉式类型的，
 * 即容器启动时就实例化bean到容器中，
 * 当然也可以设置懒汉式defalut-lazy-init="true"为延迟实例化，
 * 用到时再实例化
 * */
public class ErrorContext {

    private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal<ErrorContext>();

    private ErrorContext() {
    }

    public static ErrorContext instance() {
        ErrorContext context = LOCAL.get();
        if (context == null) {
            context = new ErrorContext();
            LOCAL.set(context);
        }
        //验证是否是同一个实例
        System.out.println(" context hashCode:"+context.hashCode());
        return context;
    }



    //测试数据是否安全
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count=0;
    //
}