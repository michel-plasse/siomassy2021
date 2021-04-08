CREATE USER IF NOT EXISTS siomassy2021_user@localhost IDENTIFIED BY 'siomassy2021_pwd';
GRANT ALL ON siomassy2021.* TO siomassy2021_user@localhost;
GRANT SELECT ON mysql.proc TO siomassy2021_user@localhost;
GRANT EXECUTE ON PROCEDURE siomassy2021.siomassy2021_reset TO siomassy2021_user@localhost;
