-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-11-2022 a las 10:31:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `yeilux`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fechafinal` varchar(20) DEFAULT NULL,
  `fechainicio` varchar(20) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `numerador` int(11) NOT NULL,
  `fabricacion_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area_empresa`
--

CREATE TABLE `area_empresa` (
  `id_area` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area_usuario`
--

CREATE TABLE `area_usuario` (
  `id_area` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL,
  `cargo` varchar(60) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id`, `cargo`, `estado`) VALUES
(1, 'ADMIN', b'1'),
(2, 'ASISTENTE', b'1'),
(3, 'GERENTE', b'1'),
(4, 'EMPLEADO', b'1'),
(5, 'JEFE_AREA', b'1'),
(6, 'JEFE_BODEGA', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `estado`, `nombre`) VALUES
(1, b'1', 'Luna'),
(2, b'1', 'Jean'),
(3, b'1', 'Azul'),
(4, b'1', 'Gerente'),
(5, b'1', 'Luna*'),
(6, b'1', 'Luna$'),
(7, b'1', 'Luna*'),
(8, b'1', 'naihilisss XD'),
(9, b'1', 'Sebastian');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL,
  `contacto` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `estado` bit(1) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `especialidad_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `contacto`, `direccion`, `email`, `estado`, `imagen`, `nombre`, `telefono`, `especialidad_id`) VALUES
