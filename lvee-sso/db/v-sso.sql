/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : 127.0.0.1:3306
Source Database       : v-sso

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-01-29 21:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `auth` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'java编程', 'v-sso');
INSERT INTO `test` VALUES ('2', 'Springboot', 'v-sso');
INSERT INTO `test` VALUES ('3', '西游记', 'v-sso');
INSERT INTO `test` VALUES ('4', '水浒传', 'v-sso');
INSERT INTO `test` VALUES ('5', '西厢记', 'v-sso');
