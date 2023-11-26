-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2023 a las 02:41:15
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
  `razon_social` varchar(25) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cuit`, `razon_social`, `activo`) VALUES
(987654, 'Pepe SA 2', 1),
(13710489, 'Innotype', 1),
(22007217, 'Bubbletube', 1),
(22275696, 'Edgewire', 1),
(31009567, 'Pixoboo', 1),
(42979481, 'Gabcube', 1),
(62324804, 'Dablist', 1),
(69393370, 'Tagchat', 1),
(69428202, 'Feedmix', 1),
(82869561, 'Bluezoom', 1),
(99341234, 'Livefish', 1);

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

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre_especialidad`) VALUES
(2, 'Soporte para Windows'),
(3, 'Soporte para macOS'),
(4, 'Soporte para Linux'),
(5, 'Soporte para Microsoft Of'),
(6, 'Soporte para software de ');

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
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `fecha_finalizado` datetime(6) DEFAULT NULL,
  `resuelto` tinyint(1) NOT NULL,
  `id_tecnico` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `id_operador` int(11) NOT NULL,
  `id_problema` int(11) NOT NULL,
  `diferencia_dias` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidente`
--

INSERT INTO `incidente` (`id_incidente`, `descripcion`, `fecha_inicio`, `fecha_finalizado`, `resuelto`, `id_tecnico`, `id_especialidad`, `id_operador`, `id_problema`, `diferencia_dias`) VALUES
(17, 'Problema de red', '2023-11-01 00:00:00.000000', '2023-11-10 00:00:00.000000', 1, 1, 2, 2, 1, 9),
(18, 'Error en la aplicación', '2023-11-02 00:00:00.000000', '2023-11-15 00:00:00.000000', 1, 2, 3, 3, 1, 13),
(19, 'Fallo del sistema operati', '2023-11-03 00:00:00.000000', '2023-11-18 00:00:00.000000', 0, 3, 4, 4, 1, 15),
(20, 'Problema de hardware', '2023-11-04 00:00:00.000000', '2023-11-20 00:00:00.000000', 1, 1, 5, 5, 1, 16),
(21, 'Error de software', '2023-11-05 00:00:00.000000', '2023-11-22 00:00:00.000000', 0, 5, 6, 6, 1, 17),
(22, 'Fallo en la red', '2023-11-06 00:00:00.000000', '2023-11-23 00:00:00.000000', 1, 1, 2, 7, 1, 17),
(23, 'Problema de aplicación mó', '2023-11-07 00:00:00.000000', '2023-11-10 00:00:00.000000', 1, 7, 3, 8, 1, 3),
(24, 'Error del sistema operati', '2023-11-08 00:00:00.000000', '2023-11-15 00:00:00.000000', 1, 8, 4, 9, 1, 7),
(25, 'Fallo de hardware', '2023-11-09 00:00:00.000000', '2023-11-18 00:00:00.000000', 1, 9, 5, 10, 1, 9),
(26, 'Error de software', '2023-11-10 00:00:00.000000', '2023-11-20 00:00:00.000000', 1, 1, 6, 11, 1, 10),
(27, 'Problema de red', '2023-11-11 00:00:00.000000', '2023-11-22 00:00:00.000000', 1, 11, 2, 12, 1, 11),
(28, 'Fallo en la aplicación', '2023-11-12 00:00:00.000000', '2023-11-23 00:00:00.000000', 1, 12, 3, 13, 1, 11),
(29, 'Error del sistema operati', '2023-11-07 00:00:00.000000', '2023-11-10 00:00:00.000000', 0, 13, 4, 14, 1, 3),
(30, 'Problema de hardware', '2023-11-14 00:00:00.000000', '2023-11-15 00:00:00.000000', 1, 2, 5, 15, 1, 1),
(31, 'Error de software', '2023-11-15 00:00:00.000000', '2023-11-18 00:00:00.000000', 1, 2, 6, 16, 1, 3),
(32, 'Fallo en la red', '2023-11-16 00:00:00.000000', '2023-11-20 00:00:00.000000', 1, 16, 2, 2, 1, 4),
(33, 'Problema de aplicación mó', '2023-11-17 00:00:00.000000', '2023-11-22 00:00:00.000000', 1, 17, 3, 3, 1, 5),
(34, 'Error del sistema operati', '2023-11-18 00:00:00.000000', '2023-11-23 00:00:00.000000', 0, 18, 4, 4, 1, 5),
(35, 'Fallo de hardware', '2023-11-07 00:00:00.000000', '2023-11-10 00:00:00.000000', 1, 19, 5, 5, 1, 3),
(36, 'Error de software', '2023-11-10 00:00:00.000000', '2023-11-15 00:00:00.000000', 1, 20, 6, 6, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operador`
--

