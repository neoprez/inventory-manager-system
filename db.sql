DROP DATABASE IF EXISTS inventory_manager;
CREATE DATABASE IF NOT EXISTS inventory_manager;
USE inventory_manager;

CREATE TABLE categories (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
	upc VARCHAR(12) NOT NULL PRIMARY KEY,
	name VARCHAR(255),
	stock_price DOUBLE,
	on_sale_price DOUBLE,
	category_id INT,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	thumbnail VARCHAR(255) /* path to the image thumbnail of product */
);

CREATE TABLE supermarkets (
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY, /* The supermarket ID*/
	name VARCHAR(255),
	address VARCHAR(255),
	zipcode INT(5),
	state VARCHAR(2),
	country VARCHAR(255),
	store_manager_id BIGINT(20),
	no_of_registers INT(5),
	opening_time TIME,
	closing_time TIME,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE employees (
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	store_id BIGINT(20),
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	position VARCHAR(255) /* Store manager, cashier, etc..*/
);

CREATE TABLE supermarkets_stock (
	product_upc INT(12),
	supermarket_id BIGINT(20),
	in_stock_count INT(10)
);

CREATE TABLE orders (
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	store_id BIGINT(20),
	net_amount DOUBLE,
	tax_percent DOUBLE,
	total_amount DOUBLE,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	employee_id BIGINT(20), /* The id of the employee */	
	order_type INT(1), /* 0 - New order, 1 - Exchange, 2 - Cancelled order */
	products_count INT
);

CREATE TABLE products_purchased_in_order (
	order_id BIGINT(20),
	product_up INT(12),
	number_of_items_purchased INT(5)	
);

CREATE TABLE threshold_notifications_list (
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY, /* The id of the notification */
	product_upc INT(12),
	stock_threshold INT,
	store_id BIGINT(20),
	manager_id BIGINT(20),
	frequency INT(1), /* 0 - immediately, 1- hourly, 2- daily */
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sent_notifications (
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,  /* The id of this sent notification*/
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /*date and time last sent */
	product_upc INT(12),
	current_stock INT,
	manager_id BIGINT(20)
);
