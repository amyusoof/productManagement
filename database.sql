
CREATE SCHEMA `productMgmt` ;

use productMgmt;

CREATE TABLE `categories` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AISLE_ID` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `products` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AVAILABLE` tinyint(1) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `PRICE` bigint(20) DEFAULT NULL,
  `CATEGORY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_9mbpgab06r3t6d7g7s9l23fw2` (`CATEGORY_ID`),
  CONSTRAINT `FK_9mbpgab06r3t6d7g7s9l23fw2` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categories` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_avh1b2ec82audum2lyjx2p1ws` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FK_g46n82f45xs0ds0r7m7ahel3d` (`user_id`),
  CONSTRAINT `FK_g46n82f45xs0ds0r7m7ahel3d` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- Users

INSERT INTO `users`
(`id`,
`dob`,
`email`,
`name`,
`password`)
VALUES
(1,
NOW(),
'admin@test.com',
'Administrator',
'admin');

INSERT INTO `users`
(`id`,
`dob`,
`email`,
`name`,
`password`)
VALUES
(2,
NOW(),
'test@test.com',
'Test',
'test');


-- Roles

insert into roles values(1, 'ROLE_ADMIN', 1);

-- Category

INSERT INTO `categories`
(`AISLE_ID`,`DESCRIPTION`,`NAME`)
VALUES
(1,'Fashion','Fashion'),
(2,'Electronics','Electronics'),
(3,'Luggage','Luggage'),
(4,'Mobiles','Mobiles'),
(5,'Laptops','Laptops');
