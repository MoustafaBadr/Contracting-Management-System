-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: contracting
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('8888','123','mmg'),('al','123','mmmmm'),('m','m','m'),('mm','123','mo'),('mmg','123','moustafa'),('mmmmmm','123','mmg'),('mmp','123','moh'),('moustafa','123','mm');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `tybe` varchar(45) NOT NULL,
  `payment` int(11) NOT NULL,
  PRIMARY KEY (`idcustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (11,'mostafa elabbasy','01205115790','mostafa@gmail.com','sirs','individual',0),(12,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(13,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(14,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(15,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(16,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(17,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(18,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(19,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(20,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(21,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(22,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(23,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(24,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(25,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(26,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(27,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(28,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200),(29,'ahmed','12548','mfmdnfd,m','xmcm','engineer',200);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerpayment`
--

DROP TABLE IF EXISTS `customerpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerpayment` (
  `idcustomerPayment` int(11) NOT NULL AUTO_INCREMENT,
  `cash` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `cusstomerId` int(11) NOT NULL,
  `date` date NOT NULL,
  `customerName` varchar(45) NOT NULL,
  PRIMARY KEY (`idcustomerPayment`),
  KEY `customerId_idx` (`cusstomerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`cusstomerId`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerpayment`
--

LOCK TABLES `customerpayment` WRITE;
/*!40000 ALTER TABLE `customerpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idemployee` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) NOT NULL,
  `salary` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `state` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `job` varchar(45) NOT NULL,
  `project` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idemployee`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'01250840001',2000,'badr@gmail.com','sengrg','busy','mostafa','badr','engineer','el mostafa');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `idprojects` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `customerId` int(11) NOT NULL,
  `timeLine` date NOT NULL,
  `payment` int(11) NOT NULL,
  `tybe` varchar(45) NOT NULL,
  PRIMARY KEY (`idprojects`),
  KEY `customer_idx` (`customerId`),
  CONSTRAINT `customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `idstore` int(11) NOT NULL AUTO_INCREMENT,
  `prodectName` varchar(45) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `supplierId` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`idstore`),
  KEY `supplier_idx` (`supplierId`),
  CONSTRAINT `supplier` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`idsupplier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'mmmm','1212121',5,12121212);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `idsupplier` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `payment` int(11) NOT NULL,
  `timeLine` date NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`idsupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (5,'hjg',-1520,'2017-01-05','jkhj','jh@','56464'),(8,'mostafagh',-3000,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(9,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(10,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(11,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(12,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(13,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058'),(14,'mostafagh',600,'2016-12-01','20ghhjchjks','gfghj@','0125058');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplierpayment`
--

DROP TABLE IF EXISTS `supplierpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplierpayment` (
  `idsupplierPayment` int(11) NOT NULL AUTO_INCREMENT,
  `cash` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `supplierId` int(11) NOT NULL,
  `date` date NOT NULL,
  `supplierName` varchar(45) NOT NULL,
  PRIMARY KEY (`idsupplierPayment`),
  KEY `supplier_idx` (`supplierId`),
  CONSTRAINT `supplierid` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`idsupplier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierpayment`
--

LOCK TABLES `supplierpayment` WRITE;
/*!40000 ALTER TABLE `supplierpayment` DISABLE KEYS */;
INSERT INTO `supplierpayment` VALUES (13,200,'mmg',8,'2016-12-22','mostafagh'),(16,200,'null',8,'2016-12-23','mostafagh'),(17,200,'null',8,'2016-12-23','mostafagh'),(18,200,'null',8,'2016-12-23','mostafagh'),(19,200,'null',8,'2016-12-23','mostafagh'),(20,200,'null',8,'2016-12-23','mostafagh'),(21,200,'null',8,'2016-12-23','mostafagh'),(22,200,'null',8,'2016-12-23','mostafagh'),(23,200,'null',8,'2016-12-23','mostafagh'),(24,200,'null',8,'2016-12-23','mostafagh'),(25,200,'null',8,'2016-12-23','mostafagh'),(26,200,'null',8,'2016-12-23','mostafagh'),(27,200,'null',8,'2016-12-23','mostafagh'),(28,200,'null',8,'2016-12-23','mostafagh'),(29,200,'null',8,'2016-12-23','mostafagh');
/*!40000 ALTER TABLE `supplierpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'contracting'
--

--
-- Dumping routines for database 'contracting'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23 22:00:44
