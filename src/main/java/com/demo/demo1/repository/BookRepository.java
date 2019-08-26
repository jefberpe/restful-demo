package com.demo.demo1.repository;

import com.demo.demo1.model.jooq.tables.AuthorBook;
import com.demo.demo1.model.jooq.tables.pojos.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book> {

    List<Book> findByAuthor(UUID authorId);

    AuthorBook addAuthor(UUID bookId, UUID authorId);

    void deleteAuthor(UUID bookId, UUID authorId);

}
