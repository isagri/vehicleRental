CREATE DATABASE  IF NOT EXISTS  `vehiclerental` /*!40100 DEFAULT CHARACTER SET utf8 */;

use `vehiclerental`;

CREATE TABLE IF NOT EXISTS `car` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `brand` varchar(100) DEFAULT NULL,
 `model` varchar(45) DEFAULT NULL,
 `color` varchar(45) DEFAULT NULL,
 `plateNumber` varchar(45) DEFAULT NULL,
 `kilometerRate` float DEFAULT NULL,
 `horsePower` int DEFAULT NULL,
 `price` float DEFAULT NULL,

 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS `client` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `login` varchar(30) NOT NULL,
 `firstName` varchar(50) DEFAULT NULL,
 `lastName` varchar(50) DEFAULT NULL,
 `mail` varchar(100) DEFAULT NULL,
 `birthDate` date DEFAULT NULL,
 `licenceDate` date DEFAULT NULL,
 `licenceNumber` varchar(45) DEFAULT NULL,
 `isGuest` boolean DEFAULT NULL,

 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `id_car` int(11) NOT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `estimatedDistance` int DEFAULT NULL,
  `estimatedPrice` float DEFAULT NULL,
  `realDistance` int DEFAULT NULL,
  `realPrice` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_client_idx` (`id_client` ASC),
  CONSTRAINT `fk_id_client`
    FOREIGN KEY (`id_client`)
    REFERENCES `vehiclerental`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  INDEX `fk_id_car_idx` (`id_car` ASC),
  CONSTRAINT `fk_id_car`
    FOREIGN KEY (`id_car`)
    REFERENCES `vehiclerental`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into client 
(login, firstName, lastName, mail, birthDate, licenceDate, licenceNumber, isGuest) 
values
('isa','isabelle', 'grillet', 'isa@free.fr', '1968/06/25', '1986/09/01','1234567890', false);

insert into client 
(login, firstName, lastName, mail, birthDate, licenceDate, licenceNumber, isGuest) 
values
('jul','julien', 'fourdachon', 'jul@free.fr', '1980/01/01', '2000/09/01','123777888', false);

insert into car
(brand, model, color, plateNumber, kilometerRate, horsePower, price)
values
('Renault','clio','blue', 'AA 123 AA', 2.10, 6, 120.50);

insert into car
(brand, model, color, plateNumber, kilometerRate, horsePower, price)
values
('Peugeot','2008','noir', 'BB 456 BB', 3.00, 10, 230.80);

insert into car
(brand, model, color, plateNumber, kilometerRate, horsePower, price)
values
('Mercedes','Benz','noir', 'ZZ 789 ZZ', 10.00, 23, 520.00);
