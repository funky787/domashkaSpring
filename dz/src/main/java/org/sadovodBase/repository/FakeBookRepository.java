package org.sadovodBase.repository;

import org.sadovodBase.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("prod")
public class FakeBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        return List.of(
                new Book(100L, "Prod Book 1", "Prod Author", 2000),
                new Book(101L, "Prod Book 2", "Prod Author", 2001)
        );
    }

    @Override
    public Optional<Book> findById(Long id) {
        return findAll().stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public Book save(Book book) {
        System.out.println("[prod] Fake save called");
        return book;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("[prod] Fake delete called for id=" + id);
    }
}