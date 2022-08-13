import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class _Callbacks {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Callbacks.class);

    public static void main(String[] args) {
        hello("John", null, value -> {
            LOGGER.info("no lastName provided for " + value);
        });

        hello2("John",
            null,
            () -> LOGGER.info("no lastName provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        LOGGER.info(firstName);
        if (lastName != null) {
            LOGGER.info(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        LOGGER.info(firstName);
        if (lastName != null) {
            LOGGER.info(lastName);
        } else {
            callback.run();
        }
    }

//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }
//    }
}
