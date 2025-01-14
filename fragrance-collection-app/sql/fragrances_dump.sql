-- MySQL dump 10.13  Distrib 8.4.0, for Win64 (x86_64)
--
-- Host: localhost    Database: fragrances_wjahat_adil
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fragrance`
--

DROP TABLE IF EXISTS `fragrance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fragrance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `description` text,
  `name` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragrance`
--

LOCK TABLES `fragrance` WRITE;
/*!40000 ALTER TABLE `fragrance` DISABLE KEYS */;
INSERT INTO `fragrance` VALUES (1,'Paco Rabanne','Invictus by Rabanne is a Woody Aquatic fragrance for men. Invictus was launched in 2013. Invictus was created by Veronique Nyberg, Anne Flipo, Olivier Polge and Dominique Ropion. Top notes are Sea Notes, Grapefruit and Mandarin Orange; middle notes are Bay Leaf and Jasmine; base notes are Ambergris, Guaiac Wood, Oakmoss and Patchouli.','Invictus',NULL,'Citrus'),(2,'Kouros','Kouros by Yves Saint Laurent is a Aromatic Fougere fragrance for men. Kouros was launched in 1981. The nose behind this fragrance is Pierre Bourdon. Top notes are Aldehydes, Coriander, Clary Sage, Artemisia and Bergamot; middle notes are Patchouli, Carnation, Geranium, Vetiver, Jasmine, Cinnamon, Orris Root and Lavender; base notes are Civet, Honey, Leather, Musk, Oakmoss, Amber, Tonka Bean and Vanilla','Yves Saint Laurent',NULL,'Musky'),(3,'Paris Hilton','Gold Rush Man by Paris Hilton is a Oriental Fougere fragrance for men. Gold Rush Man was launched in 2017. Top notes are Mandarin Orange, Cardamom and Bergamot; middle notes are Lavender, Geranium and Sage; base notes are Vanilla, Amber and Tonka Bean.','Gold rush',NULL,'Vanilla'),(4,'Givenchy','Givenchy pour Homme by Givenchy is a Woody Spicy fragrance for men. Givenchy pour Homme was launched in 2002. Givenchy pour Homme was created by Alberto Morillas and Ilias Ermenidis. Top notes are Mandarin Orange, Grapefruit, Coriander and Violet; middle notes are Vetiver and Lavender Extract; base notes are Cedar and Labdanum.','Givenchy Pour Homme',NULL,'Woody'),(5,'Versace','Versace Pour Homme Dylan Blue by Versace is a Aromatic Fougere fragrance for men. Versace Pour Homme Dylan Blue was launched in 2016. The nose behind this fragrance is Alberto Morillas. Top notes are Calabrian bergamot, Water Notes, Grapefruit and Fig Leaf; middle notes are Ambroxan, Black Pepper, Patchouli, Violet Leaf and Papyrus; base notes are Incense, Musk, Tonka Bean and Saffron.','Dylan Blue',0,'Amber');
/*!40000 ALTER TABLE `fragrance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfume_collection`
--

DROP TABLE IF EXISTS `perfume_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfume_collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfume_collection`
--

LOCK TABLES `perfume_collection` WRITE;
/*!40000 ALTER TABLE `perfume_collection` DISABLE KEYS */;
INSERT INTO `perfume_collection` VALUES (1,'Invictus ');
/*!40000 ALTER TABLE `perfume_collection` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-06 13:58:03
