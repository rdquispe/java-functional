package functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    private static final Logger LOGGER = LoggerFactory.getLogger(_Supplier.class);

    public static void main(String[] args) {
        LOGGER.info(getDBConnectionUrl());
        LOGGER.info(getDBConnectionUrlsSupplier.get().toString());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<List<String>> getDBConnectionUrlsSupplier = () ->
        List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
}
