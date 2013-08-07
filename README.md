Java-ee-facility
================
# Тестовое задание 
  
 Написать приложение для учета выпуска продукции на предприятии, со следующими возможностями: 
 - Возможность регистрации и авторизации на сайте
 - CRUD операции с продукцией
 - CRUD операции со складскими помещениями 
 - CRUD операции с дистрибьюторами
 - Возможность поиска по продукции, складам, дистрибьторам
 
 
# Используемые технологии
 
 - Приложение написано в среде NetBeans IDE 7.3
 - Сервер -  Apache Tomcat 7.0.34.0
 - База данных - MySql

# Скрипт базы данных

- DROP DATABASE IF EXISTS `production`;
DROP DATABASE IF EXISTS `distributor`;
DROP DATABASE IF EXISTS `warehouse`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `warehouse` (
  `warehouse_id` int NOT NULL AUTO_INCREMENT,
  `name` char(35) NOT NULL,
  `category` char(5) NOT NULL,
  `area` int NOT NULL,
  PRIMARY KEY (`warehouse_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `warehouse` (`warehouse_id`, `name`, `category`,`area`) VALUES
  (1,'Склад01','A','100000'),
	(2,'Склад02','B','50000'),
	(3,'Склад03','C','75000');

CREATE TABLE IF NOT EXISTS `distributor` (
  `distributor_id` int NOT NULL AUTO_INCREMENT,
  `name` char(35) NOT NULL,
  `address` char(50) NOT NULL,
  PRIMARY KEY (`distributor_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `distributor` (`distributor_id`, `name`, `address`) VALUES
	(1,'ВивиконАБС','ул. Кольцова 13-56'),
	(2,'Дистриб','ул. Калинина 22-110'),
	(3,'БигДьюти','ул. Машерова 30-8');

CREATE TABLE IF NOT EXISTS `production` (
  `production_id` int NOT NULL AUTO_INCREMENT,
  `name` char(35) NOT NULL,
  `retail_price` int NOT NULL,
  `batch_size` int NOT NULL,
  `batch_price` int NOT NULL,
  `amount` int NOT NULL,
  `warehouse_id` int NOT NULL,
  `distributor_id` int NOT NULL,
  PRIMARY KEY (`production_id`),
  CONSTRAINT FOREIGN KEY (`warehouse_id`)
  REFERENCES `warehouse` (`warehouse_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (`distributor_id`)
  REFERENCES `distributor` (`distributor_id`) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `production` (`production_id`,`name`,`retail_price`,`batch_size`,`batch_price`,`amount`,`warehouse_id`,`distributor_id`) VALUES
	(1,'Консервы','2000','1000','1500000','16000','1','3'),
	(2,'Сковороды','5000','500','2000000','35000','2','2'),
	(3,'Пакеты','500','7000','2700000','4000','3','1');

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`user_id`, `login`, `password`) VALUES
	(1,'Александр','123'),
	(2,'Виталий','abc'),
	(3,'Григорий','yyy');
