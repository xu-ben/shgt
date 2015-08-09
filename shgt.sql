# Host: localhost   Database: shgt
# ------------------------------------------------------


create database `shgt`;
use `shgt`;

#
# Table structure for table users
#

create table `users` (
	`id` bigint(20) unsigned not null auto_increment,
	`username` varchar(50) not null unique,
	`password` varchar(50) not null,
	`email` varchar(50) default null,
	`sex` int(4) default '0',
	`identityid` varchar(20) default '000000000000000000',
	`telephone` varchar(20) default null,
	`registerTime` date default '0000-00-00',
	`role` int(4) unsigned default '1',
	primary key  (`id`)
);

#
# Table structure for table good_type
#

create table `good_type`(
	`id` bigint(20) unsigned not null auto_increment,
	`type` varchar(50) default null,
	primary key  (`id`)
);


#
# Table structure for table goods
#

create table `goods` (
	`id` bigint(20) unsigned not null auto_increment,
	`name` varchar(100) not null,
	`price` bigint(20) unsigned default '0',
	`releasedate` date default '0000-00-00',
	`g_type_id` bigint(20) unsigned,
	key `g_type_id` (`g_type_id`),
	constraint  foreign key(`g_type_id`) references `good_type`(`id`),
	`picpath` varchar(300) default null,
	`description` text,
	primary key  (`id`)
);

#
# Table structure for table good_type
#
create table `info_release`(
	`id` bigint(20) unsigned not null auto_increment,
	i_type_id bigint(20) unsigned,
	i_user_id bigint(20) unsigned,
	key `i_type_id`(`i_type_id`),
	key `i_user_id`(`i_user_id`),
	constraint  foreign key(`i_type_id`) references `good_type`(`id`),
	constraint  foreign key(`i_user_id`) references `users`(`id`),
	`detail_info` text,
	`type`  int(4) default '1',
	`title` varchar(50) not null,
	`releaseDate` date default '0000-00-00'	,
	primary key  (`id`)
);

#
# Table structure for table comment
#
create table `comment`(
	`id` bigint(20) unsigned not null auto_increment,
	`content` text,
	c_user_id bigint(20) unsigned,
	c_post_id bigint(20) unsigned,
	key `c_post_id`(`c_post_id`),
	key `c_user_id`(`c_user_id`),
	constraint  foreign key(`c_post_id`) references `info_release`(`id`),
	constraint  foreign key(`c_user_id`) references `users`(`id`),	
	primary key  (`id`)
);


#
# Dumping data for table users
#
#语法：
#show databases;//查看已经创建好的数据库
#use shgt;//使用已经创建好的数据库
#show tables;//查看数据库中已经创建好的表
#describe users(表名);//查看具体表的创建


INSERT INTO `users` VALUES (1,'admin','admin','xuben@bjfu.edu.cn',0,'000000000000000000','13146668862','0000-00-00',0);

#2users表插入
insert into `users` values(080824209,'小犇','123','xuben@bjfu.edu.cn',0,'','123456','2011-04-28',1);
insert into `users` values(080824202,'凡大侠','123','zhaofan@126.com',0,'','7777777','2011-04-28',1);
insert into `users` values(080824230,'咩咩','123','meiyexin@sohu.com',0,'','66666666','2011-04-28',1);
insert into `users` values(080824229,'岚岚','123','wangqianlan66@126.com',0,'','88888888','2011-04-28',1);

#3good_type表插入
insert into `good_type` values(1,'家用电器');
insert into `good_type` values(2,'二手手机');
insert into `good_type` values(3,'玩具');
insert into `good_type` values(4,'闲置礼品');
insert into `good_type` values(5,'消费卡');
insert into `good_type` values(6,'电脑');
insert into `good_type` values(7,'二手车');
insert into `good_type` values(8,'家用电器');
insert into `good_type` values(9,'二手手机');
insert into `good_type` values(10,'二手房');
insert into `good_type` values(11,'数码相机');
insert into `good_type` values(12,'烟酒/茶叶');
insert into `good_type` values(13,'图书/杂志');
insert into `good_type` values(14,'手表');
insert into `good_type` values(15,'古玩/收藏');
insert into `good_type` values(16,'机票');
insert into `good_type` values(17,'家居用品');
insert into `good_type` values(18,'五金/建材');
insert into `good_type` values(19,'摩托车/自行车');
insert into `good_type` values(20,'电视/音响');
insert into `good_type` values(21,'办公用品');
insert into `good_type` values(22,'体育用品');
insert into `good_type` values(23,'玩具/游戏机');
insert into `good_type` values(24,'体育用品');
insert into `good_type` values(25,'首饰');
insert into `good_type` values(26,'母婴用品');
insert into `good_type` values(27,'包包/箱包');
insert into `good_type` values(28,'女装/女鞋');
insert into `good_type` values(29,'眼镜/太阳镜');
insert into `good_type` values(30,'门票/球票/戏票');
insert into `good_type` values(31,'钢琴/提琴/乐器');
insert into `good_type` values(32,'化妆品');
insert into `good_type` values(33,'男装/男鞋');
insert into `good_type` values(34,'火车票');

#info_release表插入
insert into `info_release` values(1,2,080824230,'8成新夏普手机',1,'夏普手机转让','2011-04-28');
insert into `info_release` values(2,22,080824209,'7成新阿迪篮球',1,'篮球转让','2011-04-29');
insert into `info_release` values(3,29,080824229,'太阳镜转让',1,'太阳镜转让','2011-04-29');
insert into `info_release` values(4,31,080824202,'钢琴转让，价格面议哈',1,'钢琴转让','2011-04-30');

#goods表插入
insert into `goods` values(1,'iphone手机',2000,'2011-04-28',2,'','价格可商量，联系本人');
insert into `goods` values(2,'裙子',28,'2011-04-28',13,'','夏季美裙，欢迎致电联系');
insert into `goods` values(3,'台灯',1,'2011-04-28',13,'','兔子台灯，适合小孩子使用哦');
insert into `goods` values(4,'卡通狗',3,'2011-04-28',13,'','8成新的小狗哦，欢迎致电联系');
insert into `goods` values(5,'机票',16,'2011-04-28',13,'','30日北京到重庆，欢迎致电联系');
insert into `goods` values(6,'唇膏',32,'2011-04-28',13,'','新买没用过的哈，欢迎致电联系');

#comment表插入
insert into `comment` values(1,'好喜欢这个眼镜哦',080824229,3);
insert into `comment` values(2,'什么型号的手机啊',080824230,1);
insert into `comment` values(3,'篮球还有弹性米有哦',080824209,2);
insert into `comment` values(4,'钢琴的音质怎么样啊',080824202,4);
