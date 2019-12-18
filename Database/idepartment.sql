-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2019 a las 00:05:29
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `idepartment`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `id` int(3) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Sname` varchar(20) NOT NULL,
  `PassN` varchar(20) NOT NULL,
  `DofArrival` date NOT NULL,
  `Priority` varchar(10) NOT NULL,
  `GeneralId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`id`, `Name`, `Sname`, `PassN`, `DofArrival`, `Priority`, `GeneralId`) VALUES
(1, 'Edwin', 'garces', '89huhdu', '2019-11-14', 'Low', 'IDEP309'),
(13, 'hjg', 'klhlk', 'jgdtyd57', '2009-09-09', 'Medium', 'IDEP250'),
(14, 'yuguy', 'fre', 'gjmb,m76r', '2019-09-09', 'Medium', 'IDEP350'),
(15, 'dean', 'nlknler', 'ksho8y398', '2019-09-09', 'Medium', 'IDEP234'),
(16, 'Edwin ', 'garces', '90843uj', '2019-10-10', 'Medium', 'IDEP373'),
(17, 'Edwin ', 'garces', 'jowjiwpej', '2019-10-10', 'High', 'IDEP365'),
(18, 'exon', 'garces', 'opvjerp', '2019-10-10', 'High', 'IDEP318'),
(19, 'exon', 'garces', 'opvjeu988', '2019-10-10', 'High', 'IDEP353'),
(20, 'chupamelo', ';ejl', '90430938r0', '2019-10-10', 'High', 'IDEP488'),
(21, '9074', 'garces', '77uuehmr', '2019-09-09', 'Low', 'IDEP89'),
(22, 'iouroi', 'garces', '36jkhkjfd', '2019-09-09', 'Low', 'IDEP38'),
(23, 'adam', 'saver', '763khsdkl', '2019-09-09', 'High', 'IDEP442'),
(24, 'thiago', 'almaida', 'eioy8409', '2019-09-09', 'Medium', 'IDEP475'),
(25, 'jesus', 'acuna', '98743huhru', '2019-09-09', 'High', 'IDEP83');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
