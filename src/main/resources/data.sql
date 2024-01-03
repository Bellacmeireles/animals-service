-- Inserir Funcionário
INSERT INTO funcionario (nome, telefone, idade, data_contratacao) VALUES ('EU', '12997136489', 19, current_date);

-- Inserir Animal associado ao Funcionário (utilizando o ID do funcionário inserido acima)
INSERT INTO animal (nome_provisorio, idade_estimada, specie, raca, data_entrada, condicoes_chegada, funcionario_id, data_saida, data_adocao, data_obito, porte)
VALUES ('Toto', 2, 'cat', 'Malhado', current_date, 'Arisco', 1, current_date, current_date, current_date, 'P');
