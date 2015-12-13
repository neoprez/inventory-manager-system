use inventory_manager;

/* categories data */

INSERT INTO categories (name) VALUES('Food');
INSERT INTO categories (name) VALUES('Not Food');


/* products data */

INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('035200264013', 'Riceland American Jazmine Rice',  50.28 , 1, 1, 1);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('011111065925', 'Caress Velvet Bliss Ultra Silkening Beauty Bar - 6 Ct',  21.24 , 2, 1, 2);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('023923330139', 'Earths Best Organic Fruit Yogurt Smoothie Mixed Berry',  6.31 , 1, 1, 3);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('208528800007', 'Boars Head Sliced White American Cheese - 120 Ct',  47.18 , 1, 1, 4);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('759283100036', 'Back To Nature Gluten Free White Cheddar Rice Thin Crackers',  43.06 , 1, 1, 5);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('074170388732', 'Sally Hansen Nail Color Magnetic 903 Silver Elements',  5.45 , 2, 1, 6);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('070177154004', 'Twinings Of London Classics Lady Grey Tea - 20 Ct',  20.12 , 1, 1, 7);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('051600080015', 'Lea & Perrins Marinade In-a-bag Cracked Peppercorn',  4.1 , 1, 1, 8);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('019600923015', 'Van De Kamps Fillets Beer Battered - 10 Ct',  28.24 , 1, 1, 9);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('688267141676', 'Ahold Cocoa Almonds',  13.46 , 1, 1, 10);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('657622604842', 'Honest Tea Peach White Tea',  38.06 , 1, 1, 11);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('074676640211', 'Mueller Sport Care Basic Support Level Medium Elastic Knee Support',  40.49 , 2, 1, 12);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('603084234561', 'Garnier Nutritioniste Moisture Rescue Fresh Cleansing Foam',  24.58 , 2, 2, 13);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('041167300121', 'Pamprin Maximum Strength Multi-symptom Menstrual Pain Relief',  5.58 , 2, 2, 14);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('079400847201', 'Suave Naturals Moisturizing Body Wash Creamy Tropical Coconut',  44.53 , 2, 2, 15);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('792850014008', 'Burts Bees Daily Moisturizing Cream Sensitive',  33.4 , 2, 2, 16);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('088313590791', 'Ducal Refried Red Beans',  11.05 , 1, 2, 17);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('021200725340', 'Scotch Removable Clear Mounting Squares - 35 Ct',  25.67 , 2, 2, 18);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('041520035646', 'Careone Family Comb Set - 8 Ct',  1.35 , 2, 2, 19);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('204040000000', 'Plums Black',  50.96 , 1, 2, 20);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('753950001954', 'Doctors Best Best Curcumin C3 Complex 1000mg Tablets - 120 Ct',  5.56 , 2, 2, 21);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('016000288829', 'Betty Crocker Twin Pack Real Potatoes Scalloped 2 Pouches For 2 Meals - 2 Pk',  14.49 , 1, 2, 22);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('070670009658', 'Reese Mandarin Oranges Segments In Light Syrup',  50.16 , 1, 2, 23);
INSERT INTO products (upc, name, price, category_id, distributor_id, manufacturer_id) VALUES('688267084225', 'Smart Living Charcoal Lighter Fluid',  48.52 , 2, 2, 24);


/* supermarkets data */

INSERT INTO supermarkets (name, address, zipcode, state, country, store_manager_id, no_of_registers, opening_time, closing_time) VALUES('Pioneer Supermarket', '1345 Castle Hill Ave',  '10453' , 'NY', 'United States', 1, 6, '07:30:00', '19:00:00');
INSERT INTO supermarkets (name, address, zipcode, state, country, store_manager_id, no_of_registers, opening_time, closing_time) VALUES('Pioneer Supermarket ', '238 E 161st St',  '10456' , 'NY', 'United States', 2, 8, '07:30:00', '19:00:00');
INSERT INTO supermarkets (name, address, zipcode, state, country, store_manager_id, no_of_registers, opening_time, closing_time) VALUES('Pioneer Supermarket ', '301 Morris Ave',  '10459' , 'NY', 'United States', 3, 6, '07:30:00', '19:00:00');
INSERT INTO supermarkets (name, address, zipcode, state, country, store_manager_id, no_of_registers, opening_time, closing_time) VALUES('Pioneer Supermarket ', '2556 Boston Rd',  '10474' , 'NY', 'United States', 4, 8, '07:30:00', '19:00:00');
INSERT INTO supermarkets (name, address, zipcode, state, country, store_manager_id, no_of_registers, opening_time, closing_time) VALUES('Pioneer Supermarket ', '2891 Sedgwick Ave',  '10471' , 'NY', 'United States', 5, 6, '07:30:00', '19:00:00');

