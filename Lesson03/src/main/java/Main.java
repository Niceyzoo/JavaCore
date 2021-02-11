import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        swap(arr,0,9);


        Box<Orange> o = new Box<>();
        Box<Orange> o1 = new Box<>();
        Box<Apple> a = new Box<>();
        o.addFruit(new Orange(), 3);
        a.addFruit(new Apple(), 5);
        o1.addFruit(new Orange(), 2);

        System.out.println("Коробка 1: " + o.getWeight());
        System.out.println("Коробка 2: " + a.getWeight());
        System.out.println("Коробка 3: " + o1.getWeight());

        System.out.println("Коробка 1 равна Коробке 2? " + o.compare(a));

        o.transFruit(o1);

        System.out.println("Коробка 1: " + o.getWeight());
        System.out.println("Коробка 2: " + a.getWeight());
        System.out.println("Коробка 3: " + o1.getWeight());

    }

    public static void swap(Object[] arr, int n1, int n2) {
        System.out.println(Arrays.toString(arr));
        Object s = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = s;
        System.out.println(Arrays.toString(arr)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }


}
