CREATE TABLE categoria (
    categoriaid BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome VARCHAR(255) NOT NULL,
    unidade VARCHAR(255) NOT NULL,
    CONSTRAINT pk_categoria PRIMARY KEY (categoriaid)
);