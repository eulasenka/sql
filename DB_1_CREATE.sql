create table _Tourist (
tourist_id int, name varchar(20), surame varchar(20), clubcard_id int REFERENCES _ClubCard, 
address_id int REFERENCES _Address, PRIMARY KEY (tourist_id)
);

create table _Address (
address_id int, city varchar(20), street varchar(40), room tinyint, PRIMARY KEY (address_id)
);

create table _Order (
order_id int, tourist_id int REFERENCES _Tourist, order_date date, amount smallint, PRIMARY KEY (order_id)
);

create table _ClubCard (
clubcard_id int, tourist_id int REFERENCES _Tourist, tourist_email varchar(40), discount tinyint, 
PRIMARY KEY (clubcard_id)
);

create table _Tour (
tour_id int, tour_name varchar(20), tour_description varchar(250), tour_date date, PRIMARY KEY (tour_id)
);

create table _Tour_Order (
order_id int REFERENCES _Order(order_id), tour_id int REFERENCES _Tour(tour_id)
);