/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 127.0.0.1:3306
 Source Schema         : keduw

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/07/2020 16:11:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kd_auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `kd_auth_permission`;
CREATE TABLE `kd_auth_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父权限id',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `button_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项卡或者按钮名称',
  `nav_menu` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否导航菜单',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面URL地址',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务器端提交地址',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kd_auth_permission
-- ----------------------------

-- ----------------------------
-- Table structure for kd_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `kd_auth_role`;
CREATE TABLE `kd_auth_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名字',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kd_auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for kd_auth_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `kd_auth_role_permission`;
CREATE TABLE `kd_auth_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kd_auth_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for kd_note
-- ----------------------------
DROP TABLE IF EXISTS `kd_note`;
CREATE TABLE `kd_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '创建用户',
  `term_id` int(11) NOT NULL COMMENT '所属团队id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '笔记内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `end_time` datetime(0) NOT NULL COMMENT '计划结束时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kd_note
-- ----------------------------

-- ----------------------------
-- Table structure for kd_note_term
-- ----------------------------
DROP TABLE IF EXISTS `kd_note_term`;
CREATE TABLE `kd_note_term`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '创建用户',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小组名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `odds` int(11) NOT NULL DEFAULT 0 COMMENT '抽奖机率',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kd_note_term
-- ----------------------------

-- ----------------------------
-- Table structure for kd_note_term_member
-- ----------------------------
DROP TABLE IF EXISTS `kd_note_term_member`;
CREATE TABLE `kd_note_term_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term_id` int(11) NOT NULL COMMENT '团队id',
  `user_id` int(11) NOT NULL COMMENT '成员id',
  `join_time` datetime(0) NOT NULL COMMENT '加入时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kd_note_term_member
-- ----------------------------

-- ----------------------------
-- Table structure for kd_note_wish_wall
-- ----------------------------
DROP TABLE IF EXISTS `kd_note_wish_wall`;
CREATE TABLE `kd_note_wish_wall`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '创建用户id',
  `term_id` int(11) NOT NULL COMMENT '所属团队id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心愿内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kd_note_wish_wall
-- ----------------------------

-- ----------------------------
-- Table structure for kd_user
-- ----------------------------
DROP TABLE IF EXISTS `kd_user`;
CREATE TABLE `kd_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `reg_time` datetime(0) NOT NULL COMMENT '注册时间',
  `login_time` datetime(0) NOT NULL COMMENT '最近登录时间',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `invite_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邀请码',
  `flag` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kd_user
-- ----------------------------

-- ----------------------------
-- Table structure for kd_user_role
-- ----------------------------
DROP TABLE IF EXISTS `kd_user_role`;
CREATE TABLE `kd_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kd_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
