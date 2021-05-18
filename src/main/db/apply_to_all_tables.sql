DELIMITER $$

DROP PROCEDURE IF EXISTS apply_to_all_tables$$
CREATE PROCEDURE apply_to_all_tables(p_prefix VARCHAR(45), p_suffix VARCHAR(128))
BEGIN
	-- to exit the cursor loop
	DECLARE v_ended BOOLEAN DEFAULT FALSE;
  -- sql statement for each table
	DECLARE v_sql VARCHAR(64);
  -- truncate statements (one for each table)
  DECLARE v_stmts CURSOR FOR 
		SELECT concat(p_prefix, ' ', table_name, ' ', p_suffix)
		FROM information_schema.tables	
		WHERE table_schema = DATABASE()
    ORDER BY table_name ASC;  
	-- truncate or drop require disabling referential integrity constraints
	SET FOREIGN_KEY_CHECKS = 0;
  OPEN v_stmts;
  BEGIN
    DECLARE EXIT HANDLER FOR NOT FOUND SET v_ended = TRUE;
    REPEAT
      FETCH v_stmts INTO v_sql;
      -- Need to use a user-defined variable
      SET @sql = v_sql;
      -- 3 statements to execute the truncate statement!
      PREPARE v_stmt FROM @sql;
      EXECUTE v_stmt;
			DEALLOCATE PREPARE v_stmt;
		UNTIL v_ended END REPEAT; 
  END;
  CLOSE v_stmts;
  -- Enabling again the referential integrity constraints
	SET FOREIGN_KEY_CHECKS = 0;
  -- SELECT 'All tables of current schema truncated' AS log;
END$$

DROP PROCEDURE IF EXISTS truncate_all_tables$$
CREATE PROCEDURE truncate_all_tables()
BEGIN
	CALL apply_to_all_tables('TRUNCATE TABLE', '');
END$$

DROP PROCEDURE IF EXISTS drop_all_tables$$
CREATE PROCEDURE drop_all_tables()
BEGIN
	CALL apply_to_all_tables('DROP TABLE', '');
END$$

DROP PROCEDURE IF EXISTS reset_auto_increment_all_tables$$
CREATE PROCEDURE reset_auto_increment_all_tables()
BEGIN
	CALL apply_to_all_tables('ALTER TABLE', 'AUTO_INCREMENT 1');
END$$

CALL drop_all_tables()$$
