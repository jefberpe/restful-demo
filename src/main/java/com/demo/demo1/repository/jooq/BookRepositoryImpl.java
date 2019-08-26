package com.demo.demo1.repository.jooq;

import com.demo.demo1.model.jooq.tables.AuthorBook;
import com.demo.demo1.model.jooq.tables.pojos.Book;
import com.demo.demo1.repository.BookRepository;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.demo.demo1.model.jooq.tables.AuthorBook.AUTHOR_BOOK;
import static com.demo.demo1.model.jooq.tables.Book.BOOK;
import static org.jooq.impl.DSL.select;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DSLContext jooq;

    @Override
    public Book findOne(UUID id) {
        return jooq.select(getBookFields())
                .from(BOOK)
                .where(BOOK.ID.eq(id))
                .and(BOOK.IS_DELETED.eq(false))
                .fetchOneInto(Book.class);
    }

    @Override
    public List<Book> findAll() {
        return jooq.select(getBookFields())
                .from(BOOK)
                .where(BOOK.IS_DELETED.eq(false))
                .fetchInto(Book.class);
    }

    @Override
    public Book save(Book book) {
        return (book.getId() == null) ? insertBook(book) : updateBook(book);
    }

    @Override
    public void delete(Book book) {
        jooq.delete(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.BOOK_ID.eq(book.getId()))
                .execute();
        jooq.delete(BOOK)
                .where(BOOK.ID.eq(book.getId()))
                .execute();
    }

    @Override
    public boolean exists(UUID id) {
        return jooq.fetchExists(
                select()
                        .from(BOOK)
                        .where(BOOK.ID.eq(id))
        );
    }

    @Override
    public List<Book> findByAuthor(UUID authorId) {
        return jooq.select(getBookFields())
                .from(BOOK)
                .join(AUTHOR_BOOK).on(AUTHOR_BOOK.BOOK_ID.eq(BOOK.ID))
                .where(AUTHOR_BOOK.AUTHOR_ID.eq(authorId))
                .and(BOOK.IS_DELETED.eq(false))
                .fetchInto(Book.class);
    }

    @Override
    public AuthorBook addAuthor(UUID bookId, UUID authorId) {
        return jooq.insertInto(AUTHOR_BOOK)
                .set(AUTHOR_BOOK.AUTHOR_ID, authorId)
                .set(AUTHOR_BOOK.BOOK_ID, bookId)
                .returning()
                .fetchOne()
                .into(AuthorBook.class);
    }

    @Override
    public void deleteAuthor(UUID bookId, UUID authorId) {
        jooq.delete(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.AUTHOR_ID.eq(authorId))
                .and(AUTHOR_BOOK.BOOK_ID.eq(bookId))
                .execute();
    }

    private Book insertBook(Book book) {
        return jooq.insertInto(BOOK)
                .set(BOOK.ID, UUID.randomUUID())
                .set(BOOK.TITLE, book.getTitle())
                .set(BOOK.DESCRIPTION, book.getDescription())
                .set(BOOK.PUBLISH_DATE, book.getPublishDate())
                .returning()
                .fetchOne()
                .into(Book.class);
    }

    private Book updateBook(Book book) {
        return jooq.update(BOOK)
                .set(BOOK.TITLE, book.getTitle())
                .set(BOOK.DESCRIPTION, book.getDescription())
                .set(BOOK.PUBLISH_DATE, book.getPublishDate())
                .where(BOOK.ID.eq(book.getId()))
                .returning()
                .fetchOne()
                .into(Book.class);
    }

    private List<Field<?>> getBookFields() {
        List<Field<?>> fields = new ArrayList<>();
        fields.add(BOOK.ID);
        fields.add(BOOK.TITLE);
        fields.add(BOOK.DESCRIPTION);
        fields.add(BOOK.PUBLISH_DATE);
        return fields;
    }

}
