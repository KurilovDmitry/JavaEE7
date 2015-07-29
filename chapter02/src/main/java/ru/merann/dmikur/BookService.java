package ru.merann.dmikur;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by manya on 22.07.2015.
 */
@Loggable
public class BookService {
    @Inject @Added
    private Event<Book> bookAddedEvent;

    @Inject @Deleted
    private Event<Book> bookDeletedEvent;

    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        bookAddedEvent.fire(book);
        return book;
    }

    public void deleteBook(Book book) {
        bookDeletedEvent.fire(book);
    }
}
