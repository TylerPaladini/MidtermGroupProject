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

COMMIT;

