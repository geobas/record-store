CREATE TABLE record (
	id INT AUTO_INCREMENT,
	artist VARCHAR(255),
	record_name VARCHAR(255),
	record_desc VARCHAR(2000),
	genre VARCHAR(255),
	record_condition VARCHAR(255),
	price DOUBLE,
	release_year INT,
    PRIMARY KEY (ID)
);