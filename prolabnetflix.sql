-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 01 Haz 2020, 22:56:49
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `prolabnetflix`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE `kullanici` (
  `ID` int(4) NOT NULL,
  `Ad` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `Email` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `Parola` varchar(16) COLLATE utf8_turkish_ci NOT NULL,
  `DogumTarihi` varchar(11) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`ID`, `Ad`, `Email`, `Parola`, `DogumTarihi`) VALUES
(1, 'user1', 'user1@deneme.com', '123456789', '27/5/2020'),
(2, 'user2', 'user2@deneme.com', '123456789', '1/2/2020'),
(3, 'user3', 'user3@deneme.com', '987654321', '31/5/2020'),
(4, 'user4', 'user4@deneme.com', '987654321', '1/1/2020'),
(5, 'user5', 'user5@deneme.com', '147258369', '31/5/2020'),
(7, 'user6', 'user6@deneme.com', '123456789', '12/12/2012'),
(8, 'user7', 'user7@deneme.com', '789456123', '3/5/1987'),
(9, 'user8', 'user8@deneme.com', '789456123', '2/3/2015');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici_program`
--

CREATE TABLE `kullanici_program` (
  `KID` int(4) NOT NULL,
  `PID` int(4) NOT NULL,
  `IzlenmeTarihi` varchar(11) COLLATE utf8_turkish_ci NOT NULL,
  `IzlenmeSuresi` int(4) NOT NULL,
  `KaldigiBolum` int(4) NOT NULL,
  `Puan` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanici_program`
--

INSERT INTO `kullanici_program` (`KID`, `PID`, `IzlenmeTarihi`, `IzlenmeSuresi`, `KaldigiBolum`, `Puan`) VALUES
(1, 4, '31.05.2020', 120, 1, 8),
(1, 8, '31.05.2020', 120, 1, 10),
(2, 2, '30.05.2020', 90, 1, 7),
(2, 53, '28.05.2020', 200, 5, 7),
(2, 59, '29.05.2020', 200, 6, 5),
(1, 66, '05.05.2005', 300, 14, 6),
(3, 75, '02.02.2020', 100, 4, 5),
(3, 74, '02.02.2020', 100, 3, 4),
(4, 73, '02.02.2020', 200, 5, 3),
(4, 72, '02.02.2020', 200, 4, 8),
(3, 55, '02.02.2020', 100, 3, 4),
(4, 47, '02.02.2020', 120, 1, 6),
(5, 11, '30.05.2010', 120, 1, 10),
(5, 11, '30.05.2010', 120, 1, 9);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `program`
--

