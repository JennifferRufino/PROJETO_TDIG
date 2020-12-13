-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Nov-2020 às 22:03
-- Versão do servidor: 10.4.10-MariaDB
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `controle_academico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE SCHEMA controle_academico;

use controle_academico;

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `matricula` varchar(12) COLLATE utf8_bin NOT NULL,
  `nome` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `fk_endereco_id` int(11) NOT NULL,
  `curso` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `matricula`, `nome`, `cpf`, `fk_endereco_id`, `curso`) VALUES
(1, '10', 'RODRIGO BRITO DO NASCIMENTO', '365.456.678-30', 1, 'Computacao'),
(2, '20', 'RAFAELA ALBANIZA OLIVEIRA SANTOS', '123.654.789-00', 2, 'Computacao'),
(3, '30', 'LUANDERLANDY FELLIPE DA SILVA', '365.456.678-30', 3, 'Computacao'),
(4, '40', 'THIAGO LOPES MOREIRA', '365.456.678-30', 4, 'Computacao'),
(5, '50', 'AGHATA SOPHIA DE ARAUJO TRUTA', '365.456.678-30', 5, 'Computacao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `rua` varchar(255) COLLATE utf8_bin NOT NULL,
  `numero` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `cep` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `cidade` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `estado` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pais` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `rua`, `numero`, `cep`, `cidade`, `estado`, `pais`) VALUES
(1, 'Rua Floriano Peixoto', '500', '58415-470', 'Campina Grande', 'Paraiba', 'Brasil'),
(2, 'Dantas', '74', '5841563', 'Campina Grande', 'Paraiba', 'Brasil'),
(3, 'Miguel Rodrigues', '74', '5841563', 'Campina Grande', 'Paraiba', 'Brasil'),
(4, 'Djanira Tavares', '510', '58454587', 'Campina Grande', 'Paraiba', 'Brasil'),
(5, 'Djanira Tavares', '58', '5841563', 'Campina Grande', 'Paraiba', 'Brasil'),
(6, 'Rodriguesssss', '74', '5841563', 'Campina Grande', 'Paraiba', 'Brasil'),
(7, 'Rodrigues', '74', '5841563', 'Campina Grande', 'Paraiba', 'Brasil'),
(9, 'Rua Doguinho', '500', '58415-470', 'Campina Grande', 'Paraiba', 'Brasil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `matricula` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `curso` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fk_enderecos_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id`, `matricula`, `nome`, `curso`, `fk_enderecos_id`) VALUES
(1, 201720, 'Demetrio Mestre', 'Computacao', 7),
(2, 201720, 'Suelio Matias', 'Matematica', 6),
(3, 182589, 'Ana Paula', 'Computacao', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `id` int(11) NOT NULL,
  `titulo_projeto` varchar(255) COLLATE utf8_bin NOT NULL,
  `area_projeto` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resumo` varchar(3000) COLLATE utf8_bin DEFAULT NULL,
  `palavra_chave1` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `palavra_chave2` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `palavra_chave3` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fk_professores_id` int(11) DEFAULT NULL,
  `fk_alunos_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`id`, `titulo_projeto`, `area_projeto`, `resumo`, `palavra_chave1`, `palavra_chave2`, `palavra_chave3`, `url`, `fk_professores_id`, `fk_alunos_id`) VALUES
(1, 'Projeto de Sistemas', 'Desenvolvimento Web', 'Analise e Projeto de sistemas para WEB', 'analise', 'palavra 2', 'projeto', 'http://uepb.edu.br', 1, 1),
(4, 'WEB II', 'Desenvolvimento Web', 'resumo desenvolvimento web', 'palavra 1', 'palavra 2', 'palavra 3', 'http://uepb.edu.br', 1, 1),
(5, 'Projeto de Sistemas', 'Desenvolvimento Web', 'Analise e Projeto de sistemas para WEB', 'analise', 'palavra 2', 'projeto', 'http://uepb.edu.br', 1, 1),
(7, 'Projeto de Sistemas', 'Desenvolvimento Web', 'Analise e Projeto de sistemas para WEB', 'analise', 'palavra 2', 'projeto', 'http://uepb.edu.br', 1, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_alunos_2` (`fk_endereco_id`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_professores_2` (`fk_enderecos_id`);

--
-- Índices para tabela `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_projetos_2` (`fk_professores_id`),
  ADD KEY `FK_projetos_3` (`fk_alunos_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `projeto`
--
ALTER TABLE `projeto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `FK_alunos_2` FOREIGN KEY (`fk_endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `FK_professores_2` FOREIGN KEY (`fk_enderecos_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `FK_projetos_2` FOREIGN KEY (`fk_professores_id`) REFERENCES `professor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_projetos_3` FOREIGN KEY (`fk_alunos_id`) REFERENCES `aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
