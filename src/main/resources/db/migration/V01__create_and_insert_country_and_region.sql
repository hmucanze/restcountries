
CREATE TABLE region(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	region_id BIGINT(20),
	FOREIGN KEY (region_id) REFERENCES region(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE country(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	capital VARCHAR(50) NOT NULL,
	area DECIMAL(10,2) NOT NULL,
	region_id BIGINT(20) NOT NULL,
	FOREIGN KEY (region_id) REFERENCES region(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO region(name,region_id) VALUES("África",null);
INSERT INTO region(name,region_id) VALUES("América",null);
INSERT INTO region(name,region_id) VALUES("Ásia",null);
INSERT INTO region(name,region_id) VALUES("Europa",null);

INSERT INTO region(name,region_id) VALUES("Sul da África", 1);
INSERT INTO region(name,region_id) VALUES("Norte da África",1);
INSERT INTO region(name,region_id) VALUES("Africa Central",1);

INSERT INTO region(name,region_id) VALUES("Norte da América",2);
INSERT INTO region(name,region_id) VALUES("Sul da América",2);
INSERT INTO region(name,region_id) VALUES("América Central",2);

INSERT INTO region(name,region_id) VALUES("Sul da Ásia",3);
INSERT INTO region(name,region_id) VALUES("Norte da Ásia",3);
INSERT INTO region(name,region_id) VALUES("Ásia Central",3);

INSERT INTO region(name,region_id) VALUES("Sul da Europa",4);
INSERT INTO region(name,region_id) VALUES("Norte da Europa",4);
INSERT INTO region(name,region_id) VALUES("Europa Central",4);