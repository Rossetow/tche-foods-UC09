CREATE DATABASE db_tchefoods_final;

use db_tchefoods_final;

CREATE TABLE `db_tchefoods_final`.`tb_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `user_surname` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  `user_cellphone` VARCHAR(15) NOT NULL,
  `user_adress` VARCHAR(45) NOT NULL,
  `user_gender` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_id`));
  
CREATE TABLE `db_tchefoods_final`.`tb_category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`));


CREATE TABLE `db_tchefoods_final`.`tb_product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `product_price` FLOAT NOT NULL,
  `product_category_id` INT NULL,
  PRIMARY KEY (`product_id`));
  
CREATE TABLE `db_tchefoods_final`.`tb_paymentmethod` (
  `paymentmethod_id` INT NOT NULL AUTO_INCREMENT,
  `paymentmethod_desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`paymentmthod_id`));

CREATE TABLE `db_tchefoods_final`.`tb_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `order_user_id` INT NOT NULL,
  `order_paymentmethod_id` INT NOT NULL,
  `order_datetime` DATETIME NOT NULL,
  `order_total` FLOAT NOT NULL,
  PRIMARY KEY (`order_id`));