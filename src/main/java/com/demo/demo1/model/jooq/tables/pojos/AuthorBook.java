/*
 * This file is generated by jOOQ.
 */
package com.demo.demo1.model.jooq.tables.pojos;


import java.io.Serializable;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorBook implements Serializable {

    private static final long serialVersionUID = -1482895365;

    private UUID authorId;
    private UUID bookId;

    public AuthorBook() {}

    public AuthorBook(AuthorBook value) {
        this.authorId = value.authorId;
        this.bookId = value.bookId;
    }

    public AuthorBook(
        UUID authorId,
        UUID bookId
    ) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public UUID getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getBookId() {
        return this.bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorBook (");

        sb.append(authorId);
        sb.append(", ").append(bookId);

        sb.append(")");
        return sb.toString();
    }
}
