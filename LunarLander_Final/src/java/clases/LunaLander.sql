
﻿CREATE DATABASE LunaLander;
use LunaLander;
-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-11-2017 a las 19:55:36
-- Versión del servidor: 5.1.63
-- Versión de PHP: 5.3.3-7+squeeze14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: 'LunaLander'
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'Configuration'
--

CREATE TABLE Configuration (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  dif_id int(11) NOT NULL,
  nave_id int(11) NOT NULL,
  luna_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY user_id (user_id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla 'Configuration'
--

INSERT INTO Configuration (id, user_id, dif_id, nave_id, luna_id) VALUES
(1, 1, 3, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'Score'
--

CREATE TABLE Score (
  id int(11) NOT NULL AUTO_INCREMENT,
  conf_id int(11) NOT NULL,
  speed float NOT NULL,
  fuel float NOT NULL,
  iniTime time NOT NULL,
  endTime time NOT NULL,
  PRIMARY KEY (id),
  KEY conf_id (conf_id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla 'Score'
--

INSERT INTO Score (id, conf_id, speed, fuel, iniTime, endTime) VALUES
(1, 1, 5.5, 20.1, '19:00:00', '19:02:20'),
(2, 1, 5.6, 20.2, '19:00:00', '19:03:20'),
(3, 1, 5.7, 20.3, '19:00:00', '19:04:20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'User'
--

CREATE TABLE User (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(20) NOT NULL,
  username varchar(20) NOT NULL,
  password varchar(255) NOT NULL,
  KEY id (id),
  KEY id_2 (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla 'User'
--

INSERT INTO `User` (id, nombre, username, `password`) VALUES
(1, 'Fabian', 'Toki', 'mal');
