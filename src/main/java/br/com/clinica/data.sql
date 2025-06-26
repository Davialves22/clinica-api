-- PERFIS
INSERT INTO perfil (id, nome)
SELECT 1, 'ADMIN' WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE id = 1);

INSERT INTO perfil (id, nome)
SELECT 2, 'MEDICO' WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE id = 2);

INSERT INTO perfil (id, nome)
SELECT 3, 'PACIENTE' WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE id = 3);

-- USUÁRIO (com perfil MEDICO)
-- Atenção: a senha abaixo é um hash BCrypt da senha "123456"
INSERT INTO usuarios (id, username, password)
SELECT 2, 'medico@clinica.com', '$2a$10$x2wgrZnWqhD7On9zOQeouOk8djGzGwlx8k9uMrqO0Dxzt9Cu9jq6S'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE id = 2);

-- ASSOCIAÇÃO DO USUÁRIO COM PERFIL DE MÉDICO
INSERT INTO usuarios_tem_perfis (usuario_id, perfil_id)
SELECT 2, 2
WHERE NOT EXISTS (
  SELECT 1 FROM usuarios_tem_perfis WHERE usuario_id = 2 AND perfil_id = 2
);

-- MÉDICO
INSERT INTO medicos (id, nome, crm, data_inscricao, usuario_id)
SELECT 1, 'Dr. João Silva', 'CRM123456', '2020-01-15', 2
WHERE NOT EXISTS (SELECT 1 FROM medicos WHERE id = 1);

-- Inserindo especialidades
INSERT INTO especialidades (id, nome) SELECT 1, 'Cardiologia' WHERE NOT EXISTS (SELECT 1 FROM especialidades WHERE id = 1);
INSERT INTO especialidades (id, nome) SELECT 2, 'Pediatria' WHERE NOT EXISTS (SELECT 1 FROM especialidades WHERE id = 2);

-- Associando o médico (id = 1) com as especialidades
INSERT INTO medico_especialidade (medico_id, especialidade_id)
SELECT 1, 1 WHERE NOT EXISTS (
  SELECT 1 FROM medico_especialidade WHERE medico_id = 1 AND especialidade_id = 1
);

INSERT INTO medico_especialidade (medico_id, especialidade_id)
SELECT 1, 2 WHERE NOT EXISTS (
  SELECT 1 FROM medico_especialidade WHERE medico_id = 1 AND especialidade_id = 2
);