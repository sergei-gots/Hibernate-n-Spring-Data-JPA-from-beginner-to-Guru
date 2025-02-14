-- LESSON 24
-- Create Users and Schema
-- initial script for SQL Client (e.g. dBeaver)
DROP DATABASE IF EXISTS `bookdb`;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;

CREATE DATABASE IF NOT EXISTS `bookdb` 
	CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS `bookadmin`@`%` 
	IDENTIFIED WITH caching_sha2_password BY 'password';
CREATE USER IF NOT EXISTS `bookuser`@`%`
	IDENTIFIED WITH caching_sha2_password BY 'password';

GRANT 
	SELECT, INSERT, UPDATE, DELETE,
	CREATE, ALTER, DROP,
	REFERENCES, INDEX, EXECUTE,
	CREATE VIEW, SHOW VIEW,
	CREATE ROUTINE, ALTER ROUTINE, 
	EVENT, TRIGGER
	ON `bookdb`.* TO `bookadmin`@`%`;

GRANT
	SELECT, INSERT, UPDATE, DELETE,
	SHOW VIEW 
	ON `bookdb`.* TO `bookuser`@`%`;

FLUSH PRIVILEGES;

#SHOW PLUGINS;
#SHOW VARIABLES LIKE 'plugin_dir';