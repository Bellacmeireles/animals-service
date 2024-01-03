CREATE TABLE funcionario (
   id INT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   telefone VARCHAR(255) NOT NULL,
   idade INT NOT NULL,
   data_contratacao date NOT NULL,
   data_saida date NULL,
   CONSTRAINT pk_funcionario PRIMARY KEY (id)
);

CREATE TABLE animal (
  id INT AUTO_INCREMENT NOT NULL,
  nome_provisorio VARCHAR(255) NOT NULL,
  idade_estimada INT NOT NULL,
  specie VARCHAR(255) NOT NULL,
  raca VARCHAR(255) NOT NULL,
  data_entrada date NOT NULL,
  data_saida date NULL,
  data_adocao date NULL,
  condicoes_chegada VARCHAR(255) NOT NULL,
  funcionario_id INT NOT NULL,
  data_obito date,
  porte VARCHAR(255) NULL,
  CONSTRAINT pk_animal PRIMARY KEY (id),
  CONSTRAINT FK_ANIMAL_ON_FUNCIONARIO FOREIGN KEY (funcionario_id) REFERENCES funcionario (id)
);
