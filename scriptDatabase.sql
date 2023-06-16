-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.27-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para faculdade
DROP DATABASE IF EXISTS `faculdade`;
CREATE DATABASE IF NOT EXISTS `faculdade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `faculdade`;

-- Copiando estrutura para tabela faculdade.alternativa
DROP TABLE IF EXISTS `alternativa`;
CREATE TABLE IF NOT EXISTS `alternativa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alternativa` varchar(255) NOT NULL DEFAULT '0',
  `isCorreta` varchar(50) NOT NULL DEFAULT '0',
  `id_pergunta` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_alternativa_pergunta` (`id_pergunta`),
  CONSTRAINT `FK_alternativa_pergunta` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela faculdade.alternativa: ~120 rows (aproximadamente)
INSERT IGNORE INTO `alternativa` (`id`, `alternativa`, `isCorreta`, `id_pergunta`) VALUES
	(1, 'a) Instanciacao', 'true', 1),
	(2, 'b) Iteracao', 'false', 1),
	(3, 'c) Polimorfismo', 'false', 1),
	(4, 'd) Encapsulamento', 'false', 1),
	(5, 'a) Reutilizacao de codigo', 'false', 2),
	(6, 'b) Ocultar detalhes de implementacao', 'true', 2),
	(7, 'c) Aumentar a eficiência do programa', 'false', 2),
	(8, 'd) Permitir a heranca multipla', 'false', 2),
	(9, 'a) Definir variaveis globais', 'false', 3),
	(10, 'b) Inicializar objetos da classe', 'true', 3),
	(11, 'c) Criar loops e iteracoes', 'false', 3),
	(12, 'd) Encapsular metodos', 'false', 3),
	(13, 'a) Funcional', 'true', 4),
	(14, 'b) Nao funcional', 'false', 4),
	(15, 'c) Historia de usuario', 'false', 4),
	(16, 'd) Premissa', 'false', 4),
	(17, 'a) sim/nao', 'false', 5),
	(18, 'b) bom/ruim', 'false', 5),
	(19, 'c) true/false', 'true', 5),
	(20, 'd) certo/errado', 'false', 5),
	(21, 'a) Fornecer uma melhor seguranca ao programa', 'false', 6),
	(22, 'b) Aumentar o tempo de execucao do codigo', 'false', 6),
	(23, 'c) Fornecer uma explicacao sobre o codigo ao programador', 'true', 6),
	(24, 'd) Fornecer uma boa aparência do codigo', 'false', 6),
	(25, 'a) Sequenciamento, Procedimentos, Bibliotecas e Heranca', 'false', 7),
	(26, 'b) Heranca, Polimorfismo, Classes e Objetos', 'false', 7),
	(27, 'c) Classes, Atributos, Metodos e Abstracao', 'false', 7),
	(28, 'd) Abstracao, Encapsulamento, Heranca e Polimorfismo', 'true', 7),
	(29, 'a) int', 'false', 8),
	(30, 'b) float', 'false', 8),
	(31, 'c) string', 'true', 8),
	(32, 'd) boolean', 'false', 8),
	(33, 'a) Uma representacao grafica da estrutura de uma classe e suas relacoes', 'false', 9),
	(34, 'b) Uma representacao grafica da interacao entre objetos ao longo do tempo', 'true', 9),
	(35, 'c) Um conjunto de instrucoes em codigo fonte', 'false', 9),
	(36, 'd) Uma lista de metodos de uma classe', 'false', 9),
	(37, 'a) Os metodos nunca podem ser escritos com mais de quatro parâmetros', 'false', 10),
	(38, 'b) Os metodos nao podem ser escritos com parâmetros', 'false', 10),
	(39, 'c) Os metodos podem ser escritos com qualquer numero de parâmetros', 'true', 10),
	(40, 'd) Os valores dos parâmetros nunca podem ser usados dentro do bloco de codigo do metodo', 'false', 10),
	(41, 'a) Se a primeira condicao for verdadeira, mas a segunda for falsa', 'false', 11),
	(42, 'b) Se tanto a primeira quanto a segunda condicao forem verdadeiras', 'true', 11),
	(43, 'c) Se tanto a primeira quanto a segunda condicao forem falsas', 'false', 11),
	(44, 'd) Se a primeira condicao for falsa, mas a segunda for verdadeira', 'false', 11),
	(45, 'a) Requisitos, Design, Teste, Desenvolvimento', 'false', 12),
	(46, 'b) Design, Desenvolvimento, Requisitos, Teste', 'false', 12),
	(47, 'c) Design, Requisitos, Desenvolvimento, Teste', 'false', 12),
	(48, 'd) Requisitos, Design, Desenvolvimento, Teste', 'true', 12),
	(49, 'a) Elas tornam o codigo mais flexível', 'true', 13),
	(50, 'b) As variaveis serao ignoradas pelo compilador', 'false', 13),
	(51, 'c) Elas dificultam a edicao do codigo', 'false', 13),
	(52, 'd) Pode ser que o valor atribuído a uma variavel nunca mude', 'false', 13),
	(53, 'a) &&', 'false', 14),
	(54, 'b) +', 'true', 14),
	(55, 'c) !', 'false', 14),
	(56, 'd) ||', 'false', 14),
	(57, 'a) O get normalmente nao aceita argumentos', 'true', 15),
	(58, 'b) O metodo get geralmente retorna um valor nulo', 'false', 15),
	(59, 'c) O get e um metodo privado', 'false', 15),
	(60, 'd) Você precisa ter um metodo set se quiser ter um metodo get', 'false', 15),
	(61, 'a) Geralmente, os atributos de uma classe sao publicos', 'false', 16),
	(62, 'b) Geralmente, os atributos de uma classe sao privados ', 'true', 16),
	(63, 'c) Os campos da classe marcados como privados ficam visíveis para qualquer classe', 'false', 16),
	(64, 'd) Atributos publicos sao mais seguros do que privados', 'false', 16),
	(65, 'a) Se a condicao do loop for falsa, as instrucoes nunca serao executadas', 'true', 17),
	(66, 'b) Se a condicao do loop for inicialmente verdadeira, as instrucoes nunca serao executadas', 'false', 17),
	(67, 'c) As instrucoes do loop while serao executadas apenas 5 vezes', 'false', 17),
	(68, 'd) As instrucoes do loop while serao executadas apenas 3 vezes', 'false', 17),
	(69, 'a) A existência de varios metodos em uma classe', 'false', 18),
	(70, 'b) A forma como os atributos de uma classe sao definidos', 'false', 18),
	(71, 'c) A capacidade de uma classe possuir características de outra classe base', 'true', 18),
	(72, 'd) A capacidade de uma classe criar multiplas instâncias', 'false', 18),
	(73, 'a) Composicao e uma forma de reutilizacao de codigo, enquanto heranca e uma forma de criar relacionamentos entre classes', 'false', 19),
	(74, 'b) Composicao permite que uma classe contenha instâncias de outras classes, enquanto heranca permite que uma classe herde características de outra classe', 'true', 19),
	(75, 'c) Composicao e um princípio de design, enquanto heranca e um conceito fundamental da programacao orientada a objetos', 'false', 19),
	(76, 'd) Composicao e um conceito fundamental da programacao orientada a objetos, enquanto heranca e um princípio de design', 'false', 19),
	(77, 'a) A capacidade de uma classe possuir varias instâncias de outra classe', 'false', 20),
	(78, 'b) A capacidade de uma classe substituir metodos da classe base sem alterar o comportamento do programa', 'false', 20),
	(79, 'c) A capacidade de uma classe se comunicar com outras classes', 'false', 20),
	(80, 'd) A capacidade de um objeto se comportar de maneiras diferentes com base no contexto em que e utilizado', 'true', 20),
	(81, 'a) A instância de uma classe', 'false', 21),
	(82, 'b) Uma variavel que armazena informacoes sobre um objeto', 'false', 21),
	(83, 'c) Uma variavel que sempre sera do tipo int', 'false', 21),
	(84, 'd) Um bloco de codigo que define o comportamento de uma classe', 'true', 21),
	(85, 'a) Abstracao', 'false', 22),
	(86, 'b) Encapsulamento', 'false', 22),
	(87, 'c) Polimorfismo', 'false', 22),
	(88, 'd) Heranca', 'true', 22),
	(89, 'a) A finalidade do metodo set e permitir que dados privados sejam modificados com seguranca', 'true', 23),
	(90, 'b) A finalidade de um metodo get e impedir que o valor de um campo privado seja retornado', 'false', 23),
	(91, 'c) A finalidade de um metodo set e modificar um campo publico', 'false', 23),
	(92, 'd) A finalidade de um metodo get e conceder a outras classes acesso a dados publicos', 'false', 23),
	(93, 'a) Avalia a condicao no fim do loop', 'true', 24),
	(94, 'b) Avalia a condicao no início do loop', 'false', 24),
	(95, 'c) O loop for e um exemplo de loop pos-teste', 'false', 24),
	(96, 'd) O loop while e um exemplo de loop pos-teste', 'false', 24),
	(97, 'a) =', 'true', 25),
	(98, 'b) +', 'false', 25),
	(99, 'c) :', 'false', 25),
	(100, 'd) /', 'false', 25),
	(101, 'a) long', 'true', 26),
	(102, 'b) short', 'false', 26),
	(103, 'c) int', 'false', 26),
	(104, 'd) byte', 'false', 26),
	(105, 'a) Criar uma documentacao tecnica detalhada do codigo fonte', 'false', 27),
	(106, 'b) Desenvolver interfaces de usuario atraentes e intuitivas', 'true', 27),
	(107, 'c) Identificar e representar visualmente as características e comportamentos do sistema', 'false', 27),
	(108, 'd) Testar e depurar o software em diferentes plataformas', 'false', 27),
	(109, 'a) Um diagrama que representa a estrutura hierarquica de um sistema', 'false', 28),
	(110, 'b) Um diagrama que mostra como os objetos interagem em uma determinada sequência de eventos', 'false', 28),
	(111, 'c) Um diagrama que ilustra as atividades e fluxos de controle em um processo de negocio', 'false', 28),
	(112, 'd) Um diagrama que descreve as interacoes entre os atores externos e o sistema em estudo', 'true', 28),
	(113, 'a) double', 'false', 29),
	(114, 'b) booleano', 'false', 29),
	(115, 'c) String', 'true', 29),
	(116, 'd) int', 'false', 29),
	(117, 'a) Um condicional que verifica uma condicao e executa um bloco de codigo repetidamente', 'false', 30),
	(118, 'b) Uma estrutura de controle que permite a execucao de um bloco de codigo varias vezes', 'true', 30),
	(119, 'c) Uma funcao que retorna um valor específico', 'false', 30),
	(120, 'd) Um operador matematico utilizado para realizar operacoes de soma', 'false', 30);

