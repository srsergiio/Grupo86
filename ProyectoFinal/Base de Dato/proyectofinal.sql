-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2023 a las 00:13:45
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alojamiento`
--

CREATE TABLE `alojamiento` (
  `idAlojamiento` int(11) NOT NULL,
  `fechaI` date NOT NULL,
  `fechaF` date NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `servicio` varchar(60) NOT NULL,
  `importeD` int(11) NOT NULL,
  `ciudad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `inicioTemporada` date DEFAULT NULL,
  `finTemporada` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alojamiento`
--

INSERT INTO `alojamiento` (`idAlojamiento`, `fechaI`, `fechaF`, `tipo`, `servicio`, `importeD`, `ciudad`, `estado`, `inicioTemporada`, `finTemporada`) VALUES
(24, '2024-06-21', '2024-09-20', 'cabaña', 'sin servicio', 35, 13, 1, NULL, NULL),
(25, '2024-12-21', '2025-03-20', 'hotel 2 estrellas', 'desayuno', 50, 14, 1, NULL, NULL),
(26, '2025-06-21', '2025-09-20', 'hotel 3 estrellas', 'desayuno,tv,pileta', 80, 15, 1, NULL, NULL),
(27, '2026-06-21', '2026-09-20', 'hotel 4 estrellas', 'desayuno,tv,wifi,pileta', 100, 16, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `idCiudad` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `provincia` varchar(60) NOT NULL,
  `pais` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`idCiudad`, `nombre`, `provincia`, `pais`, `estado`) VALUES
(13, 'san miguel', 'Buenos Aires', 'Argentina', 1),
(14, 'Córdoba', 'Córdoba', 'Argentina', 1),
(15, 'Ciudad de La Punta', 'San luis', 'Argentina', 1),
(16, 'Montevideo', 'Montevideo', 'Urugauy', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `dni` int(11) NOT NULL,
  `CiudadOrigen` int(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `apellido`, `dni`, `CiudadOrigen`) VALUES
(8, 'sergio', 'esquivel', 38827457, 13),
(9, 'franco', 'sanchez', 12345678, 14),
(10, 'lola', 'altamiranda', 12342535, 13),
(11, 'Paulina', 'Paulina', 98623442, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `idPaquete` int(11) NOT NULL,
  `idAlojamiento` int(11) NOT NULL,
  `idPasaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paquete`
--

INSERT INTO `paquete` (`idPaquete`, `idAlojamiento`, `idPasaje`) VALUES
(1, 24, 27),
(2, 25, 28),
(3, 26, 29),
(4, 27, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `idPasaje` int(11) NOT NULL,
  `tipoTransporte` varchar(60) NOT NULL,
  `fechaIda` date NOT NULL,
  `fechaVuelta` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `importe` int(11) NOT NULL,
  `ciudadOrigen` int(11) NOT NULL,
  `ciudadDestino` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`idPasaje`, `tipoTransporte`, `fechaIda`, `fechaVuelta`, `estado`, `importe`, `ciudadOrigen`, `ciudadDestino`) VALUES
(27, 'BUS ', '2024-06-20', '2024-09-20', 1, 100, 13, 15),
(28, 'BUS', '2024-12-20', '2025-03-20', 1, 100, 13, 14),
(29, 'BUS', '2025-06-20', '2025-09-20', 1, 100, 13, 15),
(30, 'BUS', '2026-06-20', '2026-09-20', 1, 100, 13, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idPaquete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idCliente`, `idPaquete`) VALUES
(1, 8, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD PRIMARY KEY (`idAlojamiento`),
  ADD KEY `ciudad` (`ciudad`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `origen` (`CiudadOrigen`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`idPaquete`),
  ADD KEY `costoPasaje` (`idPasaje`),
  ADD KEY `paquete_ibfk_6` (`idAlojamiento`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `ciudadDestino` (`ciudadDestino`),
  ADD KEY `pasaje_ibfk_3` (`ciudadOrigen`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idPaquete` (`idPaquete`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  MODIFY `idAlojamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `idPaquete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD CONSTRAINT `alojamiento_ibfk_1` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`CiudadOrigen`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `paquete_ibfk_2` FOREIGN KEY (`idPasaje`) REFERENCES `pasaje` (`idPasaje`),
  ADD CONSTRAINT `paquete_ibfk_6` FOREIGN KEY (`idAlojamiento`) REFERENCES `alojamiento` (`idAlojamiento`);

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `pasaje_ibfk_2` FOREIGN KEY (`ciudadDestino`) REFERENCES `ciudad` (`idCiudad`),
  ADD CONSTRAINT `pasaje_ibfk_3` FOREIGN KEY (`ciudadOrigen`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idPaquete`) REFERENCES `paquete` (`idPaquete`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
