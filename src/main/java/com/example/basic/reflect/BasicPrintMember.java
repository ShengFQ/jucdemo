package com.example.basic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 文件描述
 * 反射的核心成员Member
 *java.lang.reflect.Field ：对应类变量
 * java.lang.reflect.Method ：对应类方法
 * java.lang.reflect.Constructor ：对应类构造函数
 *
 * @author fuqiang.sheng
 * @date 2019年05月12日 上午10:48
 */
public class BasicPrintMember<T> {
    //泛型字段
    private T target;
    private String name;
    private Integer age;
    private Class<BasicPrintMember> singleClass;
    private  static List<String> allName=new ArrayList<>(10);
    public T getTarget(){
        return target;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public BasicPrintMember(){}
    public BasicPrintMember(String name,Integer age){
        this.name=name;
        this.age=age;
    }
    public BasicPrintMember(String name,Integer age,T t){

        this.target=t;
    }
    /**
     * 参数化方法
     * */
    public List<String> add(String name){
        allName.add(name);
        return allName;
    }

    public void sleep(){
        System.out.println(this.name+" sleep");
    }
    public void eat(String food){
        System.out.println(this.name+" eat "+food);
    }
    public void eat(String... food){
        System.out.println(this.name+" eat "+food);
    }

    //获取field
    private void printField() throws NoSuchFieldException{
        Class<HashMap> classes=HashMap.class;

        Field[] fields = classes.getDeclaredFields();
        for(Field f : fields){
            StringBuilder builder = new StringBuilder();
            //获取名称
            builder.append("filed name = ");
            builder.append(f.getName());
            //获取类型
            builder.append(" type = ");
            builder.append(f.getType());
            //获取修饰符
            builder.append(" modifiers = ");
            builder.append(Modifier
                    .toString(f.getModifiers()));
            //获取注解
            Annotation[] ann = f.getAnnotations();
            if (ann.length != 0) {
                builder.append(" annotations = ");
                for (Annotation a : ann){
                    builder.append(a.toString());
                    builder.append(" ");
                }
            } else {
                builder.append("  -- No Annotations --");
            }
            System.out.println( builder.toString());
        }

        Field field2=classes.getField("");
    }

    private void printMethod(){
        Method[] methods=singleClass.getDeclaredMethods();
        for(Method method:methods){
            Class targetClass=method.getReturnType();
            System.out.println("method return type:"+targetClass.toString());
            Type targetType=method.getGenericReturnType();
            System.out.println("method return type:"+targetType.toString());

            Class[] paramType=method.getParameterTypes();
            for(Class paramTypeItem:paramType) {
                System.out.println("method paramTypeItem:" + paramTypeItem.toString());
            }
            Type[] paramTypes=method.getGenericParameterTypes();
            for(Type paramTypesItem:paramTypes) {
                System.out.println("method paramTypesItem:" + paramTypesItem.toString());
            }

            //这里的m可以是普通方法Method，也可以是构造方法Constructor
//获取方法所有参数
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                Parameter p = params[i];
                p.getType();   //获取参数类型
                p.getName();  //获取参数名称，如果编译时未加上`-parameters`，返回的名称形如`argX`, X为参数在方法声明中的位置，从0开始
                p.getModifiers(); //获取参数修饰符
                p.isNamePresent();  //.class文件中是否保存参数名称, 编译时加上`-parameters`返回true,反之flase
            }

            int i=method.getModifiers();
            boolean isVar=method.isVarArgs();

        }
    }

    private void invokeMethod(){
        Class<?> c = this.getClass();
        try {
            //构造Cat实例
            Constructor constructor = c.getConstructor(String.class, Integer.class);
            Object cat = constructor.newInstance( "Jack", 3);
            //调用无参方法
            Method sleep = c.getDeclaredMethod("sleep");
            sleep.invoke(cat);
            //调用定项参数方法
            Method eat = c.getDeclaredMethod("eat", String.class);
            eat.invoke(cat, "grass");
            //调用不定项参数方法
            //不定项参数可以当成数组来处理
            Class[] argTypes = new Class[] { String[].class };
            Method varargsEat = c.getDeclaredMethod("eat", argTypes);
            String[] foods = new String[]{
                    "grass", "meat"
            };
            varargsEat.invoke(cat, (Object)foods);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BasicPrintMember member=new BasicPrintMember();
        member.invokeMethod();
    }
}
