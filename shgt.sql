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
#�﷨��
#show databases;//�鿴�Ѿ������õ����ݿ�
#use shgt;//ʹ���Ѿ������õ����ݿ�
#show tables;//�鿴���ݿ����Ѿ������õı�
#describe users(����);//�鿴�����Ĵ���


INSERT INTO `users` VALUES (1,'admin','admin','xuben@bjfu.edu.cn',0,'000000000000000000','13146668862','0000-00-00',0);

#2users�����
insert into `users` values(080824209,'С��','123','xuben@bjfu.edu.cn',0,'','123456','2011-04-28',1);
insert into `users` values(080824202,'������','123','zhaofan@126.com',0,'','7777777','2011-04-28',1);
insert into `users` values(080824230,'����','123','meiyexin@sohu.com',0,'','66666666','2011-04-28',1);
insert into `users` values(080824229,'��','123','wangqianlan66@126.com',0,'','88888888','2011-04-28',1);

#3good_type�����
insert into `good_type` values(1,'���õ���');
insert into `good_type` values(2,'�����ֻ�');
insert into `good_type` values(3,'���');
insert into `good_type` values(4,'������Ʒ');
insert into `good_type` values(5,'���ѿ�');
insert into `good_type` values(6,'����');
insert into `good_type` values(7,'���ֳ�');
insert into `good_type` values(8,'���õ���');
insert into `good_type` values(9,'�����ֻ�');
insert into `good_type` values(10,'���ַ�');
insert into `good_type` values(11,'�������');
insert into `good_type` values(12,'�̾�/��Ҷ');
insert into `good_type` values(13,'ͼ��/��־');
insert into `good_type` values(14,'�ֱ�');
insert into `good_type` values(15,'����/�ղ�');
insert into `good_type` values(16,'��Ʊ');
insert into `good_type` values(17,'�Ҿ���Ʒ');
insert into `good_type` values(18,'���/����');
insert into `good_type` values(19,'Ħ�г�/���г�');
insert into `good_type` values(20,'����/����');
insert into `good_type` values(21,'�칫��Ʒ');
insert into `good_type` values(22,'������Ʒ');
insert into `good_type` values(23,'���/��Ϸ��');
insert into `good_type` values(24,'������Ʒ');
insert into `good_type` values(25,'����');
insert into `good_type` values(26,'ĸӤ��Ʒ');
insert into `good_type` values(27,'����/���');
insert into `good_type` values(28,'Ůװ/ŮЬ');
insert into `good_type` values(29,'�۾�/̫����');
insert into `good_type` values(30,'��Ʊ/��Ʊ/ϷƱ');
insert into `good_type` values(31,'����/����/����');
insert into `good_type` values(32,'��ױƷ');
insert into `good_type` values(33,'��װ/��Ь');
insert into `good_type` values(34,'��Ʊ');

#info_release�����
insert into `info_release` values(1,2,080824230,'8���������ֻ�',1,'�����ֻ�ת��','2011-04-28');
insert into `info_release` values(2,22,080824209,'7���°�������',1,'����ת��','2011-04-29');
insert into `info_release` values(3,29,080824229,'̫����ת��',1,'̫����ת��','2011-04-29');
insert into `info_release` values(4,31,080824202,'����ת�ã��۸������',1,'����ת��','2011-04-30');

#goods�����
insert into `goods` values(1,'iphone�ֻ�',2000,'2011-04-28',2,'','�۸����������ϵ����');
insert into `goods` values(2,'ȹ��',28,'2011-04-28',13,'','�ļ���ȹ����ӭ�µ���ϵ');
insert into `goods` values(3,'̨��',1,'2011-04-28',13,'','����̨�ƣ��ʺ�С����ʹ��Ŷ');
insert into `goods` values(4,'��ͨ��',3,'2011-04-28',13,'','8���µ�С��Ŷ����ӭ�µ���ϵ');
insert into `goods` values(5,'��Ʊ',16,'2011-04-28',13,'','30�ձ��������죬��ӭ�µ���ϵ');
insert into `goods` values(6,'����',32,'2011-04-28',13,'','����û�ù��Ĺ�����ӭ�µ���ϵ');

#comment�����
insert into `comment` values(1,'��ϲ������۾�Ŷ',080824229,3);
insert into `comment` values(2,'ʲô�ͺŵ��ֻ���',080824230,1);
insert into `comment` values(3,'�����е�������Ŷ',080824209,2);
insert into `comment` values(4,'���ٵ�������ô����',080824202,4);
