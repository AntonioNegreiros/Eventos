CREATE DATABASE eventojoinville;

CREATE TABLE `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idOrganizador` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  `data` int(11) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `vagas` int(11) DEFAULT NULL,
  `participante` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `local` (
  `IdDescricao` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) DEFAULT NULL,
  `Vagas` int(11) DEFAULT NULL,
  `Eventos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdDescricao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `notificacao` (
  `idNotificacao` int(11) NOT NULL AUTO_INCREMENT,
  `mensagem` varchar(45) DEFAULT NULL,
  `destinatario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idNotificacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `organizador` (
  `idOrganizador` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) DEFAULT NULL,
  `NotificacaoO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idOrganizador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `participante` (
  `idParticipante` int(11) NOT NULL AUTO_INCREMENT,
  `TelefoneParticipante` varchar(45) DEFAULT NULL,
  `NotificacaoP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idParticipante`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `pessoa` (
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci