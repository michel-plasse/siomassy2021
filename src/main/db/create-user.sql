CREATE USER IF NOT EXISTS siomassy2021_user@localhost IDENTIFIED BY 'siomassy2021_pwd';
GRANT ALL ON siomassy2021.* TO siomassy2021_user@localhost;
GRANT EXECUTE ON siomassy2021.* TO siomassy2021_user@localhost;
-- si l'instruction précédente échoue, lancer :
-- GRANT SELECT ON mysql.proc TO siomassy2021_user@localhost;
