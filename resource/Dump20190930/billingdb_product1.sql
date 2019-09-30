-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: billingdb
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `product1`
--

DROP TABLE IF EXISTS `product1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product1` (
  `PID` int(11) NOT NULL,
  `PNAME` varchar(200) DEFAULT NULL,
  `ID` int(11) DEFAULT NULL,
  `PRATE` tinytext,
  `PTYPE` varchar(300) DEFAULT NULL,
  `INFO` varchar(500) DEFAULT NULL,
  `MINLIMIT` int(11) DEFAULT NULL,
  `BARCODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PID`),
  UNIQUE KEY `PRODUCT1_UK1` (`BARCODE`),
  KEY `ID` (`ID`),
  CONSTRAINT `product1_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `company1` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product1`
--

LOCK TABLES `product1` WRITE;
/*!40000 ALTER TABLE `product1` DISABLE KEYS */;
INSERT INTO `product1` VALUES (1,'5432 laptop',1,'32000','electronic','inspiron 15 3000 series',10,'6711430844174'),(2,'wireless mouse',1,'300','electronic','wireless mouse desc		',10,'8906010500894'),(3,'duos mobile',4,'3000','electronic',NULL,10,NULL),(4,'galaxy mobile',4,'7000','electronic',NULL,10,NULL),(5,'happy biscuit',3,'10','food','kdjsfhlksjd',15,NULL),(6,'good day biscuit',3,'20','electronic','info',18,'121'),(7,'laptop',2,'40000','electronics','jdjkfgkfdj',5,'987'),(8,'charger',1,'2000','electronic',NULL,10,'8901425052327'),(21,'abc',5,'100','electronic','jkwjek',20,'8901233018041');
/*!40000 ALTER TABLE `product1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-30 18:51:56
