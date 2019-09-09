package com.example.designpattern.template;

/**
 * 模板模式适合算法分开场景,属于分置思想,将暂时无法实现的用抽象方法代替交给其他人实现.
 * 三要素:抽象方法(扩展可变),模板方法(一般不变),钩子方法.
 *
 * 主框架相同,细节不同的场景,适合用模板.做填空题时
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午5:26
 */
public class Test {
    public static void main(String[] args) {
        AbsTemplate template=new ConcreteTemplateA();
        template.print();
    }
}
