-- Lesson 58. Natural Primary Key
DROP TABLE IF EXISTS book_natural;

CREATE TABLE book_natural (
    title VARCHAR(255),
    isbn VARCHAR(255) NOT NULL,
    publisher VARCHAR(255)
) engine = InnoDB;