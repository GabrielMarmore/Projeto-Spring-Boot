CREATE TABLE IF NOT EXISTS aluno (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);

CREATE TABLE IF NOT EXISTS professor (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);

CREATE TABLE IF NOT EXISTS funcionario (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);