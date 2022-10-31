DROP DATABASE laptopshoponline;

CREATE DATABASE laptopshoponline;

USE laptopshoponline;

CREATE TABLE admin(
	admin_id varchar(20) primary key,
    display_name varchar(50) charset utf8mb4 not null,
    account_name varchar(50) not null unique,
    password varchar(50) not null,
    gmail varchar(50) not null,
    phone varchar(50) not null,
    address varchar(50) charset utf8mb4 not null
);

CREATE TABLE news
(
    news_id varchar(20) primary key,
    admin_id varchar(20) not null,
    title varchar(200) charset utf8mb4,
    content varchar(4000) charset utf8mb4,
    image_link varchar(50),
    created date,
    CONSTRAINT PRO_ADMIN_ID_FK FOREIGN KEY (admin_id) REFERENCES admin(admin_id) ON DELETE CASCADE
);


CREATE TABLE account(
	account_id varchar(20) primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	firstname varchar(50) charset utf8mb4 not null,
	lastname varchar(50) charset utf8mb4 not null,
	gmail varchar(50) not null,
	phone varchar(50) not null,
	activation_code varchar(50),
	passwordreset_code varchar(50),
	active_account VARCHAR(10),
	provider varchar(50),
	roles VARCHAR(10)
);

CREATE TABLE supplier
(
    supplier_id varchar(20) primary key,
    supplier_name varchar(50) charset utf8mb4 not null,
    supplier_image VARCHAR(500)
);

CREATE TABLE product
(
    product_id varchar(20) primary key,
    product_name  varchar(50) charset utf8mb4 not null,
    supplier_id varchar(20) not null,
    quantity int not null,
    image varchar(500),
    unitprice INT not null,
    discount varchar(10),
    description varchar(500) charset utf8mb4,
    cpu varchar(50),
    ram varchar(50),
    weight varchar(50),
    hard_disk_capacity varchar(50),
    hard_disk_type varchar(50),
    screen_size varchar(50),
    screen_resolution varchar(50),
    graphic_card_name varchar(50),
    graphic_card_memory varchar(50),
    battery_capacity varchar(50),
    os_supplied varchar(50),
    CONSTRAINT PRO_SUPPLIER_ID_FK FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id) ON DELETE CASCADE
);

CREATE TABLE cart
(
    account_id varchar(20),
    product_id varchar(20),
    cart_product_quantity INT,
    CONSTRAINT CART_PK PRIMARY KEY(account_id, product_id),
    CONSTRAINT CART_PRODUCT_ID_FK FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE,
    CONSTRAINT CART_CUSTOMER_ID_FK FOREIGN KEY(account_id) REFERENCES account(account_id) ON DELETE CASCADE
);

CREATE TABLE orders
(
    order_id varchar(20) primary key,
    account_id varchar(20) not null,
    order_date date not null,
    receipt_date date,
    totalAmount int,
    shipping varchar(50) charset utf8mb4,
    address varchar(50) charset utf8mb4 not null,
    customer_note varchar(50) charset utf8mb4,
    status varchar(50) charset utf8mb4,
    CONSTRAINT ORDER_ACCOUNT_ID_FK FOREIGN KEY(account_id) REFERENCES account(account_id) ON DELETE CASCADE
);

CREATE TABLE orderdetail(
	order_id varchar(20) not null,
	product_id varchar(20) not null,
	quantity int not null,
	CONSTRAINT ORDERDETAIL_PK PRIMARY KEY(order_id, product_id),
    CONSTRAINT ORDERDETAIL_ORDER_ID_FK FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    CONSTRAINT ORDERDETAIL_PRODUCT_ID_FK FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE
);

CREATE TABLE reviews(
	order_id varchar(20) not null,
	product_id varchar(20) not null,
	account_id varchar(20) not null,
	content varchar(500) charset utf8mb4,
	rate varchar(1),
    reviews_date date,
	CONSTRAINT REVIEWS_PK PRIMARY KEY(order_id, product_id, account_id),
	CONSTRAINT REVIEWS_ORDER_ID_FK FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
	CONSTRAINT REVIEWS_PRODUCT_ID_FK FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE,
	CONSTRAINT REVIEWS_ACCOUNT_ID_FK FOREIGN KEY (account_id) REFERENCES account(account_id) ON DELETE CASCADE
);

