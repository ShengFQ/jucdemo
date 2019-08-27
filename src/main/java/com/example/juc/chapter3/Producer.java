package com.example.juc.chapter3;

public interface Producer {
  void produce() throws InterruptedException;
}