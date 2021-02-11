import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public Box() {

    }

    public float getWeight() { // метод получения веса коробки
        float weight = 0;

        for (T w : box) { // T w = box[i]
            weight += w.getWeight();
        }
        return weight;
    }

    public boolean compare(Box b) {
        if (getWeight() == b.getWeight())
            return true;
        return false;
    }

    public void addFruit(T f, int count) {
        for (int i = 0; i < count; i++)
            box.add(f);
    }

    public void transFruit(Box<T> b) {
        b.box.addAll(box);
        box.clear();
    }

}


