-- 1

select * 
into CidadeAux
from Cidade;

-- 2
truncate table CidadeAux

select * 
into CidadeAux
from Cidade;

-- 3
create table Produto (
	IDProduto bigint identity,
	NomeCurto varchar(20) not null,
	NomeDescritivo varchar(100) not null,
	DataCriacao datetime not null,
	LocalEstoque varchar(50) not null,
	Quantidade int not null,
	Preco decimal(10,2) not null
		constraint PK_Produto primary key (IDProduto)
);

-- 4

insert into produto(NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco) 
	values ('Televisão', 'Televisão SmartTv Samsung 50 polegadas.', current_timestamp, 'Corredor B2', 4, 4000.99 );
insert into produto(NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco) 
	values ('Computador', 'Acer 14" Intel i5 2.2GHz 8GB mémoria ram, HD 500GB', current_timestamp, 'Corredor C1', 2, 2300.32 );