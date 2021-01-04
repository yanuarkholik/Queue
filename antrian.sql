-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 03:28 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `queue`
--

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `Serial` int(10) NOT NULL,
  `Customer_Name` varchar(30) NOT NULL,
  `Type_Of_Service` varchar(30) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Detail_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`Serial`, `Customer_Name`, `Type_Of_Service`, `Description`, `Detail_Date`) VALUES
(1, 'cc', 'Software', 'aaaa', '0000-00-00'),
(2, 'lagi', 'Software', 'gg', '2020-04-08'),
(3, 'Jane', 'Hardware', 'vga rusak', '2020-04-08'),
(4, 'Jasmine', 'Software', 'the software won\'t work', '2020-04-08'),
(5, 'Jessica', 'Charger', 'the charger not working ', '2020-04-08'),
(6, 'Aren', 'Others', 'plapla', '2020-04-08'),
(7, 'Justin', 'Others', 'nvme', '2020-04-08'),
(8, 'Yeji', 'Sim', 'i don\'t know how to setup', '2020-04-08'),
(9, 'Asta', 'Sim', 'need quota', '2020-04-12');

-- --------------------------------------------------------

--
-- Table structure for table `served_queue`
--

CREATE TABLE `served_queue` (
  `Serial` int(11) NOT NULL,
  `Customer_Name` varchar(30) NOT NULL,
  `Type_Of_Service` varchar(30) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Detail_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `served_queue`
--

INSERT INTO `served_queue` (`Serial`, `Customer_Name`, `Type_Of_Service`, `Description`, `Detail_Date`) VALUES
(1, 'Jane', 'Hardware', 'vga rusak', '2020-04-12'),
(2, 'Jasmine', 'Software', 'the software won\'t work', '2020-04-12'),
(3, 'Jessica', 'Charger', 'the charger not working ', '2020-04-12'),
(4, 'Asta', 'Sim', 'need quota', '2020-04-12');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `Serial` int(10) NOT NULL,
  `Customer_Name` varchar(30) NOT NULL,
  `Type_Of_Service` varchar(30) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Detail_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`Serial`, `Customer_Name`, `Type_Of_Service`, `Description`, `Detail_Date`) VALUES
(9, 'Aren', 'Others', 'plapla', '2020-04-08'),
(10, 'Justin', 'Others', 'nvme', '2020-04-08'),
(11, 'Yeji', 'Sim', 'i don\'t know how to setup', '2020-04-08');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(1, 'a', 'a', 'Admin'),
(2, 'tayo', '123', 'guest');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`Serial`);

--
-- Indexes for table `served_queue`
--
ALTER TABLE `served_queue`
  ADD PRIMARY KEY (`Serial`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Serial`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `Serial` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `served_queue`
--
ALTER TABLE `served_queue`
  MODIFY `Serial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `Serial` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
