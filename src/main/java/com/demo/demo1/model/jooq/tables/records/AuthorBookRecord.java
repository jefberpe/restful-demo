/*
 * This file is generated by jOOQ.
 */
package com.demo.demo1.model.jooq.tables.records;


import com.demo.demo1.model.jooq.tables.AuthorBook;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorBookRecord extends UpdatableRecordImpl<AuthorBookRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = -2057687086;

    /**
     * Setter for <code>public.author_book.author_id</code>.
     */
    public void setAuthorId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.author_book.author_id</code>.
     */
    public UUID getAuthorId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.author_book.book_id</code>.
     */
    public void setBookId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.author_book.book_id</code>.
     */
    public UUID getBookId() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UUID, UUID> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UUID> field1() {
        return AuthorBook.AUTHOR_BOOK.AUTHOR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UUID> field2() {
        return AuthorBook.AUTHOR_BOOK.BOOK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID component1() {
        return getAuthorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID component2() {
        return getBookId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID value1() {
        return getAuthorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID value2() {
        return getBookId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorBookRecord value1(UUID value) {
        setAuthorId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorBookRecord value2(UUID value) {
        setBookId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorBookRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthorBookRecord
     */
    public AuthorBookRecord() {
        super(AuthorBook.AUTHOR_BOOK);
    }

    /**
     * Create a detached, initialised AuthorBookRecord
     */
    public AuthorBookRecord(UUID authorId, UUID bookId) {
        super(AuthorBook.AUTHOR_BOOK);

        set(0, authorId);
        set(1, bookId);
    }
}