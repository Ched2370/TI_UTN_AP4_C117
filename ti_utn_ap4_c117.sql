-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2023 a las 22:06:41
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ti_utn_ap4_c117`
--
CREATE DATABASE IF NOT EXISTS `ti_utn_ap4_c117` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ti_utn_ap4_c117`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cuit` int(11) NOT NULL,
  `razon_social` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cuit`, `razon_social`) VALUES
(13710489, 'Innotype'),
(22007217, 'Bubbletube'),
(22275696, 'Edgewire'),
(31009567, 'Pixoboo'),
(42979481, 'Gabcube'),
(62324804, 'Dablist'),
(69393370, 'Tagchat'),
(69428202, 'Feedmix'),
(82869561, 'Bluezoom'),
(99341234, 'Livefish');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

CREATE TABLE `contrato` (
  `id_contrato` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL,
  `nombre_especialidad` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad_tecnico`
--

CREATE TABLE `especialidad_tecnico` (
  `id_especialidad_tecnico` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `id_tecnico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

CREATE TABLE `incidente` (
  `id_incidente` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizado` date NOT NULL,
  `resuelto` tinyint(1) NOT NULL,
  `id_tecnico` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `id_operador` int(11) NOT NULL,
  `id_problema` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operador`
--

CREATE TABLE `operador` (
  `id_operador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema`
--

CREATE TABLE `problema` (
  `id_problema` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE `tecnico` (
  `id_tecnico` int(11) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`id_tecnico`, `apellido`, `nombre`) VALUES
(1, 'Barboza', 'Arturo'),
(2, 'Romero', 'Mario'),
(3, 'Valenzuela', 'Juaquin'),
(4, 'Gomez', 'Jorge'),
(5, 'Ramirez', 'Carlos'),
(6, 'Garro', 'Matias'),
(7, 'Barboza', 'Juan'),
(8, 'Fernandez', 'Gabriel'),
(9, 'Uribe', 'Gabriel'),
(10, 'Gonzalez', 'Arturo'),
(11, 'Lopez', 'Mario'),
(12, 'Ramirez', 'Mario'),
(13, 'Gomez', 'Arturo'),
(14, 'Fernandez', 'Juan'),
(15, 'Romero', 'Arturo'),
(16, 'Ramirez', 'Juaquin'),
(17, 'Uribe', 'Arturo'),
(18, 'Gomez', 'Jorge'),
(19, 'Ramirez', 'Miguel'),
(20, 'Barboza', 'Miguel'),
(21, 'Lescano', 'Juan'),
(22, 'Barboza', 'Gabriel'),
(23, 'Valenzuela', 'Arturo'),
(24, 'Barboza', 'Matias'),
(25, 'Gomez', 'Matias'),
(26, 'Barboza', 'Juaquin'),
(27, 'Ramirez', 'Matias'),
(28, 'Gonzalez', 'Jorge'),
(29, 'Garro', 'Juan'),
(30, 'Fernandez', 'Matias'),
(31, 'Romero', 'Jorge'),
(32, 'Lescano', 'Arturo'),
(33, 'Fernandez', 'Juan'),
(34, 'Valenzuela', 'Gabriel'),
(35, 'Ramirez', 'Matias'),
(36, 'Romero', 'Mario'),
(37, 'Barboza', 'Carlos'),
(38, 'Barboza', 'Gabriel'),
(39, 'Barboza', 'Matias'),
(40, 'Ramirez', 'Matias'),
(41, 'Valenzuela', 'Matias'),
(42, 'Garro', 'Arturo'),
(43, 'Romero', 'Jorge'),
(44, 'Uribe', 'Mario'),
(45, 'Garro', 'Miguel'),
(46, 'Uribe', 'Juan'),
(47, 'Gomez', 'Carlos'),
(48, 'Uribe', 'Mario'),
(49, 'Lopez', 'Jorge'),
(50, 'Uribe', 'Gabriel'),
(51, 'Valenzuela', 'Gabriel'),
(52, 'Garro', 'Matias'),
(53, 'Romero', 'Juan'),
(54, 'Lopez', 'Miguel'),
(55, 'Gonzalez', 'Jorge'),
(56, 'Fernandez', 'Gabriel'),
(57, 'Romero', 'Juaquin'),
(58, 'Valenzuela', 'Juaquin'),
(59, 'Lescano', 'Arturo'),
(60, 'Romero', 'Mario'),
(61, 'Valenzuela', 'Juan'),
(62, 'Barboza', 'Carlos'),
(63, 'Gonzalez', 'Miguel'),
(64, 'Ramirez', 'Jorge'),
(65, 'Lopez', 'Arturo'),
(66, 'Valenzuela', 'Juaquin'),
(67, 'Barboza', 'Jorge'),
(68, 'Barboza', 'Carlos'),
(69, 'Romero', 'Mario'),
(70, 'Uribe', 'Gabriel'),
(71, 'Lescano', 'Arturo'),
(72, 'Valenzuela', 'Juaquin'),
(73, 'Uribe', 'Miguel'),
(74, 'Romero', 'Arturo'),
(75, 'Garro', 'Gabriel'),
(76, 'Romero', 'Carlos'),
(77, 'Gomez', 'Matias'),
(78, 'Valenzuela', 'Arturo'),
(79, 'Lescano', 'Jorge'),
(80, 'Gomez', 'Miguel'),
(81, 'Gomez', 'Matias'),
(82, 'Valenzuela', 'Arturo'),
(83, 'Lopez', 'Arturo'),
(84, 'Ramirez', 'Matias'),
(85, 'Ramirez', 'Gabriel'),
(86, 'Valenzuela', 'Miguel'),
(87, 'Barboza', 'Jorge'),
(88, 'Ramirez', 'Matias'),
(89, 'Lescano', 'Jorge'),
(90, 'Barboza', 'Gabriel'),
(91, 'Ramirez', 'Miguel'),
(92, 'Gomez', 'Juaquin'),
(93, 'Lescano', 'Carlos'),
(94, 'Garro', 'Gabriel'),
(95, 'Lescano', 'Gabriel'),
(96, 'Lescano', 'Matias'),
(97, 'Ramirez', 'Miguel'),
(98, 'Gomez', 'Arturo'),
(99, 'Lescano', 'Juan'),
(100, 'Lopez', 'Juaquin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cuit`);

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`id_contrato`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_servicio` (`id_servicio`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `especialidad_tecnico`
--
ALTER TABLE `especialidad_tecnico`
  ADD PRIMARY KEY (`id_especialidad_tecnico`),
  ADD KEY `id_especialidad` (`id_especialidad`),
  ADD KEY `id_tecnico` (`id_tecnico`);

--
-- Indices de la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD PRIMARY KEY (`id_incidente`),
  ADD KEY `id_especialidad` (`id_especialidad`),
  ADD KEY `id_problema` (`id_problema`),
  ADD KEY `id_tecnico` (`id_tecnico`),
  ADD KEY `id_operador` (`id_operador`);

--
-- Indices de la tabla `operador`
--
ALTER TABLE `operador`
  ADD PRIMARY KEY (`id_operador`);

--
-- Indices de la tabla `problema`
--
ALTER TABLE `problema`
  ADD PRIMARY KEY (`id_problema`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`);

--
-- Indices de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`id_tecnico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `id_contrato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialidad_tecnico`
--
ALTER TABLE `especialidad_tecnico`
  MODIFY `id_especialidad_tecnico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `incidente`
--
ALTER TABLE `incidente`
  MODIFY `id_incidente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `operador`
--
ALTER TABLE `operador`
  MODIFY `id_operador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `problema`
--
ALTER TABLE `problema`
  MODIFY `id_problema` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  MODIFY `id_tecnico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cuit`),
  ADD CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`);

--
-- Filtros para la tabla `especialidad_tecnico`
--
ALTER TABLE `especialidad_tecnico`
  ADD CONSTRAINT `especialidad_tecnico_ibfk_1` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `especialidad_tecnico_ibfk_2` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnico` (`id_tecnico`);

--
-- Filtros para la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD CONSTRAINT `incidente_ibfk_2` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `incidente_ibfk_3` FOREIGN KEY (`id_problema`) REFERENCES `problema` (`id_problema`),
  ADD CONSTRAINT `incidente_ibfk_4` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnico` (`id_tecnico`),
  ADD CONSTRAINT `incidente_ibfk_5` FOREIGN KEY (`id_operador`) REFERENCES `operador` (`id_operador`);

--
-- Filtros para la tabla `problema`
--
ALTER TABLE `problema`
  ADD CONSTRAINT `problema_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cuit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
