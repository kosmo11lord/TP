package com.example.task7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel extends Stage{
    Semaphore smp = new Semaphore(2);
    public Tunnel(){
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try{
            try{
                System.out.println(c.getName() + " готовится к этапу(ждёт): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println(c.getName()+ " закончли этап: " + description);
                smp.release();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
