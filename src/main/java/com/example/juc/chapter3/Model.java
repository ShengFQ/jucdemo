package com.example.juc.chapter3;

public interface Model {
  Runnable newRunnableConsumer();
  Runnable newRunnableProducer();
}