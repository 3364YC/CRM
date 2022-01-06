/*
 Navicat MySQL Data Transfer

 Source Server         : score
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : crmdb

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 04/01/2022 18:55:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contacts` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (38, '永辉超市', '吴迪', '153', '重庆市');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `ordersId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `goods` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` double NULL DEFAULT NULL,
  `ordersDate` date NOT NULL,
  PRIMARY KEY (`ordersId`) USING BTREE,
  INDEX `FK_ORDER_CID`(`customerId`) USING BTREE,
  CONSTRAINT `FK_ORDER_CID` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (86, 38, '无', 5000, '2022-01-04');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `recordId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `source` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int NOT NULL DEFAULT 0,
  `recordDate` date NOT NULL,
  PRIMARY KEY (`recordId`) USING BTREE,
  INDEX `FK_RECORD_CID`(`customerId`) USING BTREE,
  CONSTRAINT `FK_RECORD_CID` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (46, 38, '网销', '无', 1, '2022-01-04');

SET FOREIGN_KEY_CHECKS = 1;
