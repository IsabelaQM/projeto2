create database dbAlunos;

use dbAlunos;

create table tb_aluno(
nome varchar(255),
dataNascimento date,
matricula varchar(15) primary key
);

insert into tb_aluno values ('Isabela','1995-03-10','12312312312');

insert into tb_aluno values ('Lucas','2000-08-06','1234567890');

insert into tb_aluno values ('Beatriz','1990-11-22','10020030012');

select nome,dataNascimento,matricula from tb_aluno;