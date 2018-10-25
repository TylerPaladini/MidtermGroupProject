-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema monopolydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `monopolydb` ;

-- -----------------------------------------------------
-- Schema monopolydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `monopolydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema babychangerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `babychangerdb` ;

-- -----------------------------------------------------
-- Schema babychangerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `babychangerdb` DEFAULT CHARACTER SET utf8 ;
USE `monopolydb` ;

-- -----------------------------------------------------
-- Table `land`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `land` ;

CREATE TABLE IF NOT EXISTS `land` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `color` ENUM('BROWN', 'LIGHT_BLUE', 'PINK', 'ORANGE', 'RED', 'YELLOW', 'GREEN', 'BLUE', 'NONE') NOT NULL,
  `type` ENUM('GO', 'PROPERTY', 'COMMUNITY_CHEST', 'TAX', 'RAILROAD', 'CHANCE', 'JAIL', 'UTILITY', 'FREE_PARKING', 'GO_TO_JAIL') NOT NULL,
  `purchase_price` INT NULL,
  `rent_price` INT NULL,
  `position` INT NOT NULL,
  `number_of_houses` INT NULL DEFAULT 0,
  `number_of_hotels` INT NULL DEFAULT 0,
  `status` ENUM('OWNED', 'NOT_OWNED', 'MORTGAGED') NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE `babychangerdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `street2` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `zip` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `access_limits` VARCHAR(500) NULL DEFAULT NULL,
  `purchase_required` TINYINT(1) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `open_time` TIME NULL DEFAULT NULL,
  `closed_time` TIME NULL DEFAULT NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_location_idx` (`address_id` ASC),
  CONSTRAINT `fk_address_location`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(250) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT NULL,
  `admin` TINYINT(1) NULL DEFAULT NULL,
<<<<<<< HEAD
  `date_created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
=======
  `date_created` DATETIME NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `access_limits` VARCHAR(500) NULL DEFAULT NULL,
  `purchase_required` TINYINT(1) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL,
  `open_time` TIME NULL,
  `closed_time` TIME NULL,
  `address_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
>>>>>>> cdfe33be8336057b2af2d350ca47294ee68df3ba
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `restroom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restroom` ;

CREATE TABLE IF NOT EXISTS `restroom` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `location_id` INT(11) NOT NULL,
  `picture` VARCHAR(1000) NULL DEFAULT NULL,
  `flagged` TINYINT(1) NULL DEFAULT NULL,
  `flagged_reason` TEXT NULL DEFAULT NULL,
  `flagged_date` DATETIME NULL DEFAULT NULL,
  `gender` ENUM('M', 'F', 'U') NULL DEFAULT NULL,
  `directions` VARCHAR(500) NULL DEFAULT NULL,
  `public` TINYINT(1) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `date_created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `description` TEXT NULL DEFAULT NULL,
  `changing_table` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_restroom_location1_idx` (`location_id` ASC),
  INDEX `fk_restroom_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_restroom_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restroom_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `comment` TEXT NULL DEFAULT NULL,
  `restroom_id` INT(11) NOT NULL,
  `flag_comment` TINYINT(1) NULL DEFAULT NULL,
  `rating` ENUM('1', '2', '3', '4', '5') NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT NULL,
  `date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_users1_idx` (`user_id` ASC),
  INDEX `fk_comment_restroom1_idx` (`restroom_id` ASC),
  CONSTRAINT `fk_comment_restroom1`
    FOREIGN KEY (`restroom_id`)
    REFERENCES `restroom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS monopolyuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'monopolyuser'@'localhost' IDENTIFIED BY 'monopoly';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'monopolyuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'monopolyuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
<<<<<<< HEAD
-- Data for table `land`
-- -----------------------------------------------------
START TRANSACTION;
USE `monopolydb`;
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (1, 'GO', 'NONE', 'GO', NULL, NULL, 1, NULL, NULL, 'NOT_OWNED', 'Pass go collect $200');
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (2, 'Mediteranean Avenue', 'BROWN', 'PROPERTY', 60, 2, 2, 0, 0, 'NOT_OWNED', 'First Property');
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (3, 'Community Chest', 'NONE', 'COMMUNITY_CHEST', NULL, NULL, 3, NULL, NULL, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (4, 'Baltic Avenue', 'BROWN', 'PROPERTY', 60, 4, 4, 0, 0, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (5, 'Income Tax', 'NONE', 'TAX', NULL, 200, 5, NULL, NULL, 'NOT_OWNED', 'You have to pay income tax of $200');
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (6, 'Reading Railroad', 'NONE', 'RAILROAD', 200, 25, 6, NULL, NULL, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (7, 'Oriental Avenue', 'LIGHT_BLUE', 'PROPERTY', 100, 6, 7, 0, 0, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (8, 'Chance', 'NONE', 'CHANCE', NULL, NULL, 8, NULL, NULL, 'NOT_OWNED', 'Draw a card from the Chance pile');
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (9, 'Vermont Avenue', 'LIGHT_BLUE', 'PROPERTY', 100, 6, 9, 0, 0, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (10, 'Connecticut Avenue', 'LIGHT_BLUE', 'PROPERTY', 120, 8, 10, 0, 0, 'NOT_OWNED', NULL);
INSERT INTO `land` (`id`, `name`, `color`, `type`, `purchase_price`, `rent_price`, `position`, `number_of_houses`, `number_of_hotels`, `status`, `description`) VALUES (11, 'Jail', 'NONE', 'JAIL', NULL, NULL, 11, NULL, NULL, 'NOT_OWNED', NULL);
=======
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (1, '1210 Toledo St', NULL, 'Henderson', 'NV', '80918');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (2, '317 Columbine Rd', NULL, 'Palmer Lake', 'CO', '80133');

COMMIT;


-- -----------------------------------------------------
-- Data for table `users`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (1, 'Jane', 'Doe', 'janedoe', 'janedoe@gmail.com', 'janedoe', true, false, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (2, 'John', 'Doe', 'johndoe', 'johndoe@hotmail.com', 'johndoe', true, true, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (3, 'Mike', 'Myers', 'mikem', 'mikeym@aol.com', 'mikeym', true, false, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`) VALUES (1, 'Solarium', 'have to be a student', false, '7194406626', '08:00', '18:00', 1);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`) VALUES (2, 'Gas Station E Orchard', 'must get key from attendant', true, '7203154567', NULL, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `restroom`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (1, 1, NULL, NULL, NULL, NULL, 'M', 'gound floor north tower east end down hallway', true, 2, NULL, 'changing room w/showers', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (2, 1, NULL, NULL, NULL, NULL, 'F', 'ground floor n tower ', true, 1, NULL, 'nice tp', true);
>>>>>>> cdfe33be8336057b2af2d350ca47294ee68df3ba

COMMIT;

