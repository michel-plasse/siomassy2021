-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema siomassy2021
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `siomassy2021` ;

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
  `prenom` VARCHAR(45) NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `est_formateur` TINYINT NOT NULL DEFAULT 0,
  `est_gestionnaire` VARCHAR(45) NOT NULL DEFAULT 0,
  `est_administrateur` VARCHAR(45) NOT NULL DEFAULT 0,
  `url_photo` VARCHAR(65) NULL,
  `token` VARCHAR(255) NULL,
  `inscrit_a` VARCHAR(45) NULL,
  PRIMARY KEY (`id_personne`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siomassy2021`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`questionnaire` (
  `id_questionnaire` INT NOT NULL AUTO_INCREMENT,
  `id_createur` INT(11) NOT NULL,
  PRIMARY KEY (`id_questionnaire`),
  INDEX `fk_questionnaire_personne_idx` (`id_createur` ASC),
  CONSTRAINT `fk_questionnaire_personne`
    FOREIGN KEY (`id_createur`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Le questionnaire géré par un formateur => trigger';


-- -----------------------------------------------------
-- Table `siomassy2021`.`canal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`canal` (
  `id_canal` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_canal`),
  UNIQUE INDEX `nom_UNIQUE` (`nom` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`qcm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`qcm` (
  `id_qcm` INT NOT NULL AUTO_INCREMENT,
  `id_questionnaire` INT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_qcm`),
  INDEX `fk_question_questionnaire1_idx` (`id_questionnaire` ASC),
  INDEX `fk_question_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_question_questionnaire1`
    FOREIGN KEY (`id_questionnaire`)
    REFERENCES `siomassy2021`.`questionnaire` (`id_questionnaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_canal1`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`option_qcm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`option_qcm` (
  `id_option` INT NOT NULL AUTO_INCREMENT,
  `id_qcm` INT NOT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  `est_correcte` TINYINT NOT NULL,
  PRIMARY KEY (`id_option`),
  INDEX `fk_option_question1_idx` (`id_qcm` ASC),
  CONSTRAINT `fk_option_question1`
    FOREIGN KEY (`id_qcm`)
    REFERENCES `siomassy2021`.`qcm` (`id_qcm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Réponse possible';


-- -----------------------------------------------------
-- Table `siomassy2021`.`efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`efg` (
  `id_efg` INT NOT NULL AUTO_INCREMENT,
  `cree_a` DATETIME NOT NULL,
  `id_createur` INT(11) NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_efg`),
  INDEX `fk_efg_personne1_idx` (`id_createur` ASC),
  INDEX `fk_efg_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_efg_personne1`
    FOREIGN KEY (`id_createur`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_efg_canal1`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`groupe_efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`groupe_efg` (
  `id_groupe_efg` INT NOT NULL AUTO_INCREMENT,
  `id_efg` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  PRIMARY KEY (`id_groupe_efg`),
  INDEX `fk_groupe_efg_efg1_idx` (`id_efg` ASC),
  INDEX `fk_groupe_efg_personne1_idx` (`id_personne` ASC),
  CONSTRAINT `fk_groupe_efg_efg1`
    FOREIGN KEY (`id_efg`)
    REFERENCES `siomassy2021`.`efg` (`id_efg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_groupe_efg_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Le créateur doit être membre du groupe => trigger after insert et after update met le créateur membre du groupe';


-- -----------------------------------------------------
-- Table `siomassy2021`.`membre_groupe_efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`membre_groupe_efg` (
  `id_personne` INT(11) NOT NULL,
  `id_groupe_efg` INT NOT NULL,
  PRIMARY KEY (`id_personne`, `id_groupe_efg`),
  INDEX `fk_membre_groupe_efg_groupe_efg1_idx` (`id_groupe_efg` ASC),
  CONSTRAINT `fk_membre_groupe_efg_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membre_groupe_efg_groupe_efg1`
    FOREIGN KEY (`id_groupe_efg`)
    REFERENCES `siomassy2021`.`groupe_efg` (`id_groupe_efg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`entrainement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`entrainement` (
  `id_entrainement` INT NOT NULL AUTO_INCREMENT,
  `id_questionnaire` INT NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_entrainement`),
  INDEX `fk_entrainement_questionnaire1_idx` (`id_questionnaire` ASC),
  INDEX `fk_entrainement_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_entrainement_questionnaire1`
    FOREIGN KEY (`id_questionnaire`)
    REFERENCES `siomassy2021`.`questionnaire` (`id_questionnaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrainement_canal1`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`entrainement_etudiant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`entrainement_etudiant` (
  `id_entrainement` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  PRIMARY KEY (`id_entrainement`, `id_personne`),
  INDEX `fk_entrainement_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_entrainement_personne_entrainement1_idx` (`id_entrainement` ASC),
  CONSTRAINT `fk_entrainement_personne_entrainement1`
    FOREIGN KEY (`id_entrainement`)
    REFERENCES `siomassy2021`.`entrainement` (`id_entrainement`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrainement_personne_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`reponse_entrainement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`reponse_entrainement` (
  `id_option` INT NOT NULL,
  `id_entrainement` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  PRIMARY KEY (`id_option`, `id_entrainement`, `id_personne`),
  INDEX `fk_option_entrainement_etudiant_entrainement_etudiant1_idx` (`id_entrainement` ASC, `id_personne` ASC),
  INDEX `fk_option_entrainement_etudiant_option1_idx` (`id_option` ASC),
  CONSTRAINT `fk_option_entrainement_etudiant_option1`
    FOREIGN KEY (`id_option`)
    REFERENCES `siomassy2021`.`option_qcm` (`id_option`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_option_entrainement_etudiant_entrainement_etudiant1`
    FOREIGN KEY (`id_entrainement` , `id_personne`)
    REFERENCES `siomassy2021`.`entrainement_etudiant` (`id_entrainement` , `id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`type_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`type_question` (
  `id_type_question` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_type_question`),
  UNIQUE INDEX `libelle_UNIQUE` (`libelle` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`question` (
  `id_question` INT NOT NULL AUTO_INCREMENT,
  `id_createur` INT(11) NOT NULL,
  `id_canal` INT NOT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  `id_type_question` INT NOT NULL,
  PRIMARY KEY (`id_question`),
  INDEX `fk_question_personne1_idx` (`id_createur` ASC),
  INDEX `fk_question_canal2_idx` (`id_canal` ASC),
  INDEX `fk_question_type_question2_idx` (`id_type_question` ASC),
  CONSTRAINT `fk_question_personne1`
    FOREIGN KEY (`id_createur`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_canal2`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_type_question2`
    FOREIGN KEY (`id_type_question`)
    REFERENCES `siomassy2021`.`type_question` (`id_type_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`option_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`option_question` (
  `id_option_question` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(128) NOT NULL,
  `id_question` INT NOT NULL,
  PRIMARY KEY (`id_option_question`, `id_question`),
  INDEX `fk_option_question_question1_idx` (`id_question` ASC),
  CONSTRAINT `fk_option_question_question1`
    FOREIGN KEY (`id_question`)
    REFERENCES `siomassy2021`.`question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`reponse_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`reponse_question` (
  `id_question` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `libelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_question`, `id_personne`),
  INDEX `fk_question_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_question_personne_question1_idx` (`id_question` ASC),
  CONSTRAINT `fk_question_personne_question1`
    FOREIGN KEY (`id_question`)
    REFERENCES `siomassy2021`.`question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_personne_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`seance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`seance` (
  `id_seance` INT NOT NULL,
  `debute_a` DATETIME NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_seance`),
  INDEX `fk_seance_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_seance_canal1`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`presenace_seance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`presenace_seance` (
  `id_seance` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `niveau_participation` TINYINT NULL COMMENT '0 = pas, 1=peu, 2=beaucoup, null=absent',
  PRIMARY KEY (`id_seance`, `id_personne`),
  INDEX `fk_seance_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_seance_personne_seance1_idx` (`id_seance` ASC),
  CONSTRAINT `fk_seance_personne_seance1`
    FOREIGN KEY (`id_seance`)
    REFERENCES `siomassy2021`.`seance` (`id_seance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seance_personne_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`evaluation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`evaluation` (
  `id_evaluation` INT NOT NULL AUTO_INCREMENT,
  `id_createur` INT(11) NOT NULL,
  `intitulé` VARCHAR(45) NOT NULL,
  `passee_a` DATETIME NOT NULL,
  `duree` TIME NOT NULL,
  PRIMARY KEY (`id_evaluation`),
  INDEX `fk_evaluation_personne1_idx` (`id_createur` ASC),
  CONSTRAINT `fk_evaluation_personne1`
    FOREIGN KEY (`id_createur`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siomassy2021`.`note_evaluation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`note_evaluation` (
  `id_personne` INT(11) NOT NULL,
  `id_evaluation` INT NOT NULL,
  `note` TINYINT NULL,
  PRIMARY KEY (`id_personne`, `id_evaluation`),
  INDEX `fk_personne_evaluation_evaluation1_idx` (`id_evaluation` ASC),
  INDEX `fk_personne_evaluation_personne1_idx` (`id_personne` ASC),
  CONSTRAINT `fk_personne_evaluation_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_evaluation_evaluation1`
    FOREIGN KEY (`id_evaluation`)
    REFERENCES `siomassy2021`.`evaluation` (`id_evaluation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siomassy2021`.`membre_canal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siomassy2021`.`membre_canal` (
  `id_canal` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `ajoute_a` DATETIME NOT NULL,
  PRIMARY KEY (`id_canal`, `id_personne`),
  INDEX `fk_canal_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_canal_personne_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_canal_personne_canal1`
    FOREIGN KEY (`id_canal`)
    REFERENCES `siomassy2021`.`canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_canal_personne_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `siomassy2021`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
