import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class _Optional {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Optional.class);
    public static void main(String[] args) {
        Optional.ofNullable(null)
            .ifPresentOrElse(
                email -> LOGGER.info("Sending email to " + email),
                () -> LOGGER.info("Cannot send email")
            );
    }
}
