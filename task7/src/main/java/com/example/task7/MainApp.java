package com.example.task7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainApp {
    public static final int CARS_COUNT = 5;
    public int pos = 0;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Thread[] threads = new Thread[CARS_COUNT];
        var cb = new CyclicBarrier(CARS_COUNT+1);

        for (int i = 0; i < cars.length;i++){
            cars[i]= new Car(race,20 + (int)(Math.random()*50),cb);
        }
        for (int i = 0; i<cars.length; i++) {
            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }
        cb.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try
        {
            for (int i = 0; i<cars.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
