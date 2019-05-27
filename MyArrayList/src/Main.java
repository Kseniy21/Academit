import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arList = new ArrayList<>(6);
        arList.add("a");
        arList.add("bb");
        arList.add("ccc");
        arList.add("dddd");
        arList.add("eee");
        arList.add("ff");
        arList.add("g");
        System.out.println("Список строк: " + arList.toString());
        System.out.println("Размер списка = " + arList.size());

        ArrayList<Integer> arList2 = new ArrayList<>();
        arList2.add(1);
        arList2.add(22);
        arList2.add(333);
        arList2.add(4444);
        arList2.add(55555);
        arList2.add(6666);
        arList2.add(777);
        arList2.add(null);
        System.out.println("Список чисел: " + arList2.toString());
        System.out.println("Размер списка = " + arList2.size());

        arList.remove(5);
        System.out.println("Список строк после удаления: " + arList.toString());
        arList2.remove(arList2.get(5));
        System.out.println("Список чисел после удаления: " + arList2.toString());

        arList.add(5, "ff");
        System.out.println("Список строк после добавления: " + arList.toString());
        arList2.add(5, 6666);
        System.out.println("Список чисел после добавления: " + arList2.toString());

        System.out.println("Список строк пуст: " + arList.isEmpty());
        System.out.println("Сожержит ли список строк элемент '1' " + arList.contains("1"));
        System.out.println("Сожержит ли список числе элемент '6666' " + arList2.contains(6666));
        System.out.println("Сожержит ли список 1 в себе список 2: " + arList.containsAll(arList2));

        arList2.set(6, 888);
        System.out.println("Список чисел после замены: " + arList2.toString());

        System.out.println("Индекс элемента 'ссс' в списке строк: " + arList.indexOf("ccc"));

        ArrayList<Integer> arList2test = new ArrayList<>();
        arList2test.add(1);
        arList2test.add(22);
        arList2test.add(333);
        arList2test.add(4444);
        arList2test.add(55555);
        arList2test.add(6666);
        arList2.removeAll(arList2test);
        System.out.println("Список чисел после удаления элементов списка test: " + arList2.toString());

        arList2test.clear();
        System.out.println("Список чисел после очистки: " + arList2test.toString());

        System.out.println("Список строк, распечатанный при помощи итератора: ");
        for (String element : arList) {
            System.out.println(element);

        }
    }
}
