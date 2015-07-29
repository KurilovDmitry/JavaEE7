package ru.merann.dmikur;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by manya on 22.07.2015.
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Mock: " + mock + " was generated");
        return mock;
    }
}
