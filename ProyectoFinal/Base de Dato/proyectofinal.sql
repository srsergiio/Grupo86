-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-10-2023 a las 17:10:48
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
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alojamiento`
--

INSERT INTO `alojamiento` (`idAlojamiento`, `fechaI`, `fechaF`, `tipo`, `servicio`, `importeD`, `ciudad`, `estado`) VALUES
(2, '2023-12-01', '2023-12-07', 'Hotel', 'Desayuno incluido', 150, 1, 1),
(3, '2024-01-20', '2024-01-27', 'Apartamento', 'Desayuno incluido', 200, 2, 1),
(4, '2024-02-01', '2024-02-07', 'Cabaña', 'Desayuno incluido', 180, 3, 1),
(5, '2024-02-15', '2024-02-22', 'Hotel', 'Desayuno incluido', 150, 4, 1),
(6, '2024-03-01', '2024-03-07', 'Hostel', 'Desayuno incluido', 50, 5, 1),
(7, '2024-03-15', '2024-03-22', 'Apartamento', 'Sin servicio', 200, 6, 1),
(9, '2024-02-15', '2024-02-22', 'Hotel', 'Desayuno incluido', 150, 4, 1),
(10, '2024-03-01', '2024-03-07', 'Hostel', 'Desayuno incluido', 50, 5, 1),
(11, '2024-03-15', '2024-03-22', 'Apartamento', 'Sin servicio', 200, 6, 1),
(13, '2024-02-01', '2024-02-07', 'Cabaña', 'Desayuno incluido', 180, 3, 1),
(14, '2024-02-15', '2024-02-22', 'Hotel', 'Desayuno incluido', 150, 4, 1),
(15, '2024-03-01', '2024-03-07', 'Hostel', 'Desayuno incluido', 50, 5, 1),
(16, '2024-03-15', '2024-03-22', 'Apartamento', 'Sin servicio', 200, 6, 1),
(18, '2024-02-01', '2024-02-07', 'Cabaña', 'Desayuno incluido', 180, 3, 1),
(19, '2024-02-15', '2024-02-22', 'Hotel', 'Desayuno incluido', 150, 4, 1),
(20, '2024-03-01', '2024-03-07', 'Hostel', 'Desayuno incluido', 50, 5, 1),
(21, '2024-03-15', '2024-03-22', 'Apartamento', 'Sin servicio', 200, 6, 1);

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
(1, 'Puerto Iguazú', 'Misiones', 'Argentina', 1),
(2, 'Bariloche', 'Río Negro', 'Argentina', 1),
(3, 'Mendoza', 'Mendoza', 'Argentina', 1),
(4, 'Ushuaia', 'Tierra del Fuego', 'Argentina', 1),
(5, 'El Calafate', 'Santa Cruz', 'Argentina', 1),
(6, 'Mar del Plata', 'Buenos Aires', 'Argentina', 1),
(7, 'Cancún', 'Quintana Roo', 'México', 1),
(8, 'Roma', 'Lazio', 'Italia', 1),
(9, 'París', 'Isla de Francia', 'Francia', 1),
(10, 'Tokio', 'Kanto', 'Japón', 1),
(11, 'Nueva York', 'Nueva York', 'Estados Unidos', 1),
(12, 'Sídney', 'Nueva Gales del Sur', 'Australia', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `origen` int(60) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `origen`, `idCliente`, `dni`) VALUES
('Juan', 'Pérez', 1, 3, 12345678),
('María', 'González', 2, 4, 87654321),
('Carlos', 'Rodríguez', 3, 5, 11223344),
('Ana', 'Martínez', 4, 6, 44332211),
('Pedro', 'García', 5, 7, 99887766);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `costoPasaje` int(11) NOT NULL,
  `estadia` int(11) NOT NULL,
  `idPaquete` int(11) NOT NULL,
  `costoEstadia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `tipoTransporte` varchar(60) NOT NULL,
  `importe` int(11) NOT NULL,
  `ciudadOrigen` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idPasaje` int(11) NOT NULL,
  `ciudadDestino` int(11) NOT NULL,
  `fechaIda` date NOT NULL,
  `fechaVuelta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`tipoTransporte`, `importe`, `ciudadOrigen`, `estado`, `idPasaje`, `ciudadDestino`, `fechaIda`, `fechaVuelta`) VALUES
('Avión', 500, 1, 1, 9, 2, '2024-02-01', '2024-02-07'),
('Autobús', 200, 2, 1, 10, 3, '2024-02-15', '2024-02-22'),
('Tren', 300, 3, 1, 11, 4, '2024-03-01', '2024-03-07'),
('Avión', 600, 4, 1, 12, 5, '2024-03-15', '2024-03-22'),
('Autobús', 250, 5, 1, 13, 6, '2024-04-01', '2024-04-07'),
('Avión', 500, 1, 1, 15, 2, '2024-02-01', '2024-02-07'),
('Autobús', 200, 2, 1, 16, 3, '2024-02-15', '2024-02-22'),
('Tren', 300, 3, 1, 17, 4, '2024-03-01', '2024-03-07'),
('Avión', 600, 4, 1, 18, 5, '2024-03-15', '2024-03-22'),
('Autobús', 250, 5, 1, 19, 6, '2024-04-01', '2024-04-07'),
('Avión', 500, 1, 1, 21, 2, '2024-02-01', '2024-02-07'),
('Autobús', 200, 2, 1, 22, 3, '2024-02-15', '2024-02-22'),
('Tren', 300, 3, 1, 23, 4, '2024-03-01', '2024-03-07'),
('Avión', 600, 4, 1, 24, 5, '2024-03-15', '2024-03-22'),
('Autobús', 250, 5, 1, 25, 6, '2024-04-01', '2024-04-07'),
('Tren', 350, 5, 1, 26, 7, '2024-04-15', '2024-04-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idPaquete` int(11) NOT NULL,
  `fechaReserva` date NOT NULL,
  `fechaViaje` date NOT NULL,
  `cliente` int(11) NOT NULL,
  `paquetes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `origen` (`origen`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`idPaquete`),
  ADD KEY `estadia` (`estadia`),
  ADD KEY `costoPasaje` (`costoPasaje`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `ciudadDestino` (`ciudadDestino`),
  ADD KEY `pasaje_ibfk_1` (`ciudadOrigen`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  MODIFY `idAlojamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `idPaquete` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`origen`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `paquete_ibfk_1` FOREIGN KEY (`estadia`) REFERENCES `alojamiento` (`idAlojamiento`),
  ADD CONSTRAINT `paquete_ibfk_2` FOREIGN KEY (`costoPasaje`) REFERENCES `pasaje` (`idPasaje`),
  ADD CONSTRAINT `paquete_ibfk_3` FOREIGN KEY (`idPaquete`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `paquete_ibfk_4` FOREIGN KEY (`idPaquete`) REFERENCES `pasaje` (`idPasaje`),
  ADD CONSTRAINT `paquete_ibfk_5` FOREIGN KEY (`idPaquete`) REFERENCES `alojamiento` (`idAlojamiento`),
  ADD CONSTRAINT `paquete_ibfk_6` FOREIGN KEY (`idPaquete`) REFERENCES `reserva` (`idReserva`);

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `pasaje_ibfk_1` FOREIGN KEY (`ciudadOrigen`) REFERENCES `cliente` (`origen`),
  ADD CONSTRAINT `pasaje_ibfk_2` FOREIGN KEY (`ciudadDestino`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idReserva`) REFERENCES `cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
