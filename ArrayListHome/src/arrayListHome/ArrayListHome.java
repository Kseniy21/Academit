package arrayListHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> arrList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("list.txt"))) {
            while (scanner.hasNextLine()) {
                arrList.add(scanner.nextInt());
            }
            System.out.println(arrList);
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println("Лист чисел: " + numbersList);
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }
        System.out.println("Лист посел удаления четных чисел" + numbersList);

        ArrayList<Integer> newNumbersList = new ArrayList<>();
        for (Integer element : numbersList) {
            if (!newNumbersList.contains(element)) {
                newNumbersList.add(element);
            }
        }
        System.out.println("Лист без повторений чисел" + newNumbersList);
    }
}