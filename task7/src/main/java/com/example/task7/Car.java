package com.example.task7;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable{
    static AtomicInteger atomic = new AtomicInteger(0);
    private static int CARS_COUNT;
    CyclicBarrier cb ;
    static {
        CARS_COUNT=0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed,CyclicBarrier cb) {
        this.race=race;
        this.speed=speed;
        CARS_COUNT++;
        this.name= "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    @Override
    public void run() {
        try{
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random()*800));
            System.out.println(this.name + " готов");
            cb.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0; i<race.getStages().size();i++){
            race.getStages().get(i).go(this);
            if (i == race.getStages().size() - 1 && atomic.get() < 3){
                System.out.println("\t"+atomic.incrementAndGet() + " место " + this.name);
            }
        }
    }
}
