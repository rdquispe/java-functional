package functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Function.class);

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        LOGGER.info("increment: {}", increment);

        int increment2 = incrementByOneFunction.apply(1);
        LOGGER.info("increment2: {}", increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        LOGGER.info("multiply: {}", multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
            incrementByOneFunction.andThen(multiplyBy10Function);
        LOGGER.info("addBy1AndThenMultiplyBy10: {}", addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 argument and produces 1 result
        LOGGER.info("incrementByOneAndMultiply: {}", incrementByOneAndMultiply(4, 100));

        LOGGER.info("incrementByOneAndMultiplyBiFunction: {}", incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
        (numberToIncrementByOne, numberToMultiplyBy)
            -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
