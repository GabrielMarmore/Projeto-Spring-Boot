
CREATE TABLE IF NOT EXISTS aluno (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11),
     colegio varchar(6),
     email varchar(255)
);

CREATE TABLE IF NOT EXISTS professor (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11),
     colegio varchar(6),
     email varchar(255)
);

CREATE TABLE IF NOT EXISTS funcionario (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11),
     colegio varchar(6)
);

CREATE TABLE IF NOT EXISTS escola (
     id serial PRIMARY KEY,
     nome  varchar(50),
     codigo   varchar(6)
);