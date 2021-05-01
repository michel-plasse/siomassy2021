DELIMITER $$
DROP PROCEDURE IF EXISTS reset_siomassy2021$$
CREATE PROCEDURE reset_siomassy2021(date_effet DATETIME)
BEGIN
	CALL truncate_all_tables();
  IF date_effet IS NULL THEN
		SET date_effet = NOW();
	END IF;
  BEGIN
    -- Recuperation en cas d'exception (intégrité, syntaxe)
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
      -- Annuler la transaction
      ROLLBACK;
			-- Propager l'exception
      RESIGNAL;
    END;  
    -- Demarrer une transaction : si une erreur se produit,
    -- tout sera annulé
    START TRANSACTION;
    -- 1er groupe : tableaux ne dépendant d'aucun autre
    INSERT INTO canal(id_canal, nom) VALUES
			(1, 'SIO 2021 projet'),
			(2, 'SIO 2021 java'),
			(3, 'CDA 2021');
 
		INSERT INTO personne(id_personne, prenom, nom, email, pwd, tel, est_formateur,
    est_gestionnaire, est_administrateur, url_photo, inscrit_a) VALUES
			-- 2 formateurs
			(1, 'Tryphon', 'Tournesol', 'formateur1@gmail.com', 'azerty', '0601020304', 1,
				0, 0, 'formateur1@gmail.com.jpg', date_effet - INTERVAL 3 MONTH),
			(2, 'Bianca', 'Castafiore', 'formateur2@gmail.com', 'azerty', '0611121314', 1,
				0, 0, 'formateur2@gmail.com.jpg', date_effet - INTERVAL 3 MONTH),
			-- 5 etudiants
			(3, 'Manuel', 'Rivière', 'etudiant1@gmail.com', 'azerty', '0621222324', 0,
				0, 0, 'etudiant1@gmail.com.jpg', date_effet - INTERVAL 2 MONTH),
			(4, 'Marguerite', 'Moulin', 'etudiant2@gmail.com', 'azerty', '0631323334', 0,
				0, 0, 'etudiant2@gmail.com.jpg', date_effet - INTERVAL 2 MONTH),
			(5, 'Nadia', 'Lupin', 'etudiant3@gmail.com', 'azerty', '0631323334', 0,
				0, 0, 'etudiant3@gmail.com.jpg', date_effet - INTERVAL 1 MONTH - INTERVAL 15 DAY),
			(6, 'Marguerite', 'Gatot', 'etudiant4@gmail.com', 'azerty', '0641424344', 0,
				0, 0, 'etudiant4@gmail.com.jpg', date_effet - INTERVAL 1 MONTH - INTERVAL 15 DAY),
			(7, 'Karim', 'Malingua', 'etudiant5@gmail.com', 'azerty', '0651525354', 0,
				0, 0, 'etudiant5@gmail.com.jpg', date_effet - INTERVAL 1 MONTH - INTERVAL 15 DAY);
		INSERT INTO type_question(id_type_question, libelle) VALUES
			(1, 'oui/non'),
      (2, 'options multiples'),
      (3, 'réponse libre');
      
		-- Tableaux ne dépendant que du 1er groupe
		INSERT INTO	efg(id_efg, intitule, cree_a, id_createur, id_canal) VALUES
    -- 2 dans le canal 1 + 1 dans le canal 2, tous du formateur 1
			(1, 'TP définir objectif', date_effet - INTERVAL 1 MONTH, 1, 1),
      (2, 'TP cadrage', date_effet - INTERVAL 1 MONTH, 1, 1),
      (3, "TP tests d'acceptation", date_effet - INTERVAL 1 MONTH, 1, 2);
		INSERT INTO evaluation(id_evaluation, intitule, id_createur, id_canal, 
		passee_a, duree, est_corrigee) VALUES
			-- 1 corrigée
			(1, 'Evaluation 1', 1, 1, date_effet - INTERVAL 1 MONTH, '02:00:00', 1),
      -- 1 passée mais pas corrigée
			(2, 'Evaluation 2', 1, 1, date_effet - INTERVAL 15 DAY, '01:30:00', 0),
      -- 1 planifiée
      (3, 'Evaluation 3', 1, 1, date_effet + INTERVAL 1 DAY, '01:00:00', 0);
		INSERT INTO question(id_question, libelle, id_canal, id_createur, 
    id_type_question) VALUES
			-- 1 de chaque type
			(1, 'Avez-vous fini ?', 1, 1, 1), -- oui/non
			(2, 'Combien de temps voulez-vous pour ce TP ?', 1, 1, 2), -- plusieurs choix 
			(3, 'Donnez un exemple de classe abstraite', 1, 1, 3); -- libre
		INSERT INTO membre_canal(id_canal, id_personne, ajoute_a) VALUES
			-- les 2 formateurs dans canal 1
      (1, 1, date_effet - INTERVAL 2 MONTH),
			(1, 2, date_effet - INTERVAL 2 MONTH),
      -- tous les étudiants dans canal 1
			(1, 3, date_effet - INTERVAL 1 MONTH),
			(1, 4, date_effet - INTERVAL 1 MONTH),
			(1, 5, date_effet - INTERVAL 1 MONTH),
			(1, 6, date_effet - INTERVAL 1 MONTH),
			(1, 7, date_effet - INTERVAL 1 MONTH),
      -- canal 2
			(2, 1, date_effet - INTERVAL 2 MONTH),
			(2, 3, date_effet - INTERVAL 1 MONTH),
			(2, 4, date_effet - INTERVAL 1 MONTH),
			(2, 5, date_effet - INTERVAL 1 MONTH);
		INSERT INTO questionnaire(id_questionnaire, id_createur, libelle) VALUES
			(1, 1, 'Bases de Java'),
      (2, 1, 'Fruits et légumes');
		INSERT INTO seance(id_seance, debute_a, id_canal) VALUES
			(1, DATE(date_effet) - INTERVAL 1 MONTH + INTERVAL 9 HOUR, 1),
			(2, DATE(date_effet) - INTERVAL 20 DAY + INTERVAL 9 HOUR, 1),
			(3, DATE(date_effet) - INTERVAL 10 DAY + INTERVAL 9 HOUR, 1),
			(4, DATE(date_effet) + INTERVAL 9 HOUR, 1);

		-- tableaux ne dépendant que des groupes 1 et 2
    INSERT INTO entrainement(id_entrainement, id_questionnaire, id_canal) VALUES
			-- 2 entrainements
      (1, 1, 1),
      (2, 1, 1);
		INSERT INTO groupe_efg(id_efg, id_groupe) VALUES
			-- 2 groupes par efg, avec 2 membres dans chaque (voir plus loin)
      (1, 1),
      (1, 2),
      (2, 1),
      (2, 2);
		INSERT INTO note_evaluation(id_etudiant, id_evaluation, note) VALUES
			-- 1 seule est corrigée
      (3, 1, 12),
      (4, 1, 14),
      (5, 1, 8),
      (6, 1, 16),
      (7, 1, 13);
		INSERT INTO option_question(id_option_question, id_question, libelle) VALUES
			(1, 2, '1/2h'),
      (2, 2, '1h'),
      (3, 2, '1h30');
		INSERT INTO presence_seance(id_seance, id_personne, niveau_participation) VALUES
			-- 3 séances passées, la 4e en cours
			(1, 3, NULL),
      (1, 4, 0),
      (1, 5, 1),
      (1, 6, 2),
      (1, 7, 1),
      -- 2e séance
      (2, 3, 2),
      (2, 4, 1),
      (2, 5, 2),
      (2, 6, 1),
      (2, 7, NULL),
      -- 3e
      (3, 3, 2),
      (3, 4, 1),
      (3, 5, 1),
      (3, 6, 2),
      (3, 7, 2),
      -- séance courante : personne n'a signalé sa présence
      (4, 3, NULL),
      (4, 4, NULL),
      (4, 5, NULL),
      (4, 6, NULL),
      (4, 7, NULL);
		INSERT INTO qcm(id_qcm, id_questionnaire, libelle, id_canal) VALUES
			-- 2 questions dans les 2 questionnaires (1= Java, 2=fruits et légumes)
      (1, 1, "Chassez l'intrus", 1), -- portée
      (2, 1, 'Que vaut s, avec String s = "0" + 1 ?', 1),
      (3, 2, "Quel fruit est un fruit d'hiver ?", 1),
      (4, 2, "Quel légume est le plus riche en vitamine C ?", 1);
		INSERT INTO reponse_question(id_question, id_personne, libelle) VALUES
			-- question 1 avez-vous fini
      (1, 3, 1),
      (1, 4, 1),
      (1, 5, 0),
      (1, 6, 1),
      (1, 7, 0),
			-- question 2 Combien de temps voulez-vous pour ce TP (choix de 1 à 3)
      (2, 3, 1),
      (2, 4, 2),
      (2, 5, 2),
      (2, 6, 3),
      (2, 7, 2),
      -- question 3 Donnez un exemple de classe abstraite
      (3, 3, 'java.util.List'),
      (3, 4, 'ArrayList'),
      (3, 5, 'java.sql.Connection'),
      (3, 6, 'je sais pas');
      -- 7e étudiant ne donne pas de réponse
		
    -- tableaux dépendant de tableaux des groupes 1, 2 ou 3
    INSERT INTO entrainement_etudiant(id_entrainement, id_etudiant) VALUES
			-- entrainement 1 sur le questionnaire 1, étudiants 3 à 6
      (1, 3),
      (1, 4),
      (1, 5),
      (1, 6),
      -- entrainement 2 sur questionnaire 1, étudiants 4, 5 et 7
      (2, 4),
      (2, 5),
      (2, 7);
		INSERT INTO membre_groupe_efg(id_personne, id_efg, id_groupe) VALUES
			-- 2 groupes par efg, avec 2 membres dans chaque
			(3, 1, 1),
      (4, 1, 1),
      (5, 1, 2),
      (6, 1, 2),
      (7, 1, 2),
      -- 2e efg, avec un membre pas en groupe, et des groupes différents
      (3, 2, 1),
      (4, 2, 2),
      (5, 2, 1),
      (6, 2, 2);
		INSERT INTO option_qcm(id_option_qcm, id_qcm, libelle, est_correcte) VALUES
			-- 2 questions dans les 2 questionnaires (1= Java, 2=fruits et légumes)
      (1, 1, 'private', 0), -- portée
      (2, 1, 'protege', 1),
      (3, 1, 'public', 0),
      (4, 2, '1', 0), -- Que vaut s, avec String s = "0" + 1 ?'
      (5, 2, '01', 1),
      (6, 2, 'erreur', 0),
      (7, 3, 'kaki', 1), -- Quel fruit est un fruit d'hiver ?
      (8, 3, 'melon', 0),
      (9, 3, 'orange', 1),
      (10, 4, 'chou', 1), -- Quel légume est le plus riche en vitamine C ?
      (11, 4, 'carotte', 0),
      (12, 4, 'epinard', 0);
		
    -- Dernier groupe, dépendant de tous les précédents
    INSERT INTO reponse_entrainement(id_entrainement, id_personne, id_option_qcm) VALUES
			-- entrainement 1 sur le questionnaire 1 (étudiants 3 à 6)
      -- etudiant 3 : tout ok
      (1, 3, 2),
      (1, 3, 5),
      (1, 3, 7),
      (1, 3, 9),
      (1, 3, 10),
      -- étudiant 4
      (1, 4, 1),
      (1, 4, 4),
      (1, 4, 9),
      (1, 4, 12),
      -- etudiant 5
      (1, 5, 2),
      (1, 5, 5),
      (1, 5, 7),
      (1, 5, 10),
      -- etudiant 6
      (1, 6, 1),
      (1, 6, 4),
      (1, 6, 7),
      (1, 6, 9),
      -- pas de réponse à la dernière question
      -- entrainement 2 sur questionnaire 1 (étudiants 4, 5, 7)
      -- etudiant 4 a corrigé toutes ses erreurs du 1er passage
      (2, 4, 2),
      (2, 4, 5),
      (2, 4, 7),
      (2, 4, 9),
      (2, 4, 12),
      -- etudiant 5 fait les mêmes réponses que 1ere fois
			(2, 5, 2),
      (2, 5, 5),
      (2, 5, 7),
      (2, 5, 10),
      -- etudiant 7 une erreur
      (2, 7, 2),
      (2, 7, 5),
      (2, 7, 7),
      (2, 7, 9),
      (2, 7, 11);
      
      -- Valider tout
      COMMIT;
	END;
END$$

DROP PROCEDURE IF EXISTS reset_to_now$$
CREATE PROCEDURE reset_to_now()
BEGIN
  CALL reset_siomassy2021(NOW());
END$$

CALL reset_to_now()$$
