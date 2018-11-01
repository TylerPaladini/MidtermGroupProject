-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema babychangerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `babychangerdb` ;

-- -----------------------------------------------------
-- Schema babychangerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `babychangerdb` DEFAULT CHARACTER SET utf8 ;
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
  `date_created` DATETIME NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
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
  `date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_location_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
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
  `user_id` INT NOT NULL,
  `date_created` DATETIME NULL DEFAULT current_timestamp,
  `description` TEXT NULL,
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
  `date_created` DATETIME NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_users1_idx` (`user_id` ASC),
  INDEX `fk_comment_restroom1_idx` (`restroom_id` ASC),
  CONSTRAINT `fk_comment_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_restroom1`
    FOREIGN KEY (`restroom_id`)
    REFERENCES `restroom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS stercus@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'stercus'@'localhost' IDENTIFIED BY 'stercus';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'stercus'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (1, '7400 E Orchard Rd #1450N', NULL, 'Greenwood Village', 'CO', '80111');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (2, '7701 E Orchard Rd', NULL, 'Greenwood Village', 'CO', '80111');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (3, 'Lake Loop Picnic Access', NULL, 'Englewood', 'CO', '80111');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (4, '15700 E Briarwood Cir', NULL, 'Aurora', 'CO', '80016');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (5, '8505 Park Meadows Center Dr', NULL, 'Lone Tree', 'CO', '80124');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (6, '6492 S Parker Rd ', NULL, 'Aurora', 'CO', '80016');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (7, '6982 S Quentin St', NULL, 'Englewood', 'CO', '80112');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (8, '8467 S Yosemite St ', NULL, 'Lone Tree', 'CO', '80124');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (9, '6818 S Yosemite St', NULL, 'Centennial', 'CO', '80122');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip`) VALUES (10, '8500 Pena Blvd', NULL, 'Denver', 'CO', '80249');

COMMIT;


