-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema siomassy2021
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema siomassy2021
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `siomassy2021` DEFAULT CHARACTER SET utf8 ;
USE `siomassy2021` ;

-- -----------------------------------------------------
-- Table `siomassy2021`.`personne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`personne` (
  `id_personne` INT(11) NOT NULL AUTO_INCREMENT,
  `prenom` VARCHAR(45) NULL,
  `nom` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `pwd` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  PRIMARY KEY (`id_personne`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
