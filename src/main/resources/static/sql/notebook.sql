/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.28 : Database - notebook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`notebook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `notebook`;

/*Table structure for table `users_account` */

DROP TABLE IF EXISTS `users_account`;

CREATE TABLE `users_account` (
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_account` */

insert  into `users_account`(`userName`,`password`) values ('qklt','E10ADC3949BA59ABBE56E057F20F883E');

/*Table structure for table `users_information` */

DROP TABLE IF EXISTS `users_information`;

CREATE TABLE `users_information` (
  `userName` varchar(45) NOT NULL,
  `sex` varchar(4) DEFAULT '保密',
  `age` varchar(4) DEFAULT '保密',
  `portrait` varchar(128) DEFAULT '1.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_information` */

insert  into `users_information`(`userName`,`sex`,`age`,`portrait`) values ('qklt','保密','20','ZaBh5Mw8large.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
