CREATE TABLE setor (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

INSERT INTO setor (nome) VALUES
    ("Bar"),
    ("Cozinha"),
    ("Salao"),
    ("Caixa"),
    ("Estoque");

CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    preco DECIMAL(10, 2),
    unidade_medida VARCHAR(20) NOT NULL,
    tipo_produto VARCHAR(30) NOT NULL DEFAULT 'SIMPLES',
    disponivel_venda BOOLEAN NOT NULL DEFAULT TRUE,
    setor_id BIGINT REFERENCES setor(id) ON DELETE SET NULL,
    produto_pai_id BIGINT REFERENCES produto(id) ON DELETE SET NULL,
    quantidade_fator DECIMAL(10, 3),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO produto (nome, preco, unidade_medida, tipo_produto, disponivel_venda, setor_id)
VALUES ('Coca-Cola 350ml', 7.00, 'UN', 'SIMPLES', TRUE, 1);

INSERT INTO produto (nome, preco, unidade_medida, tipo_produto, disponivel_venda, setor_id)
VALUES ('Peça Presunto Cozido Sadia 5kg', NULL, 'KG', 'PORCIONAVEL', FALSE, 3)
    RETURNING id;

INSERT INTO produto (nome, preco, unidade_medida, tipo_produto, disponivel_venda, setor_id, produto_pai_id, quantidade_fator)
VALUES ('Presunto Fatiado (100g)', 6.50, 'G', 'PORCIONADO', TRUE, 3, 2, 0.100);