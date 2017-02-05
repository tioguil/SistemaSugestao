drop schema projeto;

CREATE SCHEMA projeto; 
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`departamento` (
  `id_departamento` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_departamento`),
  UNIQUE INDEX `id_departamento` (`id_departamento` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`login` (
  `id_login` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(50) NOT NULL UNIQUE,
  `senha` VARCHAR(50) NOT NULL,
  `data_Cadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nivel` CHAR(1) NOT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE INDEX `id_login` (`id_login` ASC),
  UNIQUE INDEX `login` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`avaliador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`avaliador` (
  `id_avaliador` INT(11) NOT NULL AUTO_INCREMENT,
  `login_id_login` INT(11) NOT NULL,
  `departamento_id_departamento` INT(11) NOT NULL,
  PRIMARY KEY (`id_avaliador`),
  INDEX `fk_avaliador_login1_idx` (`login_id_login` ASC),
  INDEX `fk_avaliador_departamento1_idx` (`departamento_id_departamento` ASC),
  CONSTRAINT `fk_avaliador_departamento1`
    FOREIGN KEY (`departamento_id_departamento`)
    REFERENCES `projeto`.`departamento` (`id_departamento`),
  CONSTRAINT `fk_avaliador_login1`
    FOREIGN KEY (`login_id_login`)
    REFERENCES `projeto`.`login` (`id_login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`cadastro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`cadastro` (
  `id_cadastro` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `nascimento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `cpf` CHAR(11) NOT NULL unique,
  `email` VARCHAR(60) NOT NULL,
  `atuacao` VARCHAR(20) NOT NULL,  
  `login_id_login` INT(11) NOT NULL,
  PRIMARY KEY (`id_cadastro`),
  UNIQUE INDEX `id_cadastro` (`id_cadastro` ASC),
  INDEX `fk_cadastro_login1_idx` (`login_id_login` ASC),
  CONSTRAINT `fk_cadastro_login1`
    FOREIGN KEY (`login_id_login`)
    REFERENCES `projeto`.`login` (`id_login`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`validacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`validacao` (
  `id_validacao` INT(11) NOT NULL AUTO_INCREMENT,
  `estado` CHAR(1) NOT NULL,
  `resposta` VARCHAR(1000) NULL DEFAULT NULL,
  `data` DATE,
  `avaliador_id_avaliador` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_validacao`),
  INDEX `fk_validacao_avaliador1_idx` (`avaliador_id_avaliador` ASC),
  CONSTRAINT `fk_validacao_avaliador1`
    FOREIGN KEY (`avaliador_id_avaliador`)
    REFERENCES `projeto`.`avaliador` (`id_avaliador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

describe validacao;

-- -----------------------------------------------------
-- Table `projeto`.`sugestao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`sugestao` (
  `id_sugestao` INT(11) NOT NULL AUTO_INCREMENT,
  `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sugestao` VARCHAR(1000) NOT NULL,
  `departamento_id_departamento` INT(11) NOT NULL,
  `validacao_id_validacao` INT(11) NOT NULL,
  `login_id_login` INT(11) NOT NULL,
  PRIMARY KEY (`id_sugestao`),
  UNIQUE INDEX `id_sugestao` (`id_sugestao` ASC),
  INDEX `fk_sugestao_departamento1_idx` (`departamento_id_departamento` ASC),
  INDEX `fk_sugestao_validacao2_idx` (`validacao_id_validacao` ASC),
  INDEX `fk_sugestao_login1_idx` (`login_id_login` ASC),
  CONSTRAINT `fk_sugestao_departamento1`
    FOREIGN KEY (`departamento_id_departamento`)
    REFERENCES `projeto`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sugestao_validacao2`
    FOREIGN KEY (`validacao_id_validacao`)
    REFERENCES `projeto`.`validacao` (`id_validacao`),
  CONSTRAINT `fk_sugestao_login1`
    FOREIGN KEY (`login_id_login`)
    REFERENCES `projeto`.`login` (`id_login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- SOMENTE EXECUTAR ESSA PARA CRIAR A OUTRA TABELA 

CREATE TABLE IF NOT EXISTS `projeto`.`gostei` (
  `idGostei` INT(11) NOT NULL AUTO_INCREMENT,
  `gostei` CHAR(1) NULL DEFAULT NULL,
  `login_id_login` INT(11) NOT NULL,
  `sugestao_id_sugestao` INT(11) NOT NULL,
  PRIMARY KEY (`idGostei`),
  INDEX `fk_gostei_login1_idx` (`login_id_login` ASC),
  INDEX `fk_gostei_sugestao1_idx` (`sugestao_id_sugestao` ASC),
  CONSTRAINT `fk_gostei_login1`
    FOREIGN KEY (`login_id_login`)
    REFERENCES `projeto`.`login` (`id_login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gostei_sugestao1`
    FOREIGN KEY (`sugestao_id_sugestao`)
    REFERENCES `projeto`.`sugestao` (`id_sugestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


insert into departamento values(
	1,'Financeiro'
);

insert into departamento values(
	2,'Pedagógica'

);
insert into departamento values(
	3,'Departamento Pessoal'

);
insert into departamento values(
	4,'Infra-Estrutura'

);
insert into departamento values(
	5,'Outros'

);

-- *******************************************************


/*select nome from cadastro where login_id_login = 3;

select * from sugestao;

update login set nivel = 1 where id_login = 2;

describe validacao;

select de.nome_departamento, su.data as dataSugestao, su.sugestao, va.resposta, va.data as dataResposta, va.estado
	from sugestao su
		inner join validacao va
         on su.validacao_id_validacao = va.id_validacao
			join departamento de
			 on su.departamento_id_departamento = de.id_departamento
				join login lo
                 on su.login_id_login = 1;
				 
*/
