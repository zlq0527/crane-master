/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736 (5.7.36)
 Source Host           : localhost:3306
 Source Schema         : crane

 Target Server Type    : MySQL
 Target Server Version : 50736 (5.7.36)
 File Encoding         : 65001

 Date: 08/04/2024 09:30:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crane_data
-- ----------------------------
DROP TABLE IF EXISTS `crane_data`;
CREATE TABLE `crane_data` (
  `id` bigint(20) NOT NULL COMMENT '硬件id',
  `temporary` varchar(255) DEFAULT NULL COMMENT '塔吊温度',
  `weight` int(11) DEFAULT NULL COMMENT '塔吊重量',
  `win_speed` int(11) DEFAULT NULL COMMENT '风速',
  `distance` int(11) DEFAULT NULL COMMENT '距离',
  `angle` int(11) DEFAULT NULL COMMENT '角度',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of crane_data
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crane_equipment
-- ----------------------------
DROP TABLE IF EXISTS `crane_equipment`;
CREATE TABLE `crane_equipment` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `crane_data_id` bigint(20) DEFAULT NULL COMMENT '关联数据',
  `device_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `device_type` varchar(255) DEFAULT NULL COMMENT '设备型号',
  `sensor` varchar(255) DEFAULT NULL COMMENT '传感器列表',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of crane_equipment
-- ----------------------------
BEGIN;
INSERT INTO `crane_equipment` (`id`, `crane_data_id`, `device_name`, `device_type`, `sensor`, `gmt_create`, `gmt_modify`) VALUES (1773725228111413250, 2, '安卓开发板1', 'MT8183', '湿度传感器', '2024-03-29 22:53:43', '2024-03-30 11:45:31');
INSERT INTO `crane_equipment` (`id`, `crane_data_id`, `device_name`, `device_type`, `sensor`, `gmt_create`, `gmt_modify`) VALUES (1773725412191027202, 1, 'Android设备', '67', '温度传感器，湿度传感器，高度传感器', '2024-03-29 22:54:27', '2024-03-29 22:54:27');
INSERT INTO `crane_equipment` (`id`, `crane_data_id`, `device_name`, `device_type`, `sensor`, `gmt_create`, `gmt_modify`) VALUES (1773748470553444354, 3, '安卓开发板2', 'MT8184', '123123', '2024-03-30 00:26:05', '2024-03-30 11:45:46');
INSERT INTO `crane_equipment` (`id`, `crane_data_id`, `device_name`, `device_type`, `sensor`, `gmt_create`, `gmt_modify`) VALUES (1773748499284426754, 0, '开发板3', 'MT8185', '高度传感器，', '2024-03-30 00:26:12', '2024-03-30 11:52:06');
COMMIT;

-- ----------------------------
-- Table structure for crane_info
-- ----------------------------
DROP TABLE IF EXISTS `crane_info`;
CREATE TABLE `crane_info` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `crane_name` varchar(255) DEFAULT NULL COMMENT '塔吊名称',
  `location_name` varchar(255) DEFAULT NULL COMMENT '位置信息',
  `equipment_id` bigint(20) DEFAULT NULL COMMENT '硬件id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `img_uid` varchar(255) DEFAULT NULL COMMENT '塔吊图片UID',
  `company` varchar(255) DEFAULT NULL COMMENT '承包公司',
  `principal_name` varchar(255) DEFAULT NULL COMMENT '责任人',
  `principal_phone` varchar(255) DEFAULT NULL COMMENT '责任人手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of crane_info
-- ----------------------------
BEGIN;
INSERT INTO `crane_info` (`id`, `crane_name`, `location_name`, `equipment_id`, `gmt_create`, `gmt_modify`, `img_uid`, `company`, `principal_name`, `principal_phone`) VALUES (1776466881519751169, 'abcd', '清华大学', 1773725228111413250, '2024-04-06 04:28:04', '2024-04-07 19:28:29', '8F6D5D0D90D743FB81C33F05DC645A86', '创建', '常杰', '13037610527');
INSERT INTO `crane_info` (`id`, `crane_name`, `location_name`, `equipment_id`, `gmt_create`, `gmt_modify`, `img_uid`, `company`, `principal_name`, `principal_phone`) VALUES (1776896653253111810, 'abc', '余杭区西湖', NULL, '2024-04-07 08:55:49', '2024-04-07 08:55:49', NULL, '恒大', '恒大', '13037610527');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name_zh` varchar(255) DEFAULT NULL,
  `icon_cls` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (1, '/index', 'index', '塔吊管理', '', '', NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (2, '/index', 'index', '设备管理', '', '', NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (3, '/craneInfo', '1-1', '塔吊信息', NULL, NULL, 1);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (4, '/craneData', '1-3', '设备管理', NULL, NULL, 2);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (5, '/3-1', '', '资料管理', NULL, NULL, NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (6, '/user', 'User', '用户管理', NULL, NULL, 5);
INSERT INTO `menu` (`id`, `path`, `name`, `name_zh`, `icon_cls`, `component`, `parent_id`) VALUES (7, '/permissions', 'Permissions', '权限管理', NULL, NULL, 5);
COMMIT;

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
BEGIN;
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (2, 2, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (3, 3, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (4, 4, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (5, 1, 2);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (6, 2, 2);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (7, 3, 2);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (8, 4, 2);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (9, 5, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (10, 6, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (11, 7, 1);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (29, 3, 25);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (30, 4, 25);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (31, 3, 24);
INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES (32, 4, 24);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `name_zh` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `name`, `name_zh`) VALUES (1, 'superadmin', '超级管理员');
INSERT INTO `role` (`id`, `name`, `name_zh`) VALUES (24, 'user', '用户');
INSERT INTO `role` (`id`, `name`, `name_zh`) VALUES (25, 'admin', '普通管理员');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rel_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_time` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `user_name`, `password`, `rel_name`, `created_by`, `created_time`, `enabled`, `role_id`, `role_name`) VALUES (27, 'admin', 'admin', 'admin', 'admin2', '2024-03-23 14:14:33', 1, 1, '超级管理员');
INSERT INTO `user` (`id`, `user_name`, `password`, `rel_name`, `created_by`, `created_time`, `enabled`, `role_id`, `role_name`) VALUES (29, 'user', 'user', '普通用户', 'admin', '2024-03-31 15:18:45', 1, 24, '用户');
INSERT INTO `user` (`id`, `user_name`, `password`, `rel_name`, `created_by`, `created_time`, `enabled`, `role_id`, `role_name`) VALUES (30, 'admin2', 'admin2', 'admin2', 'admin', '2024-03-31 15:26:48', 1, 25, '普通管理员');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
