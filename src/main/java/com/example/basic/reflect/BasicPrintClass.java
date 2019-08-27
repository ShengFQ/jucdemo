package com.example.basic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 反射的核心成员
 * Class
 * Class类的定义
 * 成员
 * Class的意义作用
 * 如何获取Class对象
 * 基本数据类型的Class
 * 常用场景
 * 一个类只有一个Class对象,这个Class对象可以获取Object对象,可以创建Object对象
 * @author fuqiang.sheng
 * @date 2019年05月12日 上午9:19
 */
public class BasicPrintClass {
     private String name;
     private Integer age;
     Class<BasicPrintClass> singleClass;
     public BasicPrintClass(){}
    public BasicPrintClass(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "BasicPrintClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    //通过类的类型获取class对象
    public void getClassFirst() throws ClassNotFoundException{
        singleClass=BasicPrintClass.class;
    }

    public void getClassSecond() throws ClassNotFoundException{
        singleClass=(Class<BasicPrintClass>)Class.forName("com.example.basic.reflect.BasicPrintClass");
    }
    //通过对象实例获取class 对象
    public void getClassThrid(){
        BasicPrintClass basicPrintClass=new BasicPrintClass();
        Class targetClass=basicPrintClass.getClass();
    }
    /**
     * 通过class对象构造一个object
     * */
    public void testGetNewInstance(){
        try{
        Constructor constructor= singleClass.getConstructor(String.class,Integer.class);
        BasicPrintClass newInstance= (BasicPrintClass) constructor.newInstance("jack",12);
            System.out.println(newInstance.toString());
        }catch(NoSuchMethodException e){

        }catch (IllegalArgumentException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过Class对象获取类的成员
     * 打印HashMap class对象的方法**/
    public void testReflection() {
        Class<?> c = HashMap.class;
        //获取类名
        System.out.println( "Class : " + c.getCanonicalName());
        //获取类限定符
        System.out.println( "Modifiers : " + Modifier.toString(c.getModifiers()));
        //获取类泛型信息
        TypeVariable[] tv = c.getTypeParameters();
        if (tv.length != 0) {
            StringBuilder parameter = new StringBuilder("Parameters : ");
            for (TypeVariable t : tv) {
                parameter.append(t.getName());
                parameter.append(" ");
            }
            System.out.println("泛型类型名:"+ parameter.toString());
        } else {
            System.out.println( "  -- No Type Parameters --");
        }
        //获取类实现的所有接口
        Type[] intfs = c.getGenericInterfaces();
        if (intfs.length != 0) {
            StringBuilder interfaces = new StringBuilder("Implemented Interfaces : ");
            for (Type intf : intfs){
                interfaces.append(intf.toString());
                interfaces.append(" ");
            }
            System.out.println( interfaces.toString());
        } else {
            System.out.println( "  -- No Implemented Interfaces --");
        }
        //获取类继承数上的所有父类
        List<Class> l = new ArrayList<>();
        printAncestor(c, l);
        if (l.size() != 0) {
            StringBuilder inheritance = new StringBuilder("Inheritance Path : ");
            for (Class<?> cl : l){
                inheritance.append(cl.getCanonicalName());
                inheritance.append(" ");
            }
            System.out.println( inheritance.toString());
        } else {
            System.out.println( "  -- No Super Classes --%n%n");
        }
        //获取类的注解(只能获取到 RUNTIME 类型的注解)
        Annotation[] ann = c.getAnnotations();
        if (ann.length != 0) {
            StringBuilder annotation = new StringBuilder("Annotations : ");
            for (Annotation a : ann){
                annotation.append(a.toString());
                annotation.append(" ");
            }
            System.out.println( annotation.toString());
        } else {
            System.out.println( "  -- No Annotations --%n%n");
        }
    }

    /**
     * 递归打印父类信息
     * @param c 当前类的class对象
     * @param l 输出参数 对象列表栈
     * */
    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }

    public static void main(String[] args) {
        BasicPrintClass basicPrintClass=new BasicPrintClass();
        basicPrintClass.testReflection();
    }


}