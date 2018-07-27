/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : springboot-rabbitmq

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-27 13:55:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `UI_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `UI_USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `UI_NAME` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `UI_AGE` int(11) DEFAULT NULL COMMENT '用户年龄',
  `UI_BALANCE` decimal(10,0) DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`UI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'yuqiyu', '????', '23', null);
INSERT INTO `user_info` VALUES ('2', 'yuqiyu', '恒宇少年', '23', null);
INSERT INTO `user_info` VALUES ('3', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('4', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('5', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('6', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('7', 'yuqiyu4', '恒宇少年4', '23', null);
INSERT INTO `user_info` VALUES ('8', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('9', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('10', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('11', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('12', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('13', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('14', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('15', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('16', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('17', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('18', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('19', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('20', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('21', 'yuqiyu4', '恒宇少年4', '23', null);
INSERT INTO `user_info` VALUES ('22', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('23', 'yuqiyu4', '恒宇少年4', '23', null);
INSERT INTO `user_info` VALUES ('24', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('25', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('26', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('27', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('28', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('29', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('30', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('31', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('32', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('33', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('34', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('35', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('36', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('37', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('38', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('39', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('40', 'yuqiyu4', '恒宇少年4', '23', null);
INSERT INTO `user_info` VALUES ('41', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('42', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('43', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('44', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('45', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('46', 'yuqiyu4', '恒宇少年4', '23', null);
INSERT INTO `user_info` VALUES ('47', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('48', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('49', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('50', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('51', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('52', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('53', 'yuqiyu1', '恒宇少年1', '23', null);
INSERT INTO `user_info` VALUES ('54', 'yuqiyu7', '恒宇少年7', '23', null);
INSERT INTO `user_info` VALUES ('55', 'yuqiyu3', '恒宇少年3', '23', null);
INSERT INTO `user_info` VALUES ('56', 'yuqiyu6', '恒宇少年6', '23', null);
INSERT INTO `user_info` VALUES ('57', 'yuqiyu0', '恒宇少年0', '23', null);
INSERT INTO `user_info` VALUES ('58', 'yuqiyu9', '恒宇少年9', '23', null);
INSERT INTO `user_info` VALUES ('59', 'yuqiyu8', '恒宇少年8', '23', null);
INSERT INTO `user_info` VALUES ('60', 'yuqiyu5', '恒宇少年5', '23', null);
INSERT INTO `user_info` VALUES ('61', 'yuqiyu2', '恒宇少年2', '23', null);
INSERT INTO `user_info` VALUES ('62', 'yuqiyu4', '恒宇少年4', '23', null);
