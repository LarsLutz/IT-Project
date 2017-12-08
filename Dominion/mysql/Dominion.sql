-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Dez 2017 um 13:04
-- Server-Version: 10.1.16-MariaDB
-- PHP-Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `dominion`
--
CREATE DATABASE IF NOT EXISTS `dominion` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dominion`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `leaderboard`
--

CREATE TABLE `leaderboard` (
  `idLeaderboard` int(11) NOT NULL,
  `Resultat` int(11) NOT NULL,
  `Spieler_idSpieler` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `leaderboard`
--

INSERT INTO `leaderboard` (`idLeaderboard`, `Resultat`, `Spieler_idSpieler`) VALUES
(1, 50, 1),
(2, 52, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spieler`
--

CREATE TABLE `spieler` (
  `idSpieler` int(11) NOT NULL,
  `Spielername` varchar(45) NOT NULL,
  `Passwort` varchar(64) NOT NULL,
  `SessionID` varchar(45) NOT NULL,
  `Spielstand_idSpielstand` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `spieler`
--

INSERT INTO `spieler` (`idSpieler`, `Spielername`, `Passwort`, `SessionID`, `Spielstand_idSpielstand`) VALUES
(1, 'Test', 'test', '555', 1),
(2, 'Lars', '1234', '35', 1),
(3, 'Hans', '1111', '162', 1),
(4, 'hhhh', '1111', '0', 1),
(5, 'Adolf', '8888', '0', 1),
(6, 'Muso', 'HHHH', '0', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spielstand`
--

CREATE TABLE `spielstand` (
  `idSpielstand` int(11) NOT NULL,
  `Datum` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `spielstand`
--

INSERT INTO `spielstand` (`idSpielstand`, `Datum`) VALUES
(1, '2017-11-24 00:00:00'),
(2, '2017-11-24 00:00:00');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `leaderboard`
--
ALTER TABLE `leaderboard`
  ADD PRIMARY KEY (`idLeaderboard`),
  ADD KEY `fk_Leaderboard_Spieler_idx` (`Spieler_idSpieler`);

--
-- Indizes für die Tabelle `spieler`
--
ALTER TABLE `spieler`
  ADD PRIMARY KEY (`idSpieler`),
  ADD KEY `fk_Spieler_Spielstand1_idx` (`Spielstand_idSpielstand`);

--
-- Indizes für die Tabelle `spielstand`
--
ALTER TABLE `spielstand`
  ADD PRIMARY KEY (`idSpielstand`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `leaderboard`
--
ALTER TABLE `leaderboard`
  MODIFY `idLeaderboard` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT für Tabelle `spieler`
--
ALTER TABLE `spieler`
  MODIFY `idSpieler` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT für Tabelle `spielstand`
--
ALTER TABLE `spielstand`
  MODIFY `idSpielstand` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `leaderboard`
--
ALTER TABLE `leaderboard`
  ADD CONSTRAINT `fk_Leaderboard_Spieler` FOREIGN KEY (`Spieler_idSpieler`) REFERENCES `spieler` (`idSpieler`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints der Tabelle `spieler`
--
ALTER TABLE `spieler`
  ADD CONSTRAINT `fk_Spieler_Spielstand1` FOREIGN KEY (`Spielstand_idSpielstand`) REFERENCES `spielstand` (`idSpielstand`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
