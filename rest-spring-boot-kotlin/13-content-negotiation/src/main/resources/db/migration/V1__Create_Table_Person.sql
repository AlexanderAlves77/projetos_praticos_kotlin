CREATE TABLE person(
	id INT(11) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(80) NULL,
    last_name VARCHAR(80) NOT NULL,
    address VARCHAR(100) NOT NULL,
    gender VARCHAR(6) NOT NULL,
    PRIMARY KEY (id)
);
