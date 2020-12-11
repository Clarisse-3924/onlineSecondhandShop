CREATE DATABASE online;
\c online

CREATE TABLE IF NOT EXISTS users  (user_id SERIAL PRIMARY KEY, name VARCHAR,location VARCHAR,phone_number VARCHAR);
CREATE TABLE IF NOT EXISTS admin  (id SERIAL PRIMARY KEY, username VARCHAR,password VARCHAR);
CREATE TABLE IF NOT EXISTS clothes (c_id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR,price int,image BYTEA);
CREATE TABLE IF NOT EXISTS phones (p_id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR,price int,image BYTEA);
CREATE TABLE IF NOT EXISTS ordering (id SERIAL PRIMARY KEY, location VARCHAR,user_id int);

CREATE DATABASE online_test WITH TEMPLATE online;

