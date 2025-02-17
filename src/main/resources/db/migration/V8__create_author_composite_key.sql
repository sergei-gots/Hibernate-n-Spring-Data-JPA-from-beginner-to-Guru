-- Lesson 59. Composite Primary Key
DROP TABLE IF EXISTS author_composite_key;

CREATE TABLE author_composite_key (
    first_name VARCHAR (255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    country VARCHAR(63),
    PRIMARY KEY (first_name, last_name)
) engine = InnoDB;