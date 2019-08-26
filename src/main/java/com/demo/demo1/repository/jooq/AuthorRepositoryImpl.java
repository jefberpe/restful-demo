package com.demo.demo1.repository.jooq;

import com.demo.demo1.model.jooq.tables.AuthorBook;
import com.demo.demo1.model.jooq.tables.pojos.Author;
import com.demo.demo1.repository.AuthorRepository;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.demo.demo1.model.jooq.tables.Author.AUTHOR;
import static com.demo.demo1.model.jooq.tables.AuthorBook.AUTHOR_BOOK;
import static org.jooq.impl.DSL.select;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private DSLContext jooq;

    @Override
    public Author findOne(UUID id) {
        return jooq.select(getAuthorFields())
                .from(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .and(AUTHOR.IS_DELETED.eq(false))
                .fetchOneInto(Author.class);
    }

    @Override
    public List<Author> findAll() {
        return jooq.select(getAuthorFields())
                .from(AUTHOR)
                .where(AUTHOR.IS_DELETED.eq(false))
                .fetchInto(Author.class);
    }

    @Override
    public Author save(Author author) {
        return (author.getId() == null) ? insertAuthor(author) : updateAuthor(author);
    }

    @Override
    public void delete(Author author) {
        jooq.delete(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.AUTHOR_ID.eq(author.getId()))
                .execute();
        jooq.delete(AUTHOR)
                .where(AUTHOR.ID.eq(author.getId()))
                .execute();
    }

    @Override
    public boolean exists(UUID id) {
        return jooq.fetchExists(
                select()
                        .from(AUTHOR)
                        .where(AUTHOR.ID.eq(id))
        );
    }

    @Override
    public List<Author> findByBook(UUID bookId) {
        return jooq.select(getAuthorFields())
                .from(AUTHOR)
                .join(AUTHOR_BOOK).on(AUTHOR_BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                .where(AUTHOR_BOOK.BOOK_ID.eq(bookId))
                .and(AUTHOR.IS_DELETED.eq(false))
                .fetchInto(Author.class);
    }

    @Override
    public AuthorBook addBook(UUID authorId, UUID bookId) {
        return jooq.insertInto(AUTHOR_BOOK)
                .set(AUTHOR_BOOK.AUTHOR_ID, authorId)
                .set(AUTHOR_BOOK.BOOK_ID, bookId)
                .returning()
                .fetchOne()
                .into(AuthorBook.class);
    }

    @Override
    public void deleteBook(UUID authorId, UUID bookId) {
        jooq.delete(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.AUTHOR_ID.eq(authorId))
                .and(AUTHOR_BOOK.BOOK_ID.eq(bookId))
                .execute();
    }

    private Author insertAuthor(Author author) {
        return jooq.insertInto(AUTHOR)
                .set(AUTHOR.ID, UUID.randomUUID())
                .set(AUTHOR.FIRST_NAME, author.getFirstName())
                .set(AUTHOR.LAST_NAME, author.getLastName())
                .set(AUTHOR.BIRTH_DATE, author.getBirthDate())
                .returning()
                .fetchOne()
                .into(Author.class);
    }

    private Author updateAuthor(Author author) {
        return jooq.update(AUTHOR)
                .set(AUTHOR.FIRST_NAME, author.getFirstName())
                .set(AUTHOR.LAST_NAME, author.getLastName())
                .set(AUTHOR.BIRTH_DATE, author.getBirthDate())
                .where(AUTHOR.ID.eq(author.getId()))
                .returning()
                .fetchOne()
                .into(Author.class);
    }

    private List<Field<?>> getAuthorFields() {
        List<Field<?>> fields = new ArrayList<>();
        fields.add(AUTHOR.ID);
        fields.add(AUTHOR.FIRST_NAME);
        fields.add(AUTHOR.LAST_NAME);
        fields.add(AUTHOR.BIRTH_DATE);
        return fields;
    }

}
