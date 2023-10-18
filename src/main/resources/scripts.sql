CREATE TABLE dashboard.cliente (
	id INT auto_increment NOT NULL,
	nombre varchar(100) NOT NULL,
	numero_telefono varchar(15) NULL,
	CONSTRAINT cliente_PK PRIMARY KEY (id),
	CONSTRAINT cliente_UN UNIQUE KEY (numero_telefono)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_spanish_ci;
