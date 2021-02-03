

package ru.geek.javacore.lesson1;

import java.util.Random;

public class main {

    public static void main(String[] args) {

        Random rand = new Random();

        Actions[] actions = new Actions[3];

        int dist = rand.nextInt(10);
        int heigth = rand.nextInt(10);

        actions[0] = new Cat("Джиро", dist, heigth);

        dist = rand.nextInt(10);
        heigth = rand.nextInt(10);

        actions[1] = new Human("Никита", dist, heigth);
        dist = rand.nextInt(10);
        heigth = rand.nextInt(10);

        actions[2] = new Robot("Бендер", dist, heigth);

        obstruction[] obs = new obstruction[6];

        boolean road; //переменная позволяет рандомить позицию в масиве дорожку и стену

        for (int i = 0; i < obs.length; i++) {
            dist = rand.nextInt(10);

            road = rand.nextBoolean(); // если 1, то дорожка, если 0, то стена

            if(road)
            {
                obs[i]=new Treadmill("Дорожка "+(i+1),dist);  //создаем дорожку
            }
            else
            {
                obs[i]=new Wall("Стена "+(i+1),dist);
            }

        }


        int z=0;

        for(int i=0; i<actions.length;i++)
        {
            boolean result = true;

            System.out.println("Участник "+(i+1)+" "+actions[i].getName());

            for(int j=0; j<obs.length;j++) {

                result = obs[j].moving(actions[i]);

                if (!result){
                    break;
                }
            }

            if(result){
                System.out.println("Прошел всю дистанцию!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            }
            else  {
                System.out.println(actions[i].getName()+" Сошел с дистанции");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                z++;

            }
        }

        if(z==actions.length){
            System.out.println("Никто не прошел дистанцию!");
        }
        if(z==0)
        {
            System.out.println("Все пробежали до конца!");
        }

    }
}