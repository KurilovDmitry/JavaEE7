package ru.merann.dmikur;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by manya on 22.07.2015.
 */
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("ISBN: " + isbn + " was generated");
        return isbn;
    }
}