-- -----------------------------------------------------
-- Data for table `users`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (1, 'Jane', 'Doe', 'janedoe', 'janedoe@gmail.com', 'JaneDoe1!', true, false, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (2, 'John', 'Doe', 'johndoe', 'johndoe@hotmail.com', 'JohnDoe1!', true, false, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (3, 'Mike', 'Myers', 'mikem', 'mikeym@aol.com', 'MikeMyers1!', true, false, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (4, 'Rob', 'Thompson', 'robthompson', 'rob@10thHuman.com', 'RobThompson1!', true, true, NULL);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `email`, `password`, `active`, `admin`, `date_created`) VALUES (5, 'admin', 'admin', 'admin', 'admin@admin.com', 'Admin1!', true, true, '2018-10-01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (2, 'Shell on E Orchard', 'must get key from attendant', true, '303-770-2637', '06:00:00', '23:59:00', 2, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (3, 'Lake Loop Picnic Area', 'none, public access', false, NULL, '06:00:00', '23:59:00', 3, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (4, 'Target on Briarwood', 'none ', false, '720-214-6000', '08:00:00', '22:00:00', 4, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (5, 'Land of Nod', 'closes 9 PM', true, '303-649-9922', '10:00:00', '21:00:00', 5, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (6, 'buybuy Baby', 'closes at 9 ', false, '303-305-1130', '09:00:00', '21:00:00', 6, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (7, 'Koala Kare Products', 'kloses at 4:30', false, '303-539-8300', '07:00:00', '21:30:00', 6, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (8, 'Bed Bath & Beyond', 'none', false, '303-708-1577', '09:00:00', '21:00:00', 8, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (9, 'Park Meadows Mall', 'closes at 9 PM, loud', false, '303-792-2533', '10:00:00', '21:00:00', 5, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (10, 'Southgate Shopping Center', 'closes at 6 PM', false, NULL, '00:01:00', '18:00:00', 9, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (11, 'DIA ', '24 hr', false, NULL, '00:00:00', '23:59:00', 10, DEFAULT);
INSERT INTO `location` (`id`, `name`, `access_limits`, `purchase_required`, `phone`, `open_time`, `closed_time`, `address_id`, `date_created`) VALUES (1, 'Solarium', 'have to be a student', false, '303-302-5234', '08:00:00', '18:00:00', 1, '2018-10-01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `restroom`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (1, 1, NULL, NULL, NULL, NULL, 'M', 'gound floor north tower east end down hallway', true, 2, NULL, 'changing room w/showers', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (2, 1, NULL, NULL, NULL, NULL, 'F', 'ground floor n tower ', true, 1, NULL, 'nice tp', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (3, 2, NULL, NULL, NULL, NULL, 'M', 'inside on right', true, 4, NULL, 'its not gold plated but functional', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (4, 3, NULL, NULL, NULL, NULL, 'M', 'next to lake', true, 4, NULL, 'it\'s a public bathroom ', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (5, 4, NULL, NULL, NULL, NULL, 'M', 'inside, right or left depending on door you enter, it\'s in the middle ', true, 4, NULL, 'decently clean', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (6, 5, NULL, NULL, NULL, NULL, 'M', 'in the mall', true, 4, NULL, 'very clean', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (7, 6, NULL, NULL, NULL, NULL, 'M', 'in the store in the back', true, 4, NULL, 'very clean', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (8, 7, NULL, NULL, NULL, NULL, 'M', 'back of the store, BYOW', true, 4, NULL, 'bring your own wipes', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (9, 8, NULL, NULL, NULL, NULL, 'M', 'straight back ', true, 4, NULL, 'no TP', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (10, 9, NULL, NULL, NULL, NULL, 'M', 'next to apple store downstairs', true, 4, NULL, 'don\'t bring your iPad into the stall', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (11, 9, NULL, NULL, NULL, NULL, 'M', 'next to foodcourt upstairs', true, 4, NULL, 'it\'s a bathroom', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (12, 9, NULL, NULL, NULL, NULL, 'F', 'next to foodcourt upstairs ', true, 4, NULL, 'has sign for table on the door', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (13, 4, NULL, NULL, NULL, NULL, 'F', 'in the target ', true, 4, NULL, 'wife said there\'s a table in there', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (14, 9, NULL, NULL, NULL, NULL, 'M', 'next to macy\'s ', true, 4, NULL, 'no table', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (15, 10, NULL, NULL, NULL, NULL, 'M', 'next to the Chinese food place', true, 4, NULL, 'no table', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (16, 11, NULL, NULL, NULL, NULL, 'M', 'near gate 34', true, 4, NULL, 'need boarding pass for A', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (17, 11, NULL, NULL, NULL, NULL, 'M', 'near gate 38', true, 4, NULL, 'need boarding pass for A ', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (18, 11, NULL, NULL, NULL, NULL, 'M', 'near gate 41', true, 4, NULL, 'need A gate boarding pass ', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (19, 11, NULL, NULL, NULL, NULL, 'F', 'near gate 42', true, 4, NULL, 'need a gate boarding pass', false);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (20, 11, NULL, NULL, NULL, NULL, 'M', 'near gate 22-21', true , 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (21, 11, NULL, NULL, NULL, NULL, 'F', 'near gates 28-30', true, 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (22, 11, NULL, NULL, NULL, NULL, 'F', 'across from gate 57', true, 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (23, 11, NULL, NULL, NULL, NULL, 'F', 'near gate 39', true, 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (24, 11, NULL, NULL, NULL, NULL, 'F', 'between gates 44/48', true, 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (25, 11, NULL, NULL, NULL, NULL, 'F', 'between gates 52/54', true, 4, NULL, 'need B gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (26, 11, NULL, NULL, NULL, NULL, 'F', 'Concourse C near gates 32', true, 4, NULL, 'need C gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (27, 11, NULL, NULL, NULL, NULL, 'F', 'Concourse C near gates 38', true, 4, NULL, 'need C gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (28, 11, NULL, NULL, NULL, NULL, 'M', 'Concourse C near gate 38', true, 4, NULL, 'need C gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (29, 11, NULL, NULL, NULL, NULL, 'F', 'Con C near gate 41', true, 4, NULL, 'need C gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (30, 11, NULL, NULL, NULL, NULL, 'F', 'Con C near gate 46', true, 4, NULL, 'need C gate boarding pass', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (31, 11, NULL, NULL, NULL, NULL, 'F', 'Concourse Baggage Claim ', true, 4, NULL, 'near rental cars and fountain', true);
INSERT INTO `restroom` (`id`, `location_id`, `picture`, `flagged`, `flagged_reason`, `flagged_date`, `gender`, `directions`, `public`, `user_id`, `date_created`, `description`, `changing_table`) VALUES (32, 11, NULL, NULL, NULL, NULL, 'F', 'Concourse Ticketing', true, 4, NULL, 'near bridge to Concourse A, tix counters from Air Canada (eh) and Frontier', true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `babychangerdb`;
INSERT INTO `comment` (`id`, `user_id`, `comment`, `restroom_id`, `flag_comment`, `rating`, `active`, `date_created`) VALUES (1, 1, 'test comment', 1, NULL, '1', true, DEFAULT);
INSERT INTO `comment` (`id`, `user_id`, `comment`, `restroom_id`, `flag_comment`, `rating`, `active`, `date_created`) VALUES (2, 1, 'test another comment', 1, NULL, '5', true, DEFAULT);
INSERT INTO `comment` (`id`, `user_id`, `comment`, `restroom_id`, `flag_comment`, `rating`, `active`, `date_created`) VALUES (3, 4, 'very very clean', 13, NULL, '5', true, DEFAULT);

COMMIT;

