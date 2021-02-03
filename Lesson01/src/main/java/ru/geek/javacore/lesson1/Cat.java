package ru.geek.javacore.lesson1;



public class Cat implements Actions {
    private String Name;
    private int Max_length;
    private int Max_heigth;

   public Cat(String name, int max_length, int max_heigth) {

       this.Name=name;
       this.Max_length=max_length;
       this.Max_heigth=max_heigth;
   }


    @Override
    public void run() {
        System.out.println("Кот "+this.Name+" пробежал: "+this.getRunDist());
    }

    @Override
    public void jump() {
        System.out.println("Кот "+this.Name+" прыгнул: "+this.getJumpHeight());
    }

    @Override
    public int getRunDist() {               //позволяет обратиться к методу в классе main
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
