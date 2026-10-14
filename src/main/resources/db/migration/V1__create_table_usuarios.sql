-- 1. Criação da tabela tipo
CREATE TABLE tipo (
    id BIGSERIAL PRIMARY KEY,
    tipo VARCHAR(150) NOT NULL
);

-- 2. Inserção dos registros na tabela tipo
INSERT INTO tipo (tipo)
VALUES
    ('Administrador'),
    ('Gerente'),
    ('Garçom'),
    ('Caixa'),
    ('Cliente');

-- 3. Criação da tabela usuario
CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_id BIGINT REFERENCES tipo(id), -- Tipo ajustado para BIGINT e adicionada a vírgula
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);