CREATE TABLE `operador` (
  `id_operador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `operador`
--

INSERT INTO `operador` (`id_operador`, `nombre`) VALUES
(2, 'Juan Pérez'),
(3, 'María González'),
(4, 'Carlos Rodríguez'),
(5, 'Laura Martínez'),
(6, 'Pedro Sánchez'),
(7, 'Ana Ramírez'),
(8, 'Javier López'),
(9, 'Carmen Fernández'),
(10, 'Raúl Gómez'),
(11, 'Leticia Díaz'),
(12, 'Miguel Torres'),
(13, 'Sofía Herrera'),
(14, 'Alejandro Ruiz'),
(15, 'Lucía Vargas'),
(16, 'Gabriel Castro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema`
--

CREATE TABLE `problema` (
  `id_problema` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `problema`
--

INSERT INTO `problema` (`id_problema`, `descripcion`, `id_cliente`) VALUES
(1, 'Problema 2', 987654);

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
  `nombre` varchar(25) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`id_tecnico`, `apellido`, `nombre`, `activo`) VALUES
(1, 'Barboza', 'Arturo', 1),
(2, 'Romero', 'Mario', 1),
(3, 'Valenzuela', 'Juaquin', 1),
(4, 'Gomez', 'Jorge', 1),
(5, 'Ramirez', 'Carlos', 1),
(6, 'Garro', 'Matias', 1),
(7, 'Barboza', 'Juan', 1),
(8, 'Fernandez', 'Gabriel', 1),
(9, 'Uribe', 'Gabriel', 1),
(10, 'Gonzalez', 'Arturo', 1),
(11, 'Lopez', 'Mario', 1),
(12, 'Ramirez', 'Mario', 1),
(13, 'Gomez', 'Arturo', 1),
(14, 'Fernandez', 'Juan', 1),
(15, 'Romero', 'Arturo', 1),
(16, 'Ramirez', 'Juaquin', 1),
(17, 'Uribe', 'Arturo', 1),
(18, 'Gomez', 'Jorge', 1),
(19, 'Ramirez', 'Miguel', 1),
(20, 'Barboza', 'Miguel', 1),
(21, 'Lescano', 'Juan', 1),
(22, 'Barboza', 'Gabriel', 1),
(23, 'Valenzuela', 'Arturo', 1),
(24, 'Barboza', 'Matias', 1),
(25, 'Gomez', 'Matias', 1),
(26, 'Barboza', 'Juaquin', 1),
(27, 'Ramirez', 'Matias', 1),
(28, 'Gonzalez', 'Jorge', 1),
(29, 'Garro', 'Juan', 1),
(30, 'Fernandez', 'Matias', 1),
(31, 'Romero', 'Jorge', 1),
(32, 'Lescano', 'Arturo', 1),
(33, 'Fernandez', 'Juan', 1),
(34, 'Valenzuela', 'Gabriel', 1),
(35, 'Ramirez', 'Matias', 1),
(36, 'Romero', 'Mario', 1),
(37, 'Barboza', 'Carlos', 1),
(38, 'Barboza', 'Gabriel', 1),
(39, 'Barboza', 'Matias', 1),
(40, 'Ramirez', 'Matias', 1),
(41, 'Valenzuela', 'Matias', 1),
(42, 'Garro', 'Arturo', 1),
(43, 'Romero', 'Jorge', 1),
(44, 'Uribe', 'Mario', 1),
(45, 'Garro', 'Miguel', 1),
(46, 'Uribe', 'Juan', 1),
(47, 'Gomez', 'Carlos', 1),
(48, 'Uribe', 'Mario', 1),
(49, 'Lopez', 'Jorge', 1),
(50, 'Uribe', 'Gabriel', 1),
(51, 'Valenzuela', 'Gabriel', 1),
(52, 'Garro', 'Matias', 1),
(53, 'Romero', 'Juan', 1),
(54, 'Lopez', 'Miguel', 1),
(55, 'Gonzalez', 'Jorge', 1),
(56, 'Fernandez', 'Gabriel', 1),
(57, 'Romero', 'Juaquin', 1),
(58, 'Valenzuela', 'Juaquin', 1),
(59, 'Lescano', 'Arturo', 1),
(60, 'Romero', 'Mario', 1),
(61, 'Valenzuela', 'Juan', 1),
(62, 'Barboza', 'Carlos', 1),
(63, 'Gonzalez', 'Miguel', 1),
(64, 'Ramirez', 'Jorge', 1),
(65, 'Lopez', 'Arturo', 1),
(66, 'Valenzuela', 'Juaquin', 1),
(67, 'Barboza', 'Jorge', 1),
(68, 'Barboza', 'Carlos', 1),
(69, 'Romero', 'Mario', 1),
(70, 'Uribe', 'Gabriel', 1),
(71, 'Lescano', 'Arturo', 1),
(72, 'Valenzuela', 'Juaquin', 1),
(73, 'Uribe', 'Miguel', 1),
(74, 'Romero', 'Arturo', 1),
(75, 'Garro', 'Gabriel', 1),
(76, 'Romero', 'Carlos', 1),
(77, 'Gomez', 'Matias', 1),
(78, 'Valenzuela', 'Arturo', 1),
(79, 'Lescano', 'Jorge', 1),
(80, 'Gomez', 'Miguel', 1),
(81, 'Gomez', 'Matias', 1),
(82, 'Valenzuela', 'Arturo', 1),
(83, 'Lopez', 'Arturo', 1),
(84, 'Ramirez', 'Matias', 1),
(85, 'Ramirez', 'Gabriel', 1),
(86, 'Valenzuela', 'Miguel', 1),
(87, 'Barboza', 'Jorge', 1),
(88, 'Ramirez', 'Matias', 1),
(89, 'Lescano', 'Jorge', 1),
(90, 'Barboza', 'Gabriel', 1),
(91, 'Ramirez', 'Miguel', 1),
(92, 'Gomez', 'Juaquin', 1),
(93, 'Lescano', 'Carlos', 1),
(94, 'Garro', 'Gabriel', 1),
(95, 'Lescano', 'Gabriel', 1),
(96, 'Lescano', 'Matias', 1),
(97, 'Ramirez', 'Miguel', 1),
(98, 'Gomez', 'Arturo', 1),
(99, 'Lescano', 'Juan', 1),
(100, 'Lopez', 'Juaquin', 1),
(101, 'PepePepe', 'Prueba 2', 1);

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
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `especialidad_tecnico`
--
ALTER TABLE `especialidad_tecnico`
  MODIFY `id_especialidad_tecnico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `incidente`
--
ALTER TABLE `incidente`
  MODIFY `id_incidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `operador`
--
ALTER TABLE `operador`
  MODIFY `id_operador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `problema`
--
ALTER TABLE `problema`
  MODIFY `id_problema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  MODIFY `id_tecnico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

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
