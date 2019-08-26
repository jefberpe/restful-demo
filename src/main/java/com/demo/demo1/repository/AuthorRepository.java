package com.demo.demo1.repository;

import com.demo.demo1.model.jooq.tables.AuthorBook;
import com.demo.demo1.model.jooq.tables.pojos.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author> {

    List<Author> findByBook(UUID bookId);

    AuthorBook addBook(UUID authorId, UUID bookId);

    void deleteBook(UUID authorId, UUID bookId);

}
