CREATE VIEW stat_sur_reponses AS
SELECT t1.*, nb_etudiants, nb_reponses_total, nb_etudiants-nb_reponses_total As nb_non_reponse
FROM
(
    SELECT q.id_canal, q.id_question, q.libelle, rq.libelle AS reponse,
        COUNT(rq.id_question) AS nb_reponses
    FROM 
        question q
            LEFT OUTER JOIN 
        reponse_question rq ON q.id_question= rq.id_question
    GROUP BY q.id_canal, q.id_question, q.libelle, reponse
) t1
    INNER JOIN
(
    SELECT mc.id_canal, COUNT(DISTINCT p.id_personne) AS nb_etudiants
    FROM
        membre_canal mc
            INNER JOIN
        personne p ON mc.id_personne = p.id_personne
    WHERE p.est_formateur=0 AND p.est_administrateur=0
  GROUP BY mc.id_canal
) t2 ON t1.id_canal = t2.id_canal
    LEFT OUTER JOIN
(
    SELECT q.id_canal, rq.id_question, COUNT(DISTINCT rq.id_personne) AS nb_reponses_total
  FROM 
        reponse_question rq
            INNER JOIN
        question q
  GROUP BY q.id_canal, rq.id_question
) t3 ON t1.id_question = t3.id_question AND t2.id_canal = t3.id_canal;