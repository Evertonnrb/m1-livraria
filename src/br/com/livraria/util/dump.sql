﻿create table autor(
	id serial primary key not null,
	nome varchar(100),
	email varchar(100),
	site varchar(100)
);

create table livro (
		id serial primary key not null,
		nome varchar(100) not null,
		isbn varchar(15),
		data_publicacao date,
		autor_id int not null,
		qtd_paginas integer,
		genero varchar(100) not null,
		foreign key (autor_id) references autor(id)
);

insert into autor(nome,email,site) values ('Olavo de carvalho','olavotemrazao@gmail.com','htts://www.olavodecarvalho.com');
insert into autor (nome,email,site) values
					('Ayn Rand','randayn@hotmail.com','https://www.aynrand.com'),
					('Sthephen King','stking@stking.com','htts://www.sthevenking.com'),
					('Dan Brown','brown@dandawn.com','htt://www.browndan.com'); 

update autor set nome = 'O reyl' ,email = 'oreyl@editora.com' ,site = 'http://www.oreyl.com.br' where id = 2;
select * from autor;

insert into livro
	(nome,isbn,data_publicacao,autor_id,qtd_paginas,genero)
	values
	('Jardim das aflições','12-000001/12','2012-01-01',1,1200,'Fílosofia');

insert into livro (nome,isbn,data_publicacao,autor_id,qtd_paginas,genero)
			values
			/*nome	isbn	data	autor	qtd	genero*/
			('A revolta de atlas','2992/12','2001-10-22',3,399,'romance/drama'),
			('A nascente','0001/230','1988-10-19',3,400,'romance'),
			('Christine','0099/123','1987-02-11',3,230,'suspence'),
			('A noite dos mortos','09000/123','1988-01-01',3,403,'terrror/suspense'),
			('A torre negra','00990/100','2000-10-01',3,321,'drama/suspense'),
			('O simbolo perdido','0900/11','2002-01-01',5,456,'suspense'),
			('Ajax com Jquery','00009/200','2015-02-10',2,233,'tecnico'),
			('Orientação a objetos com Java','10000/00001','2017-10-10',2,1099,'tecnico');

select * from livro;

select * from livro
inner join autor
on livro.id = autor.id;

select livro.nome, livro.isbn, autor.nome
from livro
inner join autor
on livro.id = autor.id;
/*criando a tabela cliente*/
create table cliente(
		id serial primary key not null,
		nome varchar(100), 
		email varchar(100), 
		data_nascimento date,
		cep varchar(10),
		rua varchar(100),
		complemento varchar(100),
		numero varchar(10),
		cidade varchar(80),
		estado varchar(80)
);
select * from cliente;
SELECT * FROM cliente WHERE email like '%jaowasteros%';
select * from cliente where id = 1;

update cliente set nome = 'nome alterado', email = 'email alterado' where id = 5;
update cliente set email = 'novo email alteradooooo' where id = 5;

insert into cliente (nome,email,data_nascimento,cep,rua,numero,cidade,estado)
		values
		    ('Jão das neves','jaowasteros@gmail.com','1998-10-12','79062170','Manoel Garcia','123','CG','MS');

insert into cliente (nome,email,data_nascimento,cep,rua,numero,cidade,estado)
		values
		    ('Teste DelEte','teste delete','1998-10-12','79062170','Manoel Garcia','123','CG','MS');





