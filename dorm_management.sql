/*
 Navicat MySQL Data Transfer

 Source Server         : conn
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : dorm_management

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 21/04/2019 19:38:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for against
-- ----------------------------
DROP TABLE IF EXISTS `against`;
CREATE TABLE `against` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_id` int(11) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `punishment` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`dorm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of against
-- ----------------------------
BEGIN;
INSERT INTO `against` VALUES (1, 1, '违规情况1。。。。。。', '2019-01-28', '警告');
INSERT INTO `against` VALUES (2, 1, '违规情况2。。。。。。', '2019-02-28', '警告');
INSERT INTO `against` VALUES (3, 1, '违规情况3。。。。。', '2019-03-28', '警告');
INSERT INTO `against` VALUES (4, 7, '该宿舍有学生使用大功率电器，有火灾隐患。 ', '2019-04-08', '记过');
INSERT INTO `against` VALUES (5, 8, '阿是大叔控的', '2019-04-13', '警告');
INSERT INTO `against` VALUES (6, 3, '嘟嘟嘟', '2019-04-14', '警告');
INSERT INTO `against` VALUES (7, 3, '嘟嘟嘟嘟', '2019-04-14', '警告');
COMMIT;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `pulisher` varchar(20) DEFAULT NULL,
  `readTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
BEGIN;
INSERT INTO `announcement` VALUES (2, '标题测试1', '/anou/anou1555170206497.html', '2019-04-13', '李志豪', 0);
INSERT INTO `announcement` VALUES (3, '测试标题2', '/anou/anou1555170667452.html', '2019-04-13', '李志豪', 0);
INSERT INTO `announcement` VALUES (4, '测试标题3', '/anou/anou1555170831292.html', '2019-04-13', '李志豪', 0);
COMMIT;

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `db_id` int(11) NOT NULL,
  `dorm_number` int(11) NOT NULL,
  `dorm_gender` varchar(2) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `occupy` int(11) DEFAULT '0',
  `hid` int(11) DEFAULT NULL,
  `fee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dorm_building_id` (`db_id`),
  KEY `hygiene_id` (`hid`),
  KEY `fee_id` (`fee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm
-- ----------------------------
BEGIN;
INSERT INTO `dorm` VALUES (1, 2, 318, '男', 4, 4, NULL, 1);
INSERT INTO `dorm` VALUES (2, 2, 101, '男', 4, 3, NULL, NULL);
INSERT INTO `dorm` VALUES (3, 2, 102, '男', 4, 0, NULL, NULL);
INSERT INTO `dorm` VALUES (4, 7, 101, '男', 4, 2, NULL, NULL);
INSERT INTO `dorm` VALUES (6, 4, 101, '女', 4, 4, NULL, 6);
INSERT INTO `dorm` VALUES (7, 4, 102, '女', 4, 0, NULL, NULL);
INSERT INTO `dorm` VALUES (8, 2, 201, '男', 4, 0, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for dorm_building
-- ----------------------------
DROP TABLE IF EXISTS `dorm_building`;
CREATE TABLE `dorm_building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `floors` int(11) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `builtuptime` date DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `occupy` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm_building
-- ----------------------------
BEGIN;
INSERT INTO `dorm_building` VALUES (1, 1, 6, '湖北省武汉市东风大道', '2010-11-19', 180, 0);
INSERT INTO `dorm_building` VALUES (2, 1, 6, '湖北省武汉市东风大道', '2011-07-30', 180, 2);
INSERT INTO `dorm_building` VALUES (3, 1, 6, '湖北省武汉市东风大道', '2015-03-26', 180, 0);
INSERT INTO `dorm_building` VALUES (4, 2, 6, '湖北省武汉市东风大道', '2015-11-28', 180, 1);
INSERT INTO `dorm_building` VALUES (5, 2, 6, '湖北省武汉市东风大道', '2014-03-26', 180, 0);
INSERT INTO `dorm_building` VALUES (6, 2, 6, '湖北省武汉市东风大道', '2014-03-26', 180, 0);
INSERT INTO `dorm_building` VALUES (7, 3, 10, '湖北省武汉市东风大道', '2016-07-15', 240, 1);
INSERT INTO `dorm_building` VALUES (8, 3, 10, '湖北省武汉市东风大道', '2016-11-26', 240, 0);
INSERT INTO `dorm_building` VALUES (9, 3, 10, '湖北省武汉市', '2018-07-05', 240, 0);
INSERT INTO `dorm_building` VALUES (10, 4, 10, '湖北省武汉市', '2018-01-01', 240, 0);
INSERT INTO `dorm_building` VALUES (11, 4, 10, '湖北省武汉市', '2014-07-11', 240, 0);
INSERT INTO `dorm_building` VALUES (12, 4, 10, '湖北省武汉市', '2017-06-04', 240, 0);
INSERT INTO `dorm_building` VALUES (13, 3, 0, '湖北省武汉市东风大道901号', '2015-03-20', 210, 0);
INSERT INTO `dorm_building` VALUES (14, 2, 0, '湖北省武汉市东风大道903号', '2015-04-05', 230, 0);
COMMIT;

-- ----------------------------
-- Table structure for dormapplication
-- ----------------------------
DROP TABLE IF EXISTS `dormapplication`;
CREATE TABLE `dormapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(30) DEFAULT NULL,
  `reason` varchar(300) DEFAULT NULL,
  `to_db_id` int(11) DEFAULT NULL,
  `to_dorm_number` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormapplication
-- ----------------------------
BEGIN;
INSERT INTO `dormapplication` VALUES (1, '150576001', '没有理由。。。。', 2, 101, 2, '2019-04-08');
INSERT INTO `dormapplication` VALUES (2, '150576008', 'zxcccc', 2, 101, 1, '2019-04-15');
COMMIT;

-- ----------------------------
-- Table structure for excellentDorm
-- ----------------------------
DROP TABLE IF EXISTS `excellentDorm`;
CREATE TABLE `excellentDorm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_id` int(11) DEFAULT NULL,
  `imgs` varchar(600) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduce` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of excellentDorm
-- ----------------------------
BEGIN;
INSERT INTO `excellentDorm` VALUES (1, 1, 'image/excellentDormImg/asda.jpg,image/excellentDormImg/axcx.jpg,image/excellentDormImg/dscvb.jpg', '新的一次“文明宿舍”的评比开始了，我宿舍的 每位成员在过去的一年里，严格遵守学校及院里的有关公寓管理的各项规章制度，在各个方面都取得了丰硕的成果。经过了大一的磨练，我们深刻地体会到了作为一名合格大学生的基本素质。在过去的一年里我宿舍积极开展“争做文明大学生”活动，有效地配合了学校关于校园精神文明建设，培养学生良好的行为规范等方面的方针和政策，并且取得了优异的成绩。尤其在思想，工作，学习，卫生方面都有一个质的飞跃。\n在大学里，“家”字代表的是宿舍。大学宿舍是个充分体现个性的绝佳场所，尤其是我们大一新生的栖息之地，我们的宿舍实在是个风光无限，竞看风流、快活的地方。寝室是我们讨论的地方。我们在饭香四溢的时候进行，有说有笑，开口就是思故乡情，各说各的家乡好，呆在小屋是 一种幸福。幸福，不是一株无限之树、一茎无叶之草。幸福之花，需要付出拼搏的热血与汗水的滋养浇灌，才能绽放盛开，芳香四溢。我们在这个小屋努力拼搏、奋斗，不让时间从我们身边溜走。生活在一个好的环境中是一件幸福又很快乐的事，庆幸的是我们的宿舍就是这样，让我们深深感到的自己的幸运。\n不同的地域和不同的文化使大家拥有不一样的性格，但是我们都很团结，从不为了一点小事斤斤计较，这也是我们快乐生活的关键所在。少了面红耳赤的争执，少了尔虞我诈的算计，少了不合人群的自私，等等，无形之中增添了一份浓浓的友情。\n我们 502 宿舍，自从跨进**校门走到一起，就为我们这个“家”出谋划策。努力营造一个具有温暖、友爱、积极向上气氛的新时代文明宿舍。\n502 是我们的家。在这个大家庭里，我们彼此之间有了更多的兄弟。我们平时十分重视保持宿舍的清洁卫生，坚持每周集体进行一次大扫除，包括对门窗、地面、桌面的清洁，还有在宿舍放一盆绿色植物，来美化宿舍。我们的生活用品，书籍都摆放得整整齐齐，给人以美的感觉。每当回到宿舍，压抑的心情就会感受到舒畅了好多。每逢周日我们都要组织一次大清扫，宿舍每个人不分你我都自觉得投入进来。');
INSERT INTO `excellentDorm` VALUES (2, 8, 'image/excellentDormImg/dscvb.jpg,image/excellentDormImg/ertyy.jpg,image/excellentDormImg/fdggr.jpg', '你好，这里是测试文件1.');
INSERT INTO `excellentDorm` VALUES (3, 2, 'image/excellentDormImg/15550665209146d5b0c8e-8a83-4a70-b294-d2c222e0a9f4.jpg,image/excellentDormImg/1555066520943589280e5-7876-4d96-8f4b-b39b4a39c04f.jpg,image/excellentDormImg/155506652094415560121-710f-4cd5-b73d-3f9acba93795.jpg,', '在学习方面，也是我们宿舍最骄傲的方面。我们寝室的室友都有获得过国家励志奖学金、三好学生、一等奖、二等奖、三等奖等奖项。营造了非常良好的学习氛围。每天回到宿舍，我们都会复习今天一天的功课，虽然感到有些辛苦，但是大家在一起学习的感觉还是很好，遇到不会不懂得题我们都会互相讨论，彼此交流，共同进步。就这样，通过了一年的努力，我们宿舍六个人全部都在班里前十名，这样的成绩都是和我们共同的努力分不开的。 在生活上，我们艰苦朴素、与人相处融合，并与周边寝室搞好关系，共同促进，共同进步。我们寝室的成员将积极参加一些校园活动,如拔河,下象棋，跳绳等项目,可以活跃的学习气氛,增进同学之间的友谊,增强我们的寝室凝聚力，以寝室自身的氛围带动班级的进步。 在卫生方面，我们从开始就制定好了卫生表，分好每天值日生，并约定每周大家一起做一次大扫除。我们的个人物品摆放整齐有序，室内无垃圾堆积、无蛛网、无乱贴乱画现象，空气清新，卫生整洁，地面干净。宿舍平时卫生及成员个人卫生状况都非常好。这是因为我们寝室制定了健全的轮流值日制度,六个人分别做好打扫寝室卫生的工作,大家都表现积极，认真做好自己应该做的工作,因此我们得宿舍在大一一年里还被评为“文明寝室”的称号。我们一直是按照这个标准实施的，从没有间断过。直到现在，我们的宿舍还是这么整洁，我们已经养成了这种习惯，相信这样的好环境我们会保持到毕业。这一次我们会更加努力，争取获得这一次的“文明寝室”的称号。 在这里请允许我们向尊敬的院领导们申请文明寝室的荣誉称号，请领导们审查我们寝室的条件，今后我们一定会在各方面做的更加优秀，不辜负学院老师的关切与期望，秉承优秀宿舍个人的标准，做合格优秀的大学生！');
COMMIT;

-- ----------------------------
-- Table structure for fee
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `id` int(11) NOT NULL DEFAULT '0',
  `waterFee` double DEFAULT NULL,
  `electricityFee` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------
BEGIN;
INSERT INTO `fee` VALUES (1, 50.01, 100.53);
INSERT INTO `fee` VALUES (6, 60.22, 200.03);
COMMIT;

-- ----------------------------
-- Table structure for hygiene
-- ----------------------------
DROP TABLE IF EXISTS `hygiene`;
CREATE TABLE `hygiene` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_id` int(11) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hygiene
-- ----------------------------
BEGIN;
INSERT INTO `hygiene` VALUES (1, 1, '卫生情况1', '宿管会评价1', '2019-03-01');
INSERT INTO `hygiene` VALUES (2, 1, '卫生情况2', '宿管会评价2', '2019-01-31');
INSERT INTO `hygiene` VALUES (3, 1, '卫生情况3', '宿管会评价3', '2019-02-22');
INSERT INTO `hygiene` VALUES (4, 2, '地面整洁，墙面干净，书本衣物摆放整齐。', '请继续保持哦！', '2019-04-08');
COMMIT;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_id` int(11) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `comments` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(30) NOT NULL,
  `name` varchar(12) NOT NULL,
  `gender` varchar(2) NOT NULL,
  `age` int(11) NOT NULL,
  `dept` varchar(12) DEFAULT NULL,
  `dorm_id` int(11) DEFAULT NULL,
  `institute` varchar(20) DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  `role` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `homeAddress` varchar(50) DEFAULT NULL,
  `entrancetime` date DEFAULT NULL,
  `headpic` varchar(120) DEFAULT NULL,
  `aboutMe` varchar(200) DEFAULT NULL,
  `permission` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `dorm_id` (`dorm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('150576001', '丁成林', '男', 24, '电子商务', 1, '信息工程学院', 'dcl123', 0, '7375839128@qq.com', '湖北省麻城市', '2015-09-01', '/image/headpic/f742f8c1-9969-420d-9c8c-775170e49bf5.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('150576002', '李湘湘', '女', 21, '舞蹈表演', 6, '艺术学院', 'lxx123', 0, '7364573829@qq.com', '湖北省黄石市', '2015-09-01', '/image/headpic/defaultFemale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('150576008', '李三', '男', 22, '电子商务', 1, '信息工程学院', 'lzh123', 0, '2633002549@qq.com', '湖北省阳新县', '2015-09-01', '/image/headpic/153676eb-6bd6-408b-98fe-fb0fa4bad7f4.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 1);
INSERT INTO `user` VALUES ('150576009', '柯健康', '男', 22, '电子商务', 1, '信息工程学院', 'kjk123', 0, '1565874121@qq.com', '湖北省大冶市', '2015-09-01', '/image/headpic/defaultMale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('150576014', '何涛', '男', 22, '电子商务', 1, '信息工程学院', 'ht123', 0, '2748584378@qq.com', '湖北省咸宁市', '2015-09-01', '/image/headpic/ht.jpg', '本人有扎实的应用电子专业知识基础，对专业知识有较深入的了解；有较强的学习潜力上进心强，处事态度细心谨慎认真负责；富有团队合作精神，善于与他人沟通交流，尤其是技术方面的知识，虚心请教他人，共同学习，共同进步；有良好的生活习惯，与他人相处融洽，善于与人交际。', 0);
INSERT INTO `user` VALUES ('150577001', '徐梦梦', '女', 21, '戏曲表演', 6, '艺术学院', 'xmm123', 0, '3748559238@qq.com', '北京市朝阳区', '2017-07-29', '/image/headpic/defaultFemale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('154839550', '丁玉', '女', 22, '计算机科学与技术', 6, '信息工程学院', 'dy123', 0, '3747584822@qq.com', '上海', '2015-09-01', '/image/headpic/defaultFemale.jpg', '本人有扎实的应用电子专业知识基础，对专业知识有较深入的了解；有较强的学习潜力上进心强，处事态度细心谨慎认真负责；富有团队合作精神，善于与他人沟通交流，尤其是技术方面的知识，虚心请教他人，共同学习，共同进步；有良好的生活习惯，与他人相处融洽，善于与人交际', 0);
INSERT INTO `user` VALUES ('165748993', '王小明', '男', 23, '软件工程', 2, '信息工程学院', 'wxm123', 0, '2633885769@qq.com', '四川省成都市', '2016-09-01', '/image/headpic/defaultMale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('178273007', '何罗', '男', 20, '机械工程', 2, '机械学院', 'hl123', 0, '2633849576@qq.com', '重庆市', '2017-09-01', '/image/headpic/defaultMale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('178475667', '李婷', '女', 20, '软件工程', 6, '信息工程学院', 'lt123', 0, '4657473742@qq.com', '湖北省襄阳市', '2017-09-01', '/image/headpic/defaultFemale.jpg', '本人有扎实的应用电子专业知识基础，对专业知识有较深入的了解；有较强的学习潜力上进心强，处事态度细心谨慎认真负责；富有团队合作精神，善于与他人沟通交流，尤其是技术方面的知识，虚心请教他人，共同学习，共同进步；有良好的生活习惯，与他人相处融洽，善于与人交际.', 0);
INSERT INTO `user` VALUES ('187263554', '柯金发', '男', 19, '工商管理', 2, '工商学院', 'kjf123', 0, '3636457574@qq.com', '重庆市', '2018-09-01', '/image/headpic/defaultMale.jpg', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。', 0);
INSERT INTO `user` VALUES ('201900001', '刘三', '男', 42, '核物理', 4, '物理学院', 'ls123', 1, '7475758383@163.com', '湖北省宜昌市', '2012-07-11', '/image/headpic/defaultMale.jpg', '我是管理员', 0);
INSERT INTO `user` VALUES ('201912345', '程满满', '男', 55, '计算机科学与技术', 4, '信息工程学院', 'cmm123', 1, '4588112354@qq.com', '湖北省武汉市', '2010-07-01', '/image/headpic/a3ecc150-ec14-4a04-8cb0-194dcad6bfb1.jpg', '我是管理员', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
