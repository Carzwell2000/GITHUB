-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 26, 2025 at 07:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LottoDatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `LotteryNumbers`
--

CREATE TABLE `LotteryNumbers` (
  `num1` int(11) NOT NULL,
  `num2` int(11) NOT NULL,
  `num3` int(11) NOT NULL,
  `num4` int(11) NOT NULL,
  `num5` int(11) NOT NULL,
  `num6` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `LotteryNumbers`
--

INSERT INTO `LotteryNumbers` (`num1`, `num2`, `num3`, `num4`, `num5`, `num6`) VALUES
(1, 2, 3, 4, 5, 6),
(17, 16, 18, 19, 20, 21),
(39, 38, 37, 36, 33, 35),
(5, 6, 7, 8, 9, 21),
(6, 7, 38, 34, 37, 31),
(34, 36, 37, 35, 38, 39),
(1, 2, 3, 4, 5, 6),
(1, 2, 3, 4, 5, 6),
(1, 2, 3, 4, 34, 23);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
