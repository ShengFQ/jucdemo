package com.example.designpattern.strategy;

/**
 * 策略模式:
 * 定义抽象的算法家族成员,不同家庭有自己的成员实现.
 * 使用场景:
 *  卡交易,不同的卡,单价不同,打折不同,计算的金额也不同.
 *  根据类型来调用不同成员的实现.
 *
 * @author fuqiang.sheng
 * @date 2019年08月26日 下午10:25
 */
public class Test {
    public static void main(String[] args) {
        Context context;
        System.out.println("执行策略模式1");
        context=new Context(new ConcreteStrategyA());
        context.execute();
        System.out.println("执行策略模式1");
        context=new Context(new ConcreteStrategyB());
        context.execute();

    }

}
