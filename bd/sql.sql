-- -----------------------------------------------------
-- Schema imperador
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `imperador` ;

-- -----------------------------------------------------
-- Schema imperador
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `imperador` DEFAULT CHARACTER SET utf8 ;
USE `imperador` ;

-- -----------------------------------------------------
-- Table `imperador`.`aniversariantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `imperador`.`aniversariantes` ;

CREATE TABLE IF NOT EXISTS `imperador`.`aniversariantes` (
  `aniv_id` INT NOT NULL AUTO_INCREMENT,
  `aniv_primeiro_nome` VARCHAR(255) NULL,
  `aniv_sobrenome` VARCHAR(255) NULL,
  `aniv_sexo` TINYINT(1) NULL,
  `aniv_data_aniversario` DATE NULL,
  `aniv_nome_da_mae` VARCHAR(255) NULL,
  `aniv_nome_do_pai` VARCHAR(255) NULL,
  `aniv_telefone` VARCHAR(45) NULL,
  `aniv_endereco` VARCHAR(255) NULL,
  `aniv_email` VARCHAR(255) NULL,
  `aniv_data_cadastro` DATETIME NULL,
  PRIMARY KEY (`aniv_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imperador`.`festas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `imperador`.`festas` ;

CREATE TABLE IF NOT EXISTS `imperador`.`festas` (
  `festa_id` INT NOT NULL AUTO_INCREMENT,
  `festa_aniv_id` INT NOT NULL,
  `festa_datetime` DATETIME NULL,
  `festa_data_cadastro` DATETIME NULL,
  PRIMARY KEY (`festa_id`),
  INDEX `fk_aniv_id_idx` (`festa_aniv_id` ASC),
  CONSTRAINT `fk_aniv_id`
    FOREIGN KEY (`festa_aniv_id`)
    REFERENCES `imperador`.`aniversariantes` (`aniv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `imperador`.`aniversariantes` VALUES (0,'João','Augusto',1,'2010-03-01','Cláudia Pereira','Mario Augusto','22122212','Rua Olegário','claudia@test.com',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2012-04-03 18:00',now());
INSERT INTO `imperador`.`aniversariantes` VALUES (0,'Maria','Linhares',1,'2010-03-01','Roberta Souza','Mario Augusto','22122212','Rua Olegário','claudia@test.com',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2012-04-03 10:00',now());
INSERT INTO `imperador`.`aniversariantes` VALUES (0,'José','Augusto',1,'2010-03-01','Cláudia Pereira','Mario Augusto','22122212','Rua Olegário','claudia@test.com',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2016-01-02 09:00',now());
INSERT INTO `imperador`.`aniversariantes` VALUES (0,'Carlos','Martinho',1,'2010-03-01','Cláudia Pereira','Mario Augusto','22122212','Rua Olegário','claudia@test.com',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2014-04-02 15:00',now());
INSERT INTO `imperador`.`aniversariantes` VALUES (0,'Carla','Pereira',1,'2010-03-01','Cláudia Pereira','Mario Augusto','22122212','Rua Olegário','claudia@test.com',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,5,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,4,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,3,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,2,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());
INSERT INTO `imperador`.`festas` VALUES (0,1,'2013-02-01 18:00',now());

