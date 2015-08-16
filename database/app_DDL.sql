-- MySQL Script generated by MySQL Workbench
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema app
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `app` ;
CREATE SCHEMA IF NOT EXISTS `app` DEFAULT CHARACTER SET utf8 ;
USE `app` ;

-- -----------------------------------------------------
-- Table `app`.`seg_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`seg_usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tx_nome_completo` VARCHAR(100) NULL,
  `tx_email` VARCHAR(100) NULL,
  `tx_senha` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`cad_unidade_medida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`cad_unidade_medida` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tx_descricao` VARCHAR(100) NULL,
  `tx_simbolo` VARCHAR(5) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`cad_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`cad_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_unidade_medida` BIGINT NULL,
  `id_ultimo_usuario` BIGINT NULL,
  `tx_descricao` VARCHAR(100) NULL,
  `dc_valor` DOUBLE(15,2) NULL,
  `bl_imagem` LONGBLOB NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cad_unidade_medida_cad_item_id_unidade_medida`
    FOREIGN KEY (`id_unidade_medida`)
    REFERENCES `app`.`cad_unidade_medida` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seg_usuario_cad_item_id_ultimo_usuario`
    FOREIGN KEY (`id_ultimo_usuario`)
    REFERENCES `app`.`seg_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`com_lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`com_lista` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_proprietario` BIGINT NULL,
  `id_ultimo_usuario` BIGINT NULL,
  `tx_descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_seg_usario_com_lista_id_proprietario`
    FOREIGN KEY (`id_proprietario`)
    REFERENCES `app`.`seg_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seg_usuario_com_lista_id_ultimo_usuario`
    FOREIGN KEY (`id_ultimo_usuario`)
    REFERENCES `app`.`seg_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`com_lista_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`com_lista_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_lista` BIGINT NULL,
  `id_item` BIGINT NULL,
  `id_ultimo_usuario` BIGINT NULL,
  `dc_quantidade` DOUBLE(15,4) NULL,
  `bo_comprado` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_com_lista_com_lista_item_id_lista`
    FOREIGN KEY (`id_lista`)
    REFERENCES `app`.`com_lista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cad_item_com_lista_item_id_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `app`.`cad_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seg_usuario_com_lista_item_id_ultimo_usuario`
    FOREIGN KEY (`id_ultimo_usuario`)
    REFERENCES `app`.`seg_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`audit_com_lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`audit_com_lista` (
  `dt_operacao` DATETIME NULL,
  `tp_operacao` VARCHAR(1) NULL,
  `id` BIGINT NULL,
  `id_proprietario_ant` BIGINT NULL,
  `id_proprietario_atual` BIGINT NULL,
  `id_ultimo_usuario_ant` BIGINT NULL,
  `id_ultimo_usuario_atual` BIGINT NULL,
  `tx_descricao_ant` VARCHAR(100) NULL,
  `tx_descricao_atual` VARCHAR(100) NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`audit_com_lista_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`audit_com_lista_item` (
  `dt_operacao` DATETIME NULL,
  `tp_operacao` VARCHAR(1) NULL,
  `id` BIGINT NULL,
  `id_lista_ant` BIGINT NULL,
  `id_lista_atual` BIGINT NULL,
  `id_item_ant` BIGINT NULL,
  `id_item_atual` BIGINT NULL,
  `id_ultimo_usuario_ant` BIGINT NULL,
  `id_ultimo_usuario_atual` BIGINT NULL,
  `dc_quantidade_ant` DOUBLE(15,4) NULL,
  `dc_quantidade_atual` DOUBLE(15,4) NULL,
  `bo_comprado_ant` TINYINT(1) NULL,
  `bo_comprado_atual` TINYINT(1) NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app`.`audit_cad_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app`.`audit_cad_item` (
  `dt_operacao` DATETIME NULL,
  `tp_operacao` VARCHAR(1) NULL,
  `id` BIGINT NULL,
  `id_unidade_medida_ant` BIGINT NULL,
  `id_unidade_medida_atual` BIGINT NULL,
  `id_ultimo_usuario_ant` BIGINT NULL,
  `id_ultimo_usuario_atual` BIGINT NULL,
  `tx_descricao_ant` VARCHAR(100) NULL,
  `tx_descricao_atual` VARCHAR(100) NULL,
  `dc_valor_ant` DOUBLE(15,2) NULL,
  `dc_valor_atual` DOUBLE(15,2) NULL,
  `bl_imagem_ant` LONGBLOB NULL,
  `bl_imagem_atual` LONGBLOB NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `app`;

DELIMITER $$
USE `app`$$
CREATE TRIGGER `tai_cad_item` AFTER INSERT ON `cad_item` FOR EACH ROW
BEGIN

INSERT INTO audit_cad_item(dt_operacao, tp_operacao, id, id_unidade_medida_ant, id_unidade_medida_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual, dc_valor_ant, dc_valor_atual, bl_imagem_ant, bl_imagem_atual)
values(now(), 'I', new.id, null, new.id_unidade_medida, null, new.id_ultimo_usuario, null, new.tx_descricao, null, new.dc_valor, null, new.bl_imagem);

END;$$

USE `app`$$
CREATE TRIGGER `tau_cad_item` AFTER UPDATE ON `cad_item` FOR EACH ROW
BEGIN

INSERT INTO audit_cad_item(dt_operacao, tp_operacao, id, id_unidade_medida_ant, id_unidade_medida_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual, dc_valor_ant, dc_valor_atual, bl_imagem_ant, bl_imagem_atual)
values(now(), 'U', new.id, old.id_unidade_medida, new.id_unidade_medida, old.id_ultimo_usuario, new.id_ultimo_usuario, old.tx_descricao, new.tx_descricao, old.dc_valor, new.dc_valor, old.bl_imagem, new.bl_imagem);

END;$$

USE `app`$$
CREATE TRIGGER `tad_cad_item` AFTER DELETE ON `cad_item` FOR EACH ROW
BEGIN

INSERT INTO audit_cad_item(dt_operacao, tp_operacao, id, id_unidade_medida_ant, id_unidade_medida_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual, dc_valor_ant, dc_valor_atual, bl_imagem_ant, bl_imagem_atual)
values(now(), 'D', old.id, old.id_unidade_medida, null, old.id_ultimo_usuario, null, old.tx_descricao, null, old.dc_valor, null, old.bl_imagem, null);

END;$$

USE `app`$$
CREATE TRIGGER `tau_com_lista` AFTER UPDATE ON `com_lista` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista(dt_operacao, tp_operacao, id, id_proprietario_ant, id_proprietario_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual)
values(now(), 'U', new.id, old.id_proprietario, new.id_proprietario, old.id_ultimo_usuario, new.id_ultimo_usuario, old.tx_descricao, new.tx_descricao);

END;$$

USE `app`$$
CREATE TRIGGER `tai_com_lista` AFTER INSERT ON `com_lista` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista(dt_operacao, tp_operacao, id, id_proprietario_ant, id_proprietario_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual)
values(now(), 'I', new.id, null, new.id_proprietario, null, new.id_ultimo_usuario, null, new.tx_descricao);

END;$$

USE `app`$$
CREATE TRIGGER `tad_com_lista` AFTER DELETE ON `com_lista` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista(dt_operacao, tp_operacao, id, id_proprietario_ant, id_proprietario_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual, tx_descricao_ant, tx_descricao_atual)
values(now(), 'D', old.id, old.id_proprietario, null, old.id_ultimo_usuario, null, old.tx_descricao, null);

END;$$

USE `app`$$
CREATE TRIGGER `tai_com_lista_item` AFTER INSERT ON `com_lista_item` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista_item(dt_operacao, tp_operacao, id, id_lista_ant, id_lista_atual, id_item_ant, id_item_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual )
values(now(), 'I', new.id, null, new.id_lista, null, new.id_item, null, new.id_ultimo_usuario);

END;$$

USE `app`$$
CREATE TRIGGER `tau_com_lista_item` AFTER UPDATE ON `com_lista_item` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista_item(dt_operacao, tp_operacao, id, id_lista_ant, id_lista_atual, id_item_ant, id_item_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual )
values(now(), 'U', new.id, old.id_lista, new.id_lista, old.id_item, new.id_item, old.id_ultimo_usuario, new.id_ultimo_usuario);

END;$$

USE `app`$$
CREATE TRIGGER `tad_com_lista_item` AFTER DELETE ON `com_lista_item` FOR EACH ROW
BEGIN

INSERT INTO audit_com_lista_item(dt_operacao, tp_operacao, id, id_lista_ant, id_lista_atual, id_item_ant, id_item_atual, id_ultimo_usuario_ant, id_ultimo_usuario_atual )
values(now(), 'D', old.id, old.id_lista, null, old.id_item, null, old.id_ultimo_usuario, null);

END;$$


DELIMITER ;