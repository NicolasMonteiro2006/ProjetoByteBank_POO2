-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25/06/2025 às 02:52
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetobytebank`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta_corrente`
--

CREATE TABLE `conta_corrente` (
  `id_conta_corrente` bigint(20) UNSIGNED NOT NULL,
  `id_usuario` bigint(20) UNSIGNED DEFAULT NULL,
  `saldo` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta_corrente`
--

INSERT INTO `conta_corrente` (`id_conta_corrente`, `id_usuario`, `saldo`) VALUES
(3, 13, 145),
(4, 14, 47),
(5, 15, 191),
(6, 16, 0),
(7, 17, 20),
(8, 21, 75.30000000000001);

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta_salario`
--

CREATE TABLE `conta_salario` (
  `id_conta_salario` bigint(20) UNSIGNED NOT NULL,
  `id_usuario` bigint(20) UNSIGNED NOT NULL,
  `empresa_contratante` varchar(100) NOT NULL,
  `saldo` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta_salario`
--

INSERT INTO `conta_salario` (`id_conta_salario`, `id_usuario`, `empresa_contratante`, `saldo`) VALUES
(1, 18, 'ByteBank inc', 611),
(2, 19, 'TesteInc', 1),
(3, 20, 'TulioInc', 1000),
(4, 22, 'JosiInc', 1000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `historico_transacoes`
--

CREATE TABLE `historico_transacoes` (
  `id_transacao` bigint(20) UNSIGNED NOT NULL,
  `id_usuario_pagante` bigint(20) UNSIGNED DEFAULT NULL,
  `id_usuario_recebedor` bigint(20) UNSIGNED DEFAULT NULL,
  `tipo` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `data_transacao` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `historico_transacoes`
--

INSERT INTO `historico_transacoes` (`id_transacao`, `id_usuario_pagante`, `id_usuario_recebedor`, `tipo`, `valor`, `data_transacao`) VALUES
(1, 13, 15, 'Transferência', 33, '2025-06-22 09:58:30'),
(2, 15, 13, 'Transferência', 100, '2025-06-22 10:08:29'),
(3, 13, 14, 'Transferência', 12, '2025-06-22 10:10:52'),
(4, 13, 13, 'Saque', 44, '2025-06-23 00:15:50'),
(5, 13, 13, 'Saque', 1, '2025-06-23 00:23:20'),
(6, 13, 13, 'Saque', 2, '2025-06-23 00:30:18'),
(7, 13, 13, 'Saque', 2, '2025-06-23 00:53:10'),
(8, 13, 13, 'Depósito', 40, '2025-06-23 01:28:05'),
(9, 15, 15, 'Saque', 22, '2025-06-23 02:31:04'),
(10, 15, 15, 'Depósito', 89, '2025-06-23 02:31:26'),
(11, 15, 15, 'Depósito', 10, '2025-06-23 02:32:44'),
(12, 13, 13, 'Depósito', 100, '2025-06-24 03:40:46'),
(13, 17, 17, 'Depósito', 20, '2025-06-24 04:11:44'),
(14, 13, 15, 'Transferência', 20, '2025-06-24 05:18:06'),
(15, 13, 14, 'Transferência', 34, '2025-06-24 05:18:24'),
(16, 13, 14, 'Transferência', 1, '2025-06-24 05:18:44'),
(17, 13, 13, 'Depósito', 1000, '2025-06-24 19:53:58'),
(18, 13, 15, 'Transferência', 1, '2025-06-24 20:13:51'),
(19, 20, 13, 'Transferência', 1000, '2025-06-24 20:41:07'),
(20, 20, 13, 'Transferência', 1000, '2025-06-24 21:39:10'),
(21, 20, 13, 'Transferência', 100, '2025-06-24 21:43:46'),
(22, 13, 13, 'Saque', 3000, '2025-06-24 23:33:59'),
(23, 21, 21, 'Depósito', 123, '2025-06-25 00:36:30'),
(24, 21, 15, 'Transferência', 60, '2025-06-25 00:38:45');

-- --------------------------------------------------------

--
-- Estrutura para tabela `investimentos`
--

CREATE TABLE `investimentos` (
  `id_investimento` bigint(20) UNSIGNED NOT NULL,
  `id_usuario` bigint(20) UNSIGNED NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `data_inicio` date NOT NULL,
  `duracao_dias` int(11) NOT NULL,
  `status` varchar(20) DEFAULT 'ativo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamento_salario`
--

CREATE TABLE `pagamento_salario` (
  `id_pagamento` bigint(20) UNSIGNED NOT NULL,
  `empresa` varchar(100) NOT NULL,
  `id_usuario` bigint(20) UNSIGNED NOT NULL,
  `valor` double NOT NULL,
  `data_pagamento` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pagamento_salario`
--

INSERT INTO `pagamento_salario` (`id_pagamento`, `empresa`, `id_usuario`, `valor`, `data_pagamento`) VALUES
(1, 'TulioInc', 20, 1100, '2025-06-24 19:54:22'),
(2, 'TulioInc', 20, 1000, '2025-06-24 19:54:37'),
(3, 'ByteBank inc', 18, 500, '2025-06-24 20:11:47'),
(4, 'TesteInc', 19, 1, '2025-06-24 20:13:32'),
(5, 'ByteBank inc', 18, 11, '2025-06-24 20:19:22'),
(6, 'JosiInc', 22, 1000, '2025-06-25 00:41:29'),
(7, 'ByteBank inc', 18, 100, '2025-06-25 00:51:50');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) UNSIGNED NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `senha_hash` varchar(255) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nome`, `senha_hash`, `cpf`, `email`, `idade`) VALUES
(13, 'Nicolas', 'e7d80ffeefa212b7c5c55700e4f7193e', '123-456-789.10', 'nicolas@gmail.com', 22),
(14, 'Josi', '732002cec7aeb7987bde842b9e00ee3b', '123-456-789.10', 'josi@gmail.com', 39),
(15, 'Denis', '732002cec7aeb7987bde842b9e00ee3b', '123-456-789.10', 'denis@gmail.com', 40),
(16, 'Teste2', 'e50b9c3095381fc18cb5f982ad2bf3ec', '123-456-789.10', 'teste@teste.com', 22),
(17, 'Andrey', 'e8d95a51f3af4a3b134bf6bb680a213a', '123-456-789.10', 'andrey@gmail.com', 19),
(18, 'NicolasSalario', 'e7d80ffeefa212b7c5c55700e4f7193e', '123.456.789-10', 'nicolas@gmail.com', 19),
(19, 'TesteSalario', 'e8d95a51f3af4a3b134bf6bb680a213a', '123.456.789-10', 'testeSalario@gmail.com', 66),
(20, 'Tulio', 'e8d95a51f3af4a3b134bf6bb680a213a', '123.456.789-10', 'tulio@gmail.com', 44),
(21, 'JOSIMARA', '202cb962ac59075b964b07152d234b70', '123', '123', 39),
(22, 'JosiSalario', 'e8d95a51f3af4a3b134bf6bb680a213a', '123', 'josiSalario@teste.com', 39);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `conta_corrente`
--
ALTER TABLE `conta_corrente`
  ADD PRIMARY KEY (`id_conta_corrente`),
  ADD KEY `fk_usuario_conta` (`id_usuario`);

--
-- Índices de tabela `conta_salario`
--
ALTER TABLE `conta_salario`
  ADD PRIMARY KEY (`id_conta_salario`),
  ADD KEY `fk_usuario_salario` (`id_usuario`);

--
-- Índices de tabela `historico_transacoes`
--
ALTER TABLE `historico_transacoes`
  ADD PRIMARY KEY (`id_transacao`),
  ADD KEY `id_usuario_pagante` (`id_usuario_pagante`),
  ADD KEY `id_usuario_recebedor` (`id_usuario_recebedor`);

--
-- Índices de tabela `investimentos`
--
ALTER TABLE `investimentos`
  ADD PRIMARY KEY (`id_investimento`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices de tabela `pagamento_salario`
--
ALTER TABLE `pagamento_salario`
  ADD PRIMARY KEY (`id_pagamento`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `conta_corrente`
--
ALTER TABLE `conta_corrente`
  MODIFY `id_conta_corrente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `conta_salario`
--
ALTER TABLE `conta_salario`
  MODIFY `id_conta_salario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `historico_transacoes`
--
ALTER TABLE `historico_transacoes`
  MODIFY `id_transacao` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `investimentos`
--
ALTER TABLE `investimentos`
  MODIFY `id_investimento` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `pagamento_salario`
--
ALTER TABLE `pagamento_salario`
  MODIFY `id_pagamento` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `conta_corrente`
--
ALTER TABLE `conta_corrente`
  ADD CONSTRAINT `fk_usuario_conta` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `conta_salario`
--
ALTER TABLE `conta_salario`
  ADD CONSTRAINT `fk_usuario_salario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `historico_transacoes`
--
ALTER TABLE `historico_transacoes`
  ADD CONSTRAINT `historico_transacoes_ibfk_1` FOREIGN KEY (`id_usuario_pagante`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `historico_transacoes_ibfk_2` FOREIGN KEY (`id_usuario_recebedor`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `investimentos`
--
ALTER TABLE `investimentos`
  ADD CONSTRAINT `investimentos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `pagamento_salario`
--
ALTER TABLE `pagamento_salario`
  ADD CONSTRAINT `pagamento_salario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
