-- LESSON 48 Add the table 'author' to the database
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS author_seq;

CREATE TABLE author (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE author_seq (
    next_val BIGINT
) engine = InnoDB;

INSERT INTO author_seq values ( 1 );