package ru.merann.dmikur;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий");
        System.out.println("Book: " + book);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Description: " + book.getDescription());
        System.out.println("Number: " + book.getNumber());

        bookService.deleteBook(book);
        weld.shutdown();
    }
}
