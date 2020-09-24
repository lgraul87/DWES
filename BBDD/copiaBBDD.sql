-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para nomina
CREATE DATABASE IF NOT EXISTS `nomina` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `nomina`;

-- Volcando estructura para tabla nomina.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `nombre` varchar(40) NOT NULL,
  `categoria` int(11) NOT NULL DEFAULT 0,
  `anio` int(11) NOT NULL DEFAULT 0,
  `dni` varchar(9) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nomina.empleado: ~4 rows (aproximadamente)
DELETE FROM `empleado`;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`nombre`, `categoria`, `anio`, `dni`, `sexo`) VALUES
	('tyuyu', 1, 0, '23143243g', 'M'),
	('ffdfd', 1, 1, '34232132d', 'H'),
	('Raul', 1, 2, '45808798C', 'H'),
	('Eszter', 1, 0, '45808799C', 'M');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
