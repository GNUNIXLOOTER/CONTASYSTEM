-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-07-2021 a las 17:17:34
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apertura_caja`
--

CREATE TABLE `apertura_caja` (
  `cod_caja` int(11) NOT NULL,
  `nombre_caja` varchar(200) NOT NULL,
  `monto_apertura` double(11,2) NOT NULL,
  `vendedor` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(200) NOT NULL,
  `estado` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `cod_articulo` varchar(150) NOT NULL,
  `referencia` varchar(150) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `proveedor` varchar(50) DEFAULT NULL,
  `valor` double(11,2) NOT NULL,
  `valor_bruto` double(11,2) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `ultima_actualizacion` varchar(50) NOT NULL,
  `codigo_provisorio` varchar(50) DEFAULT NULL,
  `codigo_unico` int(30) NOT NULL,
  `total_con_iva` double(11,2) NOT NULL,
  `porcentaje_ganancia` double(11,2) NOT NULL,
  `iva` double(11,2) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `valor_bruto_sin_iva` double(11,2) NOT NULL,
  `ivaCompra` double(11,2) NOT NULL,
  `impresion_etiqueta` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo_referencia`
--

CREATE TABLE `articulo_referencia` (
  `id` int(11) NOT NULL,
  `cod_articulo` varchar(20) NOT NULL,
  `proveedor` int(11) NOT NULL,
  `precio` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajas`
--

CREATE TABLE `cajas` (
  `cod_caja` int(11) NOT NULL,
  `nombre_caja` varchar(200) NOT NULL,
  `estado` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cajas`
--

INSERT INTO `cajas` (`cod_caja`, `nombre_caja`, `estado`) VALUES
(1, 'CAJA PRINCIPAL', 'CERRADA'),
(2, 'CAJA 2', 'CERRADA'),
(3, 'CAJA 3', 'CERRADA'),
(4, 'CAJA 4', 'CERRADA'),
(5, 'CAJA 5', 'CERRADA'),
(6, 'CAJA 6', 'CERRADA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cierre_caja`
--

CREATE TABLE `cierre_caja` (
  `cod_cierre` int(11) NOT NULL,
  `cod_caja` varchar(200) NOT NULL,
  `nombre_caja` varchar(200) NOT NULL,
  `monto_apertura` double(11,2) NOT NULL,
  `monto_compras` double(11,2) NOT NULL,
  `monto_ventas` double(11,2) NOT NULL,
  `monto_ingresos` double(11,2) NOT NULL,
  `monto_retiros` double(11,2) NOT NULL,
  `monto_saldos_cobrados` double(11,2) NOT NULL,
  `monto_saldos_pagados` double(11,2) NOT NULL,
  `monto_devolucion_ventas` double(11,2) NOT NULL,
  `monto_devolucion_compras` double(11,2) NOT NULL,
  `total_caja` double(11,2) NOT NULL,
  `vendedor` double(11,2) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `localidad` varchar(50) DEFAULT NULL,
  `dirrecion` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  `dni` varchar(20) DEFAULT NULL,
  `cuit` varchar(20) DEFAULT NULL,
  `contribuyente` varchar(25) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `nombres`, `localidad`, `dirrecion`, `telefono`, `estado`, `dni`, `cuit`, `contribuyente`, `provincia`, `email`) VALUES
(0, 'CONSUMIDOR FINAL', ' ', ' ', ' ', '', ' ', ' ', 'Consumidor Final', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `cod_compra` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_proveedor` int(11) NOT NULL,
  `condicion` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `tipo_factura` varchar(10) NOT NULL,
  `iva` varchar(10) NOT NULL,
  `total_con_iva` double(11,2) NOT NULL,
  `total_sin_iva` double(11,2) NOT NULL,
  `ivaDiscriminado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`cod_compra`, `fecha`, `cod_proveedor`, `condicion`, `categoria`, `tipo_pago`, `tipo_factura`, `iva`, `total_con_iva`, `total_sin_iva`, `ivaDiscriminado`) VALUES
(0, '2012-02-01', 0, '0', '0', '0', '0', '0', 0.00, 0.00, '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_cheque`
--

CREATE TABLE `compra_cheque` (
  `cod_cheque` int(11) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `num_cheque` varchar(200) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `monto` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_credito`
--

CREATE TABLE `compra_credito` (
  `cod_credito` int(11) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `total` double(11,2) NOT NULL,
  `acuenta` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_deposito`
--

CREATE TABLE `compra_deposito` (
  `cod_deposito` int(11) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `num_cuenta` varchar(200) NOT NULL,
  `num_deposito` varchar(200) NOT NULL,
  `monto` double(11,2) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_efectivo`
--

CREATE TABLE `compra_efectivo` (
  `cod_efectivo` int(11) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `subtotal` double(11,2) NOT NULL,
  `iva` double(11,2) NOT NULL,
  `total` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_mixta`
--

CREATE TABLE `compra_mixta` (
  `cod_mixta` int(11) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `total` double(11,2) NOT NULL,
  `monto_efectivo` double(11,2) NOT NULL,
  `monto_tarjeta` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `vuelto` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE `contiene` (
  `cod_contiene` int(11) NOT NULL,
  `cod_articulo` int(11) NOT NULL,
  `cod_factura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_corriente`
--

CREATE TABLE `cuenta_corriente` (
  `cod_cuenta` int(11) NOT NULL,
  `cod_cliente` varchar(150) NOT NULL,
  `ultimo_pago` double(11,2) NOT NULL,
  `fecha_ultimo_pago` date NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuenta_corriente`
--

INSERT INTO `cuenta_corriente` (`cod_cuenta`, `cod_cliente`, `ultimo_pago`, `fecha_ultimo_pago`, `total_pago`, `saldo_restante`) VALUES
(0, '0', 0.00, '2019-03-16', 0.00, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_credito_compra`
--

CREATE TABLE `cuenta_credito_compra` (
  `cod_cuenta` int(11) NOT NULL,
  `cod_proveedor` varchar(150) NOT NULL,
  `ultimo_pago` double(11,2) NOT NULL,
  `fecha_ultimo_pago` date NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_credito_venta`
--

CREATE TABLE `cuenta_credito_venta` (
  `cod_cuenta` int(11) NOT NULL,
  `cod_cliente` varchar(150) NOT NULL,
  `ultimo_pago` double(11,2) NOT NULL,
  `fecha_ultimo_pago` date NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion_compra`
--

CREATE TABLE `devolucion_compra` (
  `cod_devolucion` int(11) NOT NULL,
  `cod_caja` varchar(200) NOT NULL,
  `cod_compra` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `monto_efectivo` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion_venta`
--

CREATE TABLE `devolucion_venta` (
  `cod_devolucion` int(11) NOT NULL,
  `cod_caja` varchar(200) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `monto_efectivo` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribuye`
--

CREATE TABLE `distribuye` (
  `cod_distribuye` int(11) NOT NULL,
  `cod_proveedor` int(11) NOT NULL,
  `cod_articulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `cod_empleado` int(11) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `dirrecion` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `localidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`cod_empleado`, `nombres`, `apellidos`, `dirrecion`, `telefono`, `estado`, `dni`, `localidad`) VALUES
(1, 'NACIONAL', 'CODE', 'NACIONAL CODE', '+ 57 3504931577', 'ACTIVO', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `cod_empresa` int(3) NOT NULL,
  `nombreTitular` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cuit` varchar(50) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `imagen` blob NOT NULL,
  `fechaInicio` varchar(30) NOT NULL,
  `ingresosBrutos` varchar(50) NOT NULL,
  `punto_de_venta` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`cod_empresa`, `nombreTitular`, `nombre`, `cuit`, `tipo`, `direccion`, `localidad`, `provincia`, `telefono`, `correo`, `imagen`, `fechaInicio`, `ingresosBrutos`, `punto_de_venta`) VALUES
(1, 'NACIONAL CODE', 'NACIONAL CODE', '+57 3504931577', 'Responsable Monotributo', 'NACIONAL CODE', 'NACIONAL CODE', 'NACIONAL CODE', '+57 3504931577', 'VENTAS@NACIONALCODE.COM', 0x433a5c55736572735c4875676f5c446f63756d656e74735c626572746f313533303139333933392e706e67, '1/10/2013', '0111358856656', '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `cod_factura` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_empleado` int(11) NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `condicion` varchar(50) NOT NULL,
  `iva` varchar(10) NOT NULL,
  `tipo_factura` varchar(20) NOT NULL,
  `total_con_iva` double(11,2) NOT NULL,
  `total_sin_iva` double(11,2) NOT NULL,
  `ivaDiscriminado` varchar(10) NOT NULL,
  `estado_afip` varchar(30) NOT NULL,
  `cae` varchar(200) DEFAULT NULL,
  `vencimiento_cae` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`cod_factura`, `fecha`, `cod_cliente`, `cod_empleado`, `tipo_pago`, `condicion`, `iva`, `tipo_factura`, `total_con_iva`, `total_sin_iva`, `ivaDiscriminado`, `estado_afip`, `cae`, `vencimiento_cae`) VALUES
(0, '2014-01-23', 0, 0, '0', '0', '0', '0', 0.00, 0.00, '0.00', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturable`
--

CREATE TABLE `facturable` (
  `fecha` varchar(8) NOT NULL DEFAULT '',
  `tipo` varchar(3) NOT NULL DEFAULT '011',
  `pto` varchar(5) NOT NULL DEFAULT '00002',
  `numero` varchar(20) NOT NULL DEFAULT '',
  `gravado` double NOT NULL DEFAULT 0,
  `alicuota` varchar(4) NOT NULL DEFAULT '0005',
  `impuesto` double NOT NULL DEFAULT 0,
  `id` int(11) NOT NULL,
  `total` double NOT NULL DEFAULT 0,
  `fechaRegistro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` int(11) NOT NULL DEFAULT 0,
  `idcliente` int(11) NOT NULL DEFAULT 1,
  `tipoClienteId` int(11) NOT NULL DEFAULT 99,
  `razon` varchar(30) NOT NULL DEFAULT '',
  `cuit` varchar(20) NOT NULL DEFAULT '',
  `afip` varchar(20) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fiscal`
--

CREATE TABLE `fiscal` (
  `fecha` varchar(8) NOT NULL DEFAULT '',
  `tipo` varchar(3) NOT NULL DEFAULT '011',
  `pto` varchar(5) NOT NULL DEFAULT '00002',
  `numero` varchar(20) NOT NULL DEFAULT '',
  `gravado` double NOT NULL DEFAULT 0,
  `alicuota` varchar(4) NOT NULL DEFAULT '0005',
  `impuesto` double NOT NULL DEFAULT 0,
  `id` int(11) NOT NULL,
  `total` double NOT NULL DEFAULT 0,
  `fechaRegistro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` int(11) NOT NULL DEFAULT 0,
  `idcliente` int(11) NOT NULL DEFAULT 1,
  `tipoClienteId` int(11) NOT NULL DEFAULT 99,
  `razon` varchar(30) NOT NULL DEFAULT '',
  `cuit` varchar(20) NOT NULL DEFAULT '',
  `cae` varchar(200) NOT NULL,
  `vencimiento_cae` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `idhotel` int(11) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso_efectivo`
--

CREATE TABLE `ingreso_efectivo` (
  `cod_ingreso` int(11) NOT NULL,
  `cod_caja` varchar(200) NOT NULL,
  `monto_ingresado` double(11,2) NOT NULL,
  `concepto` varchar(200) NOT NULL,
  `vendedor` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso_usuarios`
--

CREATE TABLE `ingreso_usuarios` (
  `cod_ingreso` int(11) NOT NULL,
  `nombre_usuario` varchar(200) NOT NULL,
  `fecha_ingreso` timestamp NULL DEFAULT current_timestamp(),
  `fecha_salida` timestamp NULL DEFAULT NULL,
  `estado` varchar(200) NOT NULL,
  `tipo_usuario` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingreso_usuarios`
--

INSERT INTO `ingreso_usuarios` (`cod_ingreso`, `nombre_usuario`, `fecha_ingreso`, `fecha_salida`, `estado`, `tipo_usuario`) VALUES
(125, 'NACIONAL CODE', '2021-07-09 15:11:51', '2021-07-09 15:17:22', 'INACTIVO', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE `localidad` (
  `cod_localidad` int(11) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `codigo_postal` varchar(50) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monedas`
--

CREATE TABLE `monedas` (
  `cod_moneda` int(11) NOT NULL,
  `nombre_moneda` varchar(150) NOT NULL,
  `signo_moneda` varchar(150) CHARACTER SET utf8 NOT NULL,
  `estado` varchar(50) NOT NULL,
  `seleccion_moneda` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `monedas`
--

INSERT INTO `monedas` (`cod_moneda`, `nombre_moneda`, `signo_moneda`, `estado`, `seleccion_moneda`) VALUES
(1, 'DOLARES ESTADO ESTADOUNIDENCES', 'USD', 'ACTIVA', ''),
(3, 'PESOS COLOMBIANOS', '$', 'ACTIVA', 'SELECCIONADA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota_credito`
--

CREATE TABLE `nota_credito` (
  `cod_nota_credito` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_empleado` int(11) NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `condicion` varchar(50) NOT NULL,
  `iva` varchar(10) NOT NULL,
  `tipo_nota_credito` varchar(20) NOT NULL,
  `total_con_iva` double(11,2) NOT NULL,
  `total_sin_iva` double(11,2) NOT NULL,
  `ivaDiscriminado` varchar(10) NOT NULL,
  `referencia_factura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nota_credito`
--

INSERT INTO `nota_credito` (`cod_nota_credito`, `fecha`, `cod_cliente`, `cod_empleado`, `tipo_pago`, `condicion`, `iva`, `tipo_nota_credito`, `total_con_iva`, `total_sin_iva`, `ivaDiscriminado`, `referencia_factura`) VALUES
(0, '2015-02-01', 0, 0, '0', '0', '0', '0', 0.00, 0.00, '0', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota_credito_compra`
--

CREATE TABLE `nota_credito_compra` (
  `cod_nota_credito_compra` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_proveedor` int(11) NOT NULL,
  `cod_empleado` int(11) NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `condicion` varchar(50) NOT NULL,
  `iva` varchar(10) NOT NULL,
  `tipo_nota_credito` varchar(20) NOT NULL,
  `total_con_iva` double(11,2) NOT NULL,
  `total_sin_iva` double(11,2) NOT NULL,
  `ivaDiscriminado` varchar(10) NOT NULL,
  `referencia_factura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nota_credito_compra`
--

INSERT INTO `nota_credito_compra` (`cod_nota_credito_compra`, `fecha`, `cod_proveedor`, `cod_empleado`, `tipo_pago`, `condicion`, `iva`, `tipo_nota_credito`, `total_con_iva`, `total_sin_iva`, `ivaDiscriminado`, `referencia_factura`) VALUES
(0, '2012-02-03', 0, 0, '0', '0', '0', '0', 0.00, 0.00, '0', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `porcentajes`
--

CREATE TABLE `porcentajes` (
  `id` int(11) NOT NULL,
  `porcentaje_ganancia` varchar(30) NOT NULL,
  `porcentaje_iva_compra` varchar(30) NOT NULL,
  `porcentaje_iva_venta` varchar(30) NOT NULL,
  `actualizacionPrecios` varchar(50) NOT NULL,
  `porcentaje_iva_factura` varchar(50) NOT NULL,
  `impresion` varchar(200) NOT NULL,
  `tipo_factura_electronica` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `porcentajes`
--

INSERT INTO `porcentajes` (`id`, `porcentaje_ganancia`, `porcentaje_iva_compra`, `porcentaje_iva_venta`, `actualizacionPrecios`, `porcentaje_iva_factura`, `impresion`, `tipo_factura_electronica`) VALUES
(1, '65', '0%', '0%', 'INACTIVO', '0%', '56', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presupuesto`
--

CREATE TABLE `presupuesto` (
  `cod_presupuesto` int(11) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `cod_cliente` varchar(30) NOT NULL,
  `cod_empleado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `presupuesto`
--

INSERT INTO `presupuesto` (`cod_presupuesto`, `fecha`, `cod_cliente`, `cod_empleado`) VALUES
(0, '20130102', '0', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `cod_proveedor` int(11) NOT NULL,
  `nombre_firma` varchar(30) NOT NULL,
  `responsable_firma` varchar(40) NOT NULL,
  `direccion_firma` varchar(40) NOT NULL,
  `ciudad_firma` varchar(40) NOT NULL,
  `cod_postal_firma` varchar(30) NOT NULL,
  `provincia_firma` varchar(30) NOT NULL,
  `cuit` varchar(50) NOT NULL,
  `ingresos_brutos` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
  `cbu` varchar(50) NOT NULL,
  `telefono_firma` varchar(30) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `condicion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`cod_proveedor`, `nombre_firma`, `responsable_firma`, `direccion_firma`, `ciudad_firma`, `cod_postal_firma`, `provincia_firma`, `cuit`, `ingresos_brutos`, `cbu`, `telefono_firma`, `estado`, `condicion`) VALUES
(0, 'SIN PROVEEDOR', '', '-', '', '', '', '', '', '', '', 'ACTIVO', 'Consumidor Final');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `realiza`
--

CREATE TABLE `realiza` (
  `cod_realiza` int(11) NOT NULL,
  `cod_factura` int(11) NOT NULL,
  `cod_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_compra`
--

CREATE TABLE `referencia_compra` (
  `cod_compra` int(11) NOT NULL,
  `codigo_producto` varchar(150) NOT NULL,
  `referencia` varchar(100) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `unitario_costo` double(11,2) NOT NULL,
  `total_costo` double(11,2) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `total_compra` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL,
  `unitario_sin_iva` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_cuenta_corriente`
--

CREATE TABLE `referencia_cuenta_corriente` (
  `id` int(11) NOT NULL,
  `cod_cuenta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `pago_abonado` double(11,2) NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `total_remitos` double(11,2) NOT NULL,
  `actualizacion_precios` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_cuenta_credito_compra`
--

CREATE TABLE `referencia_cuenta_credito_compra` (
  `id` int(11) NOT NULL,
  `cod_cuenta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `pago_abonado` double(11,2) NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `total_factura` double(11,2) NOT NULL,
  `cod_factura` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_cuenta_credito_venta`
--

CREATE TABLE `referencia_cuenta_credito_venta` (
  `id` int(11) NOT NULL,
  `cod_cuenta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `pago_abonado` double(11,2) NOT NULL,
  `total_pago` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `total_factura` double(11,2) NOT NULL,
  `cod_factura` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_factura`
--

CREATE TABLE `referencia_factura` (
  `cod_factura` int(11) NOT NULL,
  `codigo_producto` varchar(150) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `referencia` varchar(150) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `Total` double(11,2) NOT NULL,
  `unitarioBruto` double(11,2) NOT NULL,
  `totalBruto` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_nota_credito`
--

CREATE TABLE `referencia_nota_credito` (
  `cod_nota_credito` int(11) NOT NULL,
  `codigo_producto` varchar(150) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `referencia` varchar(150) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `Total` double(11,2) NOT NULL,
  `unitarioBruto` double(11,2) NOT NULL,
  `totalBruto` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_nota_credito_compra`
--

CREATE TABLE `referencia_nota_credito_compra` (
  `cod_nota_credito_compra` int(11) NOT NULL,
  `codigo_producto` varchar(150) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `referencia` varchar(150) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `Total` double(11,2) NOT NULL,
  `unitarioBruto` double(11,2) NOT NULL,
  `totalBruto` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_presupuesto`
--

CREATE TABLE `referencia_presupuesto` (
  `cod_presupuesto` int(11) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `referencia` varchar(150) NOT NULL,
  `cantidad` double(11,2) NOT NULL,
  `Total` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencia_remito`
--

CREATE TABLE `referencia_remito` (
  `cod_remito` int(11) NOT NULL,
  `valor_unitario` double(11,2) NOT NULL,
  `valor_total` double(11,2) NOT NULL,
  `cod_articulo` varchar(150) NOT NULL,
  `referencia` varchar(150) DEFAULT NULL,
  `cantidad` double(11,2) DEFAULT NULL,
  `total` double(11,2) NOT NULL,
  `unitarioBruto` double(11,2) NOT NULL,
  `totalBruto` double(11,2) NOT NULL,
  `unitario_sin_iva` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `remito`
--

CREATE TABLE `remito` (
  `cod_remito` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_empleado` int(11) NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `condicion` varchar(20) NOT NULL,
  `total` double(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante_empresa`
--

CREATE TABLE `representante_empresa` (
  `cod_representante` int(11) NOT NULL,
  `nombre_apellido` varchar(40) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `empresa` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `retiro_efectivo`
--

CREATE TABLE `retiro_efectivo` (
  `cod_retiro` int(11) NOT NULL,
  `cod_caja` varchar(200) NOT NULL,
  `monto_retirado` double(11,2) NOT NULL,
  `concepto` varchar(200) NOT NULL,
  `vendedor` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicita`
--

CREATE TABLE `solicita` (
  `cod_solicita` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_factura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `clave` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `usuario` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `acceso` varchar(25) NOT NULL,
  `cod_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`clave`, `usuario`, `nombre`, `apellido`, `direccion`, `telefono`, `estado`, `acceso`, `cod_usuario`) VALUES
('admin', 'admin', 'NACIONAL', 'CODE', '', '', 'ACTIVO', 'Administrador', 1),
('facturador', 'facturador', 'FACTURADOR', 'PRUEBA', '', '', 'ACTIVO', 'Facturador', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_cheque`
--

CREATE TABLE `venta_cheque` (
  `cod_cheque` int(11) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `num_cheque` varchar(200) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `monto` double(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_credito`
--

CREATE TABLE `venta_credito` (
  `cod_credito` int(11) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `total` double(11,2) NOT NULL,
  `acuenta` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_deposito`
--

CREATE TABLE `venta_deposito` (
  `cod_deposito` int(11) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `num_cuenta` varchar(200) NOT NULL,
  `num_deposito` varchar(200) NOT NULL,
  `monto` double(11,2) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_efectivo`
--

CREATE TABLE `venta_efectivo` (
  `cod_efectivo` int(11) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `subtotal` double(11,2) NOT NULL,
  `iva` double(11,2) NOT NULL,
  `total` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_mixta`
--

CREATE TABLE `venta_mixta` (
  `cod_mixta` int(11) NOT NULL,
  `cod_venta` varchar(200) NOT NULL,
  `total` double(11,2) NOT NULL,
  `monto_efectivo` double(11,2) NOT NULL,
  `monto_tarjeta` double(11,2) NOT NULL,
  `saldo_restante` double(11,2) NOT NULL,
  `vuelto` double(11,2) NOT NULL,
  `cod_caja` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apertura_caja`
--
ALTER TABLE `apertura_caja`
  ADD PRIMARY KEY (`cod_caja`);

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`codigo_unico`),
  ADD KEY `descripcion` (`referencia`,`cantidad`,`valor`,`valor_bruto`) USING BTREE;

--
-- Indices de la tabla `articulo_referencia`
--
ALTER TABLE `articulo_referencia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cajas`
--
ALTER TABLE `cajas`
  ADD PRIMARY KEY (`cod_caja`);

--
-- Indices de la tabla `cierre_caja`
--
ALTER TABLE `cierre_caja`
  ADD PRIMARY KEY (`cod_cierre`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`),
  ADD KEY `nombres` (`nombres`,`localidad`,`dirrecion`,`telefono`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`cod_compra`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_cliente` (`cod_proveedor`);

--
-- Indices de la tabla `compra_cheque`
--
ALTER TABLE `compra_cheque`
  ADD PRIMARY KEY (`cod_cheque`);

--
-- Indices de la tabla `compra_credito`
--
ALTER TABLE `compra_credito`
  ADD PRIMARY KEY (`cod_credito`);

--
-- Indices de la tabla `compra_deposito`
--
ALTER TABLE `compra_deposito`
  ADD PRIMARY KEY (`cod_deposito`);

--
-- Indices de la tabla `compra_efectivo`
--
ALTER TABLE `compra_efectivo`
  ADD PRIMARY KEY (`cod_efectivo`);

--
-- Indices de la tabla `compra_mixta`
--
ALTER TABLE `compra_mixta`
  ADD PRIMARY KEY (`cod_mixta`);

--
-- Indices de la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`cod_contiene`),
  ADD KEY `cod.articulo` (`cod_articulo`,`cod_factura`),
  ADD KEY `cod_factura` (`cod_factura`);

--
-- Indices de la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  ADD PRIMARY KEY (`cod_cuenta`);

--
-- Indices de la tabla `cuenta_credito_compra`
--
ALTER TABLE `cuenta_credito_compra`
  ADD PRIMARY KEY (`cod_cuenta`);

--
-- Indices de la tabla `cuenta_credito_venta`
--
ALTER TABLE `cuenta_credito_venta`
  ADD PRIMARY KEY (`cod_cuenta`);

--
-- Indices de la tabla `devolucion_compra`
--
ALTER TABLE `devolucion_compra`
  ADD PRIMARY KEY (`cod_devolucion`);

--
-- Indices de la tabla `devolucion_venta`
--
ALTER TABLE `devolucion_venta`
  ADD PRIMARY KEY (`cod_devolucion`);

--
-- Indices de la tabla `distribuye`
--
ALTER TABLE `distribuye`
  ADD KEY `cod_articulo` (`cod_articulo`),
  ADD KEY `cod_proveedor` (`cod_proveedor`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cod_empleado`),
  ADD KEY `nombres` (`nombres`,`apellidos`,`dirrecion`,`telefono`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`cod_empresa`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`cod_factura`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_cliente` (`cod_cliente`,`cod_empleado`);

--
-- Indices de la tabla `facturable`
--
ALTER TABLE `facturable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `numero_2` (`numero`);

--
-- Indices de la tabla `fiscal`
--
ALTER TABLE `fiscal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `numero_2` (`numero`);

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idhotel`);

--
-- Indices de la tabla `ingreso_efectivo`
--
ALTER TABLE `ingreso_efectivo`
  ADD PRIMARY KEY (`cod_ingreso`);

--
-- Indices de la tabla `ingreso_usuarios`
--
ALTER TABLE `ingreso_usuarios`
  ADD PRIMARY KEY (`cod_ingreso`);

--
-- Indices de la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD PRIMARY KEY (`cod_localidad`);

--
-- Indices de la tabla `monedas`
--
ALTER TABLE `monedas`
  ADD PRIMARY KEY (`cod_moneda`);

--
-- Indices de la tabla `nota_credito`
--
ALTER TABLE `nota_credito`
  ADD PRIMARY KEY (`cod_nota_credito`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_cliente` (`cod_cliente`,`cod_empleado`);

--
-- Indices de la tabla `nota_credito_compra`
--
ALTER TABLE `nota_credito_compra`
  ADD PRIMARY KEY (`cod_nota_credito_compra`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_proveedor` (`cod_proveedor`,`cod_empleado`);

--
-- Indices de la tabla `porcentajes`
--
ALTER TABLE `porcentajes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `presupuesto`
--
ALTER TABLE `presupuesto`
  ADD PRIMARY KEY (`cod_presupuesto`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_cliente` (`cod_cliente`,`cod_empleado`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`cod_proveedor`);

--
-- Indices de la tabla `realiza`
--
ALTER TABLE `realiza`
  ADD PRIMARY KEY (`cod_realiza`),
  ADD KEY `cod.factura` (`cod_factura`,`cod_empleado`),
  ADD KEY `cod_factura` (`cod_factura`),
  ADD KEY `cod_empleado` (`cod_empleado`);

--
-- Indices de la tabla `referencia_cuenta_corriente`
--
ALTER TABLE `referencia_cuenta_corriente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `referencia_cuenta_credito_compra`
--
ALTER TABLE `referencia_cuenta_credito_compra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `referencia_cuenta_credito_venta`
--
ALTER TABLE `referencia_cuenta_credito_venta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `referencia_factura`
--
ALTER TABLE `referencia_factura`
  ADD KEY `cod_factura` (`cod_factura`);

--
-- Indices de la tabla `referencia_nota_credito`
--
ALTER TABLE `referencia_nota_credito`
  ADD KEY `cod_nota_credito` (`cod_nota_credito`);

--
-- Indices de la tabla `referencia_nota_credito_compra`
--
ALTER TABLE `referencia_nota_credito_compra`
  ADD KEY `cod_nota_credito_compra` (`cod_nota_credito_compra`);

--
-- Indices de la tabla `referencia_presupuesto`
--
ALTER TABLE `referencia_presupuesto`
  ADD KEY `cod_presupuesto` (`cod_presupuesto`);

--
-- Indices de la tabla `referencia_remito`
--
ALTER TABLE `referencia_remito`
  ADD KEY `cod_remito` (`cod_remito`);

--
-- Indices de la tabla `remito`
--
ALTER TABLE `remito`
  ADD PRIMARY KEY (`cod_remito`),
  ADD KEY `descripcion` (`fecha`),
  ADD KEY `cod_cliente` (`cod_cliente`,`cod_empleado`);

--
-- Indices de la tabla `representante_empresa`
--
ALTER TABLE `representante_empresa`
  ADD PRIMARY KEY (`cod_representante`);

--
-- Indices de la tabla `retiro_efectivo`
--
ALTER TABLE `retiro_efectivo`
  ADD PRIMARY KEY (`cod_retiro`);

--
-- Indices de la tabla `solicita`
--
ALTER TABLE `solicita`
  ADD PRIMARY KEY (`cod_solicita`),
  ADD KEY `cod.cliente` (`cod_cliente`,`cod_factura`),
  ADD KEY `cod_cliente` (`cod_cliente`),
  ADD KEY `cod_cliente_2` (`cod_cliente`),
  ADD KEY `cod_factura` (`cod_factura`),
  ADD KEY `cod_cliente_3` (`cod_cliente`),
  ADD KEY `cod_factura_2` (`cod_factura`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- Indices de la tabla `venta_cheque`
--
ALTER TABLE `venta_cheque`
  ADD PRIMARY KEY (`cod_cheque`);

--
-- Indices de la tabla `venta_credito`
--
ALTER TABLE `venta_credito`
  ADD PRIMARY KEY (`cod_credito`);

--
-- Indices de la tabla `venta_deposito`
--
ALTER TABLE `venta_deposito`
  ADD PRIMARY KEY (`cod_deposito`);

--
-- Indices de la tabla `venta_efectivo`
--
ALTER TABLE `venta_efectivo`
  ADD PRIMARY KEY (`cod_efectivo`);

--
-- Indices de la tabla `venta_mixta`
--
ALTER TABLE `venta_mixta`
  ADD PRIMARY KEY (`cod_mixta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apertura_caja`
--
ALTER TABLE `apertura_caja`
  MODIFY `cod_caja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `codigo_unico` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de la tabla `articulo_referencia`
--
ALTER TABLE `articulo_referencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `cajas`
--
ALTER TABLE `cajas`
  MODIFY `cod_caja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cierre_caja`
--
ALTER TABLE `cierre_caja`
  MODIFY `cod_cierre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compra_cheque`
--
ALTER TABLE `compra_cheque`
  MODIFY `cod_cheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `compra_credito`
--
ALTER TABLE `compra_credito`
  MODIFY `cod_credito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `compra_deposito`
--
ALTER TABLE `compra_deposito`
  MODIFY `cod_deposito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `compra_efectivo`
--
ALTER TABLE `compra_efectivo`
  MODIFY `cod_efectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `compra_mixta`
--
ALTER TABLE `compra_mixta`
  MODIFY `cod_mixta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  MODIFY `cod_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `cuenta_credito_compra`
--
ALTER TABLE `cuenta_credito_compra`
  MODIFY `cod_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `cuenta_credito_venta`
--
ALTER TABLE `cuenta_credito_venta`
  MODIFY `cod_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `devolucion_compra`
--
ALTER TABLE `devolucion_compra`
  MODIFY `cod_devolucion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `devolucion_venta`
--
ALTER TABLE `devolucion_venta`
  MODIFY `cod_devolucion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `cod_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `facturable`
--
ALTER TABLE `facturable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=329;

--
-- AUTO_INCREMENT de la tabla `fiscal`
--
ALTER TABLE `fiscal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=365;

--
-- AUTO_INCREMENT de la tabla `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idhotel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingreso_efectivo`
--
ALTER TABLE `ingreso_efectivo`
  MODIFY `cod_ingreso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ingreso_usuarios`
--
ALTER TABLE `ingreso_usuarios`
  MODIFY `cod_ingreso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT de la tabla `localidad`
--
ALTER TABLE `localidad`
  MODIFY `cod_localidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `monedas`
--
ALTER TABLE `monedas`
  MODIFY `cod_moneda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `porcentajes`
--
ALTER TABLE `porcentajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `referencia_cuenta_corriente`
--
ALTER TABLE `referencia_cuenta_corriente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `referencia_cuenta_credito_compra`
--
ALTER TABLE `referencia_cuenta_credito_compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT de la tabla `referencia_cuenta_credito_venta`
--
ALTER TABLE `referencia_cuenta_credito_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=143;

--
-- AUTO_INCREMENT de la tabla `representante_empresa`
--
ALTER TABLE `representante_empresa`
  MODIFY `cod_representante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `retiro_efectivo`
--
ALTER TABLE `retiro_efectivo`
  MODIFY `cod_retiro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `cod_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `venta_cheque`
--
ALTER TABLE `venta_cheque`
  MODIFY `cod_cheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `venta_credito`
--
ALTER TABLE `venta_credito`
  MODIFY `cod_credito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `venta_deposito`
--
ALTER TABLE `venta_deposito`
  MODIFY `cod_deposito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `venta_efectivo`
--
ALTER TABLE `venta_efectivo`
  MODIFY `cod_efectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT de la tabla `venta_mixta`
--
ALTER TABLE `venta_mixta`
  MODIFY `cod_mixta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
