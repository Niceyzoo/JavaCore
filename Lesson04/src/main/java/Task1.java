import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList(
                "Бигль","Боксер","Бигль","Долматин","Волкодав",
                "Корги","Бигль","Муди","Мастиф","Бигль","Шарпей",
                "Папильон","Корги","Уиппет","Чихуахуа","Корги","Чау-чау",
                "Мастиф"
        ));

        Set<String> dogs = new HashSet<String>(words);

        System.out.println(dogs.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        for(String key : dogs) //String key = dogs[i];
        {
            System.out.println(key+":"+Collections.frequency(words,key));
        }




    }

}
