/*
Navicat MySQL Data Transfer

Source Server         : liuchao
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-05 13:58:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `url` varchar(20) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null);
INSERT INTO `sys_permission` VALUES ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(10) DEFAULT NULL,
  `sys_permission_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_role_id` (`sys_role_id`),
  KEY `sys_permission_id` (`sys_permission_id`),
  CONSTRAINT `sys_permission_id` FOREIGN KEY (`sys_permission_id`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `sys_role_id` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2');
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(10) DEFAULT NULL,
  `sys_role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`sys_user_id`),
  KEY `role_id` (`sys_role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');
INSERT INTO `sys_role_user` VALUES ('4', '9', '2');
INSERT INTO `sys_role_user` VALUES ('5', '9', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_password_change` bigint(13) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admi', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', null, null, '0');
INSERT INTO `sys_user` VALUES ('2', 'abel', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', null, null, '1');
INSERT INTO `sys_user` VALUES ('3', '测试用例3', null, null, null, null);
INSERT INTO `sys_user` VALUES ('4', 'aaa', 'aaaa', null, null, null);
INSERT INTO `sys_user` VALUES ('5', 'zhangsan', '1', null, null, null);
INSERT INTO `sys_user` VALUES ('6', 'xx', '$2a$10$2wHbNEexiipN5JigZIkdXefhZ3H/bNDv/gxUtXR8Gnfzu6z.68NGq', null, null, null);
INSERT INTO `sys_user` VALUES ('8', 'zz', '$2a$10$j2q7ypQgTUEvLwLMHQtv/ut8M.fO8kDAMVLJOkEWG1VU6j5SIlkJ6', null, null, null);
INSERT INTO `sys_user` VALUES ('9', 'qq', '$2a$10$EMINgDqsqkzkwdA3GevKguEEA1.b0YZALJgO4eA46SHGdMlnW5ije', null, null, '1');
INSERT INTO `sys_user` VALUES ('10', 'lc', '$2a$10$XfgZCIFxiJP2zOLTKqQ/eugoQ/fsZRWPhA/x36oBcLBynjXRM6V0O', null, null, null);
INSERT INTO `sys_user` VALUES ('11', 'lcc', '$2a$10$v8OtRd4IDhh2Ss9s55igLe.L8O0Lk2HvKbK2joW/PWrc44o9K7Lzq', null, null, null);
INSERT INTO `sys_user` VALUES ('12', 'lcx', '$2a$10$UcmkOZSxymaxch5az1sxUOMMn8UAl7jYSevb6LXfguO.U6aRfUpjm', null, null, null);
INSERT INTO `sys_user` VALUES ('13', 'lcv', '$2a$10$mWIk/aAXv31lpJH7J3twROjCY7JdfJUC63XICATlbXTgJJRr539Vq', null, null, null);
INSERT INTO `sys_user` VALUES ('14', 'lk', '$2a$10$F9C5tDmGysA7t/W9RvyXhuZa/H9QJjBDWTb4XHNSnyRyHFcRCcGny', null, null, null);
INSERT INTO `sys_user` VALUES ('15', 'lj', '$2a$10$tbPvf.lC0hFZnbcp7ibxKO.BvEZmGXWDSk1yRUe7ho07g/Nl42nWW', null, null, null);
INSERT INTO `sys_user` VALUES ('16', 'lo', '$2a$10$W.QXDrL7WPBlA8IVKxMxYe1bZYrcEIX1PjU/ITeMZI/VgM1JSfsQa', null, null, null);
INSERT INTO `sys_user` VALUES ('17', 'LL', '$2a$10$SDzo.e9BBFEKpUQNYYLl4OheUwJeo9U0vMxbGTy9cUNDFqKiGNceO', null, null, null);
INSERT INTO `sys_user` VALUES ('18', 'qw', '$2a$10$JoShJE.ntBhDteciz6MY9.uINNyZczf9eic7WP2NjVlTnOUz3Lw8O', null, null, null);
INSERT INTO `sys_user` VALUES ('19', 'qwe', '$2a$10$G7seSTM1cK8UQDE5Kh2uCuBXgfnsCM7aTjfiqlC2WGdLviIn6xvYW', null, null, null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(20) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(20) DEFAULT NULL,
  `u_password` varchar(20) DEFAULT NULL,
  `u_email` varchar(20) DEFAULT NULL,
  `u_age` int(4) DEFAULT NULL,
  `u_address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', 'EmailOne', '12', 'BJ');
INSERT INTO `t_user` VALUES ('2', 'usernameTwo', 'pdwTwo', 'EmailTwo', '13', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Procedure structure for lc_pro_test
-- ----------------------------
DROP PROCEDURE IF EXISTS `lc_pro_test`;
DELIMITER ;;
CREATE DEFINER=`test`@`localhost` PROCEDURE `lc_pro_test`()
begin
show variables like '%event_sche%';
end
;;
DELIMITER ;
