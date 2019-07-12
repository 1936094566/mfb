/*
 Navicat Premium Data Transfer

 Source Server         : bendi
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : mfb

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 12/07/2019 15:00:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mfb_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_mfb_menu`;
CREATE TABLE `t_mfb_menu`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `pid` int(11) NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提示',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单状态',
  `belong` int(255) NULL DEFAULT NULL COMMENT '0-前台,1-后台',
  `num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `ismenu` int(255) NULL DEFAULT NULL COMMENT '0-是菜单,1不是菜单',
  `per_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_mfb_menu
-- ----------------------------
INSERT INTO `t_mfb_menu` VALUES (1, '测试1', '/#', 'ceshi1', 0, '0', '1', '测试1', '0', 1, 0, 1, NULL);
INSERT INTO `t_mfb_menu` VALUES (2, '测试2', '/#', 'ceshi2', 0, '0', '1', '测试2', '0', 1, 1, 1, NULL);
INSERT INTO `t_mfb_menu` VALUES (4, '测试4', '/#', 'ceshi4', 0, '0', '1', '测试4', '0', 1, 3, 1, NULL);
INSERT INTO `t_mfb_menu` VALUES (5, '测试5', '/#', 'ceshi5', 0, '0', '1', '测试5', '0', 1, 4, 1, NULL);

-- ----------------------------
-- Table structure for t_mfb_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mfb_role`;
CREATE TABLE `t_mfb_role`  (
  `id` int(11) NOT NULL,
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称\r\n',
  `rolecode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `descprition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_mfb_role
-- ----------------------------
INSERT INTO `t_mfb_role` VALUES (1, 'admin', 'admin', '超级管理员');

-- ----------------------------
-- Table structure for t_mfb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_mfb_role_menu`;
CREATE TABLE `t_mfb_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_mfb_user
-- ----------------------------
DROP TABLE IF EXISTS `t_mfb_user`;
CREATE TABLE `t_mfb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '账号状态,需要验证 0 表示 正常 1被封',
  `relname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实名称',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `birthday` datetime(6) NULL DEFAULT NULL COMMENT '生日',
  `user_type` int(2) NOT NULL DEFAULT 1 COMMENT '用户类型 0 管理员 1 普通用户',
  `salt` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码加盐',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_mfb_user
-- ----------------------------
INSERT INTO `t_mfb_user` VALUES (1, 'admin', 'admin', 'machao0605@qq.com', '2019-05-06 18:05:04', NULL, '0', 'mc', '1', '1994-06-05 18:05:22.000000', 0, '1111');

-- ----------------------------
-- Table structure for t_mfb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mfb_user_role`;
CREATE TABLE `t_mfb_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_mfb_user_role
-- ----------------------------
INSERT INTO `t_mfb_user_role` VALUES (1, 1, 1);

-- ----------------------------
-- Procedure structure for insert_data_p
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_data_p`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_data_p`(IN num INT)
BEGIN
DECLARE n INT DEFAULT 1;
WHILE n <= num DO
INSERT INTO big_data(name,age,email)values(concat('mmcc',n),rand()*50,concat('mmcc',n,'@qq.com'));
set n=n+1;
end while;
ENd
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
