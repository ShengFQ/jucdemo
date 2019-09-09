package com.example.designpattern.strategy;

/**
 * 策略模式:
 * 定义抽象的算法家族成员,不同家庭有自己的成员实现.
 * 使用场景:
 *  卡交易,不同的卡,单价不同,打折不同,计算的金额也不同.
 *  根据类型来调用不同成员的实现.
 *
 *• 几个类的主要逻辑相同,只在部分逻辑的算法和行为上稍有区别的情况。
 * • 有几种相似的行为,或者说算法,客户端需要动态地决定使用哪一种,那么可以使用策略模式,将这些算法
 * 封装起来供客户端调用。
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