(1, 'Marcelo', 'calle 13', 'marcos.rincon1903@gmail.com', b'1', NULL, 'Jean', 98113564, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `inventario_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradapro`
--

CREATE TABLE `entradapro` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `inventario_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id`, `descripcion`, `estado`, `nombre`) VALUES
(1, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaa', b'1', 'Diseño'),
(2, 'holaa', b'1', 'holaaa'),
(3, 'holaa', b'1', 'holaaa'),
(4, 'holaa', b'1', 'holaaa'),
(5, 'holaa', b'1', 'holaaa'),
(6, 'bebes como etan', b'1', 'holisss bebes be'),
(7, 'como estas ', b'1', 'holsa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricacion`
--

CREATE TABLE `fabricacion` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fechafinal` varchar(20) DEFAULT NULL,
  `fechainicio` varchar(20) NOT NULL,
  `suspendido` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricacion_insumo`
--

CREATE TABLE `fabricacion_insumo` (
  `id_fabricacion` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricacion_producto`
--

CREATE TABLE `fabricacion_producto` (
  `id_fabricacion` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricacion_usuario`
--

CREATE TABLE `fabricacion_usuario` (
  `id_fabricacion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE `insumo` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `material` varchar(30) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `proveedor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `insumo`
--

INSERT INTO `insumo` (`id`, `estado`, `imagen`, `material`, `nombre`, `proveedor_id`) VALUES
(1, b'1', NULL, 'azucar', 'Boton', 1),
(2, b'1', 'unnamed.jpg', 'azucar', 'Remache', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo_tipo`
--

CREATE TABLE `insumo_tipo` (
  `id_insumo` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `tipo_unidad` varchar(30) NOT NULL,
  `insumo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id`, `estado`, `tipo_unidad`, `insumo_id`) VALUES
(1, b'1', 'Unidad', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventariopro`
--

CREATE TABLE `inventariopro` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegio`
--

CREATE TABLE `privilegio` (
  `id` int(11) NOT NULL,
  `privilegio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `privilegio`
--

INSERT INTO `privilegio` (`id`, `privilegio`) VALUES
(1, 'PRODUCTO_CREATE_UPDATE'),
(2, 'PRODUCTO_SELECT'),
(3, 'PRODUCTO_DELETE'),
(4, 'INSUMO_CREATE_UPDATE'),
(5, 'INSUMO_SELECT'),
(6, 'INSUMO_DELETE'),
(7, 'FABRICACION_CREATE_UPDATE'),
(8, 'FABRICACION_SELECT'),
(9, 'FABRICACION_DELETE'),
(10, 'USUARIO_CREATE_UPDATE'),
(11, 'USUARIO_SELECT'),
(12, 'USUARIO_DELETE'),
(13, 'EMPRESA_CREATE_UPDATE'),
(14, 'EMPRESA_SELECT'),
(15, 'EMPRESA_DELETE'),
(16, 'INVENTARIOS_CREATE_UPDATE'),
(17, 'INVENTARIOS_SELECT'),
(18, 'INVENTARIOS_DELETE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegio_cargo`
--

CREATE TABLE `privilegio_cargo` (
  `id_cargo` int(11) NOT NULL,
  `id_privilegio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `privilegio_cargo`
--

INSERT INTO `privilegio_cargo` (`id_cargo`, `id_privilegio`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion`
--

CREATE TABLE `produccion` (
  `id` int(11) NOT NULL,
  `confirmacion` bit(1) DEFAULT NULL,
  `descripcion` varchar(300) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `visto` bit(1) NOT NULL,
  `area_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `visible` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `descripcion`, `estado`, `imagen`, `nombre`, `visible`) VALUES
(24, NULL, b'1', '0.6615906176528441unnamed.jpg', 'Luna', b'0'),
(25, '', b'1', '0.07169753036044846fondo01.webp', 'hola', b'0'),
(26, 'jjjjjjjjjjjjjjjjjjj', b'0', '0.2383195264529914816442302078686.jpg', 'Sebastian', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_categoria`
--

CREATE TABLE `producto_categoria` (
  `id_producto` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto_categoria`
--

INSERT INTO `producto_categoria` (`id_producto`, `id_categoria`) VALUES
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(4, 1),
(4, 3),
(5, 1),
(6, 1),
(6, 3),
(7, 1),
(8, 1),
(9, 2),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 2),
(25, 8),
(26, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `contacto` varchar(60) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `email` varchar(200) NOT NULL,
  `estado` bit(1) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `contacto`, `direccion`, `email`, `estado`, `nombre`, `telefono`) VALUES
(1, 'Maria Gomez', 'calle 12', 'marincon444@misena.edu.co', b'1', 'Marcos', 1234567800),
(2, 'Maria Gomez', 'calle 123', 'sswdw@gmail.com', b'1', 'Luna', 123456678),
(3, 'Maria Gomez', 'calle 12', 'marincon444@misena.edu.co', b'1', 'Luna*', 1234567800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `inventario_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidapro`
--

CREATE TABLE `salidapro` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `inventario_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id` int(11) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id`, `estado`, `nombre`) VALUES
(1, b'1', 'Jean');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(12) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `identificacion` bigint(20) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `inicio` bit(1) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `verificacion` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellido`, `direccion`, `estado`, `fecha`, `genero`, `identificacion`, `imagen`, `inicio`, `nombre`, `password`, `telefono`, `tipo`, `user_name`, `verificacion`) VALUES
(1, 'Rincon', 'Calle 13', b'1', '12-12-2004', 'MASCULINO', 12345678900, NULL, b'1', 'Marcos', '$2a$10$w5jdVAVhBUMAKU5lY2YcbeUCmGCnzQVRcCsRFlqj2W7/2GHAsVplK', 98113564, 'CEDULA', 'marcos.rincon1903@gmail.com', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_cargo`
--

CREATE TABLE `usuario_cargo` (
  `id_usuario` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_cargo`
--

INSERT INTO `usuario_cargo` (`id_usuario`, `id_cargo`) VALUES
(1, 1),
(1, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg1l34t9f2g5kefrposef5u5ob` (`fabricacion_id`);

--
-- Indices de la tabla `area_empresa`
--
ALTER TABLE `area_empresa`
  ADD PRIMARY KEY (`id_area`,`id_empresa`),
  ADD KEY `FK6m9b2l54rallrw0qq2u8nnv0a` (`id_empresa`);

--
-- Indices de la tabla `area_usuario`
--
ALTER TABLE `area_usuario`
  ADD PRIMARY KEY (`id_area`,`id_usuario`),
  ADD KEY `FKte20qfmk8cxk4smqquyo5qwe` (`id_usuario`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK32gfienydryxrr7cvpiqtejso` (`especialidad_id`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4y26wa0jba0pvfhfcwv17bi3f` (`inventario_id`),
  ADD KEY `FKcejqwringjwk7bo01ody2lnr2` (`usuario_id`);

--
-- Indices de la tabla `entradapro`
--
ALTER TABLE `entradapro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhsddwvo0mayyfbhsbnhhid2gf` (`inventario_id`),
  ADD KEY `FKgeiwgwjm2teuvlbpyef8uahs3` (`usuario_id`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fabricacion`
--
ALTER TABLE `fabricacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fabricacion_insumo`
--
ALTER TABLE `fabricacion_insumo`
  ADD PRIMARY KEY (`id_fabricacion`,`id_insumo`),
  ADD KEY `FKbhb7uop3nxnll0hphe6r1y0xx` (`id_insumo`);

--
-- Indices de la tabla `fabricacion_producto`
--
ALTER TABLE `fabricacion_producto`
  ADD PRIMARY KEY (`id_fabricacion`,`id_producto`),
  ADD KEY `FKdd6xqb09wbbxrd17q3lewpuv0` (`id_producto`);

--
-- Indices de la tabla `fabricacion_usuario`
--
ALTER TABLE `fabricacion_usuario`
  ADD PRIMARY KEY (`id_fabricacion`,`id_usuario`),
  ADD KEY `FK54raexhbvt5ecwg9c4qiu1kl3` (`id_usuario`);

--
-- Indices de la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmsmbrf64upncu8ieylvsb70r6` (`proveedor_id`);

--
-- Indices de la tabla `insumo_tipo`
--
ALTER TABLE `insumo_tipo`
  ADD PRIMARY KEY (`id_insumo`,`id_tipo`),
  ADD KEY `FKivp1tkpuu7xt01yggchlcw3uf` (`id_tipo`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1wbpk06lc86s53p0o4021e146` (`insumo_id`);

--
-- Indices de la tabla `inventariopro`
--
ALTER TABLE `inventariopro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5fcw0ck8g2vfb305bctl0e8ge` (`producto_id`);

--
-- Indices de la tabla `privilegio`
--
ALTER TABLE `privilegio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `privilegio_cargo`
--
ALTER TABLE `privilegio_cargo`
  ADD PRIMARY KEY (`id_cargo`,`id_privilegio`),
  ADD KEY `FK5qtqnta5vq466pn4mymrta7n6` (`id_privilegio`);

--
-- Indices de la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj3x5vulm8e9s2oev0bijokhp9` (`area_id`),
  ADD KEY `FKbnmcqti8ggemtuo4e0lli0gh7` (`usuario_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD PRIMARY KEY (`id_producto`,`id_categoria`),
  ADD KEY `FKgwvyylk3oo917u8d8pq27olq7` (`id_categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkusn100klacbbe2qw74rfbsoj` (`inventario_id`),
  ADD KEY `FKio1ychckjhfxek4ypilhfedkq` (`usuario_id`);

--
-- Indices de la tabla `salidapro`
--
ALTER TABLE `salidapro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlgyfno2okttx4v1iehbqrcewf` (`inventario_id`),
  ADD KEY `FKaqld2gda3lg4ucofxshs77v98` (`usuario_id`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKhkbpo5cmco9h5smkprarnya5e` (`identificacion`),
  ADD UNIQUE KEY `UK_pimirdqbf828ejsgnxmc3kfix` (`user_name`),
  ADD UNIQUE KEY `UK_rp3xy79b9ophkgt0jeq37vqwv` (`user_name`);

--
-- Indices de la tabla `usuario_cargo`
--
ALTER TABLE `usuario_cargo`
  ADD PRIMARY KEY (`id_usuario`,`id_cargo`),
  ADD KEY `FKfriutlt0b0pprelqfordq4fve` (`id_cargo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entradapro`
--
ALTER TABLE `entradapro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `fabricacion`
--
ALTER TABLE `fabricacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `insumo`
--
ALTER TABLE `insumo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `inventariopro`
--
ALTER TABLE `inventariopro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `privilegio`
--
ALTER TABLE `privilegio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `produccion`
--
ALTER TABLE `produccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `salida`
--
ALTER TABLE `salida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `salidapro`
--
ALTER TABLE `salidapro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `area`
--
ALTER TABLE `area`
  ADD CONSTRAINT `FKg1l34t9f2g5kefrposef5u5ob` FOREIGN KEY (`fabricacion_id`) REFERENCES `fabricacion` (`id`);

--
-- Filtros para la tabla `area_empresa`
--
ALTER TABLE `area_empresa`
  ADD CONSTRAINT `FK6m9b2l54rallrw0qq2u8nnv0a` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `FKanb1e83ldf18qkle7n2t6v974` FOREIGN KEY (`id_area`) REFERENCES `area` (`id`);

--
-- Filtros para la tabla `area_usuario`
--
ALTER TABLE `area_usuario`
  ADD CONSTRAINT `FKgwp1qnlj6v8966dkewweflpey` FOREIGN KEY (`id_area`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKte20qfmk8cxk4smqquyo5qwe` FOREIGN KEY (`id_usuario`) REFERENCES `area` (`id`);

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `FK32gfienydryxrr7cvpiqtejso` FOREIGN KEY (`especialidad_id`) REFERENCES `especialidad` (`id`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK4y26wa0jba0pvfhfcwv17bi3f` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id`),
  ADD CONSTRAINT `FKcejqwringjwk7bo01ody2lnr2` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `entradapro`
--
ALTER TABLE `entradapro`
  ADD CONSTRAINT `FKgeiwgwjm2teuvlbpyef8uahs3` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKhsddwvo0mayyfbhsbnhhid2gf` FOREIGN KEY (`inventario_id`) REFERENCES `inventariopro` (`id`);

--
-- Filtros para la tabla `fabricacion_insumo`
--
ALTER TABLE `fabricacion_insumo`
  ADD CONSTRAINT `FK78iv095qsaq60n05wf30ksq35` FOREIGN KEY (`id_fabricacion`) REFERENCES `insumo` (`id`),
  ADD CONSTRAINT `FKbhb7uop3nxnll0hphe6r1y0xx` FOREIGN KEY (`id_insumo`) REFERENCES `fabricacion` (`id`);

--
-- Filtros para la tabla `fabricacion_producto`
--
ALTER TABLE `fabricacion_producto`
  ADD CONSTRAINT `FKdd6xqb09wbbxrd17q3lewpuv0` FOREIGN KEY (`id_producto`) REFERENCES `fabricacion` (`id`),
  ADD CONSTRAINT `FKs0ju55avaf3186vg7b84o2p2e` FOREIGN KEY (`id_fabricacion`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `fabricacion_usuario`
--
ALTER TABLE `fabricacion_usuario`
  ADD CONSTRAINT `FK54raexhbvt5ecwg9c4qiu1kl3` FOREIGN KEY (`id_usuario`) REFERENCES `fabricacion` (`id`),
  ADD CONSTRAINT `FKe2s7jjy7kha08rqugp2kmn3pn` FOREIGN KEY (`id_fabricacion`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD CONSTRAINT `FKmsmbrf64upncu8ieylvsb70r6` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`);

--
-- Filtros para la tabla `insumo_tipo`
--
ALTER TABLE `insumo_tipo`
  ADD CONSTRAINT `FKdfhqofkm8lu495elgks36njdl` FOREIGN KEY (`id_insumo`) REFERENCES `tipo` (`id`),
  ADD CONSTRAINT `FKivp1tkpuu7xt01yggchlcw3uf` FOREIGN KEY (`id_tipo`) REFERENCES `insumo` (`id`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `FK1wbpk06lc86s53p0o4021e146` FOREIGN KEY (`insumo_id`) REFERENCES `insumo` (`id`);

--
-- Filtros para la tabla `inventariopro`
--
ALTER TABLE `inventariopro`
  ADD CONSTRAINT `FK5fcw0ck8g2vfb305bctl0e8ge` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `privilegio_cargo`
--
ALTER TABLE `privilegio_cargo`
  ADD CONSTRAINT `FK5qtqnta5vq466pn4mymrta7n6` FOREIGN KEY (`id_privilegio`) REFERENCES `privilegio` (`id`),
  ADD CONSTRAINT `FKm52weui8tv8u1cnrcpjfvgdir` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`);

--
-- Filtros para la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD CONSTRAINT `FKbnmcqti8ggemtuo4e0lli0gh7` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKj3x5vulm8e9s2oev0bijokhp9` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`);

--
-- Filtros para la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD CONSTRAINT `FKgwvyylk3oo917u8d8pq27olq7` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `FKny56r8kiy3rt023t3ghlpre87` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `FKio1ychckjhfxek4ypilhfedkq` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKkusn100klacbbe2qw74rfbsoj` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id`);

--
-- Filtros para la tabla `salidapro`
--
ALTER TABLE `salidapro`
  ADD CONSTRAINT `FKaqld2gda3lg4ucofxshs77v98` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKlgyfno2okttx4v1iehbqrcewf` FOREIGN KEY (`inventario_id`) REFERENCES `inventariopro` (`id`);

--
-- Filtros para la tabla `usuario_cargo`
--
ALTER TABLE `usuario_cargo`
  ADD CONSTRAINT `FK9aau8s15lq8r5v02brfla2j90` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKfriutlt0b0pprelqfordq4fve` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
