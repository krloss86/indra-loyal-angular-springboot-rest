CREATE DATABASE IF NOT EXISTS dashboardv2;
USE dashboardv2;

-- Volcando estructura para tabla dashboard.equipo
CREATE TABLE IF NOT EXISTS equipo (
  id int NOT NULL AUTO_INCREMENT,
  estado_linea varchar(50)  NOT NULL,
  fabricante varchar(50)  NOT NULL,
  estado_uso bit(1) NOT NULL,
  misdn varchar(50)  NOT NULL,
  imei varchar(50)  NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY misdn (misdn),
  UNIQUE KEY imei (imei)
);


-- Volcando estructura para tabla dashboard.cliente
CREATE TABLE IF NOT EXISTS cliente (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100)  NOT NULL,
  numero_telefono varchar(15) NULL,
  PRIMARY KEY (id),
  UNIQUE KEY cliente_UN (numero_telefono)
);

-- Volcando estructura para tabla dashboard.promocion
CREATE TABLE IF NOT EXISTS promocion (
  id int NOT NULL AUTO_INCREMENT,
  codigo varchar(50)  NOT NULL,
  descripcion varchar(256)  NOT NULL,
  nombre varchar(50)  NOT NULL,
  fecha_incio datetime NOT NULL,
  fecha_fin datetime NULL,
  PRIMARY KEY (id),
  UNIQUE KEY codigo (codigo),
  UNIQUE KEY nombre (nombre)
) ;

-- Volcando estructura para tabla dashboard.saldo
CREATE TABLE IF NOT EXISTS saldo (
  id int NOT NULL AUTO_INCREMENT,
  descripcion varchar(50)  NOT NULL,
  fecha datetime NOT NULL,
  PRIMARY KEY (id)
);

-- Volcando estructura para tabla dashboard.profile
CREATE TABLE IF NOT EXISTS profile (
  id int NOT NULL AUTO_INCREMENT,
  avatar varchar(256)  NOT NULL,
  nickname varchar(50)  NOT NULL,
  name varchar(50)  NOT NULL,
  surname varchar(50)  NOT NULL,
  cliente_id int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nickname (nickname),
  KEY FK_profile_cliente (cliente_id),
  CONSTRAINT FK_profile_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ;

-- Volcando estructura para tabla dashboard.cliente_equipos
CREATE TABLE IF NOT EXISTS cliente_equipos (
  cliente_id int NOT NULL,
  equipo_id int NOT NULL,
  PRIMARY KEY (cliente_id,equipo_id),
  KEY FK_cliente_equipos_equipo (equipo_id),
  CONSTRAINT FK_cliente_equipos_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
  CONSTRAINT FK_cliente_equipos_equipo FOREIGN KEY (equipo_id) REFERENCES equipo (id)
) ;

-- Volcando estructura para tabla dashboard.cliente_promocion
CREATE TABLE IF NOT EXISTS cliente_promocion (
  cliente_id int NOT NULL,
  promocion_id int NOT NULL,
  fecha_ofrecimiento datetime NOT NULL,
  estado varchar(50)  NOT NULL,
  PRIMARY KEY (cliente_id,promocion_id),
  KEY FK__promocion (promocion_id),
  CONSTRAINT FK__promocion FOREIGN KEY (promocion_id) REFERENCES promocion (id),
  CONSTRAINT FK_promocion_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ;

-- Volcando estructura para tabla dashboard.cliente_saldos
CREATE TABLE IF NOT EXISTS cliente_saldos (
  cliente_id int NOT NULL,
  saldo_id int NOT NULL,
  PRIMARY KEY (cliente_id,saldo_id),
  KEY FK__saldo (saldo_id),
  CONSTRAINT FK__cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
  CONSTRAINT FK__saldo FOREIGN KEY (saldo_id) REFERENCES saldo (id)
) ;

-- Volcando datos para la tabla dashboard.cliente: ~1 rows (aproximadamente)
INSERT INTO cliente (id, nombre, numero_telefono) VALUES
	(1, 'carlos', '1122334455');


-- Volcando datos para la tabla dashboard.equipo: ~1 rows (aproximadamente)
INSERT INTO equipo (id, estado_linea, fabricante, estado_uso, misdn, imei) VALUES
	(1, 'ACTIVA', 'SONY', 1, '9887766332', '1234567890');


-- Volcando datos para la tabla dashboard.profile: ~1 rows (aproximadamente)
INSERT INTO profile (id, avatar, nickname, name, surname, cliente_id) VALUES
	(1, 'http://bla.com.ar/avatar', 'krloss', 'carlos', 'carlos', 1);

-- Volcando datos para la tabla dashboard.promocion: ~1 rows (aproximadamente)
INSERT INTO promocion (id, codigo, descripcion, nombre, fecha_incio, fecha_fin) VALUES
	(1, 'MOTO_ULTRA', 'Moto edge 30 Ultra.', 'PROMO MOTOROLA', '2023-10-19 06:34:39', '2023-12-19 06:34:40');


-- Volcando datos para la tabla dashboard.saldo: ~5 rows (aproximadamente)
INSERT INTO saldo (id, descripcion, fecha) VALUES
	(1, 'CRÉDITO DE RECARGA', '2023-10-19 06:33:20'),
	(2, 'CRÉDITO PROMOCIONAL', '2023-10-19 06:33:29'),
	(3, 'INTERNET', '2023-10-19 06:33:41'),
	(4, 'WHATSAPP', '2023-10-19 06:33:45'),
	(5, 'LLAMADAS DE REGALO', '2023-10-19 06:34:02');

-- Volcando datos para la tabla dashboard.cliente_equipos: ~1 rows (aproximadamente)
INSERT INTO cliente_equipos (cliente_id, equipo_id) VALUES
	(1, 1);

-- Volcando datos para la tabla dashboard.cliente_promocion: ~1 rows (aproximadamente)
INSERT INTO cliente_promocion (cliente_id, promocion_id, fecha_ofrecimiento, estado) VALUES
	(1, 1, '2023-10-19 06:41:15', 'OFRECIDO');

-- Volcando datos para la tabla dashboard.cliente_saldos: ~5 rows (aproximadamente)
INSERT INTO cliente_saldos (cliente_id, saldo_id) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5);

CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE INDEX username (username)
);

CREATE TABLE role (
	id INT NOT NULL AUTO_INCREMENT,
	rol varchar(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE INDEX rol (rol)
);

CREATE TABLE users_roles (
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (user_id, role_id),
	CONSTRAINT FK_users_roles_user FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT FK_users_roles_role FOREIGN KEY (role_id) REFERENCES role (id)
);

ALTER TABLE user CHANGE COLUMN password password VARCHAR(100) NOT NULL AFTER username;
UPDATE user SET password='$2y$10$l6fkrLZMWR1qhuxGFX.I5uePZ7hxVQdno7OQjRAt3nX2pd5qs06PO' WHERE  id=1;
