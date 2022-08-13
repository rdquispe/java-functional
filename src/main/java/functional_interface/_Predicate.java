package functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class _Predicate {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Function.class);

    public static void main(String[] args) {
        LOGGER.info("Without predicate");
        LOGGER.info("isPhoneNumberValid: {}", isPhoneNumberValid("07000000000"));
        LOGGER.info("isPhoneNumberValid: {}", isPhoneNumberValid("0700000000"));
        LOGGER.info("isPhoneNumberValid: {}", isPhoneNumberValid("09009877300"));

        LOGGER.info("With predicate");
        LOGGER.info("isPhoneNumberValidPredicate: {}", isPhoneNumberValidPredicate.test("07000000000"));
        LOGGER.info("isPhoneNumberValidPredicate: {}", isPhoneNumberValidPredicate.test("0700000000"));
        LOGGER.info("isPhoneNumberValidPredicate: {}", isPhoneNumberValidPredicate.test("09009877300"));

        LOGGER.info(
            "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );

        LOGGER.info(
            "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
        phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
