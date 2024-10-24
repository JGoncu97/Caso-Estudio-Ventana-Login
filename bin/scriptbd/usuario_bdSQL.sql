-- drop  database usuario_bd;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS productos (
id_producto varchar(25) primary key not null,
nombre varchar(30) not null,
precio decimal (10,2) not null,
cantidad int not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS compras (
id_compra int auto_increment primary key not null,
id_producto varchar(25) not null,
id_usuario varchar(11) not null,
fecha date not null,
precio_total decimal(10,2) not null,
foreign key (id_producto) references productos(id_producto),
foreign key (id_usuario) references usuario(documento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("123","admin","admin","Administrador","Desarrollador",27,"Sena","12345",1,1);
INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("234","usuario","usuario","Usuario","Desarrollador",30,"Sena","12345",2,1);
INSERT INTO usuario (documento,username,password,nombre,profesion,edad,direccion,telefono,tipo,estado) VALUES ("345","secretaria","secretaria","Secretaria","Desarrollador",30,"Sena","12345",3,1)