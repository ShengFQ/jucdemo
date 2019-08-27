package com.example.designpattern.build.simple;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月23日 下午7:38
 */
public class ProductBuilder extends Builder {
    private Product product=new Product();

    @Override
    public void material(Material material) {
        product.setMaterial(material);
    }

    @Override
    public void process(Process process) {
        product.setProcess(process);
    }

    @Override
    public void productLine(ProductLine productLine) {
        product.setProductLine(productLine);
    }

    @Override
    public Product build() {
        return product;
    }
}
