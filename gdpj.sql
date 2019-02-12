# Host: localhost  (Version 5.7.18-log)
# Date: 2019-02-13 00:28:13
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "auth_rule"
#

DROP TABLE IF EXISTS `auth_rule`;
CREATE TABLE `auth_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单id',
  `name` varchar(50) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` varchar(30) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `parent` varchar(50) DEFAULT NULL COMMENT '父菜单名称',
  `code` varchar(30) DEFAULT NULL COMMENT '菜单编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "foodstuff"
#

DROP TABLE IF EXISTS `foodstuff`;
CREATE TABLE `foodstuff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(99) DEFAULT NULL,
  `desc` text COMMENT '食品描述',
  `typeid` int(11) DEFAULT NULL COMMENT '食品类型id',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` varchar(30) DEFAULT NULL,
  `origin` varchar(99) DEFAULT NULL COMMENT '产地',
  `price` int(11) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `is_discount` int(11) DEFAULT NULL COMMENT '是否折扣商品',
  `inventory` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "foodstuff_kind"
#

DROP TABLE IF EXISTS `foodstuff_kind`;
CREATE TABLE `foodstuff_kind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(99) DEFAULT NULL,
  `desc` text,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "gdpj_user"
#

DROP TABLE IF EXISTS `gdpj_user`;
CREATE TABLE `gdpj_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '用户类型',
  `type_name` varchar(30) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for table "payment_record"
#

DROP TABLE IF EXISTS `payment_record`;
CREATE TABLE `payment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_order_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='支付流水';

#
# Structure for table "shopping_cart_detail"
#

DROP TABLE IF EXISTS `shopping_cart_detail`;
CREATE TABLE `shopping_cart_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `foodstuff_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='购物车详情';

#
# Structure for table "system_log"
#

DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(10) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "transaction_order"
#

DROP TABLE IF EXISTS `transaction_order`;
CREATE TABLE `transaction_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_money` int(11) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='交易订单';

#
# Structure for table "transaction_order_detail"
#

DROP TABLE IF EXISTS `transaction_order_detail`;
CREATE TABLE `transaction_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_order_id` int(11) DEFAULT NULL,
  `foodstuff_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单详情';

#
# Structure for table "user_auth"
#

DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `auth_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` datetime DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
