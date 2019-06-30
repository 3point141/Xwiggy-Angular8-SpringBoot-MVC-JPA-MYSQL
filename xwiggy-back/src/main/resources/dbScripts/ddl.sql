CREATE DATABASE IF NOT EXISTS myusers;
USE myusers;

DROP TABLE IF EXISTS `myusers`.`user`;
CREATE TABLE `myusers`.`user`
(
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NULL,
  `email`     VARCHAR(45) NULL,
  `address`   VARCHAR(45) NULL,
  `phone`     INT         NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `myusers`.`food` (
   `id` VARCHAR(45) NOT NULL,
   `item` VARCHAR(45) NOT NULL,
   `prince` INT NOT NULL,
   `quantity` INT NOT NULL,
   `url` VARCHAR(150) NOT NULL ,
   `formID` VARCHAR(50) NOT NULL ,
   `cartID` VARCHAR(50) NOT NULL ,
   PRIMARY KEY (`id`));

CREATE TABLE 'myusers'.'cart' (
  'quantity1' INT NOT NULL ,
  'quantity2' INT NOT NULL ,
  'quantity3' INT NOT NULL ,
  PRIMARY KEY ('quantity1')
);
