-- Lesson 55. author.id as UUID VARCHAR(36(
DROP TABLE IF EXISTS author;

CREATE TABLE author (
    id VARCHAR (36) NOT NULL,
    first_name VARCHAR (255),
    last_name VARCHAR (255),
    PRIMARY KEY (id)
) engine = InnoDB;