package com.ejer8.seguridad.service;

import com.ejer8.seguridad.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idCounter.getAndIncrement());
        }
        books.put(book.getId(), book);
        return book;
    }

    public void delete(Long id) {
        books.remove(id);
    }
}
