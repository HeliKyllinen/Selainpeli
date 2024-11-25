SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS game_session;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS game_session_seq;
DROP TABLE IF EXISTS user_seq;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(61) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    create_date DATE NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE game_session (
    game_session_id BIGINT NOT NULL AUTO_INCREMENT,
    status VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    game_id BIGINT NOT NULL,
    PRIMARY KEY (game_session_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE SEQUENCE game_session_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE user_seq START WITH 3 INCREMENT BY 1;

INSERT INTO user (username, password, email, role, create_date) VALUES
('maija', '$2a$10$bHuGnxspXWIfAebaoq9Mw.VES7LCSp2M2.VKPbfjqFdbPIKW0h3lO', 'maijameikalainen@gmail.com', 'ADMIN', '2024-09-16'), 
('matti', '$2a$10$FvuYuTcfWMlwua1U0blhVOufUgvCB1QvmpqCNQlw5sB5zeRV5LtQK', 'mattimeikalainen@gmail.com', 'USER', '2024-09-17');

INSERT INTO game_session (status, user_id, game_id) VALUES
('online', 1, 1),
('offline', 2, 2);

SELECT * FROM game_session;
SELECT * FROM user;

SELECT username, password FROM user;