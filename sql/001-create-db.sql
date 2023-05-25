CREATE TABLE orders (id INT NOT NULL AUTO_INCREMENT,date DATE, customer_id INT NOT NULL, products VARCHAR(255), PRIMARY KEY (id)) ENGINE=InnoDB;
create table orders_seq (next_val bigint) engine=InnoDB;
insert into orders_seq values ( 1 );