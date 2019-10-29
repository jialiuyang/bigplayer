/*
 Navicat Premium Data Transfer

 Source Server         : 分销测试
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.1.29:3306
 Source Schema         : fx_test

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 29/10/2019 13:34:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for doublecolor
-- ----------------------------
DROP TABLE IF EXISTS `doublecolor`;
CREATE TABLE `doublecolor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `red01` int(2) DEFAULT NULL,
  `red02` int(2) DEFAULT NULL,
  `red03` int(2) DEFAULT NULL,
  `red04` int(2) DEFAULT NULL,
  `red05` int(2) DEFAULT NULL,
  `red06` int(2) DEFAULT NULL,
  `blue` int(2) DEFAULT NULL,
  `doubleday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2025 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
