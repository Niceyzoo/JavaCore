package ru.geek.javacore.lesson1;

public class Wall extends obstruction {
    private int heigth;

    public Wall(String name, int heigth) {
        super(name);
        this.heigth=heigth;
    }

    public int getHeigth(){
        return heigth;
    }


    @Override
    protected boolean moving(Actions actions) {   //функция с параметром

        System.out.println(super.getName()+" высота: "+this.heigth);

        actions.jump();

        if(getHeigth()<= actions.getJumpHeight()) //если высота стены <= высоты прыжка участника, то...
        {
            System.out.println("прыжок удачный");

            return  true;
        }   else
        {
            System.out.println("прыжок не удался");
            return false;
        }


    }
}
