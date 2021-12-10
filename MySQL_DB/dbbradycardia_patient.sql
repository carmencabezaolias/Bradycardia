CREATE DATABASE  IF NOT EXISTS `dbbradycardia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbbradycardia`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: dbbradycardia
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` text NOT NULL,
  `username` text NOT NULL,
  `address` text NOT NULL,
  `phoneNumber` text NOT NULL,
  `email` text NOT NULL,
  `diagnosis` text,
  `pwd` text NOT NULL,
  `macBitalino` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Maria','Maria','Madrid','676206084','m@gmail.com','Yes#No#Yes#No#No#Headache#','1','98:D3:91:FD:69:49'),(2,'pepe','pepe','ceu','676206084','pp@gmail.com','null','java','hola'),(3,'pepito','pepito','ceu','676206084','pp@gmail.com','null','java','null'),(4,'Irene','irene','mi casa','668572669','i@gmail.com','null','hola','null'),(5,'Pablo lopez','theplaygroud','Seville','657483920','pablo@usp.ceu.es','null','lol','null'),(6,'Alba','Lopez','Calle Bravo Murillo','662719330','albagmail.com','null','alba00*','null'),(7,'Jimena','Sanchez','calle bravo murillo','623921882','jimena@gmail.com','null','jimena12','null'),(8,'Cristina','cris','madrid','676209023','c@gmail.com','null','cris','null'),(9,'Ana Delgado','anita','rozas','689808980','adelgado@gmail.com','Yes#No#Yes#No#Yes#stomachache#','pan','null'),(10,'Raquel Vazquez','raquel','galicia','670656465','raquelv@gmail.com','null','jamon','98:D3:91:FD:69:49'),(11,'Alberto Gil','alberto','silicon Valley','691865423','alberto@netbeans.com','No#No#No#No#No#healthy#','java','98:D3:91:FD:69:49'),(12,'Javier Martin','francis','teruel','645832689','javier.martin@gmail.com','null','guapo','null'),(13,'irene Gomez','irenita','pozuelo','634286253','i.gomez@gmail.com','Yes#No#Yes#No#Yes#headache#','telemedicine','null'),(14,'Paula Rodriguez','pau.3','alicante','652586233','paula@gmail.com','null','8797*','null');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 23:19:10
