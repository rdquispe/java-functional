import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class _Lambdas {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Lambdas.class);

    public static void main(String[] args) {

        Integer number = null;
        int couter = 0;

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            int counter = 0;
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            LOGGER.info("age: {}", age);
            return name.toUpperCase();
        };

        LOGGER.info(upperCaseName.apply("Alex", null));

    }
}
