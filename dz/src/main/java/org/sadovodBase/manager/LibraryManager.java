package org.sadovodBase.manager;

import org.sadovodBase.model.Book;
import org.sadovodBase.service.BookService;
import org.sadovodBase.service.CounterService;
import org.springframework.stereotype.Component;

@Component
public class LibraryManager {

    private final BookService bookService;
    private final CounterService counterService;

    public LibraryManager(BookService bookService, CounterService counterService) {
        this.bookService = bookService;
        this.counterService = counterService;
    }

    public void seedThreeBooks() {
        bookService.create(new Book(null, "1984", "George Orwell", 1949));
        bookService.create(new Book(null, "Dune", "Frank Herbert", 1965));
        bookService.create(new Book(null, "The Hobbit", "J.R.R. Tolkien", 1937));
    }

    public void printAll() {
        bookService.getAll().forEach(System.out::println);
    }

    public void showCounterFromManager() {
        System.out.println("LibraryManager counter: " + counterService.increment());
    }
}