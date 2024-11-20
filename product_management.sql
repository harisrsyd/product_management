CREATE DATABASE product_management;

CREATE TABLE products
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category VARCHAR(100) NOT NULL
);

ALTER TABLE products ADD COLUMN description TEXT;