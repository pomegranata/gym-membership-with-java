/*
 Navicat Premium Data Transfer

 Source Server         : port3306
 Source Server Type    : MySQL
 Source Server Version : 100416 (10.4.16-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : membership

 Target Server Type    : MySQL
 Target Server Version : 100416 (10.4.16-MariaDB)
 File Encoding         : 65001

 Date: 28/07/2024 09:40:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `plan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `trainer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 3) NOT NULL,
  `monthly_progress` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('MEM-01', 'Hans Müller', 'Berlin', 'Yoga', 'Natasha', 90.000, 15);
INSERT INTO `member` VALUES ('MEM-02', 'Anna Schmidt', 'Munich', 'Endurance', 'Demian', 150.000, 23);
INSERT INTO `member` VALUES ('MEM-03', 'Maximilian Fischer', 'Hamburg', 'Cardio', 'Ivan', 80.000, 27);
INSERT INTO `member` VALUES ('MEM-04', 'Lukas Becker', 'Cologne', 'Power', 'Hermann', 100.000, 14);
INSERT INTO `member` VALUES ('MEM-05', 'Mia Wagner', 'Frankfurt', 'Body Building', 'Dmitry', 100.000, 19);
INSERT INTO `member` VALUES ('MEM-06', 'Sophia Weber', 'Stuttgart', 'Endurance', 'Demian', 150.000, 7);
INSERT INTO `member` VALUES ('MEM-07', 'Leon Richter', 'Düsseldorf', 'Yoga', 'Natasha', 90.000, 21);
INSERT INTO `member` VALUES ('MEM-08', 'Emily Klein', 'Dortmund', 'Power', 'Hermann', 100.000, 30);
INSERT INTO `member` VALUES ('MEM-09', 'Ben Hoffmann', 'Bremen', 'Cardio', 'Ivan', 80.000, 18);
INSERT INTO `member` VALUES ('MEM-10', 'Emma Meyer', 'Leipzig', 'Body Building', 'Dmitry', 100.000, 25);
INSERT INTO `member` VALUES ('MEM-11', 'Noah Keller', 'Dresden', 'Endurance', 'Demian', 150.000, 13);
INSERT INTO `member` VALUES ('MEM-12', 'Paul Koch', 'Hanover', 'Power', 'Hermann', 100.000, 17);
INSERT INTO `member` VALUES ('MEM-13', 'Marie Schulz', 'Nuremberg', 'Yoga', 'Natasha', 90.000, 29);
INSERT INTO `member` VALUES ('MEM-14', 'Felix Bauer', 'Duisburg', 'Cardio', 'Ivan', 80.000, 12);
INSERT INTO `member` VALUES ('MEM-15', 'Clara Braun', 'Bochum', 'Body Building', 'Dmitry', 100.000, 28);
INSERT INTO `member` VALUES ('MEM-16', 'Julian Krüger', 'Wuppertal', 'Endurance', 'Demian', 150.000, 10);
INSERT INTO `member` VALUES ('MEM-17', 'Elena Wolf', 'Bielefeld', 'Power', 'Hermann', 100.000, 22);
INSERT INTO `member` VALUES ('MEM-18', 'Jonas Schröder', 'Bonn', 'Cardio', 'Ivan', 80.000, 16);
INSERT INTO `member` VALUES ('MEM-19', 'Laura Neumann', 'Münster', 'Body Building', 'Dmitry', 100.000, 24);
INSERT INTO `member` VALUES ('MEM-20', 'Niklas Schwarz', 'Karlsruhe', 'Yoga', 'Natasha', 90.000, 20);

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `memID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `trID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sesi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `plan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `progress` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `memID`(`memID` ASC) USING BTREE,
  INDEX `trID`(`trID` ASC) USING BTREE,
  CONSTRAINT `memID` FOREIGN KEY (`memID`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trID` FOREIGN KEY (`trID`) REFERENCES `trainer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('SCH-01', 'MEM-11', 'TR-04', 'Malam', 'Endurance', 15);
INSERT INTO `schedule` VALUES ('SCH-02', 'MEM-07', 'TR-05', 'Siang', 'Yoga', 8);
INSERT INTO `schedule` VALUES ('SCH-03', 'MEM-03', 'TR-02', 'Sore', 'Cardio', 20);
INSERT INTO `schedule` VALUES ('SCH-04', 'MEM-14', 'TR-02', 'Pagi', 'Cardio', 11);
INSERT INTO `schedule` VALUES ('SCH-05', 'MEM-05', 'TR-03', 'Malam', 'Body Building', 5);
INSERT INTO `schedule` VALUES ('SCH-06', 'MEM-12', 'TR-01', 'Sore', 'Power', 7);
INSERT INTO `schedule` VALUES ('SCH-07', 'MEM-19', 'TR-03', 'Pagi', 'Body Building', 12);
INSERT INTO `schedule` VALUES ('SCH-08', 'MEM-08', 'TR-01', 'Malam', 'Power', 19);
INSERT INTO `schedule` VALUES ('SCH-09', 'MEM-09', 'TR-02', 'Siang', 'Cardio', 14);
INSERT INTO `schedule` VALUES ('SCH-10', 'MEM-10', 'TR-03', 'Pagi', 'Body Building', 18);
INSERT INTO `schedule` VALUES ('SCH-11', 'MEM-16', 'TR-04', 'Siang', 'Endurance', 16);
INSERT INTO `schedule` VALUES ('SCH-12', 'MEM-13', 'TR-05', 'Sore', 'Yoga', 10);
INSERT INTO `schedule` VALUES ('SCH-13', 'MEM-17', 'TR-01', 'Malam', 'Power', 22);
INSERT INTO `schedule` VALUES ('SCH-14', 'MEM-18', 'TR-02', 'Pagi', 'Cardio', 13);
INSERT INTO `schedule` VALUES ('SCH-15', 'MEM-15', 'TR-03', 'Siang', 'Body Building', 9);
INSERT INTO `schedule` VALUES ('SCH-16', 'MEM-02', 'TR-04', 'Sore', 'Endurance', 17);
INSERT INTO `schedule` VALUES ('SCH-17', 'MEM-20', 'TR-05', 'Malam', 'Yoga', 21);
INSERT INTO `schedule` VALUES ('SCH-18', 'MEM-06', 'TR-04', 'Pagi', 'Endurance', 23);
INSERT INTO `schedule` VALUES ('SCH-19', 'MEM-01', 'TR-05', 'Siang', 'Yoga', 11);
INSERT INTO `schedule` VALUES ('SCH-20', 'MEM-04', 'TR-01', 'Sore', 'Power', 20);

-- ----------------------------
-- Table structure for trainer
-- ----------------------------
DROP TABLE IF EXISTS `trainer`;
CREATE TABLE `trainer`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `spesialisasi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `payment_progress` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trainer
-- ----------------------------
INSERT INTO `trainer` VALUES ('TR-01', 'Hermann', 'Power', 15);
INSERT INTO `trainer` VALUES ('TR-02', 'Ivan', 'Cardio', 8);
INSERT INTO `trainer` VALUES ('TR-03', 'Dmitry', 'Body Building', 20);
INSERT INTO `trainer` VALUES ('TR-04', 'Demian', 'Endurance', 11);
INSERT INTO `trainer` VALUES ('TR-05', 'Natasha', 'Yoga', 5);

SET FOREIGN_KEY_CHECKS = 1;
