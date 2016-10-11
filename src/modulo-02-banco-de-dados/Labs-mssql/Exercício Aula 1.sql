-- 1

select * 
into CidadeAux
from Cidade;

-- 2
truncate table CidadeAux

insert into CidadeAux (IDCidade, Nome, UF)
	select IDCidade, Nome, UF from Cidade;

-- 3
create table Produto (
	IDProduto		bigint identity,
	NomeCurto		varchar(20) not null,
	NomeDescritivo	varchar(100) not null,
	DataCriacao		datetime default getDate() not null,
	LocalEstoque	varchar(50) not null,
	Quantidade		decimal(7,3) not null,
	Preco			decimal(7,2) not null
		constraint PK_Produto primary key (IDProduto)
);

-- 4

insert into produto(NomeCurto, NomeDescritivo, LocalEstoque, Quantidade, Preco) 
	values ('Televisão', 'Televisão SmartTv Samsung 50 polegadas.', 'Corredor B2', 4.0, 4000.99 );
insert into produto(NomeCurto, NomeDescritivo, LocalEstoque, Quantidade, Preco) 
	values ('Computador', 'Acer 14" Intel i5 2.2GHz 8GB mémoria ram, HD 500GB', 'Corredor C1', 2.0, 2300.32 );