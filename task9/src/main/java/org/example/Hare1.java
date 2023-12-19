package org.example;

import java.sql.Date;

@Table(Title = "Hare1")
class Hare1 {
    @Column
    String name;
    //    @Column
    int dangerLvl;
    @Column
    Color color;
    @Column
    Date date;


    public Hare1(String name, int dangerLvl, Color color, Date date) {
        this.name = name;
        this.dangerLvl = dangerLvl;
        this.color = color;
        this.date = date;
    }
}
