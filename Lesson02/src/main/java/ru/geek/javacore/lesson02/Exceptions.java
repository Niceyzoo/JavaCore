package ru.geek.javacore.lesson02;

public class Exceptions {
    int sum = 0;

    public static void main(String[] args) {
        Exceptions main = new Exceptions();
        String[][] good = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] err1 = {{"1", "1", "1", "2"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] err2 = {{"1", "1", "1", "3"}, {"1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] err3 = {{"1", "a", "1", "4"}, {"1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        try {
            main.stringExceptionTest(good);
            //main.stringExceptionTest(err1);
            //main.stringExceptionTest(err2);
            main.stringExceptionTest(err3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void stringExceptionTest(String[][] arr) throws MyArraySizeException {

        if (arr.length != 4) throw new MyArraySizeException("Должно быть 4 строки!");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length != 4) throw new MyArraySizeException("Должно быть 4 столбца!");

            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].matches("[a-zA-Z]+"))
                    throw new NumberFormatException("в ячейке [" + i + "],[" + j + "] не число!");
                sum = sum + Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println(sum);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }


   class NumberFormatException extends Exception {
        public NumberFormatException() {
        }
    }
}
