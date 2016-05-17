USE `aal`;


alter table aolchild_relation add `note`  varchar(50) default '';
alter table t_pathology add `doctor_id`  varchar(50) default '';


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

DROP TABLE IF EXISTS `run_record`;

CREATE TABLE `run_record` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) not null comment '用户ID',
  `mileage` double default 0 comment '里程数',
  `step` int default 0 comment '步数',
  `consumption` double default 0 comment '消耗',
  `create_date` varchar(30) comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_pathology_v2`;

CREATE TABLE `t_pathology_v2` (
  `ID` varchar(32) NOT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  `CONTENT` varchar(20000) DEFAULT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL COMMENT '讲座链接地址',
  `TYPE` int(2) DEFAULT NULL COMMENT '类型 0:病理 1:讲座',
  `doctor_id` varchar(32) default null comment '医师ID',
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER` varchar(50) DEFAULT NULL,
  `doctor_id` varchar(50) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pathology_v2` */

insert  into `t_pathology`(`ID`,`TITLE`,`CONTENT`,`IMAGE`,`URL`,`TYPE`,`CREATE_DATE`,`CREATE_USER`,`doctor_id`) values ('8a22dd0f526766c1015267e64cbb0002','儿童急救大全！爸爸妈妈必备的基本常识','<p><span style=\"color:rgb(63, 63, 63)\">事故，家长马上想到的是送医院！其实如果爸爸妈妈们具有救护、自救的知识，能冷静、沉着、迅速地采取急救措施，就能为宝贝的生命争取时间，减少事故对宝贝的伤害。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">吞食异物</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">大人坐在椅子上，宝宝俯卧在双腿上，上胸部和头部低垂着，家长用一手固定孩子，另一手有节奏地拍击其两肩胛间的背部，使气道内的阻塞物脱离原位而咳出。必要的时候要进行人工呼吸或心外按摩。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">划伤</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">先用清水或稀释的消毒药水把伤口洗干净，然后止血。如果伤口较深长的话，就要用消毒纱布将伤口及周围包扎住，可以包扎得稍紧一些以止血;对于四肢上出血较多的伤口可以抬高患肢。做完初步的包扎止血措施之后应立即带宝宝去找医生救治。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">宠物咬伤</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">首先确保宠物已被控制住。用流动水冲洗伤口5分钟，确保从伤口完全冲洗掉动物唾液，用干净的纱布包扎伤口，立即送往医院。只要皮肤被咬破，哪怕是很小的伤口，也需看医生，注射狂犬疫苗。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">一氧化碳中毒</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">首先关闭气源，将患儿转移到空气新鲜的场所，注意保暖勿着凉。吸氧是最重要的治疗措施，所以需尽快将孩子送往医院，接受专业治疗。如果呼吸心跳已停止，必须立即行心肺复苏。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">烧伤烫伤</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">用凉水冲洗患处10-15分钟(婴儿用温水)，以降低温度。 未粘着的衣物小心地脱下(不要撕扯)， 以减少皮肤损害。 然后用干净的布单或纱布包裹伤口处并立即送医院，不要自行涂抹任何药膏，也不要挑破水疱，以免影响进一步治疗。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">溺水</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">注意清除口腔内的泥沙污物，保证气道畅通。若还有呼吸，则让患儿侧躺，使嘴在脸部下端而方便水流出。如果出现呼吸心跳停止，即刻施行人工呼吸以及心外按摩。抢救同时联系急救车(拨打120)，尽快送往医院实施进一步治疗。切记自己不要想办法把水拍出来，以免肺中的水扩散到其他部位。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">触电</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">尽快关闭电源，用不导电物(如干燥木棍、竹竿、塑料椅子等)挑开电线或将触电人离开电源。检查呼吸及心跳，心跳呼吸停止的一定要及时做人工呼吸及心外按摩。若手指插入插座而触电，之后手指如果有一红点的话，哪怕宝宝看起来没事了，也要马上去医院做检查，因为体内存余的电力可能会在24小时内影响心脏正常工作。</span></p>\r\n\r\n<p style=\"text-align:center\">&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">中毒</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">带上中毒物品，尽快将孩子送往医院，以便医生尽快查出毒源。不知道怎么办也可以电话到中毒急救中心，打电话时要镇静，先说明孩子多大，体重多少，吃错什么东西，多少量。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">误吃腐蚀物</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">不要想办法让孩子呕吐，正确的方法是让孩子大量喝水，起稀释的作用。注意！！如果孩子喝的是洗洁剂的话千万不可喝水，否则洗洁剂在体内起泡膨胀，易进入肺部。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><span style=\"color:rgb(63, 63, 63)\">蜂螫</span></strong></p>\r\n\r\n<p><span style=\"color:rgb(63, 63, 63)\">尽量冷敷，必要的时候要用药，以防过敏症状的出现。区分蜜蜂和马蜂? 马蜂刺人后还可以继续飞，而蜜蜂刺人后就死翘翘啦</span></p>\r\n\r\n<p>&nbsp;</p>\r\n','/upload/qc/1453348807724_351505_20160122135451954.jpg','',1,'2016-01-22 13:54:52',NULL,'8a22dd0f511357d301511380f1130005');
insert  into `t_pathology`(`ID`,`TITLE`,`CONTENT`,`IMAGE`,`URL`,`TYPE`,`CREATE_DATE`,`CREATE_USER`,`doctor_id`) values ('8a22dd0f526766c1015267e6ee2b0004','血糖监测的五个最佳时段','<p><strong>&nbsp; &nbsp; 并不是所有时段的血糖监测都有必要，了解血糖全貌，只需记住5个监测时段。</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>&nbsp; &nbsp;第一个时段：</strong><span style=\"font-family:宋体\">测空腹血糖，可以看出头天晚上所用药物对整个夜间乃至清晨血糖的控制情况。</span></p>\r\n\r\n<p><span style=\"font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p>　 &nbsp;&nbsp;<strong>第二个时段：</strong><span style=\"font-family:宋体\">测餐前血糖，可以及时发现低血糖，指导患者调整将要吃入的食物总量和餐前药物的用量。</span></p>\r\n\r\n<p><span style=\"font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p>　 &nbsp;&nbsp;<strong>第三个时段：</strong><span style=\"font-family:宋体\">测餐后两小时<span style=\"font-family:calibri\">(</span>从吃第一口饭开始算起<span style=\"font-family:calibri\">)</span>血糖，许多早期糖尿病患者空腹血糖并不高，但其胰岛素分泌功能已受损，受高糖刺激后反应较差，餐后血糖会明显升高。</span></p>\r\n\r\n<p><span style=\"font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p><strong>　　第四个时段：</strong><span style=\"font-family:宋体\">测睡前血糖，可以指导夜间用药或注射胰岛素剂量。睡前血糖小于<span style=\"font-family:calibri\">6</span>毫摩尔<span style=\"font-family:calibri\">/</span>升，夜间低血糖发生率大于<span style=\"font-family:calibri\">50%</span>。</span></p>\r\n\r\n<p><span style=\"font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p><strong>　　第五个时段：</strong><span style=\"font-family:宋体\">测凌晨<span style=\"font-family:calibri\">3</span>点血糖，可以鉴别空腹高血糖的原因，因为夜间胰岛素缺乏可以引起空腹高血糖。</span></p>\r\n\r\n<p><span style=\"font-family:宋体; font-size:14px\">&nbsp;&nbsp;</span></p>\r\n\r\n<p>　　<span style=\"font-family:宋体\">用胰岛素的患者，开始时每日血糖监测至少<span style=\"font-family:calibri\">5</span>次，达标后可每日<span style=\"font-family:calibri\">2~4</span>次；使用口服药的患者，血糖达标后每周监测<span style=\"font-family:calibri\">2~4</span>次，直到病情稳定。</span></p>\r\n\r\n<div>&nbsp;</div>\r\n','/upload/qc/1453348004544_959146_20160122135533438.jpg','',1,'2016-01-22 13:55:33',NULL,'8a22dd0f511357d301511380f1130005');
insert  into `t_pathology`(`ID`,`TITLE`,`CONTENT`,`IMAGE`,`URL`,`TYPE`,`CREATE_DATE`,`CREATE_USER`,`doctor_id`) values ('8a22dd0f526766c1015267e776f30006','有效预防咽炎知多少','<p><span style=\"font-family:宋体\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-family:宋体\">日常生活当中咽炎这种疾病的病发率很高，该病困扰到了较多的患者朋友，伤害到了患者的咽喉健康，大家应当警惕咽炎的出现，而且要进行一些咽炎的预防工作才可以，接下来来大家来介绍一下可以预防咽炎的方法会是什么呢。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:24px\">咽炎</span><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">是一种极易受空气质量所影响的疾病，尤其是空气不好、污染比较严重时最容易诱发慢性咽炎。所以咽炎患者在雾霾天气下，要注意饮食起居和用药方面的预防，减少外出的时间，或者是外出戴口罩等，以免方法不当加重咽炎病情。</span></p>\r\n\r\n<p style=\"text-align:justify\"><strong>须知一：</strong><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">跑步应暂时取消，空气污染较重，建议不要外出锻炼，尤其不要进行一些运动量较大的活动，比如取消跑步等。如果是外界污染诱发慢性咽炎等疾病复发，建议选择含&nbsp;中药成分有清热解毒，清利咽喉的作用的药剂，可抵御致病菌对咽喉的伤害。此外，外出时建议佩戴口罩并减少到人流密集的场所活动。出现呼吸困难等症状时，建议及时就医。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p style=\"text-align:justify\"><strong>须知二</strong><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:14px\">：</span><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">抗生素不利病情，生活中，很多人都会认为既然慢性咽炎是&ldquo;炎症&rdquo;，就得用抗生素治疗，这种认识其实是错误的。李广盛提醒，这样用药对于慢性咽炎有害而无益。&nbsp;因为滥用抗生素可能导致咽喉部正常菌群失调，引起二重感染。另外，每一种抗生素都可能引起全身副作用，长期滥用可对人体造成危害。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p style=\"text-align:justify\"><strong>须知三：</strong><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">盐水有利于清洁，很多咽炎患者都备有多重含片和去火的药剂。对此李广盛指出，无论何种含片都只能起到辅助作用，不宜长期应用。此外，因为咽炎的发生不仅仅是&nbsp;上火导致的，而且寒凉性味的药物长时间服用对胃及消化系统没什么好处，因此这两种药不可长期和擅自使用。日常使用的食盐具有呵护咽喉的作用，轻微的咽喉炎&nbsp;可用盐水配合药物治疗。方法为当咽喉感觉有轻度不适时，可用淡盐水做晨间漱口剂;当咽喉肿痛时，每日用浓盐水漱口三四次，能起到清除尘埃影响、消炎杀菌的&nbsp;效果。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p style=\"text-align:justify\"><strong>须知四：</strong><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">科学合理用嗓，老师、歌手、演员等职业用嗓者，由于用嗓时间较多，若不注意科学合理性的话，慢性咽炎就会如影随形，影响正常的工作。所以要避免用嗓过度或大&nbsp;声喊叫，注意休息，减少操劳，适当锻炼身体。杜绝对咽喉的刺激，生活中烟酒既可刺激咽喉又可使机体功能受损，应坚决戒除;煎炒、辛辣、腌制、烧烤等食品刺&nbsp;激性也都很大，慢性咽炎患者要少吃;另外空气寒冷和多尘时，也会刺激咽粘膜，所以专家建议患者要保持居室内空气湿润清洁，用暖气取暖时应注意室内不要太干&nbsp;燥，可使用加湿器，或者在睡前在暖气上放块湿毛巾，以保持空气湿润，一旦外出，要戴口罩防尘保暖。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">&nbsp;</span></p>\r\n\r\n<p style=\"text-align:justify\"><strong>须知五：</strong><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">积极治疗引发咽炎的疾病，流行感冒、鼻炎、鼻窦炎、中耳炎、胃酸反流等疾病，由于在位置、生理结构上和咽部存在着天然的联系，一旦它们发病过久，不可避免的&nbsp;就会引起咽粘膜的炎症，所以必须积极治疗。多吃对咽喉有益的食物，患者可时常饮用清凉润喉的饮料，多吃水果，如甘蔗、梨、荸荠、石榴等，每天早晨用盐水漱&nbsp;口，还可生吃萝卜或用萝卜做菜吃，都可以做到生津利咽，修复咽粘膜。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(51, 51, 51); font-family:宋体; font-size:14px\">有效预防咽炎的方法就是上面的知识了，咽炎会给患者带来苦恼，也会严重的伤害到患者的咽部健康，朋友们必须要将上面的这些预防措施了解清楚，注意咽喉部位的健康情况，而且在自己的饮食方面也应当注意清淡一些，还要多多休息。</span></p>\r\n\r\n<div>&nbsp;</div>\r\n','/upload/qc/1453348241962_904809_20160122135608469.jpg','',1,'2016-01-22 13:56:08',NULL,'8a22dd0f511357d301511380f1130005');
insert  into `t_pathology`(`ID`,`TITLE`,`CONTENT`,`IMAGE`,`URL`,`TYPE`,`CREATE_DATE`,`CREATE_USER`,`doctor_id`) values ('8a22dd0f526766c1015267e800c40008','门诊不输液是医疗常识的回归','<p><span style=\"font-family:黑体; font-size:14px\">据《现代快报》报道，江苏省卫计委日前下发通知，对门诊输液作出最新规定。明年7月1日起，除儿童医院，全省二级以上医院全面停止门诊患者静脉输注抗菌药物；明年年底前，除了儿童医院，全省二级以上医院全面停止门诊患者静脉输液。也就是说，门诊不允许开输液药品，要想输液，患者只能去急诊或者住院。</span></p>\r\n\r\n<p><span style=\"font-family:黑体; font-size:14px\">&ldquo;能吃药不打针，能打针不输液&rdquo;，这是一个基本的医学原则，但在现实生活中，医院里最忙碌的地方往往是输液室。据媒体报道，2009年我国医疗输液104亿瓶，相当于13亿人口每人输了8瓶液，远远高于国际上人均2.5至3.3瓶的水平。这组数据的另一面是，每年因不安全注射导致死亡的人数在39万人以上，其中，每年约有20万人死于药物不良反应。</span></p>\r\n\r\n<p><span style=\"font-family:黑体; font-size:14px\">相比起口服用药和肌肉注射，输液是医学界公认的最危险的给药方式，过度输液不仅增加了患者的负担，而且会带来一系列不良影响。很多人都有这样的体会，面对同样的疾病，输液用的药越来越好，越来越贵，其中的原因就在于输液会使用抗生素，而抗生素会使人产生抗药性，结果是抗生素的剂量越来越大。世界卫生组织的数据显示，中国是全球抗生素滥用最严重的国家之一，这个抗生素大国的名号着实令人汗颜。改变过度输液的局面，首先需要患者提高合理用药的意识，当然，解决问题的根本还在于规范医院的行为。</span></p>\r\n\r\n<p><span style=\"font-family:黑体; font-size:14px\">传统以药养医的模式中，输液收入往往是医院药品收入的大头，这也是过度输液之所以愈演愈烈的关键所在。在这样的背景下，江苏省卫计委明确叫停门诊输液，无疑值得点赞。新医改的一个重要方向是完善分级诊疗，叫停门诊输液之后，有需求的患者可以选择住院治疗，或是直接在社区医院就诊，由此不仅有助于遏制大医院的门诊乱输液、乱用药，而且有助于普及&ldquo;能吃药不打针，能打针不输液&rdquo;这样的医学常识。</span></p>\r\n\r\n<p style=\"text-align:center\">&nbsp;</p>\r\n\r\n<p><span style=\"font-family:黑体; font-size:14px\">叫停门诊输液之后，很多人都在担心，社区医院能否承担起公众的输液需求。其实，这样的心态正是输液依赖症的一种直观体现，不断改善社区医院的条件固然重要，普及医学常识摆脱输液依赖显然更加重要。从这种意义上说，取消门诊输液的同时，卫生管理部门有必要进一步宣传普及医疗常识，使公众对科学用药多一些理解和认同。</span></p>\r\n\r\n<p><a href=\"http://www.propoliscapsules.net/\" style=\"color: rgb(255, 255, 255);\" target=\"_blank\">propolis</a><a href=\"http://www.propoliscapsules.net/\" style=\"color: rgb(255, 255, 255);\" target=\"_blank\">propolis capsule</a></p>\r\n','/upload/qc/1453348180036_193387_20160122135643750.jpg','',1,'2016-01-22 13:56:43',NULL,'8a22dd0f511357d301511380f1130005');
insert  into `t_pathology`(`ID`,`TITLE`,`CONTENT`,`IMAGE`,`URL`,`TYPE`,`CREATE_DATE`,`CREATE_USER`,`doctor_id`) values ('8a22dd0f526766c1015267e8d6b2000a','请医网提醒您冬天您需要注意的医疗常识','<p><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">1.&nbsp;</span><span style=\"font-family:宋体\">对付冬季干燥，除了坚持早晨喝水的习惯外，在每次餐前也应该适量喝一点水，不仅可以缓解咽干，而且可以起到刺激胃肠消化功能的作用。喝水可以大口喝，但要小口咽，让水有慢慢滋润咽部的感觉。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">2.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">在室内放几盆清水，可以有效保持室内湿度，预防呼吸系统疾病</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">3.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">注意足部保暖，足部着凉，全身血液循环不畅，会引起鼻、咽、气管等上呼吸道疾病。所以，无论幼儿还是老人，睡前都应该用热水泡脚，稍做按摩，可以预防呼吸道感染</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">4.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">外出前用凉水洗脸，增强对外面气候的适应能力。外出回来必须洗手，流感病毒在手上能存活70个小时，从这个角度讲，洗手是防病的&ldquo;第一道关&rdquo;</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">5.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">寒冷的冬天，舒舒服服地洗个热水澡是一件很惬意的事，但如果洗得时间过长，也未必是一件好事，尤其是心脏病患者，洗澡方法不当，容易引起急性心脏病，甚至导致猝死</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">6.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">带小朋友出去玩，记得戴上保暖的帽子。人的头部是神经中枢的所在地，头部的皮肤虽然薄，却布满血管及毛发，所以体内热量常从头部大量往外散发。寒冷时候戴帽子不仅能保暖，还可避免感冒、咳嗽、头痛、而神经麻痹等疾病发生。</span></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">7.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">不戴帽子虽潇洒，感冒流涕就不好啦，这时要记得多喝热水，多休息</span></p>\r\n\r\n<p><span style=\"color:rgb(255, 0, 0); font-family:宋体; font-size:24px\">8.</span><span style=\"font-family:宋体\">&nbsp;</span><span style=\"font-family:宋体\">天冷的时候，大多数人都只想着待在屋子里或者待在被窝里，其实多点出去运动锻炼身体有利于增强抵抗力的，感冒的几率就低很多了</span></p>\r\n\r\n<div>&nbsp;</div>\r\n','/upload/qc/1453348295074_549878_20160122135738469.jpg','',1,'2016-01-22 13:57:38',NULL,'8a22dd0f511357d301511380f1130005');
