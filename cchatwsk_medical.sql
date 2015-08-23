-- phpMyAdmin SQL Dump
-- version 4.0.10.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 23, 2015 at 05:20 AM
-- Server version: 5.5.44-37.3-log
-- PHP Version: 5.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cchatwsk_medical`
--

-- --------------------------------------------------------

--
-- Table structure for table `accelerometer`
--

CREATE TABLE IF NOT EXISTS `accelerometer` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `accelerometer`
--

INSERT INTO `accelerometer` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:54:01', 5),
(2, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:54:03', 5),
(3, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:02:40', 5),
(4, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:02:42', 5),
(5, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:02:49', 5),
(6, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:02:50', 5),
(7, 1, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:02:52', 5),
(8, 1, '', '', '00000000bb573a9a', '2015-08-23 05:13:52', 5),
(9, 1, '', '', '00000000bb573a9a', '2015-08-23 05:13:55', 5),
(10, 1, '', '', '00000000bb573a9a', '2015-08-23 05:13:56', 5),
(11, 1, '', '', '00000000bb573a9a', '2015-08-23 05:13:58', 5),
(12, 1, '', '', '00000000bb573a9a', '2015-08-23 05:14:12', 5),
(13, 1, '', '', '00000000bb573a9a', '2015-08-23 05:16:12', 5),
(14, 1, '', '', '00000000bb573a9a', '2015-08-23 05:16:14', 5),
(15, 1, '', '', '00000000bb573a9a', '2015-08-23 05:16:21', 5);

-- --------------------------------------------------------

--
-- Table structure for table `alcohol`
--

CREATE TABLE IF NOT EXISTS `alcohol` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `alcohol`
--

INSERT INTO `alcohol` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 1, '76.879858', '8.5576148', '00000000bb573a9a', '10:41 Am', 5);

-- --------------------------------------------------------

--
-- Table structure for table `carcount`
--

CREATE TABLE IF NOT EXISTS `carcount` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(100) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `carcount`
--

INSERT INTO `carcount` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:18:56', 5),
(2, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:36:27', 5),
(3, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:37:27', 5),
(4, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:37:43', 5),
(5, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:37:56', 5),
(6, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:38:10', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pedcount`
--

CREATE TABLE IF NOT EXISTS `pedcount` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(100) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `pedcount`
--

INSERT INTO `pedcount` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 'pedestrian_present', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:39:24', 5),
(2, 'pedestrian_present', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:39:46', 5),
(3, 'pedestrian_present', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:40:12', 5),
(4, 'pedestrian_present', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:40:35', 5),
(5, 'pedestrian_present', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:41:50', 5);

-- --------------------------------------------------------

--
-- Table structure for table `sound`
--

CREATE TABLE IF NOT EXISTS `sound` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(100) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `sound`
--

INSERT INTO `sound` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 'low', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:16:00', 5),
(2, 'low', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:16:24', 5),
(3, 'low', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:17:17', 5),
(4, 'high', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:29:30', 5),
(5, 'low', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:29:44', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tempreature`
--

CREATE TABLE IF NOT EXISTS `tempreature` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `temp` int(100) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `trafficsign`
--

CREATE TABLE IF NOT EXISTS `trafficsign` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(100) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `trafficsign`
--

INSERT INTO `trafficsign` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(4, 'bump', '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:22:16', 5);

-- --------------------------------------------------------

--
-- Table structure for table `ultrasound`
--

CREATE TABLE IF NOT EXISTS `ultrasound` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `lon` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `seen` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `ultrasound`
--

INSERT INTO `ultrasound` (`sno`, `level`, `lon`, `lat`, `id`, `time`, `seen`) VALUES
(1, 43, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:10:32', 0),
(2, 6, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:10:36', 0),
(3, 5, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:17:04', 5),
(4, 99, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:19:58', 5),
(5, 7, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:20:28', 5),
(6, 45, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:20:41', 5),
(7, 7, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:20:53', 5),
(8, 41, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:22:57', 5),
(9, 48, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:26:12', 5),
(10, 7, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:26:14', 5),
(11, 80, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:26:40', 5),
(12, 82, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:26:51', 5),
(13, 8, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:26:57', 5),
(14, 8, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:30:07', 5),
(15, 94, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:30:50', 5),
(16, 6, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:30:51', 5),
(17, 30, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:31:04', 5),
(18, 5, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:31:06', 5),
(19, 81, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:32:19', 5),
(20, 10, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 03:32:28', 5),
(21, 8, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:03:04', 5),
(22, 36, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:03:08', 5),
(23, 80, '76.879858', '8.5576148', '00000000bb573a9a', '2015-08-23 04:03:13', 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
