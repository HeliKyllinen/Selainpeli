SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS game_session;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS game_session_seq;
DROP TABLE IF EXISTS image_seq;
DROP TABLE IF EXISTS user_seq;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    create_date DATE NOT NULL,
    PRIMARY KEY (user_id),
);

CREATE TABLE image (
    image_id BIGINT NOT NULL AUTO_INCREMENT,
    image_url VARCHAR(550) NOT NULL,
    search_query VARCHAR(50) NOT NULL,
    PRIMARY KEY (image_id)
);

CREATE TABLE game_session (
    game_session_id BIGINT NOT NULL AUTO_INCREMENT,
    status VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (game_session_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
);

CREATE SEQUENCE game_session_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE user_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE image_seq START WITH 3 INCREMENT BY 1;

INSERT INTO user (username, password, email, create_date) VALUES
('maija', 'root', 'maijameikalainen@gmail.com', '2024-09-16'),
('matti', 'root', 'mattimeikalainen@gmail.com', '2024-09-17');

INSERT INTO game_session (status, user_id) VALUES
('online', 1),
('offline', 2);

INSERT INTO image(image_url, search_query) VALUES
('https://cdn.pixabay.com/photo/2022/11/02/14/47/bird-7565103_960_720.jpg', 'Tarkkaileva lintu'),
('https://cdn.pixabay.com/photo/2024/08/18/14/34/folkstone-8978132_960_720.jpg', 'Veneitä satamassa');

SELECT * FROM game_session;
SELECT * FROM user;
SELECT * FROM image;
