-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:12 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fideline_ishimwe_mpundu_l_m_s`
--

-- --------------------------------------------------------

--
-- Table structure for table `adimn`
--

CREATE TABLE `adimn` (
  `ID` int(23) NOT NULL,
  `username` varchar(120) NOT NULL,
  `password` varchar(67) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

CREATE TABLE `authors` (
  `AU_ID` int(23) NOT NULL,
  `AU_FNAME` varchar(120) NOT NULL,
  `AU_LNAME` varchar(67) NOT NULL,
  `AU_biography` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`AU_ID`, `AU_FNAME`, `AU_LNAME`, `AU_biography`) VALUES
(1, 'fie', 'keza', 'root'),
(2, 'aime', 'sugira', 'rub'),
(3, 'safi', 'shema', 'rj');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(23) NOT NULL,
  `book_title` varchar(120) NOT NULL,
  `book_isnb` varchar(67) NOT NULL,
  `book_pubyear` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `book_isnb`, `book_pubyear`) VALUES
(1, 'chemistry', 'rt', 2009),
(2, 'ICT', 'rK', 1899),
(3, 'JAVA', 'rK', 1990);

-- --------------------------------------------------------

--
-- Table structure for table `borrowing`
--

CREATE TABLE `borrowing` (
  `ID` int(23) NOT NULL,
  `returndate` text NOT NULL,
  `borrowingdate` text NOT NULL,
  `amount` int(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowing`
--

INSERT INTO `borrowing` (`ID`, `returndate`, `borrowingdate`, `amount`) VALUES
(1, '11/09/2000', '13/08/1999', 9000),
(2, '10/09/2009', '12/09/2023', 700);

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `lngid` int(23) NOT NULL,
  `lng_fname` varchar(120) NOT NULL,
  `lng_lname` varchar(67) NOT NULL,
  `lng_country` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`lngid`, `lng_fname`, `lng_lname`, `lng_country`) VALUES
(1, 'FIDE', 'KAM', 'rwanda'),
(2, 'FIDh', 'tyy', 'congo');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(23) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(67) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `pub_id` int(23) NOT NULL,
  `pub_fname` varchar(120) NOT NULL,
  `pub_lname` varchar(67) NOT NULL,
  `pub_contact` int(45) NOT NULL,
  `pub_address` varchar(23) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`pub_id`, `pub_fname`, `pub_lname`, `pub_contact`, `pub_address`) VALUES
(1, 'kit', 'kaga', 789, 'huye'),
(2, 'serge', 'shami', 8900, 'kigali');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `ID` int(23) NOT NULL,
  `name` varchar(120) NOT NULL,
  `phone` int(67) NOT NULL,
  `address` varchar(10) NOT NULL,
  `email` varchar(67) NOT NULL,
  `username` varchar(56) NOT NULL,
  `password` varchar(56) NOT NULL,
  `hireddate` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`ID`, `name`, `phone`, `address`, `email`, `username`, `password`, `hireddate`) VALUES
(1, 'fidelineishimwe', 8909876, 'huye', 'ishimwe@gmil.com', 'fideline', 'fifi', '12/22/2000'),
(1, 'manzi frank', 2345, 'kigali', 'manzi@gmil.com', 'fideline', 'fifi', '12/22/2000');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(23) NOT NULL,
  `firstname` varchar(120) NOT NULL,
  `lastname` varchar(67) NOT NULL,
  `address` varchar(45) NOT NULL,
  `contact` int(67) NOT NULL,
  `birthdate` text NOT NULL,
  `username` varchar(56) NOT NULL,
  `password` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `firstname`, `lastname`, `address`, `contact`, `birthdate`, `username`, `password`) VALUES
(1, 'ella', 'hirwa', 'kamonyi', 123, '12/12/2000', 'fideline', 'fifi'),
(2, 'alle', 'shami', 'ruhango', 34678, '11/11/1999', 'fideline', 'fifi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrowing`
--
ALTER TABLE `borrowing`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrowing`
--
ALTER TABLE `borrowing`
  MODIFY `ID` int(23) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
