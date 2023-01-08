create table food_truck (location_id bigint not null, address varchar(255), applicant varchar(50) not null, approved bigint, block varchar(10), block_lot varchar(10), cnn integer, days_hours varchar(25), expiration_date bigint, facility_type varchar(10) not null, food_items varchar(255), latitude double precision, location varchar(100), location_description varchar(255), longitude double precision, lot varchar(10), noi_sent bigint, permit varchar(10), prior_permit integer, received varchar(10), schedule varchar(255), status varchar(10), x double precision, y double precision, primary key (location_id)) engine=InnoDB;
