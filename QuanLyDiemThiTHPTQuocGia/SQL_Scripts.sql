create database login_demo;

use login_demo;

CREATE TABLE `login_demo`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

INSERT INTO `login_demo`.`account` (`username`, `password`) VALUES ('admin', '123456');

SELECT * FROM account where username = 'admin' and password = '123456';