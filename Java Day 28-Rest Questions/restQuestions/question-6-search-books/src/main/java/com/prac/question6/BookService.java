package com.prac.question6;

import org.springframework.stereotype.Service;
import com.prac.question6.BookRepository;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> search(String title, String author) {
        // TODO: validate title, call the repository, and throw the correct exceptions
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (author != null && author.isBlank()) {
            throw new IllegalArgumentException("author must not be blank");
        }
        List<Book> books = bookRepository.findByTitleAndAuthor(title, author);
        if(books.isEmpty()) {
            throw new BookNotFoundException("No books found");
        }
        return books;
    }
}
