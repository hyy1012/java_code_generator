/*
Navicat MySQL Data Transfer

Source Server         : 172.16.0.177
Source Server Version : 50505
Source Host           : 172.16.0.177:3306
Source Database       : automation

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-06-13 15:20:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `db` varchar(255) DEFAULT NULL,
  `pageurl` varchar(255) DEFAULT NULL,
  `tablename` varchar(255) DEFAULT NULL,
  `dbname` varchar(255) DEFAULT NULL,
  `dbip` varchar(255) DEFAULT NULL,
  `dbusername` varchar(255) DEFAULT NULL,
  `dbpassword` varchar(255) DEFAULT NULL,
  `downurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('2', '172.16.11.38', 'MYSQL', 'com.netmarch.a.b', 'jdyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528691567154172.16.11.38.zip');
INSERT INTO `logs` VALUES ('3', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'nj', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('4', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'njjob', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('5', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'njposition', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('6', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'requestcode', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('7', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'requeststatus', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('8', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'statisticsagriculturalmachinery', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('9', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'statisticsfishingboat', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('10', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'zfcl', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('11', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'zfyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('12', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'zhcl', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('13', '172.16.11.38', 'MYSQL', 'com.netmarch.aaa.bbb', 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528694523330172.16.11.38.zip');
INSERT INTO `logs` VALUES ('14', '172.16.11.38', 'MYSQL', 'com.netmarch.sss.bbb', 'njjob', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528704402151172.16.11.38.zip');
INSERT INTO `logs` VALUES ('15', '172.16.11.38', 'MYSQL', 'com.netmarch.a.b', 'accidenttreatment', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528722412282172.16.11.38.zip');
INSERT INTO `logs` VALUES ('16', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528765075515172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('17', '172.16.11.38', 'MYSQL', null, 'work_atachment', 'fixedassets', '172.16.0.177', 'root', 'netmarch', '1528765075515172.16.11.38(fixedassets).doc');
INSERT INTO `logs` VALUES ('18', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528765075515172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('19', '172.16.11.210', 'MYSQL', null, 'accidenttreatment', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528766588628172.16.11.210(enterpriseplatform).doc');
INSERT INTO `logs` VALUES ('20', '172.16.11.210', 'MYSQL', null, 'users', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528766588628172.16.11.210(enterpriseplatform).doc');
INSERT INTO `logs` VALUES ('21', '172.16.11.210', 'MYSQL', 'com.netintech.AQHC.AqHc', 'enterprisesafetytraining', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528766588628172.16.11.210.zip');
INSERT INTO `logs` VALUES ('22', '172.16.11.38', 'MYSQL', null, 'users', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528771328862172.16.11.38(enterpriseplatform).doc');
INSERT INTO `logs` VALUES ('23', '172.16.11.38', 'MYSQL', null, 'users', 'enterpriseplatform', '172.16.0.177', 'root', 'netmarch', '1528769629087172.16.11.38(enterpriseplatform).doc');
INSERT INTO `logs` VALUES ('24', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528772850668172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('25', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528771069687172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('26', '172.16.11.38', 'MYSQL', null, 'weixin', 'ksufwresource', '172.16.0.177', 'root', 'netmarch', '1528771069687172.16.11.38(ksufwresource).doc');
INSERT INTO `logs` VALUES ('27', '172.16.11.241', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528786273441172.16.11.241(dwxx).doc');
INSERT INTO `logs` VALUES ('28', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528786441419172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('29', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528869923736172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('30', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528870018912172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('31', '172.16.11.38', 'MYSQL', null, 'zhyc', 'dwxx', '172.16.0.177', 'root', 'netmarch', '1528870176720172.16.11.38(dwxx).doc');
INSERT INTO `logs` VALUES ('32', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('33', '172.16.11.38', 'MYSQL', null, 'address', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('34', '172.16.11.38', 'MYSQL', null, 'arti_article', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('35', '172.16.11.38', 'MYSQL', null, 'arti_article_attachment', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('36', '172.16.11.38', 'MYSQL', null, 'cms_admin', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('37', '172.16.11.38', 'MYSQL', null, 'cms_member_group', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('38', '172.16.11.38', 'MYSQL', null, 'cms_chnl_model_item', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('39', '172.16.11.38', 'MYSQL', null, 'cms_member_group', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('40', '172.16.11.38', 'MYSQL', null, 'cms_member_group', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('41', '172.16.11.38', 'MYSQL', null, 'cms_member_group', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('42', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528870632155172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('43', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528873160560172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('44', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528873160560172.16.11.38(cms2).doc');
INSERT INTO `logs` VALUES ('45', '172.16.11.38', 'MYSQL', null, 'vote_topic', 'cms2', '172.16.0.177', 'root', 'netmarch', '1528871921739172.16.11.38(cms2).doc');