-- Copiando estrutura para tabela faculdade.pergunta
DROP TABLE IF EXISTS `pergunta`;
CREATE TABLE IF NOT EXISTS `pergunta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) DEFAULT NULL,
  `isUsada` enum('true','false') DEFAULT 'false',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela faculdade.pergunta: ~30 rows (aproximadamente)
INSERT IGNORE INTO `pergunta` (`id`, `pergunta`, `isUsada`) VALUES
	(1, 'Qual é o termo usado para descrever a criação de um novo objeto com base em uma classe existente?', 'false'),
	(2, 'Qual é o principal objetivo do encapsulamento na programação orientada a objetos?', 'false'),
	(3, 'Qual é a principal função de um construtor em uma classe?', 'false'),
	(4, 'Analise o seguinte requisito e informe, com base nos conceitos de Modelagem de Software, a sua classificação: "O sistema deve permitir o acesso de docentes e discentes"', 'false'),
	(5, 'Quais são os valores possíveis de um tipo de dados booliano em Java?', 'false'),
	(6, 'Qual é a finalidade de adicionar comentários ao código?', 'false'),
	(7, 'Os quatro pilares do Paradigma de Orientação a Objetos são:', 'false'),
	(8, 'Qual dos seguintes não é um tipo de dado primitivo em Java?', 'false'),
	(9, 'O que é um diagrama de sequência?', 'false'),
	(10, 'Qual das seguintes afirmações é verdadeira?', 'false'),
	(11, 'Em uma expressão booliana que usa o operador &&, o que faria com que essa expressão gerasse um resultado verdadeiro?', 'false'),
	(12, 'De acordo com conceitos da Modelagem de Software, assinale a ordem correta das etapas do Modelo Espiral de Desenvolvimento.', 'false'),
	(13, 'Qual afirmação é verdadeira sobre as variáveis?', 'false'),
	(14, 'No contexto da programação, qual opção não representa um operador lógico?', 'false'),
	(15, 'Qual afirmação é verdadeira a respeito do método "get"?', 'false'),
	(16, 'Indique a alternativa que descreve a informação correta a respeito dos atributos de uma classe.', 'false'),
	(17, 'Qual afirmação é verdadeira sobre o loop while?', 'false'),
	(18, 'O que é herança em programação orientada a objetos?', 'false'),
	(19, 'Qual é a principal diferença entre composição e herança na programação orientada a objetos?', 'false'),
	(20, 'O que é o polimorfismo na programação orientada a objetos?', 'true'),
	(21, 'O que é um método na programação orientada a objetos?', 'false'),
	(22, 'Qual dos seguintes princípios da programação orientada a objetos enfatiza a reutilização de código e a criação de hierarquias entre classes?', 'false'),
	(23, 'Qual afirmação a seguir é verdadeira?', 'false'),
	(24, 'Sobre um loop pós-teste, pode-se afirmar:', 'false'),
	(25, 'Qual é o símbolo utilizado para atribuição de valor em muitas linguagens de programação?', 'false'),
	(26, 'Qual dos seguintes tipos de dados é o maior?', 'false'),
	(27, 'Qual é o objetivo principal da Modelagem de Software?', 'false'),
	(28, 'O que é um diagrama de casos de uso na modelagem de software?', 'false'),
	(29, 'Qual tipo de dados tem um valor padrão nulo?', 'false'),
	(30, 'O que é um loop "for" na programação?', 'false');

-- Copiando estrutura para tabela faculdade.personagem
DROP TABLE IF EXISTS `personagem`;
CREATE TABLE IF NOT EXISTS `personagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `status` enum('true','false') NOT NULL DEFAULT 'false',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela faculdade.personagem: ~4 rows (aproximadamente)
INSERT IGNORE INTO `personagem` (`id`, `nome`, `status`) VALUES
	(1, 'Kaida', 'true'),
	(2, 'Solstice', 'true'),
	(3, 'Orion', 'false'),
	(4, 'Avalon', 'false');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
