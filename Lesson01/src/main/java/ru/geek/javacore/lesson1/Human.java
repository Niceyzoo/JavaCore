package ru.geek.javacore.lesson1;

public class Human  implements Actions{

    private String Name;
    private int Max_length;
    private int Max_heigth;

    public Human(String name, int max_length, int max_heigth) {

        this.Name=name;
        this.Max_length=max_length;
        this.Max_heigth=max_heigth;
    }

    @Override
    public void run() {
        System.out.println("Человек "+this.Name+" пробежал: "+this.getRunDist());
    }

    @Override
    public void jump() {
        System.out.println("Человек "+this.Name+" прыгнул: "+this.getJumpHeight());
    }

    @Override
    public int getRunDist() {
        return this.Max_length;
    }

    @Override
    public int getJumpHeight() {
        return this.Max_heigth;
    }

    @Override
    public String getName() {
        return this.Name;
    }
}
