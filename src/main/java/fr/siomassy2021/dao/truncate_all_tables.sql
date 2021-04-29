DELIMITER $$
DROP PROCEDURE IF EXISTS truncate_all_tables$$
CREATE PROCEDURE truncate_all_tables()
BEGIN
	-- to exit the cursor loop
	DECLARE v_ended BOOLEAN DEFAULT FALSE;
  -- sql statement for each table
	DECLARE v_sql VARCHAR(64);
  -- truncate statements (one for each table)
  DECLARE v_truncates CURSOR FOR 
		SELECT concat('TRUNCATE TABLE ', table_name)
		FROM information_schema.tables	
		WHERE table_schema = DATABASE()
    ORDER BY table_name ASC;  
	-- truncate require disabling referential integrity constraints
	SET FOREIGN_KEY_CHECKS = 0;
  OPEN v_truncates;
  BEGIN
    DECLARE EXIT HANDLER FOR NOT FOUND SET v_ended = TRUE;
    REPEAT
      FETCH v_truncates INTO v_sql;
      -- Need to use a user-defined variable
      SET @sql = v_sql;
      -- 3 statements to execute the truncate statement!
      PREPARE v_stmt FROM @sql;
      EXECUTE v_stmt;
			DEALLOCATE PREPARE v_stmt;
		UNTIL v_ended END REPEAT; 
  END;
  CLOSE v_truncates;
  -- Enabling again the referential integrity constraints
	SET FOREIGN_KEY_CHECKS = 0;
  -- SELECT 'All tables of current schema truncated' AS log;
END$$

CALL truncate_all_tables()$$
