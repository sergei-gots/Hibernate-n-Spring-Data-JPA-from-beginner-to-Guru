-- LESSON 35 Schema Initialization with Hibernate

DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_seq;

CREATE TABLE book (
    id BIGINT NOT NULL AUTO_INCREMENT,
    isbn VARCHAR(255),
    publisher VARCHAR(255),
    title VARCHAR(255),
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE book_seq (
    next_val BIGINT
) engine = InnoDB;

INSERT INTO book_seq values ( 1 );