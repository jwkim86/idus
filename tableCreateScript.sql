create table user_list (
	user_id varchar(20)  PRIMARY KEY,
	user_name varchar(20) not null,
	user_alias varchar(30) not null,
	passwd varchar(100) not null,
	phone_no varchar(20) not null,
	email_addr varchar(100) not null,
	sex char(1)
)
;

create table order_list (
	order_no varchar(12) PRIMARY KEY,
	user_id varchar(20) ,
	product_name varchar(100) not null,
	order_date datetime,
	
	FOREIGN KEY (user_id)
    REFERENCES user_list (user_id) ON update CASCADE ON delete CASCADE
)


-- admin user insert. id: admin pw: test1314
insert into user_list (
	user_id,
	user_name,
	user_alias,
	passwd,
	phone_no,
	email_addr,
	sex
) values (
	'admin',
	'테스트',
	'test',
	'$2a$10$xRLflagn5MhwgDP6nmDJa.Ow/Mq00hkuZZTGfyFO15Ch6rTSpSY/K',
	'01026401234',
	'a23323@idus.com',
	'M'
)
;
;