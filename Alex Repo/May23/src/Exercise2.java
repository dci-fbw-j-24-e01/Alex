import java.util.List;
import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Inda", 29));
        people.add(new Person("Sunanda", 35));
        people.add(new Person("Oleg", 15));
        people.add(new Person("Vitalii", 30));
        people.add(new Person("Desi", 16));
        people.add(new Person("Lana", 8));
        people.add(new Person("Alex", 36));

        people.stream()
                .filter(o1 -> o1.getAge() < 18)
                .map(Person::getName)
                .toList()
                .forEach(System.out::println);
    }
}
