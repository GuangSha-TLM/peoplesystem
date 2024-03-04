/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : peoplesystem

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 04/03/2024 17:34:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stu_id` bigint(20) NOT NULL COMMENT ' 学号/工号',
  `status` tinyint(2) NULL DEFAULT 0 COMMENT '状态（0：未选， 1：被选）',
  `createtime` date NULL DEFAULT NULL COMMENT ' 创建时间',
  `updatetime` date NULL DEFAULT NULL COMMENT ' 修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
