USE `aal`;

/*Table structure for table `adspublish` */

DROP TABLE IF EXISTS `signing`;

CREATE TABLE `signing` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(32) NOT NULL comment '用户ID',
  `doctor_id` VARCHAR(32) NOT NULL COMMENT '医师ID',
  `month` INT(2) NOT NULL DEFAULT 5 comment '签约时长，按月算',
  `sn` varchar(32) NOT NULL default '' comment '订单号',
  `order_status` int(2) default 0 comment '支付状态  0:待支付 1:已支付',
  `is_sign` int(2) default 0 comment '签约状态 0:解约 1:签约',
  `create_date` BIGINT comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `question` varchar(50) default '' comment '问题',
  `answer` varchar(500) default '' comment '答案',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `question` (`question`,`answer`,`create_date`) VALUES
('问题1','答案1',100000),('问题2','答案2',100000),('问题3','答案3',100000),('问题4','答案4',100000);


DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `path` varchar(200) default '' comment '问题',
  `feekback_id` varchar(500) default '' comment '答案',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) default '' comment '标题',
  `content` varchar(1000) default '' comment '内容',
  `path` varchar(200) default '' comment '图片url',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `information` (`title`,`content`,`path`,`create_date`) VALUES
('资讯1','资讯1内容','http://localhost',100000),
('资讯2','资讯2内容','http://localhost',100000),
('资讯3','资讯3内容','http://localhost',100000),
('资讯4','资讯4内容','http://localhost',100000),
('资讯5','资讯5内容','http://localhost',100000);

DROP TABLE IF EXISTS `novice`;

CREATE TABLE `novice` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) default '' comment '内容',
  `path` varchar(200) default '' comment '图片url',
  `index` int(2) default 1 comment '序号 从小到大排序',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `novice`(`content`,`path`,`index`,`create_date`) VALUES
('新手指导第一步','http://localhost',1,100000),
('新手指导第二步','http://localhost',2,100000),
('新手指导第三步','http://localhost',3,100000),
('新手指导第四步','http://localhost',4,100000),
('新手指导第五步','http://localhost',5,100000);


DROP TABLE IF EXISTS `complaint`;

CREATE TABLE `complaint` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) default '' comment '用户ID',
  `doctor_id` varchar(32) default '' comment '医师ID',
  `content` varchar(1000) default '' comment '内容',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `accountsconfig`;

CREATE TABLE `accountsconfig` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `min_month` int(2) default 0 comment '最大免费月份',
  `price` double default 0 comment '签约每月价格',
  `create_date` bigint comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `accountsconfig` (`min_month`,`price`) values (5,100);

alter table aolchild_relation add `note` varchar(50);
