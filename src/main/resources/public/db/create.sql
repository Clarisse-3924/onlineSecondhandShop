CREATE DATABASE online;
\c online;

--CREATE TABLE sightings (id SERIAL PRIMARY KEY, name VARCHAR);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker_test;

CREATE TABLE users (user_id SERIAL PRIMARY KEY, name VARCHAR,phone_number VARCHAR);
CREATE TABLE clothes (c_id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR,price int,image BYTEA);
CREATE TABLE phones (p_id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR,price int,image BYTEA);
CREATE TABLE ordering (id SERIAL PRIMARY KEY, location VARCHAR,user_id int);

CREATE DATABASE online_test WITH TEMPLATE online;