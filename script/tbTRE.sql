-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdTRE
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdTRE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdTRE` DEFAULT CHARACTER SET utf8 ;
USE `bdTRE` ;

-- -----------------------------------------------------
-- Table `bdTRE`.`TB_ZONAELEITORAL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdTRE`.`TB_ZONAELEITORAL` ;

CREATE TABLE IF NOT EXISTS `bdTRE`.`TB_ZONAELEITORAL` (
  `CD_ZONAELEITORAL` INT NOT NULL,
  `NR_ZONA` VARCHAR(45) NULL,
  PRIMARY KEY (`CD_ZONAELEITORAL`))
ENGINE = InnoDB;

/*!40000 ALTER TABLE `TB_ZONAELEITORAL` DISABLE KEYS */;
LOCK TABLES `TB_ZONAELEITORAL` WRITE;
INSERT INTO `TB_ZONAELEITORAL` VALUES (1,'279'),(2, '314');
UNLOCK TABLES;
/*!40000 ALTER TABLE `TB_ZONAELEITORAL` ENABLE KEYS */;

-- -----------------------------------------------------
-- Table `bdTRE`.`TB_SECAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdTRE`.`TB_SECAO` ;

CREATE TABLE IF NOT EXISTS `bdTRE`.`TB_SECAO` (
  `CD_SECAO` INT NOT NULL,
  `NM_ESCOLA` VARCHAR(45) NULL,
  `NM_SALA` VARCHAR(20) NULL,
  `BAIRRO` VARCHAR(45) NULL,
  `CD_ZONAELEITORAL` INT NOT NULL,
  PRIMARY KEY (`CD_SECAO`),
  INDEX `fk_TB_SECAO_TB_ZONAELEITORAL1_idx` (`CD_ZONAELEITORAL` ASC),
  CONSTRAINT `fk_TB_SECAO_TB_ZONAELEITORAL1`
    FOREIGN KEY (`CD_ZONAELEITORAL`)
    REFERENCES `bdTRE`.`TB_ZONAELEITORAL` (`CD_ZONAELEITORAL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/*!40000 ALTER TABLE `TB_SECAO` DISABLE KEYS */;
LOCK TABLES `TB_SECAO` WRITE;
INSERT INTO `TB_SECAO` VALUES (1,'Messias Pedreiro', '20', 'Cazeca', 1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `TB_SECAO` ENABLE KEYS */;

-- -----------------------------------------------------
-- Table `bdTRE`.`TB_ELEITOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdTRE`.`TB_ELEITOR` ;

CREATE TABLE IF NOT EXISTS `bdTRE`.`TB_ELEITOR` (
  `CD_ELEITOR` INT NOT NULL,
  `NM_ELEITOR` VARCHAR(45) NULL,
  `CPF_ELEITOR` VARCHAR(45) NULL,
  `NRO_TITULOELEITOR` VARCHAR(12) NULL,
  `LOG_ELEITOR` VARCHAR(45) NULL,
  `CEP_ELEITOR` VARCHAR(8) NULL,
  `CD_SECAO` INT NOT NULL,
  PRIMARY KEY (`CD_ELEITOR`, `CD_SECAO`),
  INDEX `fk_TB_ELEITOR_TB_SECAO1_idx` (`CD_SECAO` ASC),
  CONSTRAINT `fk_TB_ELEITOR_TB_SECAO1`
    FOREIGN KEY (`CD_SECAO`)
    REFERENCES `bdTRE`.`TB_SECAO` (`CD_SECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/*!40000 ALTER TABLE `TB_ELEITOR` DISABLE KEYS */;
LOCK TABLES `TB_ELEITOR` WRITE;
INSERT INTO `TB_ELEITOR` VALUES (1, 'Anna Carolina Novaes', '11559346604', '202520770230', 'Rua do Jardineiro, 627', '38413219', 1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `TB_ELEITOR` ENABLE KEYS */;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



use dbSeguranca;

insert into tb_sistema(nm_sistema,ds_url) 
values  ('Seguranca','http://localhost:8080/Seguranca'),
	   ('Sistema TRE','http://localhost:8080/PDS2-Trabalho01/');

insert into tb_usuario(ds_login,fl_ativo,ds_email,ds_senha)
values ('carloseduardo',1,'carloseduardodantas@iftm.edu.br','e4UXW0VQYOMjfpJfAjBTypUV6Ggqg8iwmRHHJKH4t18='),
('annacn',1,'annacn@iftm.edu.br','e4UXW0VQYOMjfpJfAjBTypUV6Ggqg8iwmRHHJKH4t18='),
       ('bruno',1,'bruno@iftm.edu.br','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
       
       -- carlos
       -- 123
       
insert into tb_role(nm_nome,cd_sistema)
values 
       ('SEG_admin', 1),
       ('SEG_cadastro',1),
       ('SEG_consulta',1),
       ('TRE_admin', 2),
       ('TRE_cadastro', 2),
       ('TRE_consulta', 2);
       
insert into tb_usuario_role(cd_role,ds_login)
values (1,'bruno'),
       (4,'annacn'),
       (3,'carloseduardo'),
       (6,'carloseduardo'); 
