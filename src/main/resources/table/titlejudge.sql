/*
 Navicat Premium Data Transfer

 Source Server         : cho
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 123.57.71.124:3306
 Source Schema         : titlejudge

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 16/08/2020 00:22:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `ModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块id',
  `ModuleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块名称',
  `ModuleURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块地址',
  `ModuleIcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图标地址',
  `ParentModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父模块id',
  `ModuleStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块状态',
  `ModuleOrderNum` int(11) NOT NULL COMMENT '模块序号',
  `ModuleComponet` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块组件',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路由',
  PRIMARY KEY (`ModuleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('628a225b91cc4e5c9a115981e330b8ab', '模块管理', 'moduleManage', '/icon/teacher', '0', '启用', 1, 'Layout', '模块管理', '/sysControl/moduleManage');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `RoleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `RoleStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态',
  `RoleOrderNum` int(5) NOT NULL COMMENT '角色序号',
  PRIMARY KEY (`RoleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('3017134c0cf84b0fbd683943c0cbe50c', '学生处老师', '启用', 1);

-- ----------------------------
-- Table structure for rolemodule
-- ----------------------------
DROP TABLE IF EXISTS `rolemodule`;
CREATE TABLE `rolemodule`  (
  `RoleModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色模块id',
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `ModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块id',
  PRIMARY KEY (`RoleModuleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rolemodule
-- ----------------------------
INSERT INTO `rolemodule` VALUES ('a560af78e71e48249366d93d9794a8d5', '3017134c0cf84b0fbd683943c0cbe50c', '628a225b91cc4e5c9a115981e330b8ab');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `UserRoleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户角色id',
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `UserID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  PRIMARY KEY (`UserRoleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('018d65cfac994e9dabb53af5159f683e', '3017134c0cf84b0fbd683943c0cbe50c', '4856d359bc86494d9b3b817065933077');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `UserID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `LoginPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录电话',
  `UserPassWord` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `UserRealName` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `UserStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`UserID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('4856d359bc86494d9b3b817065933077', '123', '4d54497a', 'hh', '1');

SET FOREIGN_KEY_CHECKS = 1;
