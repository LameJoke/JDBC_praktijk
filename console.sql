CREATE DATABASE JDBCPraktijk_db;

CREATE TABLE customer(
    customer_id         INTEGER PRIMARY KEY  AUTO_INCREMENT,
    firstName           VARCHAR(255),
    lastName            VARCHAR(255),
    email               VARCHAR(255),
    phone               VARCHAR(20),
    address             VARCHAR(255),
    city                VARCHAR(255),
    zipcode             INTEGER(4)
);

CREATE TABLE `order`(
    order_id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    status              VARCHAR(255),
    creation_date       DATE,
    customer_id         INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE order_item(
    order_item_id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id            INTEGER,
    product_id          INTEGER,
    quantity            INTEGER,
    FOREIGN KEY (order_id) REFERENCES `order`(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE product(
    product_id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    code                INTEGER,
    name                VARCHAR(255),
    price               DOUBLE

);
