package ru.merann.dmikur;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by manya on 23.07.2015.
 */
@Loggable
public class InventoryService {
    @Inject
    Logger logger;

    List<Book> inventory = new ArrayList<>();

    public void addBook(@Observes @Added Book book) {
        logger.info("Adding book " + book.getTitle() + " to inventory");
        inventory.add(book);
    }

    public void deleteBook(@Observes @Deleted Book book) {
        logger.info("Deleting book " + book.getTitle() + " from inventory");
        inventory.remove(book);
    }
}
