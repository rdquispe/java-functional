import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class _Stream {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Stream.class);

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE),
            new Person("Bob", Gender.PREFER_NOT_TO_SAY)
        );

        people.stream()
            .map(person -> person.name)
            .mapToInt(String::length)
            .forEach(item -> LOGGER.info(String.valueOf(item)));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
