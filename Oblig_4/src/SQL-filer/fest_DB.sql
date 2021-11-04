DROP SCHEMA IF EXISTS fest_oblig4 CASCADE;
CREATE SCHEMA fest_oblig4;
SET search_path = fest_oblig4;

CREATE TYPE ENUM_KJONN AS ENUM ('mann', 'kvinne');
CREATE CAST (varchar AS ENUM_KJONN) WITH INOUT AS IMPLICIT;
CREATE TABLE deltager 
(
	mobil				INTEGER,
	fornavn 			VARCHAR(20),
	etternavn 			VARCHAR(20),
	kjonn				ENUM_KJONN,
	pass_hash 			VARCHAR(64),
	pass_salt			VARCHAR(32),
	
   	PRIMARY KEY (mobil)
);