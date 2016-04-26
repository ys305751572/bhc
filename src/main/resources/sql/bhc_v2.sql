CREATE DATABASE /*!32312 IF NOT EXISTS*/`aal` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aal`;

/*Table structure for table `adspublish` */

DROP TABLE IF EXISTS `signing`;

CREATE TABLE `signing` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(32) NOT NULL comment '用户ID',
  `doctor_id` VARCHAR(32) NOT NULL COMMENT '医师ID',
  `month` INT(2) NOT NULL DEFAULT 5 comment '签约时长，按月算',
  `create_date` BIGINT comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;