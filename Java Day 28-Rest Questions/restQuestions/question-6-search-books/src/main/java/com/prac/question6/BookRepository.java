package com.prac.question6;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public List<Book> findByTitleAndAuthor(String title, String author) {
        // TODO: filter BookData.books() by title prefix and optional author prefix
        return  BookData.books().stream()
                .filter(book -> book.title().toLowerCase().startsWith(title.toLowerCase()))
                .filter(book -> author == null || book.author().toLowerCase().startsWith(author.toLowerCase()))
                .toList();
    }
}
