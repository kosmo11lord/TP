package org.example;

@Table(Title = "Hare")
class Hare {
    @Column
    String name;
    @Column
    int dangerLvl;
    @Column
    Color color;

    public Hare(String name, int dangerLvl, Color color) {
        this.name = name;
        this.dangerLvl = dangerLvl;
        this.color = color;
    }
}
