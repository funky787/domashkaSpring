package org.sadovodBase.repository;

import org.sadovodBase.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("dev")
public class InMemoryBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<Book> findAll() { return new ArrayList<>(books); }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idGenerator.incrementAndGet());
            books.add(book);
        } else {
            deleteById(book.getId());
            books.add(book);
        }
        return book;
    }

    @Override
    public void deleteById(Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }
}