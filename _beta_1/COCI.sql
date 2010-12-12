-- MySQL dump 10.13  Distrib 5.1.51, for Win32 (ia32)
--
-- Host: localhost    Database: coci
-- ------------------------------------------------------
-- Server version	5.1.51-community

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
-- Table structure for table `act`
--

DROP TABLE IF EXISTS `act`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `creator_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `act_date` datetime DEFAULT NULL,
  `act_place` text,
  `act_describe` text,
  `act_url` text,
  `deadline_date` datetime DEFAULT NULL,
  `classify` int(11) DEFAULT NULL,
  `maxnum` int(11) DEFAULT NULL,
  `nowapp` int(11) DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  KEY `owner` (`creator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act`
--

LOCK TABLES `act` WRITE;
/*!40000 ALTER TABLE `act` DISABLE KEYS */;
INSERT INTO `act` VALUES (1,'Act1',3,'2010-12-12 03:36:38','2010-12-11 11:11:00','ClassroomD203','<p><strong><em>This is act1.</em></strong></p>\r\n<p><em><img alt=\"\" src=\"http://172.18.12.100:8080/COCI/fckeditor/editor/images/smiley/msn/thumbs_up.gif\" /></em></p>','http://www.baidu.com','2010-12-12 12:12:00',1,100,NULL),(2,'Act2',3,'2010-12-12 03:37:28','2010-01-01 01:01:00','123','<p>123 <img alt=\"\" src=\"http://172.18.12.100:8080/COCI/fckeditor/editor/images/smiley/msn/kiss.gif\" /></p>','','2010-02-02 02:02:00',2,123,NULL);
/*!40000 ALTER TABLE `act` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appli`
--

DROP TABLE IF EXISTS `appli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appli` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `l_status` int(11) NOT NULL DEFAULT '0',
  `u_id` int(11) NOT NULL,
  `a_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`l_id`),
  KEY `u_a` (`u_id`),
  KEY `a_u` (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appli`
--

LOCK TABLES `appli` WRITE;
/*!40000 ALTER TABLE `appli` DISABLE KEYS */;
/*!40000 ALTER TABLE `appli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `care`
--

DROP TABLE IF EXISTS `care`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `care` (
  `u_id` int(11) NOT NULL,
  `a_id` int(11) NOT NULL,
  KEY `u_a` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `care`
--

LOCK TABLES `care` WRITE;
/*!40000 ALTER TABLE `care` DISABLE KEYS */;
INSERT INTO `care` VALUES (2,1);
/*!40000 ALTER TABLE `care` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `passworld` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `telephone` varchar(16) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`u_id`),
  KEY `name_u` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,3,'admin','admin',NULL,NULL,'2010-12-12 03:14:19'),(2,1,'student','student','312136446@qq.com','15018744294','2010-12-12 03:25:16'),(3,2,'group','group','312136446@qq.com','15017555264','2010-12-12 03:27:58');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-12-12  3:42:03
