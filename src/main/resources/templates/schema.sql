SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS game_session;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS piece;
DROP TABLE IF EXISTS puzzle;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS game_seq;
DROP TABLE IF EXISTS game_session_seq;
DROP TABLE IF EXISTS image_seq;
DROP TABLE IF EXISTS piece_seq;
DROP TABLE IF EXISTS puzzle_seq;
DROP TABLE IF EXISTS role_seq;
DROP TABLE IF EXISTS user_seq;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE game (
    game_id BIGINT NOT NULL AUTO_INCREMENT,
    game_name VARCHAR(150) NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (game_id)
);

CREATE TABLE role (
    role_id BIGINT NOT NULL AUTO_INCREMENT,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    create_date DATE NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE image (
    image_id BIGINT NOT NULL AUTO_INCREMENT,
    image_url VARCHAR(550) NOT NULL,
    description VARCHAR(500) NOT NULL,
    create_date DATE NOT NULL,
    PRIMARY KEY (image_id)
);

CREATE TABLE game_session (
    game_session_id BIGINT NOT NULL AUTO_INCREMENT,
    status VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    game_id BIGINT NOT NULL,
    PRIMARY KEY (game_session_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (game_id) REFERENCES game(game_id)
);

CREATE TABLE puzzle (
    puzzle_id BIGINT NOT NULL AUTO_INCREMENT,
    piece_count INTEGER NOT NULL,
    create_date DATE NOT NULL,
    image_id BIGINT NOT NULL,
    game_session_id BIGINT NOT NULL,
    PRIMARY KEY (puzzle_id),
    FOREIGN KEY (image_id) REFERENCES image(image_id),
    FOREIGN KEY (game_session_id) REFERENCES game_session(game_session_id)
);

 CREATE TABLE piece (
    piece_id BIGINT NOT NULL AUTO_INCREMENT,
    position_x INTEGER NOT NULL,
    position_y INTEGER NOT NULL,
    current_pos_x INTEGER NOT NULL,
    current_pos_y INTEGER NOT NULL,
    puzzle_id BIGINT NOT NULL,
    PRIMARY KEY (piece_id),
    FOREIGN KEY (puzzle_id) REFERENCES puzzle(puzzle_id)
 );

CREATE SEQUENCE game_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE game_session_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE puzzle_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE user_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE role_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE image_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE piece_seq START WITH 3 INCREMENT BY 1;

INSERT INTO role(role) VALUES
('placeholder1'),
('placeholder2');

INSERT INTO user (username, password, email, create_date, role_id) VALUES
('maija', 'root', 'maijameikalainen@gmail.com', '2024-09-16', 2),
('matti', 'root', 'mattimeikalainen@gmail.com', '2024-09-17', 1);

INSERT INTO game (game_name, description) VALUES
('Puzzle', 'Pelaa meidän uniikkia palapeliä, jossa tekoäly luo juuri sinun haluamiasi kuvia'),
('Tetris', 'Klassikkopeli, ehkä mielenkiintoisempi versio');

INSERT INTO game_session (status, user_id, game_id) VALUES
('online', 1, 1),
('offline', 2, 2);

INSERT INTO image(image_url, description, create_date) VALUES
('https://cdn.pixabay.com/photo/2022/11/02/14/47/bird-7565103_960_720.jpg', 'Tarkkaileva lintu', '2022-11-03'),
('https://cdn.pixabay.com/photo/2024/08/18/14/34/folkstone-8978132_960_720.jpg', 'Veneitä satamassa', '2024-08-20');

INSERT INTO puzzle (piece_count, create_date, game_session_id, image_id) VALUES
(36, '2024-09-16', 1, 2),
(49, '2024-09-17', 1, 1);

INSERT INTO piece(position_x, position_y, current_pos_x, current_pos_y, puzzle_id) VALUES
(1, 3, 7, 5, 2),
(4, 2, 1, 6, 1);

SELECT * FROM game;
SELECT * FROM game_session;
SELECT * FROM puzzle;
SELECT * FROM user;
SELECT * FROM role;
SELECT * FROM image;
SELECT * FROM piece;

SELECT * FROM puzzle WHERE image_id IS NULL;