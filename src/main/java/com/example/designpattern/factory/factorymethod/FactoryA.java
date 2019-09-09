package com.example.designpattern.factory.factorymethod;

class FactoryA implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductA();
    }
}