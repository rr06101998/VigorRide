CREATE TABLE `sequences` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sequence_name` varchar(50) NOT NULL,
  `increment_by` int unsigned NOT NULL DEFAULT '1',
  `min_value` int unsigned NOT NULL DEFAULT '1',
  `max_value` bigint unsigned NOT NULL DEFAULT '999999999',
  `cur_value` bigint unsigned NOT NULL DEFAULT '1',
  `is_reset_daily` tinyint(1) NOT NULL DEFAULT '0',
  `sequence_date` date DEFAULT NULL,
  `description` TEXT DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sequence_config` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sequence_type` varchar(50) NOT NULL,
  `config` TEXT DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY (`sequence_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DELIMITER //
CREATE FUNCTION generate_next_sequence(seq_name VARCHAR(50))
RETURNS BIGINT(20) DETERMINISTIC
BEGIN
    DECLARE overflow_flag TINYINT(1);
    DECLARE cur_val BIGINT(20);
    DECLARE step_val INT(12);
    DECLARE min_val BIGINT(20);
    DECLARE new_val BIGINT(20);

    SELECT
        cur_value, increment_by, min_value,
        IF (
            (is_reset_daily = 1 AND CURRENT_DATE() <> sequence_date)
            OR (cur_value + increment_by > max_value), 1, 0
        ) INTO cur_val, step_val, min_val, overflow_flag
    FROM
        sequences
    WHERE
        sequence_name = seq_name
    FOR UPDATE;

    IF overflow_flag = 1 THEN
        SET new_val = min_val;
    ELSE
        SET new_val = cur_val + step_val;
    END IF;

    UPDATE sequences SET cur_value = new_val, sequence_date = CURRENT_DATE() WHERE sequence_name = seq_name;

    RETURN new_val;
END;
//
DELIMITER ;

    

