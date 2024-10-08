﻿USE `test`;

drop table if exists whmtest;

/*==============================================================*/
/* Table: whmtest                                               */
/*==============================================================*/
create table whmtest
(
    id                   bigint(20) not null auto_increment,
    name                 varchar(80),
    type                 int(9),
    mydate               timestamp default CURRENT_TIMESTAMP,
    primary key (id)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

drop table if exists zyjtest;

/*==============================================================*/
/* Table: zyjtest                                               */
/*==============================================================*/
create table zyjtest
(
    id                   bigint(20) not null auto_increment,
    name                 varchar(80),
    type                 int(9),
    mydate               timestamp default CURRENT_TIMESTAMP,
    primary key (id)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家信息';

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市级信息';

CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 用户信息
INSERT INTO `user_info` VALUES ('1', 'test1', '12345678', '1', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('2', 'test2', 'aaaa', '2', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('3', 'test3', 'bbbb', '1', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('4', 'test4', 'cccc', '2', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('5', 'test5', 'dddd', '1', null, null, null, null, null);

-- 国家信息
INSERT INTO `country` VALUES (1,'Angola','AO');
INSERT INTO `country` VALUES (2,'Afghanistan','AF');
INSERT INTO `country` VALUES (3,'Albania','AL');
INSERT INTO `country` VALUES (4,'Algeria','DZ');
INSERT INTO `country` VALUES (5,'Andorra','AD');
INSERT INTO `country` VALUES (6,'Anguilla','AI');
INSERT INTO `country` VALUES (7,'Antigua and Barbuda','AG');
INSERT INTO `country` VALUES (8,'Argentina','AR');
INSERT INTO `country` VALUES (9,'Armenia','AM');
INSERT INTO `country` VALUES (10,'Australia','AU');
INSERT INTO `country` VALUES (11,'Austria','AT');
INSERT INTO `country` VALUES (12,'Azerbaijan','AZ');
INSERT INTO `country` VALUES (13,'Bahamas','BS');
INSERT INTO `country` VALUES (14,'Bahrain','BH');
INSERT INTO `country` VALUES (15,'Bangladesh','BD');
INSERT INTO `country` VALUES (16,'Barbados','BB');
INSERT INTO `country` VALUES (17,'Belarus','BY');
INSERT INTO `country` VALUES (18,'Belgium','BE');
INSERT INTO `country` VALUES (19,'Belize','BZ');
INSERT INTO `country` VALUES (20,'Benin','BJ');
INSERT INTO `country` VALUES (21,'Bermuda Is.','BM');
INSERT INTO `country` VALUES (22,'Bolivia','BO');
INSERT INTO `country` VALUES (23,'Botswana','BW');
INSERT INTO `country` VALUES (24,'Brazil','BR');
INSERT INTO `country` VALUES (25,'Brunei','BN');
INSERT INTO `country` VALUES (26,'Bulgaria','BG');
INSERT INTO `country` VALUES (27,'Burkina-faso','BF');
INSERT INTO `country` VALUES (28,'Burma','MM');
INSERT INTO `country` VALUES (29,'Burundi','BI');
INSERT INTO `country` VALUES (30,'Cameroon','CM');
INSERT INTO `country` VALUES (31,'Canada','CA');
INSERT INTO `country` VALUES (32,'Central African Republic','CF');
INSERT INTO `country` VALUES (33,'Chad','TD');
INSERT INTO `country` VALUES (34,'Chile','CL');
INSERT INTO `country` VALUES (35,'China','CN');
INSERT INTO `country` VALUES (36,'Colombia','CO');
INSERT INTO `country` VALUES (37,'Congo','CG');
INSERT INTO `country` VALUES (38,'Cook Is.','CK');
INSERT INTO `country` VALUES (39,'Costa Rica','CR');
INSERT INTO `country` VALUES (40,'Cuba','CU');
INSERT INTO `country` VALUES (41,'Cyprus','CY');
INSERT INTO `country` VALUES (42,'Czech Republic','CZ');
INSERT INTO `country` VALUES (43,'Denmark','DK');
INSERT INTO `country` VALUES (44,'Djibouti','DJ');
INSERT INTO `country` VALUES (45,'Dominica Rep.','DO');
INSERT INTO `country` VALUES (46,'Ecuador','EC');
INSERT INTO `country` VALUES (47,'Egypt','EG');
INSERT INTO `country` VALUES (48,'EI Salvador','SV');
INSERT INTO `country` VALUES (49,'Estonia','EE');
INSERT INTO `country` VALUES (50,'Ethiopia','ET');
INSERT INTO `country` VALUES (51,'Fiji','FJ');
INSERT INTO `country` VALUES (52,'Finland','FI');
INSERT INTO `country` VALUES (53,'France','FR');
INSERT INTO `country` VALUES (54,'French Guiana','GF');
INSERT INTO `country` VALUES (55,'Gabon','GA');
INSERT INTO `country` VALUES (56,'Gambia','GM');
INSERT INTO `country` VALUES (57,'Georgia','GE');
INSERT INTO `country` VALUES (58,'Germany','DE');
INSERT INTO `country` VALUES (59,'Ghana','GH');
INSERT INTO `country` VALUES (60,'Gibraltar','GI');
INSERT INTO `country` VALUES (61,'Greece','GR');
INSERT INTO `country` VALUES (62,'Grenada','GD');
INSERT INTO `country` VALUES (63,'Guam','GU');
INSERT INTO `country` VALUES (64,'Guatemala','GT');
INSERT INTO `country` VALUES (65,'Guinea','GN');
INSERT INTO `country` VALUES (66,'Guyana','GY');
INSERT INTO `country` VALUES (67,'Haiti','HT');
INSERT INTO `country` VALUES (68,'Honduras','HN');
INSERT INTO `country` VALUES (69,'Hongkong','HK');
INSERT INTO `country` VALUES (70,'Hungary','HU');
INSERT INTO `country` VALUES (71,'Iceland','IS');
INSERT INTO `country` VALUES (72,'India','IN');
INSERT INTO `country` VALUES (73,'Indonesia','ID');
INSERT INTO `country` VALUES (74,'Iran','IR');
INSERT INTO `country` VALUES (75,'Iraq','IQ');
INSERT INTO `country` VALUES (76,'Ireland','IE');
INSERT INTO `country` VALUES (77,'Israel','IL');
INSERT INTO `country` VALUES (78,'Italy','IT');
INSERT INTO `country` VALUES (79,'Jamaica','JM');
INSERT INTO `country` VALUES (80,'Japan','JP');
INSERT INTO `country` VALUES (81,'Jordan','JO');
INSERT INTO `country` VALUES (82,'Kampuchea (Cambodia )','KH');
INSERT INTO `country` VALUES (83,'Kazakstan','KZ');
INSERT INTO `country` VALUES (84,'Kenya','KE');
INSERT INTO `country` VALUES (85,'Korea','KR');
INSERT INTO `country` VALUES (86,'Kuwait','KW');
INSERT INTO `country` VALUES (87,'Kyrgyzstan','KG');
INSERT INTO `country` VALUES (88,'Laos','LA');
INSERT INTO `country` VALUES (89,'Latvia','LV');
INSERT INTO `country` VALUES (90,'Lebanon','LB');
INSERT INTO `country` VALUES (91,'Lesotho','LS');
INSERT INTO `country` VALUES (92,'Liberia','LR');
INSERT INTO `country` VALUES (93,'Libya','LY');
INSERT INTO `country` VALUES (94,'Liechtenstein','LI');
INSERT INTO `country` VALUES (95,'Lithuania','LT');
INSERT INTO `country` VALUES (96,'Luxembourg','LU');
INSERT INTO `country` VALUES (97,'Macao','MO');
INSERT INTO `country` VALUES (98,'Madagascar','MG');
INSERT INTO `country` VALUES (99,'Malawi','MW');
INSERT INTO `country` VALUES (100,'Malaysia','MY');
INSERT INTO `country` VALUES (101,'Maldives','MV');
INSERT INTO `country` VALUES (102,'Mali','ML');
INSERT INTO `country` VALUES (103,'Malta','MT');
INSERT INTO `country` VALUES (104,'Mauritius','MU');
INSERT INTO `country` VALUES (105,'Mexico','MX');
INSERT INTO `country` VALUES (106,'Moldova, Republic of','MD');
INSERT INTO `country` VALUES (107,'Monaco','MC');
INSERT INTO `country` VALUES (108,'Mongolia','MN');
INSERT INTO `country` VALUES (109,'Montserrat Is','MS');
INSERT INTO `country` VALUES (110,'Morocco','MA');
INSERT INTO `country` VALUES (111,'Mozambique','MZ');
INSERT INTO `country` VALUES (112,'Namibia','NA');
INSERT INTO `country` VALUES (113,'Nauru','NR');
INSERT INTO `country` VALUES (114,'Nepal','NP');
INSERT INTO `country` VALUES (115,'Netherlands','NL');
INSERT INTO `country` VALUES (116,'New Zealand','NZ');
INSERT INTO `country` VALUES (117,'Nicaragua','NI');
INSERT INTO `country` VALUES (118,'Niger','NE');
INSERT INTO `country` VALUES (119,'Nigeria','NG');
INSERT INTO `country` VALUES (120,'North Korea','KP');
INSERT INTO `country` VALUES (121,'Norway','NO');
INSERT INTO `country` VALUES (122,'Oman','OM');
INSERT INTO `country` VALUES (123,'Pakistan','PK');
INSERT INTO `country` VALUES (124,'Panama','PA');
INSERT INTO `country` VALUES (125,'Papua New Cuinea','PG');
INSERT INTO `country` VALUES (126,'Paraguay','PY');
INSERT INTO `country` VALUES (127,'Peru','PE');
INSERT INTO `country` VALUES (128,'Philippines','PH');
INSERT INTO `country` VALUES (129,'Poland','PL');
INSERT INTO `country` VALUES (130,'French Polynesia','PF');
INSERT INTO `country` VALUES (131,'Portugal','PT');
INSERT INTO `country` VALUES (132,'Puerto Rico','PR');
INSERT INTO `country` VALUES (133,'Qatar','QA');
INSERT INTO `country` VALUES (134,'Romania','RO');
INSERT INTO `country` VALUES (135,'Russia','RU');
INSERT INTO `country` VALUES (136,'Saint Lueia','LC');
INSERT INTO `country` VALUES (137,'Saint Vincent','VC');
INSERT INTO `country` VALUES (138,'San Marino','SM');
INSERT INTO `country` VALUES (139,'Sao Tome and Principe','ST');
INSERT INTO `country` VALUES (140,'Saudi Arabia','SA');
INSERT INTO `country` VALUES (141,'Senegal','SN');
INSERT INTO `country` VALUES (142,'Seychelles','SC');
INSERT INTO `country` VALUES (143,'Sierra Leone','SL');
INSERT INTO `country` VALUES (144,'Singapore','SG');
INSERT INTO `country` VALUES (145,'Slovakia','SK');
INSERT INTO `country` VALUES (146,'Slovenia','SI');
INSERT INTO `country` VALUES (147,'Solomon Is','SB');
INSERT INTO `country` VALUES (148,'Somali','SO');
INSERT INTO `country` VALUES (149,'South Africa','ZA');
INSERT INTO `country` VALUES (150,'Spain','ES');
INSERT INTO `country` VALUES (151,'Sri Lanka','LK');
INSERT INTO `country` VALUES (152,'St.Lucia','LC');
INSERT INTO `country` VALUES (153,'St.Vincent','VC');
INSERT INTO `country` VALUES (154,'Sudan','SD');
INSERT INTO `country` VALUES (155,'Suriname','SR');
INSERT INTO `country` VALUES (156,'Swaziland','SZ');
INSERT INTO `country` VALUES (157,'Sweden','SE');
INSERT INTO `country` VALUES (158,'Switzerland','CH');
INSERT INTO `country` VALUES (159,'Syria','SY');
INSERT INTO `country` VALUES (160,'Taiwan','TW');
INSERT INTO `country` VALUES (161,'Tajikstan','TJ');
INSERT INTO `country` VALUES (162,'Tanzania','TZ');
INSERT INTO `country` VALUES (163,'Thailand','TH');
INSERT INTO `country` VALUES (164,'Togo','TG');
INSERT INTO `country` VALUES (165,'Tonga','TO');
INSERT INTO `country` VALUES (166,'Trinidad and Tobago','TT');
INSERT INTO `country` VALUES (167,'Tunisia','TN');
INSERT INTO `country` VALUES (168,'Turkey','TR');
INSERT INTO `country` VALUES (169,'Turkmenistan','TM');
INSERT INTO `country` VALUES (170,'Uganda','UG');
INSERT INTO `country` VALUES (171,'Ukraine','UA');
INSERT INTO `country` VALUES (172,'United Arab Emirates','AE');
INSERT INTO `country` VALUES (173,'United Kiongdom','GB');
INSERT INTO `country` VALUES (174,'United States of America','US');
INSERT INTO `country` VALUES (175,'Uruguay','UY');
INSERT INTO `country` VALUES (176,'Uzbekistan','UZ');
INSERT INTO `country` VALUES (177,'Venezuela','VE');
INSERT INTO `country` VALUES (178,'Vietnam','VN');
INSERT INTO `country` VALUES (179,'Yemen','YE');
INSERT INTO `country` VALUES (180,'Yugoslavia','YU');
INSERT INTO `country` VALUES (181,'Zimbabwe','ZW');
INSERT INTO `country` VALUES (182,'Zaire','ZR');
INSERT INTO `country` VALUES (183,'Zambia','ZM');

-- 城市信息
INSERT INTO `city` VALUES ('1', '石家庄', '河北');
INSERT INTO `city` VALUES ('2', '邯郸', '河北');