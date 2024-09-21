CREATE TABLE produto (
    produtoid BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome VARCHAR(255) NOT NULL,
    unidade SMALLINT,
    categoria_categoriaid BIGINT,
    fornecedor_fornecedorid BIGINT,
    CONSTRAINT pk_produto PRIMARY KEY (produtoid)
);

ALTER TABLE produto ADD CONSTRAINT FK_PRODUTO_ON_CATEGORIA_CATEGORIAID
FOREIGN KEY (categoria_categoriaid) REFERENCES categoria (categoriaid);

ALTER TABLE produto ADD CONSTRAINT FK_PRODUTO_ON_FORNECEDOR_FORNECEDORID
FOREIGN KEY (fornecedor_fornecedorid) REFERENCES fornecedor (fornecedorid);
