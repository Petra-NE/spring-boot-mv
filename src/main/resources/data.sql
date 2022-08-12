INSERT INTO MEDICO_TABLE (crm, nome, especialidade) VALUES ('12345', 'Gilson', 'Cardiologista');
INSERT INTO MEDICO_TABLE (crm, nome, especialidade) VALUES ('12346', 'Bruno', 'Nutricionista');

INSERT INTO PACIENTE_TABLE (nome, cpf, idade, endereco, medico_crm) VALUES ('Karol', '09647578422', '31', '', 12345);
INSERT INTO PACIENTE_TABLE (nome, cpf, idade, endereco, medico_crm) VALUES ('Mathe', '04785214718', '20', 'rua são paulo', 12346);
INSERT INTO PACIENTE_TABLE (nome, cpf, idade, endereco, medico_crm) VALUES ('Marcos', '09647848422', '25', 'rua são paulo', 12345);
INSERT INTO PACIENTE_TABLE (nome, cpf, idade, endereco, medico_crm) VALUES ('Breno', '35847578422', '45', 'rua são paulo', 12346);
INSERT INTO PACIENTE_TABLE (nome, cpf, idade, endereco, medico_crm) VALUES ('Bruna', '23567578422', '37', 'rua são paulo', 12345);
