/*
 Navicat Premium Data Transfer

 Source Server         : wzm
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : 123.56.66.43:3306
 Source Schema         : titlejudge

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 23/07/2020 05:43:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
CREATE DATABASE `titlejudge`;
USE `titlejudge`;
-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `ModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块id',
  `ModuleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块名称',
  `ModuleURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块地址',
  `ModuleIcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图标地址',
  `ParentModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '父模块id',
  `ModuleStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块状态',
  `ModuleOrderNum` int(11) NOT NULL COMMENT '模块序号',
  `ModuleComponet` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块组件',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '路由',
  PRIMARY KEY (`ModuleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色id',
  `RoleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `RoleStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色状态',
  `RoleOrderNum` int(5) NOT NULL COMMENT '角色序号',
  PRIMARY KEY (`RoleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rolemodule
-- ----------------------------
DROP TABLE IF EXISTS `rolemodule`;
CREATE TABLE `rolemodule`  (
  `RoleModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色模块id',
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色id',
  `ModuleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块id',
  PRIMARY KEY (`RoleModuleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `UserRoleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户角色id',
  `RoleID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色id',
  `UserID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  PRIMARY KEY (`UserRoleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `UserID` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `LoginPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录电话',
  `UserPassWord` char(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `UserRealName` varchar(14) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '真实姓名',
  `UserStatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`UserID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

alter table `module` convert to character set utf8 ;
alter table `role` convert to character set utf8 ;
alter table `rolemodule` convert to character set utf8 ;
alter table `userrole` convert to character set utf8 ;
alter table `users` convert to character set utf8 ;