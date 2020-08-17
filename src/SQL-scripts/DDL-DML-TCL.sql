CREATE DATABASE demos;
--This IS an SQL comment

--DDL (Data Definition Lang) commands

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	real_name VARCHAR (30),
	power_level INTEGER
);

ALTER TABLE avengers ADD COLUMN active BOOLEAN;

TRUNCATE TABLE avengers;

--DML commands (see transactions, it's exactly that, minus BEGIN and COMMIT)

DELETE FROM avengers WHERE real_name = 'Steve Rogers';

--DQL

SELECT real_name FROM avengers;

SELECT * FROM avengers WHERE superhero_name = 'Hawkeye';

--Transactions

BEGIN;
INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Captain America', 'Super Strong Frisbee', 'Steve Rogers', 20),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55)
	
	
UPDATE avengers SET active = FALSE WHERE superhero_name = 'Captain America';
UPDATE avengers SET active = TRUE WHERE superhero_name = 'Hawkeye';
COMMIT;

