package org.sadovodBase.service;

import org.sadovodBase.model.Book;
import org.sadovodBase.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: id=" + id));
    }

    @Override
    public Book create(Book book) {
        book.setId(null);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {

        getById(id);
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        bookRepository.deleteById(id);
    }
}