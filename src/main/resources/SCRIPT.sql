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
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `idVenda` INT(10) NOT NULL ,
  `categoria` VARCHAR(50) DEFAULT NULL,
  `descricao` VARCHAR(100) DEFAULT NULL,
  `vlrProduto` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`), 
  FOREIGN KEY (idVenda) REFERENCES vendas(id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


