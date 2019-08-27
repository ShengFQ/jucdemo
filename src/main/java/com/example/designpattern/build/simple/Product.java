package com.example.designpattern.build.simple;

/**
 * 一个简单的build构建器
 *
 * @author fuqiang.sheng
 * @date 2019年08月23日 下午7:10
 */
public class Product {
    /**
     * 产品的构造需要原料,产线加工,工序组装
     * */
    private Integer age;
    private String name;
    private String size;
    private String goods;

    private Material material;
    private ProductLine productLine;
    private Process process;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Product{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", goods='" + goods + '\'' +
                '}';
    }
//可以通过构造函数来构建一个对象,略

}
