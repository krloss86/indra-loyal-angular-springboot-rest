-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.1.0 - MySQL Community Server - GPL
-- SO del servidor:              Linux
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para dashboard
CREATE DATABASE IF NOT EXISTS `dashboard` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dashboard`;

-- Volcando estructura para tabla dashboard.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `numero_telefono` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cliente_UN` (`numero_telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.cliente: ~1 rows (aproximadamente)
INSERT INTO `cliente` (`id`, `nombre`, `numero_telefono`) VALUES
	(1, 'carlos', '1122334455');

-- Volcando estructura para tabla dashboard.cliente_equipos
CREATE TABLE IF NOT EXISTS `cliente_equipos` (
  `cliente_id` int NOT NULL,
  `equipo_id` int NOT NULL,
  PRIMARY KEY (`cliente_id`,`equipo_id`),
  KEY `FK_cliente_equipos_equipo` (`equipo_id`),
  CONSTRAINT `FK_cliente_equipos_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK_cliente_equipos_equipo` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.cliente_equipos: ~1 rows (aproximadamente)
INSERT INTO `cliente_equipos` (`cliente_id`, `equipo_id`) VALUES
	(1, 1);

-- Volcando estructura para tabla dashboard.cliente_promocion
CREATE TABLE IF NOT EXISTS `cliente_promocion` (
  `cliente_id` int NOT NULL,
  `promocion_id` int NOT NULL,
  `fecha_ofrecimiento` datetime NOT NULL,
  `estado` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`cliente_id`,`promocion_id`),
  KEY `FK__promocion` (`promocion_id`),
  CONSTRAINT `FK__promocion` FOREIGN KEY (`promocion_id`) REFERENCES `promocion` (`id`),
  CONSTRAINT `FK_promocion_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='hostorico de promociones ofrecidas a un cliente';

-- Volcando datos para la tabla dashboard.cliente_promocion: ~1 rows (aproximadamente)
INSERT INTO `cliente_promocion` (`cliente_id`, `promocion_id`, `fecha_ofrecimiento`, `estado`) VALUES
	(1, 1, '2023-10-19 06:41:15', 'OFRECIDO');

-- Volcando estructura para tabla dashboard.cliente_saldos
CREATE TABLE IF NOT EXISTS `cliente_saldos` (
  `cliente_id` int NOT NULL,
  `saldo_id` int NOT NULL,
  PRIMARY KEY (`cliente_id`,`saldo_id`),
  KEY `FK__saldo` (`saldo_id`),
  CONSTRAINT `FK__cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK__saldo` FOREIGN KEY (`saldo_id`) REFERENCES `saldo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.cliente_saldos: ~5 rows (aproximadamente)
INSERT INTO `cliente_saldos` (`cliente_id`, `saldo_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5);

-- Volcando estructura para tabla dashboard.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado_linea` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `fabricante` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `estado_uso` bit(1) NOT NULL DEFAULT (0),
  `misdn` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `imei` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `misdn` (`misdn`),
  UNIQUE KEY `imei` (`imei`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.equipo: ~1 rows (aproximadamente)
INSERT INTO `equipo` (`id`, `estado_linea`, `fabricante`, `estado_uso`, `misdn`, `imei`) VALUES
	(1, 'ACTIVA', 'SONY', b'1', '9887766332', '1234567890');

-- Volcando estructura para tabla dashboard.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(256) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `nickname` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `surname` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  `cliente_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`),
  KEY `FK_profile_cliente` (`cliente_id`),
  CONSTRAINT `FK_profile_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.profile: ~1 rows (aproximadamente)
INSERT INTO `profile` (`id`, `avatar`, `nickname`, `name`, `surname`, `cliente_id`) VALUES
	(1, 'http://bla.com.ar/avatar', 'krloss', 'carlos', 'carlos', 1);

-- Volcando estructura para tabla dashboard.promocion
CREATE TABLE IF NOT EXISTS `promocion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `descripcion` varchar(256) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `fecha_incio` datetime NOT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.promocion: ~1 rows (aproximadamente)
INSERT INTO `promocion` (`id`, `codigo`, `descripcion`, `nombre`, `fecha_incio`, `fecha_fin`) VALUES
	(1, 'MOTO_ULTRA', 'Moto edge 30 Ultra.', 'PROMO MOTOROLA', '2023-10-19 06:34:39', '2023-12-19 06:34:40');

-- Volcando estructura para tabla dashboard.saldo
CREATE TABLE IF NOT EXISTS `saldo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla dashboard.saldo: ~5 rows (aproximadamente)
INSERT INTO `saldo` (`id`, `descripcion`, `fecha`) VALUES
	(1, 'CRÉDITO DE RECARGA', '2023-10-19 06:33:20'),
	(2, 'CRÉDITO PROMOCIONAL', '2023-10-19 06:33:29'),
	(3, 'INTERNET', '2023-10-19 06:33:41'),
	(4, 'WHATSAPP', '2023-10-19 06:33:45'),
	(5, 'LLAMADAS DE REGALO', '2023-10-19 06:34:02');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
