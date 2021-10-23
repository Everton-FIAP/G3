create database goodvibe;
use goodvibe;
CREATE TABLE GV_TEMA (
             id_tema INT auto_increment,
             titulo_tema VARCHAR(100) NOT NULL,
             ds_tema VARCHAR(280) NOT NULL,
             CONSTRAINT PK_GV_TEMA
             PRIMARY KEY (id_tema)
);


CREATE TABLE GV_USUARIO (
             id_usuario INT AUTO_INCREMENT,
             nome_usuario VARCHAR(100) NOT NULL,
             idade_usuario INT NOT NULL,
             sobre_usuario VARCHAR(280) NOT NULL,
             CONSTRAINT PK_GV_USUARIO
             PRIMARY KEY (id_usuario)
);


CREATE TABLE GV_POSTAGEM (
             id_post INT AUTO_INCREMENT,
             id_tema INT NOT NULL,
             id_usuario INT,
             titulo_post VARCHAR(280) NOT NULL,
             ds_post VARCHAR(280) NOT NULL,
             dt_post DATE NOT NULL,
             link_post VARCHAR(1000) NOT NULL,
             CONSTRAINT PK_GV_POSTAGEM
             PRIMARY KEY (id_post)
);


CREATE TABLE GV_LOGIN (
             id_usuario INT NOT NULL auto_increment,
             email_login VARCHAR(320) NOT NULL,
             senha_login VARCHAR(30) NOT NULL,
             CONSTRAINT PK_GV_LOGIN
             PRIMARY KEY (id_usuario)
);

ALTER TABLE GV_LOGIN
ADD CONSTRAINT UN_GV_LOGIN_EMAIL
UNIQUE (email_login);

ALTER TABLE GV_POSTAGEM
ADD CONSTRAINT FK_GV_POSTAGEM_TEMA
FOREIGN KEY (id_tema)
REFERENCES GV_TEMA (id_tema)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE GV_POSTAGEM
ADD CONSTRAINT FK_GV_POSTAGEM_USUARIO
FOREIGN KEY (id_usuario)
REFERENCES GV_USUARIO (id_usuario)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE GV_LOGIN
ADD CONSTRAINT FK_GV_LOGIN_USUARIO
FOREIGN KEY (id_usuario)
REFERENCES GV_USUARIO (id_usuario)
ON DELETE CASCADE ON UPDATE CASCADE;