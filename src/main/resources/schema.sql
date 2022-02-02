DROP TABLE IF EXISTS player_promotion;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS transaction_type;
DROP TABLE IF EXISTS promotions;
-- DROP PROCEDURE IF EXISTS get_lastx_transactions_by_type;

CREATE TABLE player (
	pid INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL,
	name VARCHAR(255) NULL,
	surname VARCHAR(255) NULL,
	balance BIGINT NOT NULL
);

ALTER TABLE player
ADD CONSTRAINT pk_player
PRIMARY KEY (pid);

ALTER TABLE player
ADD CONSTRAINT unique_player_username UNIQUE (username);

----------------------------------------------------------------------------------------------------------------

CREATE TABLE transaction_type (
	ttid INT NOT NULL AUTO_INCREMENT,
	tname VARCHAR(255) NOT NULL
);

ALTER TABLE transaction_type
ADD CONSTRAINT pk_transaction_type
PRIMARY KEY (ttid);

ALTER TABLE transaction_type
ADD CONSTRAINT unique_transaction_type UNIQUE (tname);

----------------------------------------------------------------------------------------------------------------

CREATE TABLE transactions (
	tid INT NOT NULL, -- Transaction Id
	pid INT NOT NULL, -- Player Id
	tdate datetime NOT NULL,
	ttid INT NOT NULL, -- Transaction Type Id
	amount BIGINT NULL
);

ALTER TABLE transactions
ADD CONSTRAINT pk_transactions
PRIMARY KEY (tid);

ALTER TABLE transactions
ADD CONSTRAINT fk_transactions_player_id
FOREIGN KEY (pid) REFERENCES player(pid);

ALTER TABLE transactions
ADD CONSTRAINT fk_transactions_transaction_type_id
FOREIGN KEY (ttid) REFERENCES transaction_type(ttid);

----------------------------------------------------------------------------------------------------------------

CREATE TABLE promotions (
	pid INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(255) NOT NULL,
	applicaton_limit INT NOT NULL,
	amount BIGINT NULL
);

ALTER TABLE promotions
ADD CONSTRAINT pk_promotions
PRIMARY KEY (pid);

----------------------------------------------------------------------------------------------------------------

CREATE TABLE player_promotion (
	player_id INT NOT NULL,
	promotion_id INT NOT NULL,
	promotion_date datetime NOT NULL,
	remaining_applications INT NOT NULL
);

ALTER TABLE player_promotion
ADD CONSTRAINT pk_player_promotion
PRIMARY KEY (player_id, promotion_id, promotion_date);

ALTER TABLE player_promotion
ADD CONSTRAINT fk_player_promotion_player_id
FOREIGN KEY (player_id) REFERENCES player(pid);

ALTER TABLE player_promotion
ADD CONSTRAINT fk_player_promotion_promotion_id
FOREIGN KEY (promotion_id) REFERENCES promotions(pid);

----------------------------------------------------------------------------------------------------------------


-- CREATE PROCEDURE get_lastx_transactions_by_type (
-- IN in_pid INT,
-- IN in_ttid INT)
-- BEGIN
-- 	SELECT * FROM transactions WHERE pid = in_pid AND in_ttid;
-- END
