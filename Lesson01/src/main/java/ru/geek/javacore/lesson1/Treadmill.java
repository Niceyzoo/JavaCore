package ru.geek.javacore.lesson1;

public class Treadmill extends obstruction{
    private int length;

    public Treadmill(String name, int length) {
        super(name);
        this.length=length;
    }

    public int getLength(){
        return length;
    }


    @Override
    protected boolean moving(Actions actions) {
        System.out.println(super.getName()+" длина: "+this.length);

        actions.run();

        if(getLength()<= actions.getRunDist())
        {
            System.out.println("забег удачный");

            return  true;
        }   else
        {
            System.out.println("забег не удался");
            return false;
        }


    }
}
