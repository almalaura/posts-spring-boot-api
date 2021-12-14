
--
-- Base de datos: `almalaurameza`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answers`
--

DROP TABLE IF EXISTS `answers`;
CREATE TABLE IF NOT EXISTS `answers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `idcomment` bigint(20) DEFAULT NULL,
  `iduser` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5xnkm27bt98nkjt584txu1mdj` (`idcomment`),
  KEY `FKdd3omch6rgf489rgkpewo54k6` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `idpost` bigint(20) DEFAULT NULL,
  `iduser` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnpifb9i6my6wadrv9lq0kph2d` (`idpost`),
  KEY `FKifgy5otfiwwp6d429kep72qgt` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posts`
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `iduser` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhcvmkpd9g2u1w9rinf7v0vjd6` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


--
-- Filtros para la tabla `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `FK5xnkm27bt98nkjt584txu1mdj` FOREIGN KEY (`idcomment`) REFERENCES `comments` (`id`),
  ADD CONSTRAINT `FKdd3omch6rgf489rgkpewo54k6` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FKifgy5otfiwwp6d429kep72qgt` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKnpifb9i6my6wadrv9lq0kph2d` FOREIGN KEY (`idpost`) REFERENCES `posts` (`id`);

--
-- Filtros para la tabla `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FKhcvmkpd9g2u1w9rinf7v0vjd6` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`);
COMMIT;

