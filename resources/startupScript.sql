-- Creation of the database 
CREATE DATABASE IF NOT EXISTS contact_db;
use contact_db;

-- Creation of the tables
CREATE TABLE IF NOT EXISTS user (
	id 	INT 
		PRIMARY KEY 
		AUTO_INCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    phone_number VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS contact (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone_number VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS user_contact(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
    contact_id INT NOT NULL,
    
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(contact_id) REFERENCES contact(id)
);

-- Seed the database
-- INSERT INTO user(email, password, phone_number)
-- VALUES ("Albert", "Paez", "albertzeap@gmail.com", "password");

       





