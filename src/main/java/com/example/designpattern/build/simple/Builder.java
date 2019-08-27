package com.example.designpattern.build.simple;

/***通过构造器来分步骤,分条件构造
 *
 *
 * 使用场景
 * 1.相同的方法，不同的执行顺序，产生不同的事件结果。（View的封装，对外暴露的方法不同）
 * 2.多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时
 * 3.产品类非常复杂，或者产品类中的调用顺序不同产生了不同的作用
 * 4.初始化一个对象特别复杂，如参数特别多且很多都具有默认参数时
 *
 * 关键点
 * 原始版-四个角色
 * 一个产品类—需要被构建的产品
 * 一个抽象Build类—隔离产品组件的构建
 * 一个具体构建产品的Build实现类—产品组件的具体构建
 * 一个组装类—组件与产品的组装
 * 简易版—两个角色
 * 一个产品类—需要被构建的产品
 * 一个Builder类—一般为产品类的静态内部类，负责组件的具体构建和产品的组装
 *
 *
 * **/
   public abstract   class Builder{
        /**
         * 不同的原料,不同的步骤,不同的顺序,构造不同的产品实例
         * */
        public abstract void material(Material material);

        public abstract void process(Process process);

        public abstract void productLine(ProductLine productLine);

        //组装产品
        public abstract Product build();

    }