
CREATE OR REPLACE FUNCTION _update_updated_at()
RETURNS TRIGGER AS $$
  BEGIN
    NEW.updated_at = current_timestamp;
    RETURN NEW;
  END;
$$ language 'plpgsql';


CREATE TABLE book
(
    id                  UUID        PRIMARY KEY,
    title               TEXT        NOT NULL,
    description         TEXT        NULL,
    publish_date        TIMESTAMP   NOT NULL,
    is_deleted          BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at          TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    updated_at          TIMESTAMP   NOT NULL DEFAULT current_timestamp
);
CREATE TRIGGER book_updated_at_trigger
    BEFORE UPDATE
    ON book
    FOR EACH ROW EXECUTE PROCEDURE _update_updated_at();


CREATE TABLE author
(
    id                  UUID        PRIMARY KEY,
    first_name          VARCHAR(50) NOT NULL,
    last_name           VARCHAR(50) NOT NULL,
    birth_date          TIMESTAMP   NOT NULL,
    is_deleted          BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at          TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    updated_at          TIMESTAMP   NOT NULL DEFAULT current_timestamp
);
CREATE TRIGGER author_updated_at_trigger
    BEFORE UPDATE
    ON author
    FOR EACH ROW EXECUTE PROCEDURE _update_updated_at();


CREATE TABLE author_book
(
    author_id           UUID        NOT NULL REFERENCES author(id),
    book_id             UUID        NOT NULL REFERENCES book(id),
    PRIMARY KEY (author_id, book_id)
);




