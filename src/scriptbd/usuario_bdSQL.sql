drop  database usuario_bd;
CREATE DATABASE IF NOT EXISTS usuario_bd;
USE usuario_bd;

CREATE TABLE IF NOT EXISTS usuario (
    documento varchar(11) NOT NULL primary key,
    username varchar(11) not null,
    password varchar(11) not null,
    nombre varchar(80) NOT NULL,
    profesion varchar(200) NOT NULL,
    edad int(3) NOT NULL,
    direccion varchar(200) NOT NULL,
    telefono varchar(10) NOT NULL,
    tipo int(2) NOT NULL,
    estado int(2) not null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("123","admin","admin","Administrador","Desarrollador",27,"Sena","12345",1,1);
INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("234","usuario","usuario","Usuario","Desarrollador",30,"Sena","12345",2,1);
INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("345","secretaria","secretaria","Secretaria","Desarrollador",30,"Sena","12345",3,1)