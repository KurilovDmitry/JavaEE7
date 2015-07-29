package ru.merann.dmikur;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by manya on 22.07.2015.
 */
@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("ISSN: " + issn + " was generated");
        return issn;
    }
}
