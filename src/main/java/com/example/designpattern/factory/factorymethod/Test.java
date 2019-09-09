package com.example.designpattern.factory.factorymethod;

/**
 * 工厂方法模式:用于对象的实例化过程场景,工厂构造出产品对象, mybatis-sqlSessionFactory-->sqlSession
 * 封装了实例化逻辑,调用者是面向抽象的获取对象实例,mybatis
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午8:47
 */
public class Test {
    public static void main(String[] args) {
        IFactory factoryA = new FactoryA();
        IProduct prodectA = factoryA.createProduct();
        prodectA.productMethod();

        IFactory factoryB = new FactoryB();
        IProduct prodect = factoryB.createProduct();
        prodect.productMethod();
    }
}
