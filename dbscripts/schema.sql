SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `feedback` ;
CREATE SCHEMA IF NOT EXISTS `feedback` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `feedback` ;

-- -----------------------------------------------------
-- Table `feedback`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`user` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(45) NULL ,
  `password` VARCHAR(100) NULL ,
  `email` VARCHAR(45) NULL ,
  `contact_number` VARCHAR(45) NULL ,
  `role` VARCHAR(45) NULL ,
  `business_unit` VARCHAR(45) NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `feedback`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`event` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`event` (
  `event_id` INT NOT NULL AUTO_INCREMENT ,
  `event_no` VARCHAR(45) NULL ,
  `month` VARCHAR(45) NULL ,
  `location` VARCHAR(45) NULL ,
  `beneficiary_name` VARCHAR(200) NULL ,
  `address` VARCHAR(200) NULL ,
  `council_name` VARCHAR(45) NULL ,
  `project` VARCHAR(45) NULL ,
  `category` VARCHAR(200) NULL ,
  `event_name` VARCHAR(200) NULL ,
  `event_description` VARCHAR(500) NULL ,
  PRIMARY KEY (`event_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`event_summary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`event_summary` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`event_summary` (
  `summary_id` INT NOT NULL AUTO_INCREMENT ,
  `total_volunteer` DOUBLE NULL ,
  `no_of_hrs` DOUBLE NULL ,
  `travel_hrs` DOUBLE NULL ,
  `lives_impact` DOUBLE NULL ,
  `avg_volunteer` DOUBLE NULL ,
  `event_id` INT NOT NULL ,
  PRIMARY KEY (`summary_id`) ,
  INDEX `fk_event_summary_event1_idx` (`event_id` ASC) ,
  CONSTRAINT `fk_event_summary_event1`
    FOREIGN KEY (`event_id` )
    REFERENCES `feedback`.`event` (`event_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`user_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`user_event` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`user_event` (
  `event_us_id` INT NOT NULL ,
  `user_user_id` INT NULL ,
  `particpation` VARCHAR(45) NULL ,
  `volunteer_hr` DOUBLE NULL ,
  `travel_hr` DOUBLE NULL ,
  `event_id` INT NOT NULL ,
  PRIMARY KEY (`event_us_id`) ,
  INDEX `fk_user_has_event_user1_idx` (`user_user_id` ASC) ,
  INDEX `fk_user_event_event1_idx` (`event_id` ASC) ,
  CONSTRAINT `fk_user_has_event_user1`
    FOREIGN KEY (`user_user_id` )
    REFERENCES `feedback`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_event_event1`
    FOREIGN KEY (`event_id` )
    REFERENCES `feedback`.`event` (`event_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`feedback_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`feedback_type` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`feedback_type` (
  `feedback_type_id` INT NOT NULL AUTO_INCREMENT ,
  `feedback_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`feedback_type_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`feedback` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`feedback` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT ,
  `feedback_type` INT NOT NULL ,
  `feedback_answer_type` VARCHAR(45) NULL ,
  `feedback_question` VARCHAR(200) NULL ,
  PRIMARY KEY (`feedback_id`) ,
  INDEX `fk_feedback_feedback_type1_idx` (`feedback_type` ASC) ,
  CONSTRAINT `fk_feedback_feedback_type1`
    FOREIGN KEY (`feedback_type` )
    REFERENCES `feedback`.`feedback_type` (`feedback_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`feedback_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`feedback_answer` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`feedback_answer` (
  `feedback_answer_id` INT NOT NULL AUTO_INCREMENT ,
  `feedback_id` INT NOT NULL ,
  `feedback_answer` VARCHAR(300) NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`feedback_answer_id`) ,
  INDEX `fk_feedback_answer_feedback1_idx` (`feedback_id` ASC) ,
  INDEX `fk_feedback_answer_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_feedback_answer_feedback1`
    FOREIGN KEY (`feedback_id` )
    REFERENCES `feedback`.`feedback` (`feedback_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_answer_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `feedback`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`.`feedback_preanswer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback`.`feedback_preanswer` ;

CREATE  TABLE IF NOT EXISTS `feedback`.`feedback_preanswer` (
  `answer_id` INT NOT NULL AUTO_INCREMENT ,
  `feedback_answer` VARCHAR(200) NULL ,
  `feedback_id` INT NOT NULL ,
  PRIMARY KEY (`answer_id`) ,
  INDEX `fk_feedback_preanswer_feedback1_idx` (`feedback_id` ASC) ,
  CONSTRAINT `fk_feedback_preanswer_feedback1`
    FOREIGN KEY (`feedback_id` )
    REFERENCES `feedback`.`feedback` (`feedback_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `feedback` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
