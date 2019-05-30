-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: recurit_sys
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司编号',
  `username` varchar(100) DEFAULT NULL COMMENT '公司用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实名称',
  `location` varchar(255) DEFAULT NULL COMMENT '坐标位置',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `tip` varchar(255) DEFAULT NULL COMMENT '公司介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'sam2','jk123789','国信清软科技有限责任公司','山西太原','1212121','343242@qq.com','国信清软科技有限公司注册在北京中关村高科技园区，始创于2005年3月，已通过软件企业认证，是一家集实训、咨询、开发、服务于一体的高新技术产业公司。2008年被纳入“653工程”。国信清软科技有限公司2009年6月19日与中华人民共和国软件与集成电路促成中心达成战略合作伙伴关系。并承担中国JAVA软件工程师标准的制定，成为中国唯一的Java软件工程师标准制定企业。'),(2,'sam3','jk123789','华夏时代广告传媒有限公司','北京市海淀区','6093352','6093352@qq.com','华夏时代·传媒成立于2005年，致力电视栏目制作、媒体代理发布、广告策划、创意制作、大型活动执行，是以媒体经营为依托、其它媒体服务并举的全方位媒体广告公司。'),(3,'sam1','jk123789','企业金融服务山西中心','山西太原','8974562','2132131','人人行科技，依靠九鼎的雄厚实力和强大影响力，集结互联网、金融、支付、法律等领域的专业精英团队，着力为投资者打造个性化的融资及投资需求平台，开创创新型个人金融服务平台的先河。 '),(4,'sam4','jk123789','瀚信企业管理咨询(上海)有限公司','上海市静安区北京西路968号嘉地中心808室','4049785','66666@qq.com','PKF，全称Pannell KerrForster，从1869年只有4间成员所（澳洲、加拿大、英国、美国）发展到如今在全球125个国家拥有超过440间成员所，21,400名拥有专业经验的合伙人和员工。2011年，PKF已跻身全球前10大知名会计师事务所之列，同时在咨询业也是名列前茅，当年PKF其全球营业额超过20亿美元。 '),(5,'sam5','jk123789',' 南京壹进制信息技术股份有限公司 ','南京市秦淮区光华路1号（白下高新园区）斯坦德物联网大厦南楼8层','3723561','yijinzhi@163c.com','南京壹进制信息技术股份有限公司成立于2008年12月23日，注册资金2650万元，总部南京，在全国设立了20多个营销和服务分支机构。公司自成立以来秉承自主创新、自有品牌的经营理念，凝聚了众多高端技术人才，拥有多项发明专利和独立知识产权，是江苏省双软企业，产品通过多项国家认证。'),(6,'sam6','jk123789',' 广州水禾田软件科技有限公司 ','广州市白云区嘉禾望岗粤旺大厦B栋8307 ','4038521','4038521@qq.com','广州水禾田软件科技有限公司成立于2010年，6年来我们一直以专业创造价值，用概念铸就品牌为目的。\r\n公司团队日趋成熟，拥有资深的电子商务应用策划师，一流的网页设计师，经验丰富的程序员。\r\n先后为政府、教育、医卫、部队、金融、交通、地铁、能源化工、房地产等行业用户以及外资、合资企业提供专业网站建设服务。'),(7,'huatai','123456','华泰电池厂','山东省临沂市','17852054367','lolcdkey@163.com','啊啊啊'),(8,'dasda','dada','大大','dada','fffs','fsfsf','daaa');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_needs`
--

DROP TABLE IF EXISTS `company_needs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company_needs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cid` int(11) DEFAULT NULL COMMENT '公司编号',
  `needs` varchar(255) DEFAULT NULL,
  `salary` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_needs`
--

LOCK TABLES `company_needs` WRITE;
/*!40000 ALTER TABLE `company_needs` DISABLE KEYS */;
INSERT INTO `company_needs` VALUES (2,2,'文员','0-3000'),(3,3,'web前端','3001-4000'),(4,4,'UI设计','3001-4000'),(5,5,'平面设计','4001-5000'),(6,6,'java后端','6001-7000'),(7,7,'软件工程师','7001-8000'),(8,8,'会计','0-3000'),(9,2,'会计','3001-4000'),(10,1,'平面设计','3001-4000'),(11,6,'会计','3001-4000'),(12,5,'会计','3001-4000'),(13,3,'会计','3001-4000'),(14,4,'会计','3001-4000'),(15,7,'会计','3001-4000');
/*!40000 ALTER TABLE `company_needs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employ`
--

DROP TABLE IF EXISTS `employ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(11) DEFAULT NULL COMMENT '求职者编号',
  `cid` int(11) DEFAULT NULL COMMENT '公司编号',
  `status` int(2) DEFAULT NULL COMMENT '状态  0 未处理 1 同意 2 回绝',
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employ`
--

LOCK TABLES `employ` WRITE;
/*!40000 ALTER TABLE `employ` DISABLE KEYS */;
INSERT INTO `employ` VALUES (1,1,1,1,'平面设计');
/*!40000 ALTER TABLE `employ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '求职者编号',
  `username` varchar(20) DEFAULT NULL COMMENT '求职者用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '求职者密码',
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '生日',
  `school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `salary` varchar(20) DEFAULT NULL COMMENT '期望工资',
  `tip` varchar(255) DEFAULT NULL COMMENT '个人介绍',
  `desiredPosition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '期望职位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'yudiancheng','123','于佃成','男','1997-09-29','南山学院','17852054373','lolcdkey@163.com','软件工程','3000-4000','hahh方法f大','java开发工程师'),(2,'zhangsan','123456','张三','男','2019-05-18','北京大学','17852054373','lolcdk@163.com','计算机','3000-5000','web','jiji'),(3,'lisi','123456','李四','男','2019-05-18','清华大学','17852054367','1569555768@qq.com','计算机科学','?-3000','驱动了','web前端'),(4,'wangwu','123456','王五','男','2019-05-18','达到','17852054367','lolcdkey@163.com','计算机科学','?-3000','达到','web前端'),(5,'shaohui','123456','邵辉','女','2019-05-18','山东理工大学','17852054367','1569555768@qq.com','计算机科学','?-3000','大大','会计');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '求职者简历编号',
  `pid` int(11) DEFAULT NULL COMMENT '求职者编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-30 16:52:40
