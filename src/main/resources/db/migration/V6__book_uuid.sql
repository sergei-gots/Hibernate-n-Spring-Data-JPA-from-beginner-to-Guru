-- Lesson 56. Binary UUID id for book
DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id BINARY(16) NOT NULL,
    isbn VARCHAR(255),
    publisher VARCHAR(255),
    title VARCHAR(255),
    author_id VARCHAR(36),
    PRIMARY KEY (id)
) engine = InnoDB;