-- database: dell
-- public.categories definition

-- Drop table

-- DROP TABLE public.categories;

CREATE TABLE public.categories (
	category serial NOT NULL,
	categoryname varchar(50) NOT NULL,
	CONSTRAINT categories_pkey PRIMARY KEY (category)
);


-- public.customers definition

-- Drop table

-- DROP TABLE public.customers;

CREATE TABLE public.customers (
	customerid serial NOT NULL,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	address1 varchar(50) NOT NULL,
	address2 varchar(50) NULL,
	city varchar(50) NOT NULL,
	state varchar(50) NULL,
	zip int4 NULL,
	country varchar(50) NOT NULL,
	region int2 NOT NULL,
	email varchar(50) NULL,
	phone varchar(50) NULL,
	creditcardtype int4 NOT NULL,
	creditcard varchar(50) NOT NULL,
	creditcardexpiration varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	age int2 NULL,
	income int4 NULL,
	gender varchar(1) NULL,
	CONSTRAINT customers_pkey PRIMARY KEY (customerid)
);
CREATE UNIQUE INDEX ix_cust_username ON public.customers USING btree (username);


-- public.inventory definition

-- Drop table

-- DROP TABLE public.inventory;

CREATE TABLE public.inventory (
	prod_id int4 NOT NULL,
	quan_in_stock int4 NOT NULL,
	sales int4 NOT NULL,
	CONSTRAINT inventory_pkey PRIMARY KEY (prod_id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	prod_id serial NOT NULL,
	category int4 NOT NULL,
	title varchar(50) NOT NULL,
	actor varchar(50) NOT NULL,
	price numeric(12,2) NOT NULL,
	special int2 NULL,
	common_prod_id int4 NOT NULL,
	CONSTRAINT products_pkey PRIMARY KEY (prod_id)
);
CREATE INDEX ix_prod_category ON public.products USING btree (category);
CREATE INDEX ix_prod_special ON public.products USING btree (special);


-- public.reorder definition

-- Drop table

-- DROP TABLE public.reorder;

CREATE TABLE public.reorder (
	prod_id int4 NOT NULL,
	date_low date NOT NULL,
	quan_low int4 NOT NULL,
	date_reordered date NULL,
	quan_reordered int4 NULL,
	date_expected date NULL
);


-- public.cust_hist definition

-- Drop table

-- DROP TABLE public.cust_hist;

CREATE TABLE public.cust_hist (
	customerid int4 NOT NULL,
	orderid int4 NOT NULL,
	prod_id int4 NOT NULL,
	CONSTRAINT fk_cust_hist_customerid FOREIGN KEY (customerid) REFERENCES customers(customerid) ON DELETE CASCADE
);
CREATE INDEX ix_cust_hist_customerid ON public.cust_hist USING btree (customerid);


-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	orderid serial NOT NULL,
	orderdate date NOT NULL,
	customerid int4 NULL,
	netamount numeric(12,2) NOT NULL,
	tax numeric(12,2) NOT NULL,
	totalamount numeric(12,2) NOT NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (orderid),
	CONSTRAINT fk_customerid FOREIGN KEY (customerid) REFERENCES customers(customerid) ON DELETE SET NULL
);
CREATE INDEX ix_order_custid ON public.orders USING btree (customerid);


-- public.orderlines definition

-- Drop table

-- DROP TABLE public.orderlines;

CREATE TABLE public.orderlines (
	orderlineid int4 NOT NULL,
	orderid int4 NOT NULL,
	prod_id int4 NOT NULL,
	quantity int2 NOT NULL,
	orderdate date NOT NULL,
	CONSTRAINT fk_orderid FOREIGN KEY (orderid) REFERENCES orders(orderid) ON DELETE CASCADE
);
CREATE UNIQUE INDEX ix_orderlines_orderid ON public.orderlines USING btree (orderid, orderlineid);