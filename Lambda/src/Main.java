
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> peoples = new LinkedList<>();
        peoples.add(new Person("Петр", 20));
        peoples.add(new Person("Иван", 25));
        peoples.add(new Person("Федор", 30));
        peoples.add(new Person("Василий", 15));
        peoples.add(new Person("Кристина", 31));
        peoples.add(new Person("Кристина", 45));
        peoples.add(new Person("Юлия", 17));
        peoples.add(new Person("Кристина", 28));
        peoples.add(new Person("Евгений", 29));
        peoples.add(new Person("Андрей", 24));

        String uniqueNamesPerson = peoples.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println("Список уникальных имен:" + uniqueNamesPerson);

        String peoplesUnder18 = peoples.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Список людей, которым нет 18:" + peoplesUnder18);


        OptionalDouble averageAgePeoples = peoples.stream()
                .mapToDouble(Person::getAge)
                .filter(agePerson -> agePerson < 18)
                .average();
        if (averageAgePeoples.isPresent()) {
            System.out.println("Средний возраст людей младше 18 лет составляет = " + averageAgePeoples.getAsDouble());
        } else {
            System.out.println("Людей с возрастом < 18 в списке нет!");
        }

        Map<String, Double> peoplesMap = peoples.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println("Группировка списка с ключом имени человека: " + peoplesMap.toString());

        String peoplesList = peoples.stream()
                .filter(person -> person.getAge() <= 45 && person.getAge() >= 20)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.joining(","));
        System.out.println("Список людей в возрасте от 20 до 45 с сортировкой по убываю возраста: " + peoplesList);
    }
}
