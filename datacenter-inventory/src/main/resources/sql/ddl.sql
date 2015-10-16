-- MySQL dump 10.13  Distrib 5.5.36, for Win64 (x86)
--
-- Host: localhost    Database: datacenter
-- ------------------------------------------------------
-- Server version	5.5.36

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
-- Table structure for table `colocation_provider_types`
--

DROP TABLE IF EXISTS `colocation_provider_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colocation_provider_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `components`
--

DROP TABLE IF EXISTS `components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `components` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `core_classifications`
--

DROP TABLE IF EXISTS `core_classifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_classifications` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `datacenters`
--

DROP TABLE IF EXISTS `datacenters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datacenters` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `province` varchar(255) DEFAULT NULL,
  `state_abbreviation` varchar(255) NOT NULL,
  `zip` varchar(5) NOT NULL,
  `agency_abbreviation` varchar(255) NOT NULL,
  `ageny_datacenter_id` varchar(255) NOT NULL,
  `classification` varchar(255) NOT NULL,
  `component` varchar(255) NOT NULL,
  `datacenter_id` varchar(255) NOT NULL,
  `datacenter_name` varchar(255) NOT NULL,
  `legacy_id` varchar(255) DEFAULT NULL,
  `office_name` varchar(255) DEFAULT NULL,
  `published_name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `subcategory` varchar(255) DEFAULT NULL,
  `validity` varchar(255) NOT NULL,
  `annual_cost` int(11) NOT NULL,
  `colocation_provider` bit(1) NOT NULL,
  `colocation_provider_type` varchar(255) DEFAULT NULL,
  `datacenter_tier` varchar(255) DEFAULT NULL,
  `government_wide_provider` char(1) DEFAULT NULL,
  `gross_floor_area` int(11) NOT NULL,
  `other_agencies_serviced` varchar(255) DEFAULT NULL,
  `ownership_type` varchar(255) NOT NULL,
  `percent_services_paid` int(11) DEFAULT NULL,
  `providing_services` char(1) NOT NULL,
  `total_customer_floor_area` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_apsc8x712tl0s7gk2f7tm02ue` (`datacenter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `datacenters_quarterly_data`
--

DROP TABLE IF EXISTS `datacenters_quarterly_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datacenters_quarterly_data` (
  `datacenters_id` bigint(20) NOT NULL,
  `quarterlyData_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_bg99ve1yy37x4hn6ybop75qg2` (`quarterlyData_id`),
  KEY `FK_awnr30enejsr1sl1imbpic24q` (`datacenters_id`),
  CONSTRAINT `FK_awnr30enejsr1sl1imbpic24q` FOREIGN KEY (`datacenters_id`) REFERENCES `datacenters` (`id`),
  CONSTRAINT `FK_bg99ve1yy37x4hn6ybop75qg2` FOREIGN KEY (`quarterlyData_id`) REFERENCES `quarterly_data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `non_core_subcategories`
--

DROP TABLE IF EXISTS `non_core_subcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `non_core_subcategories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ownership_types`
--

DROP TABLE IF EXISTS `ownership_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ownership_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quarterly_data`
--

DROP TABLE IF EXISTS `quarterly_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quarterly_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `averate_electricity_usage` decimal(19,2) DEFAULT NULL,
  `averate_it_electricity_usage` decimal(19,2) DEFAULT NULL,
  `closing_fiscal_year` int(11) DEFAULT NULL,
  `closing_quarter` varchar(255) DEFAULT NULL,
  `closing_stage` varchar(255) DEFAULT NULL,
  `cost_per_kwh` decimal(19,2) DEFAULT NULL,
  `electricity_indcluded` char(1) DEFAULT NULL,
  `electricity_metered` char(1) DEFAULT NULL,
  `fiscal_year` int(11) DEFAULT NULL,
  `fte` decimal(19,2) DEFAULT NULL,
  `fte_cost` decimal(19,2) DEFAULT NULL,
  `other_servers` int(11) DEFAULT NULL,
  `overall_fte_reduction` int(11) DEFAULT NULL,
  `quarter` varchar(255) DEFAULT NULL,
  `rack_count` int(11) DEFAULT NULL,
  `real_property_disposition` varchar(255) DEFAULT NULL,
  `total_decomissioned_servers` int(11) DEFAULT NULL,
  `total_floor_area_reclaimed` int(11) DEFAULT NULL,
  `total_hpc_cluster_nodes` int(11) DEFAULT NULL,
  `total_ibm_mainframes` int(11) DEFAULT NULL,
  `total_it_power_capacity` decimal(19,2) DEFAULT NULL,
  `total_linux_servers` int(11) DEFAULT NULL,
  `total_other_mainframes` int(11) DEFAULT NULL,
  `total_power_capacity` decimal(19,2) DEFAULT NULL,
  `total_servers_moved` int(11) DEFAULT NULL,
  `total_storage` decimal(19,2) DEFAULT NULL,
  `total_unix_servers` int(11) DEFAULT NULL,
  `total_virtual_hosts` int(11) DEFAULT NULL,
  `total_virtual_os` int(11) DEFAULT NULL,
  `total_windows_servers` int(11) DEFAULT NULL,
  `used_storage` decimal(19,2) DEFAULT NULL,
  `datacenter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ea6fwbvc9hhyq49d8kl88q9gh` (`datacenter_id`),
  CONSTRAINT `FK_ea6fwbvc9hhyq49d8kl88q9gh` FOREIGN KEY (`datacenter_id`) REFERENCES `datacenters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `record_validities`
--

DROP TABLE IF EXISTS `record_validities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record_validities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authenticated` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-16 15:53:43
