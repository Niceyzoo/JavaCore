import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, List<String>> book; //Название ключа, массив с номерами, название HashMap

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String number) {
        if (book.containsKey(name)) { //Ключ это имя
            List<String> numbers = book.get(name); // создаем массив с номерамми, который получает данные по ключу
            if (!numbers.contains(number)) { //если нет совападения по номеру, то добавляем
                numbers.add(number);

            } else {
            }
        } else { //если в массиве нет имени, то создаем его в массиве
            book.put(name, new ArrayList<>(Arrays.asList(number)));
        }
    }

    public List<String> get(String name) { //поулчить данные по имени
        if(book.containsKey(name)){
            return book.get(name);
        }else
        {
            return new ArrayList<>();
        }
    }

}
