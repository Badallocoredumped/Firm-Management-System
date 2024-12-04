-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: firmmanagement
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `role` enum('Manager','Engineer','Technician','Intern') COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `surname` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `phone_no` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_start` date DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEFAULT_PASSWORD` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'emir5757','manager123','Manager','Emir','Özen','+905551234567','1980-01-01','2010-05-15','emirozen57@hotmail.com',0),(2,'Teca7','WeLoveTeca','Engineer','Ahmed Marcolino Teca','Kanadji','+905441234567','1980-01-01','2010-05-15','teca.kanadji@example.com',1),(3,'Emir@57','KhasEmir@57','Manager','Emir','Özen',NULL,'2002-01-01','2023-01-01',NULL,1),(5,'TürkçeHerŞey','123asd123','Intern','EMİR','ÖZEN','+905375549413','2000-01-01','2023-01-01','NoTurkish57@hotmail.com',0),(6,'ÖZEN$$##','KhasÖZEN$$##','Manager','Emir\'özen','Özen\'Emir',NULL,'2000-01-01','2023-01-01',NULL,1),(7,'Hello!!!@@@$$$','KhasHello!!!@@@$$$','Technician','ÖZEN\'a','Teka\'man',NULL,'2004-01-01','2024-01-01',NULL,1),(8,'TahaÖzkan','KhasTahaÖzkan','Engineer','Taha','Özkan',NULL,'2004-01-01','2024-02-03',NULL,1),(9,'Maryam_Khan','KhasMaryam_Khan','Technician','Maryam','Khan',NULL,'2000-01-01','2018-02-03',NULL,1),(10,'Alara@Gümüşçü','KhasAlara@Gümüşçü','Intern','Alara','Gümüşçü',NULL,'2000-01-12','2024-12-01',NULL,1),(11,'Ahmed_Teka_12$','KhasAhmed_Teka_12$','Intern','Ahmed TeKa','Ahmed\'Teka',NULL,'2000-09-12','2024-12-04',NULL,1),(12,'KeremCrownguard','ilovelux','Intern','Kerem','Biçen','+905992077420','2004-10-03','2024-12-04','kerembicen@stu.khas.edu.tr',0),(13,'Jayce_Sinoplu57','KhasJayce_Sinoplu57','Technician','Jayce','Talis',NULL,'2002-01-02','2020-03-04',NULL,1),(14,'ViktorEvolution','KhasViktorEvolution','Engineer','Viktor','Evo\'man',NULL,'1960-02-03','2024-01-02',NULL,1),(15,'Erk$Demirel#12','KhasErk$Demirel#12','Engineer','Erk','Demirel',NULL,'2000-12-02','2020-11-02',NULL,1),(16,'M_Ekin-Ay','KhasM_Ekin-Ay','Intern','Mehmet Ekin','Ay',NULL,'2002-07-31','2021-05-03',NULL,1),(17,'ILoveScience_12','KhasILoveScience_12','Engineer','Cecil\'B','Heimerdinger',NULL,'1921-01-01','2024-05-03',NULL,1),(18,'Uğurkan_100Al','KhasUğurkan_100Al','Technician','Uğurkan','Bekit',NULL,'1960-05-06','2000-03-04',NULL,1),(19,'Jericho_İnt','KhasJericho_İnt','Intern','Jericho','Crowman',NULL,'1934-05-06','2000-01-02',NULL,1),(20,'VLK-34_Erd','KhasVLK-34_Erd','Engineer','Volkan','Erdoğan',NULL,'1984-03-04','2024-01-02',NULL,1),(21,'lazy2enter','okay1234','Manager','Lazy\'to','Enter\'Data','+345684329312','1922-09-03','2000-03-04','okay-53@hotmail.com',0),(22,'Ramliram_57','KhasRamliram_57','Intern','Ram','Ghaddar',NULL,'2004-06-05','2024-01-01',NULL,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-04 15:14:40
