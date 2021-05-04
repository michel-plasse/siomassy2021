USE `siomassy2021` ;

-- -----------------------------------------------------
-- Table `personne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `personne` (
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
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `questionnaire` (
  `id_questionnaire` INT NOT NULL AUTO_INCREMENT,
  `id_createur` INT(11) NOT NULL,
  `libelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_questionnaire`),
  INDEX `fk_questionnaire_personne_idx` (`id_createur` ASC),
  CONSTRAINT `fk_questionnaire_personne`
    FOREIGN KEY (`id_createur`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Le questionnaire géré par un formateur => trigger';


-- -----------------------------------------------------
-- Table `canal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `canal` (
  `id_canal` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_canal`),
  UNIQUE INDEX `nom_UNIQUE` (`nom` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qcm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qcm` (
  `id_qcm` INT NOT NULL AUTO_INCREMENT,
  `id_questionnaire` INT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_qcm`),
  INDEX `fk_qcm_questionnaire_idx` (`id_questionnaire` ASC),
  INDEX `fk_qcm_canal_idx` (`id_canal` ASC),
  CONSTRAINT `fk_qcm_questionnaire`
    FOREIGN KEY (`id_questionnaire`)
    REFERENCES `questionnaire` (`id_questionnaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qcm_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `option_qcm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `option_qcm` (
  `id_option_qcm` INT NOT NULL AUTO_INCREMENT,
  `id_qcm` INT NOT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  `est_correcte` TINYINT NOT NULL,
  PRIMARY KEY (`id_option_qcm`),
  INDEX `fk_option_question1_idx` (`id_qcm` ASC),
  CONSTRAINT `fk_option_question`
    FOREIGN KEY (`id_qcm`)
    REFERENCES `qcm` (`id_qcm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Réponse possible';


-- -----------------------------------------------------
-- Table `efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efg` (
  `id_efg` INT NOT NULL AUTO_INCREMENT,
  `intitule` VARCHAR(45) NULL,
  `cree_a` DATETIME NOT NULL,
  `id_createur` INT(11) NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_efg`),
  INDEX `fk_efg_personne1_idx` (`id_createur` ASC),
  INDEX `fk_efg_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_efg_personne`
    FOREIGN KEY (`id_createur`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_efg_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupe_efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupe_efg` (
  `id_efg` INT NOT NULL,
  `id_groupe` INT NOT NULL AUTO_INCREMENT COMMENT 'N° du groupe dans le EFG',
  PRIMARY KEY (`id_groupe`, `id_efg`),
  INDEX `fk_groupe_efg_efg_idx` (`id_efg` ASC),
  CONSTRAINT `fk_groupe_efg_efg`
    FOREIGN KEY (`id_efg`)
    REFERENCES `efg` (`id_efg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entrainement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entrainement` (
  `id_entrainement` INT NOT NULL AUTO_INCREMENT,
  `id_questionnaire` INT NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_entrainement`),
  INDEX `fk_entrainement_questionnaire1_idx` (`id_questionnaire` ASC),
  INDEX `fk_entrainement_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_entrainement_questionnaire`
    FOREIGN KEY (`id_questionnaire`)
    REFERENCES `questionnaire` (`id_questionnaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrainement_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entrainement_etudiant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entrainement_etudiant` (
  `id_entrainement` INT NOT NULL,
  `id_etudiant` INT(11) NOT NULL,
  PRIMARY KEY (`id_entrainement`, `id_etudiant`),
  INDEX `fk_entrainement_personne_personne1_idx` (`id_etudiant` ASC),
  INDEX `fk_entrainement_personne_entrainement1_idx` (`id_entrainement` ASC),
  CONSTRAINT `fk_entrainement_personne_entrainement`
    FOREIGN KEY (`id_entrainement`)
    REFERENCES `entrainement` (`id_entrainement`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrainement_personne_personne`
    FOREIGN KEY (`id_etudiant`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reponse_entrainement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reponse_entrainement` (
  `id_entrainement` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `id_option_qcm` INT NOT NULL,
  PRIMARY KEY (`id_entrainement`, `id_personne`, `id_option_qcm`),
  INDEX `fk_option_entrainement_etudiant_entrainement_etudiant1_idx` (`id_entrainement` ASC, `id_personne` ASC),
  INDEX `fk_option_entrainement_etudiant_option1_idx` (`id_option_qcm` ASC),
  CONSTRAINT `fk_reponse_entrainement_option_qcm`
    FOREIGN KEY (`id_option_qcm`)
    REFERENCES `option_qcm` (`id_option_qcm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reponse_entrainement_entrainement_etudiant`
    FOREIGN KEY (`id_entrainement` , `id_personne`)
    REFERENCES `entrainement_etudiant` (`id_entrainement` , `id_etudiant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `type_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `type_question` (
  `id_type_question` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_type_question`),
  UNIQUE INDEX `libelle_UNIQUE` (`libelle` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question` (
  `id_question` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(128) NOT NULL,
  `id_canal` INT NOT NULL,
  `id_createur` INT NOT NULL,
  `id_type_question` INT NOT NULL,
  PRIMARY KEY (`id_question`),
  INDEX `fk_question_personne_idx` (`id_createur` ASC),
  INDEX `fk_question_canal_idx` (`id_canal` ASC),
  INDEX `fk_question_type_question_idx` (`id_type_question` ASC),
  CONSTRAINT `fk_question_personne`
    FOREIGN KEY (`id_createur`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_type_question`
    FOREIGN KEY (`id_type_question`)
    REFERENCES `type_question` (`id_type_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `option_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `option_question` (
  `id_option_question` INT NOT NULL AUTO_INCREMENT,
  `id_question` INT NOT NULL,
  `libelle` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id_option_question`, `id_question`),
  INDEX `fk_option_question_question1_idx` (`id_question` ASC),
  CONSTRAINT `fk_option_question_question`
    FOREIGN KEY (`id_question`)
    REFERENCES `question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reponse_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reponse_question` (
  `id_question` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `libelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_question`, `id_personne`),
  INDEX `fk_reponse_quesion_personne_idx` (`id_personne` ASC),
  INDEX `fk_reponse_question_question_idx` (`id_question` ASC),
  CONSTRAINT `fk_reponse_question_question`
    FOREIGN KEY (`id_question`)
    REFERENCES `question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reponse_question_personne`
    FOREIGN KEY (`id_personne`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seance` (
  `id_seance` INT NOT NULL,
  `debute_a` DATETIME NOT NULL,
  `id_canal` INT NOT NULL,
  PRIMARY KEY (`id_seance`),
  INDEX `fk_seance_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_seance_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `presence_seance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `presence_seance` (
  `id_seance` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `niveau_participation` TINYINT NULL COMMENT '0 = pas, 1=peu, 2=beaucoup, null=absent',
  PRIMARY KEY (`id_seance`, `id_personne`),
  INDEX `fk_seance_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_seance_personne_seance1_idx` (`id_seance` ASC),
  CONSTRAINT `fk_presence_seance_seance`
    FOREIGN KEY (`id_seance`)
    REFERENCES `seance` (`id_seance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_presence_seance_personne`
    FOREIGN KEY (`id_personne`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `evaluation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` INT NOT NULL AUTO_INCREMENT,
  `intitule` VARCHAR(45) NOT NULL,
  `id_createur` INT(11) NOT NULL,
  `id_canal` INT NOT NULL,
  `passee_a` DATETIME NOT NULL,
  `duree` TIME NOT NULL,
  `est_corrigee` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_evaluation`),
  INDEX `fk_evaluation_personne_idx` (`id_createur` ASC),
  INDEX `fk_evaluation_canal_idx` (`id_canal` ASC),
  CONSTRAINT `fk_evaluation_personne`
    FOREIGN KEY (`id_createur`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluation_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `note_evaluation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `note_evaluation` (
  `id_etudiant` INT(11) NOT NULL,
  `id_evaluation` INT NOT NULL,
  `note` TINYINT NULL,
  PRIMARY KEY (`id_etudiant`, `id_evaluation`),
  INDEX `fk_personne_evaluation_evaluation1_idx` (`id_evaluation` ASC),
  INDEX `fk_personne_evaluation_personne1_idx` (`id_etudiant` ASC),
  CONSTRAINT `fk_note_evaluation_personne`
    FOREIGN KEY (`id_etudiant`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_note_evaluation_evaluation`
    FOREIGN KEY (`id_evaluation`)
    REFERENCES `evaluation` (`id_evaluation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `membre_canal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `membre_canal` (
  `id_canal` INT NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `ajoute_a` DATETIME NOT NULL,
  PRIMARY KEY (`id_canal`, `id_personne`),
  INDEX `fk_canal_personne_personne1_idx` (`id_personne` ASC),
  INDEX `fk_canal_personne_canal1_idx` (`id_canal` ASC),
  CONSTRAINT `fk_membre_canal_canal`
    FOREIGN KEY (`id_canal`)
    REFERENCES `canal` (`id_canal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membre_canal_personne`
    FOREIGN KEY (`id_personne`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `membre_groupe_efg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `membre_groupe_efg` (
  `id_personne` INT(11) NOT NULL,
  `id_efg` INT NOT NULL,
  `id_groupe` INT NOT NULL,
  PRIMARY KEY (`id_personne`, `id_efg`, `id_groupe`),
  INDEX `fk_personne_groupe_efg_groupe_efg1_idx` (`id_groupe` ASC, `id_efg` ASC),
  INDEX `fk_personne_groupe_efg_personne1_idx` (`id_personne` ASC),
  CONSTRAINT `fk_membre_groupe_efg_personne`
    FOREIGN KEY (`id_personne`)
    REFERENCES `personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membre_groupe_efg_groupe_efg`
    FOREIGN KEY (`id_groupe` , `id_efg`)
    REFERENCES `groupe_efg` (`id_groupe` , `id_efg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
