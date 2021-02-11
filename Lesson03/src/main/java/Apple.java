import java.util.Random;

public class Apple extends Fruit {
    @Override
    float getWeight() {
       /* Random rnd = new Random();
        int z;
        z = rnd.nextInt(10);*/
        return 1.5f;
    }
}
