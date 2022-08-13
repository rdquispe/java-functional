package imperative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative._Imperative.Gender.FEMALE;
import static imperative._Imperative.Gender.MALE;

public class _Imperative {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Imperative.class);

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        LOGGER.info("// Imperative approach");
        // Imperative approach

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            LOGGER.info(female.toString());
        }

        LOGGER.info("// Declarative approach");
        // Declarative approach

        Predicate<Person> personPredicate = person -> MALE.equals(person.gender);

        List<Person> females2 = people.stream()
            .filter(personPredicate)
            .collect(Collectors.toList());
        females2.forEach(item -> LOGGER.info(item.toString()));
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
        MALE, FEMALE
    }
}
