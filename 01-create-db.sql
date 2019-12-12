CREATE DATABASE  IF NOT EXISTS `ranking`;
USE `ranking`;

DROP TABLE IF EXISTS `challenge`;
DROP TABLE IF EXISTS `period`;
DROP TABLE IF EXISTS `player`;

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_of_birth` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `player` VALUES 
	(1,'Felipe','Nunes','felipenumes@ranking.com', '1979-01-17'),
	(2,'Rodrigo','Bloise','rbloise@ranking.com', '1979-02-17'),
	(3,'Flavia','Almeida','falmeida@ranking.com', '1979-03-17');
    
--
-- Table structure for table `period`
--

CREATE TABLE `period` (
  `period` varchar(7) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`period`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `period` VALUES
	('2019-10', 'CLOSED'),
    ('2019-11', 'OPEN');
    
--
-- Table structure for table `challenge`
--
    
CREATE TABLE `challenge` (
  `period` varchar(7) NOT NULL,
  `challenger` int NOT NULL,
  `challenged` int NOT NULL,
  `challenge_date` date,
  `game_date` date,
  `challenger_set` int DEFAULT 0,
  `challenged_set` int DEFAULT 0,
  `comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`period`, `challenger`, `challenged`),
  CONSTRAINT fk_pediod FOREIGN KEY (period)  REFERENCES period(period),
  CONSTRAINT fk_challenger FOREIGN KEY (challenger)  REFERENCES player(id),
  CONSTRAINT fk_challenged FOREIGN KEY (challenged)  REFERENCES player(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `challenge` 
	(`period`, `challenger`, `challenged`, `challenge_date`, `comments`) VALUES 
	('2019-11', 1, 2, '2019-11-17', 'Not escheduled'),
	('2019-11', 3, 1, '2019-11-10', 'Not escheduled');