/* employees data */

INSERT INTO employees (first_name, last_name, store_id, position, email_address) VALUES('Gerald ', 'Rose',  1 , 'manager', 'geraldrose@pioneer.com');
INSERT INTO employees (first_name, last_name, store_id, position, email_address) VALUES('Thomas', 'Marshall',  2 , 'manager', 'thomasmarshall@pioneer.com');
INSERT INTO employees (first_name, last_name, store_id, position, email_address) VALUES('Hedie', 'Warburton',  3 , 'manager', 'hediewarburton@pioneer.com');
INSERT INTO employees (first_name, last_name, store_id, position, email_address) VALUES('Joseph', 'Goldberg',  4 , 'manager', 'josephgoldberg@pioneer.com');
INSERT INTO employees (first_name, last_name, store_id, position, email_address) VALUES('Mildred', 'Dennison',  5 , 'manager', 'mildreddennison@pioneer.com');

/*supermarkets_stock data*/

INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('035200264013', 1, 18,  true  , 1, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('011111065925', 2, 10,  true  , 2, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('023923330139', 3, 12,  true  , 3, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('208528800007', 4, 18,  true  , 4, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('759283100036', 5, 13,  true  , 5, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('074170388732', 1, 18,  true  , 1, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('070177154004', 2, 21,  true  , 2, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('051600080015', 3, 11,  true  , 3, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('019600923015', 4, 22,  true  , 4, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('688267141676', 5, 11,  true  , 5, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('657622604842', 1, 10,  true  , 1, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('074676640211', 2, 12,  true  , 2, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('603084234561', 3, 24,  true  , 3, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('041167300121', 4, 17,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('079400847201', 5, 18,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('792850014008', 1, 11,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('088313590791', 2, 22,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('021200725340', 3, 11,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('041520035646', 4, 25,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('204040000000', 5, 18,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('753950001954', 1, 12,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('016000288829', 2, 10,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('070670009658', 3, 21,  false , NULL, NULL);
INSERT INTO supermarkets_stock (product_upc, supermarket_id, product_count, has_notification, threshold_count, date_last_updated) VALUES('688267084225', 4, 23,  false , NULL, NULL);

/* manufacturers data */

INSERT INTO manufacturers (name) VALUES('Riceland');
INSERT INTO manufacturers (name) VALUES('Caress');
INSERT INTO manufacturers (name) VALUES('Earths Best');
INSERT INTO manufacturers (name) VALUES('Boars Head');
INSERT INTO manufacturers (name) VALUES('Back To Nature');
INSERT INTO manufacturers (name) VALUES('Sally Hansen');
INSERT INTO manufacturers (name) VALUES('Twinings Of London');
INSERT INTO manufacturers (name) VALUES('Lea & Perrins');
INSERT INTO manufacturers (name) VALUES('Van De Kamps');
INSERT INTO manufacturers (name) VALUES('Ahold');
INSERT INTO manufacturers (name) VALUES('Honest Tea');
INSERT INTO manufacturers (name) VALUES('Mueller');
INSERT INTO manufacturers (name) VALUES('Garnier Nutritioniste');
INSERT INTO manufacturers (name) VALUES('Pamprin');
INSERT INTO manufacturers (name) VALUES('Suave');
INSERT INTO manufacturers (name) VALUES('Burts Bees');
INSERT INTO manufacturers (name) VALUES('Ducal');
INSERT INTO manufacturers (name) VALUES('Scotch');
INSERT INTO manufacturers (name) VALUES('Careone');
INSERT INTO manufacturers (name) VALUES('Usda Produce');
INSERT INTO manufacturers (name) VALUES('Doctors Best');
INSERT INTO manufacturers (name) VALUES('Betty Crocker');
INSERT INTO manufacturers (name) VALUES('Reese');
INSERT INTO manufacturers (name) VALUES('Smart Living');


/* distributors data */

INSERT INTO distributors (name) VALUES('A1 Food Distributors');
INSERT INTO distributors (name) VALUES('Prime Food Distributor');