CREATE TABLE `program` (
  `ID` int(11) NOT NULL,
  `Ad` varchar(300) NOT NULL,
  `Tip` enum('Film','Dizi','Tv Show') NOT NULL,
  `BolumS` int(11) NOT NULL,
  `Uzunluk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `program`
--

INSERT INTO `program` (`ID`, `Ad`, `Tip`, `BolumS`, `Uzunluk`) VALUES
(1, 'Recep İvedik 6', 'Film', 1, 116),
(2, 'Assassın\'s Creed', 'Film', 1, 92),
(3, 'Alaca Karanlık', 'Film', 1, 93),
(4, 'Yüzüklerin Efendisi İki Kule', 'Film', 1, 121),
(5, 'Maske', 'Film', 1, 139),
(6, 'Kara Şövalye', 'Film', 1, 111),
(7, 'Sherlock Holmes', 'Film', 1, 131),
(8, 'Yüzüklerin Efendisi kralın Dönüşü', 'Film', 1, 127),
(9, 'Transformers Kayıp Çağ', 'Film', 1, 185),
(10, 'Başlangıç', 'Film', 1, 134),
(11, 'Interstellar', 'Film', 1, 127),
(12, 'Harry Potter lüm Yadigarları', 'Film', 1, 98),
(13, 'Jurassic World', 'Film', 1, 114),
(14, 'Fantastik Canavarlar', 'Film', 1, 122),
(15, 'Ninja Kaplumbağalar', 'Film', 1, 129),
(16, 'Kuşlarla Dans', 'Film', 1, 121),
(17, 'Mission Blue', 'Film', 1, 140),
(18, 'Mercan Peşinde', 'Film', 1, 91),
(19, 'Dream Big', 'Film', 1, 107),
(20, 'Ay\'daki Son Adam', 'Film', 1, 125),
(21, 'Plastik Okyanus', 'Film', 1, 106),
(22, 'Rakamlarla Tahmin', 'Film', 1, 94),
(23, 'Ben Efsaneyim', 'Film', 1, 91),
(24, 'Arif V 216', 'Film', 1, 90),
(25, 'pk', 'Film', 1, 139),
(26, 'Örümcek Adam', 'Film', 1, 138),
(27, 'Jurassıc Park', 'Film', 1, 103),
(28, 'Frankestein ', 'Film', 1, 96),
(29, 'Gezegenimiz', 'Film', 1, 120),
(30, '72 sevimli hayvan', 'Film', 1, 116),
(31, 'Kuşçular', 'Film', 1, 98),
(32, 'Marsta Keşif', 'Film', 1, 108),
(33, 'Gezegenimiz', 'Film', 1, 130),
(34, 'Pandemic', 'Film', 1, 127),
(35, 'Pokemon', 'Film', 1, 129),
(36, 'Şirinler', 'Film', 1, 127),
(37, 'Charlie\'nin Çikolata Fabrikası', 'Film', 1, 140),
(38, 'Alvin ve Sincaplar', 'Film', 1, 96),
(39, 'Scooby-Doo', 'Film', 1, 98),
(40, 'Kung Fu Panda', 'Film', 1, 109),
(41, 'Mr. Bean Tatilde', 'Film', 1, 134),
(42, 'Shrek ', 'Film', 1, 112),
(43, 'Mega Zeka', 'Film', 1, 103),
(44, 'Bizi Hatırla', 'Film', 1, 138),
(45, 'Delibal', 'Film', 1, 136),
(46, 'Kardeşim Benim', 'Film', 1, 115),
(47, 'Dangal', 'Film', 1, 128),
(48, 'Yerçekimi', 'Film', 1, 110),
(49, 'Jaws', 'Film', 1, 139),
(50, 'Da Vinci Şifresi', 'Film', 1, 91),
(51, 'Marwel\' Iron Fist', 'Dizi', 57, 49),
(52, 'Ejderhalar', 'Dizi', 29, 42),
(53, 'Diriliş Ertuğrul', 'Dizi', 65, 30),
(54, 'Trol Avcıları: Arcadia Hikayeleri', 'Dizi', 26, 31),
(55, 'How I met your mother', 'Dizi', 60, 52),
(56, 'Leyla ile Mecnun', 'Dizi', 58, 29),
(57, 'Beni Böyle Sev', 'Dizi', 25, 51),
(58, 'Patron Bebek Yine İş başında', 'Dizi', 35, 38),
(59, 'Atiye', 'Dizi', 71, 42),
(60, 'Maşa ve Koca Ayı', 'Dizi', 64, 44),
(61, 'Sünger Bob', 'Dizi', 55, 54),
(62, 'Stranger Tings', 'Dizi', 19, 37),
(63, 'The Originals', 'Dizi', 59, 55),
(64, 'Angry Birds', 'Dizi', 63, 25),
(65, 'Criminal', 'Dizi', 23, 52),
(66, 'Beyblade', 'Dizi', 38, 23),
(67, 'Sonic X ', 'Dizi', 53, 44),
(68, 'Kung Fu Panda Muhteşem Sırlar', 'Dizi', 76, 37),
(69, 'The Blacklist', 'Dizi', 45, 37),
(70, 'Dünyanın En Sıra Dışı Evleri', 'Tv Show', 14, 63),
(71, 'Car Masters', 'Tv Show', 12, 44),
(72, 'Büyük Tasarımlar', 'Tv Show', 20, 62),
(73, 'Basketball or Nothing', 'Tv Show', 14, 57),
(74, 'The Big Family Cooking', 'Tv Show', 21, 44),
(75, 'Sıradışı Kulübeler', 'Tv Show', 12, 38);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `program_tur`
--

CREATE TABLE `program_tur` (
  `PID` int(11) NOT NULL,
  `TID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `program_tur`
--

INSERT INTO `program_tur` (`PID`, `TID`) VALUES
(1, 1),
(2, 1),
(2, 3),
(3, 1),
(3, 10),
(4, 1),
(4, 3),
(5, 1),
(5, 3),
(6, 1),
(6, 3),
(7, 1),
(8, 1),
(8, 3),
(9, 1),
(10, 1),
(11, 1),
(11, 6),
(12, 1),
(12, 3),
(12, 5),
(13, 1),
(14, 1),
(14, 5),
(15, 1),
(15, 3),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 3),
(24, 3),
(24, 8),
(25, 3),
(25, 10),
(26, 1),
(26, 3),
(27, 1),
(27, 3),
(28, 1),
(28, 3),
(28, 9),
(29, 2),
(29, 4),
(30, 2),
(30, 4),
(31, 2),
(31, 4),
(32, 2),
(32, 4),
(33, 2),
(33, 4),
(34, 2),
(34, 4),
(35, 5),
(36, 5),
(36, 8),
(37, 5),
(37, 8),
(38, 5),
(39, 5),
(40, 1),
(40, 5),
(41, 5),
(42, 5),
(42, 8),
(43, 5),
(43, 8),
(44, 6),
(45, 6),
(45, 10),
(46, 6),
(46, 8),
(47, 6),
(48, 3),
(48, 6),
(49, 7),
(50, 7),
(51, 1),
(52, 1),
(52, 5),
(53, 1),
(54, 1),
(54, 5),
(55, 10),
(56, 10),
(57, 6),
(57, 10),
(58, 5),
(58, 8),
(59, 1),
(59, 10),
(60, 5),
(61, 5),
(61, 8),
(62, 1),
(62, 9),
(63, 6),
(63, 9),
(64, 5),
(64, 8),
(65, 7),
(66, 5),
(66, 11),
(67, 1),
(67, 11),
(68, 1),
(69, 1),
(69, 7),
(70, 12),
(71, 12),
(72, 12),
(73, 12),
(74, 12),
(75, 12);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tur`
--

CREATE TABLE `tur` (
  `ID` int(11) NOT NULL,
  `Ad` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `tur`
--

INSERT INTO `tur` (`ID`, `Ad`) VALUES
(1, 'Aksiyon ve Macera'),
(2, 'Belgesel'),
(3, 'Bilim Kurgu ve Fantastik Yapımlar'),
(4, 'Bilim ve Doğa'),
(5, 'Çocuk ve Aile'),
(6, 'Drama'),
(7, 'Gerilim'),
(8, 'Komedi'),
(9, 'Korku'),
(10, 'Romantik'),
(11, 'Anime'),
(12, 'Reality Programs');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Tablo için indeksler `kullanici_program`
--
ALTER TABLE `kullanici_program`
  ADD KEY `FKID` (`KID`),
  ADD KEY `FPID` (`PID`);

--
-- Tablo için indeksler `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `program_tur`
--
ALTER TABLE `program_tur`
  ADD KEY `relPID` (`PID`),
  ADD KEY `relTID` (`TID`);

--
-- Tablo için indeksler `tur`
--
ALTER TABLE `tur`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `program`
--
ALTER TABLE `program`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- Tablo için AUTO_INCREMENT değeri `tur`
--
ALTER TABLE `tur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `kullanici_program`
--
ALTER TABLE `kullanici_program`
  ADD CONSTRAINT `FKID` FOREIGN KEY (`KID`) REFERENCES `kullanici` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FPID` FOREIGN KEY (`PID`) REFERENCES `program` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `program_tur`
--
ALTER TABLE `program_tur`
  ADD CONSTRAINT `relPID` FOREIGN KEY (`PID`) REFERENCES `program` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `relTID` FOREIGN KEY (`TID`) REFERENCES `tur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
