package com.example.designpattern.factory.factorymethod;

class FactoryB implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductB();
    }
}