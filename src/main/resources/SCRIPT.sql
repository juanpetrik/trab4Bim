DROP DATABASE IF EXISTS trab4BimOO;
CREATE DATABASE trab4BimOO;

/* Tabela de clientes */
DROP TABLE IF EXISTS clientes;
CREATE TABLE `clientes` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) DEFAULT NULL,
  `telefone` VARCHAR(20) DEFAULT NULL,
  `endereco` VARCHAR(100) DEFAULT NULL,
  `cidade` VARCHAR(100) DEFAULT NULL,
  `estado` CHAR(2) DEFAULT NULL,
  `email` VARCHAR(150) DEFAULT NULL,
  `genero` CHAR(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('1','JOAO FERNANDO','4599256859','ENDEREÇO DE TESTE','CASCAVEL','PR','EMAILDETESTE@GMAIL.COM','M');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('2','CAROLINE DA SILVA','4588859685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('3','DANIEL DA SILVA','4588859685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('4','PEDRO DA LUZ','4589849685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('5','MARCELLI RIBEIRO','4588823485','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('6','DANIELA DA SILVA','4588859685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('7','ANTONIA DA SILVA','4588859685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('8','PEDRINHA DA SILVA','4583459685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('9','JENIFER MARCELLE','4588859685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');
insert into `clientes` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `estado`, `email`, `genero`) values('10','JOAO DA SILVA','4588456685','RUA DE TESTE','CASCAVEL','PR','EMAILDETESTE@HOTMAIL.COM','F');


/* Tabela de usuarios */
DROP TABLE IF EXISTS usuarios;
CREATE TABLE `usuarios` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `idCliente` INT(10) DEFAULT NULL,
  `senha` VARCHAR(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/* Tabela de produtos */
DROP TABLE IF EXISTS produtos;
CREATE TABLE `produtos` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `codBarras` VARCHAR(15) DEFAULT NULL,
  `categoria` VARCHAR(50) DEFAULT NULL,
  `descricao` VARCHAR(100) DEFAULT NULL,
  `unidade` CHAR(3) NOT NULL,
  `custo` DECIMAL(10,2) NOT NULL,
  `margemLucro` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('1','7896026300889','Limpeza','SABÃO EM PÓ','CX','5.99','5');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('2','7895651561516','Frutas','MAÇA','UN','2.99','1');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('3','7893453453453','Frutas','UVA','KG','3.99','7');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('4','7895651654165','Frutas','PÊRA','KG','4.99','8');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('5','7896516165161','Frutas','BANANA','KG','1.49','9');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('6','7895615161516','Limpeza','AMACIANTE','UN','6.99','7');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('7','7896156161561','Limpeza','DETERGENTE','UN','1.29','3');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('8','7895165161651','Limpeza','VASSOURA','UN','10.45','10');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('9','7896219841519','Limpeza','MULTIUSO VEJA','UN','3.99','7');
insert into `produtos` (`id`, `codBarras`, `categoria`, `descricao`, `unidade`, `custo`, `margemLucro`) values('10','7898219822981','Limpeza','PALHA DE AÇO','UN','1.99','2');


/* Tabela de vendas (capa) */
DROP TABLE IF EXISTS vendas;
CREATE TABLE `vendas` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `idCliente` INT(10) DEFAULT NULL,
  `nomeCliente` VARCHAR(100) DEFAULT NULL,
  `vlrTotalVenda` DECIMAL(10,2) NOT NULL,
  `dtLancamento` DATE,
  `hrLancamento` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/* Tabela de itens da vendas */
DROP TABLE IF EXISTS itensvendas;
CREATE TABLE `itensvendas` (
  `idSeq` INT(10) NOT NULL AUTO_INCREMENT,
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `idVenda` INT(10) NOT NULL ,
  `codBarras` VARCHAR(50) DEFAULT NULL,
  `descricao` VARCHAR(100) DEFAULT NULL,
  `categoria` VARCHAR(50) DEFAULT NULL,
  `unidade` VARCHAR(50) DEFAULT NULL,
  `custo` DECIMAL(10,2) NOT NULL,
  `margemLucro` DECIMAL(10,2) NOT NULL,
  `qtde` INT(10) NOT NULL ,
  `vlrUnit` DECIMAL(10,2) NOT NULL,
  `subTotal` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`), 
  FOREIGN KEY (idVenda) REFERENCES vendas(id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


