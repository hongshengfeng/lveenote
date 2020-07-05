/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50548
 Source Host           : 127.0.0.1:3306
 Source Schema         : lvee

 Target Server Type    : MySQL
 Target Server Version : 50548
 File Encoding         : 65001

 Date: 05/07/2020 20:10:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lv_note
-- ----------------------------
DROP TABLE IF EXISTS `lv_note`;
CREATE TABLE `lv_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '创建用户',
  `term_id` int(11) NOT NULL COMMENT '所属团队id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '笔记内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `end_time` datetime NOT NULL COMMENT '计划结束时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lv_note
-- ----------------------------

-- ----------------------------
-- Table structure for lv_term
-- ----------------------------
DROP TABLE IF EXISTS `lv_term`;
CREATE TABLE `lv_term`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '创建用户',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小组名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `odds` int(11) NOT NULL DEFAULT 0 COMMENT '抽奖机率',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lv_term
-- ----------------------------

-- ----------------------------
-- Table structure for lv_term_member
-- ----------------------------
DROP TABLE IF EXISTS `lv_term_member`;
CREATE TABLE `lv_term_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term_id` int(11) NOT NULL COMMENT '团队id',
  `user_id` int(11) NOT NULL COMMENT '成员id',
  `join_time` datetime NOT NULL COMMENT '加入时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lv_term_member
-- ----------------------------

-- ----------------------------
-- Table structure for lv_user
-- ----------------------------
DROP TABLE IF EXISTS `lv_user`;
CREATE TABLE `lv_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  `login_time` datetime NOT NULL COMMENT '最近登录时间',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `invite_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邀请码',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lv_user
-- ----------------------------

-- ----------------------------
-- Table structure for lv_wish
-- ----------------------------
DROP TABLE IF EXISTS `lv_wish`;
CREATE TABLE `lv_wish`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '创建用户id',
  `term_id` int(11) NOT NULL COMMENT '所属团队id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心愿内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lv_wish
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
