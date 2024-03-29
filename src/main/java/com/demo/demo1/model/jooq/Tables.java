/*
 * This file is generated by jOOQ.
 */
package com.demo.demo1.model.jooq;


import com.demo.demo1.model.jooq.tables.Author;
import com.demo.demo1.model.jooq.tables.AuthorBook;
import com.demo.demo1.model.jooq.tables.Book;
import com.demo.demo1.model.jooq.tables.FlywaySchemaHistory;


/**
 * Convenience access to all tables in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.author</code>.
     */
    public static final Author AUTHOR = com.demo.demo1.model.jooq.tables.Author.AUTHOR;

    /**
     * The table <code>public.author_book</code>.
     */
    public static final AuthorBook AUTHOR_BOOK = com.demo.demo1.model.jooq.tables.AuthorBook.AUTHOR_BOOK;

    /**
     * The table <code>public.book</code>.
     */
    public static final Book BOOK = com.demo.demo1.model.jooq.tables.Book.BOOK;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.demo.demo1.model.jooq.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;
}
