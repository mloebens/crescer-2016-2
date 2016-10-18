-- Exercício 1
SELECT count(1) 
FROM pedido
WHERE MONTH(datapedido) = 9
	AND YEAR(datapedido) = 2016

-- Exercício 2
SELECT p.Nome
FROM produto p
INNER JOIN ProdutoMaterial pm ON pm.IDProduto = p.IDProduto
INNER JOIN Material m ON m.IDMaterial = pm.IDMaterial
WHERE m.IDMaterial = 15836

-- Exercício 3
SELECT Nome
FROM Cliente
WHERE UPPER(Nome) like '%LTDA%'
	OR UPPER(RazaoSocial) like '%LTDA%'

-- Exercício 4
INSERT INTO produto(nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES('Galocha Maragato', GETDATE(), 33.67, 77.95, 'A')

-- Exercício 5
SELECT distinct Nome
FROM Produto
WHERE IDProduto not in (select IDProduto from PedidoItem)

-- Exercício 6
select MenosClientes.UF as MenosClientes,
	MaisClientes.UF as MaisClientes
from
	(select top 1 count(1) as QuantidadeCliente,
				cid.UF
	From cidade cid
	INNER JOIN cliente cli ON cli.IDCidade = cid.IDCidade
	group by uf
	order by QuantidadeCliente asc) as MenosClientes,
	(select top 1 count(1) as QuantidadeCliente,
				cid.UF
	From cidade cid
	INNER JOIN cliente cli ON cli.IDCidade = cid.IDCidade
	group by uf
	order by QuantidadeCliente desc) as MaisClientes


-- Exercício 7
SELECT ped.IDPedido, ped.DataEntrega, ped.ValorPedido, pi.Quantidade, cli.Nome
FROM PedidoItem pi
INNER JOIN pedido ped ON pi.IDPedido = ped.IDPedido
INNER JOIN produto pro ON pro.IDProduto = pi.IDProduto
INNER JOIN ProdutoMaterial pm ON pm.IDProduto = pro.IDProduto
INNER JOIN cliente cli ON cli.IDCliente = ped.IDCliente
WHERE pm.IDMaterial in (14650, 15703, 15836, 16003, 16604, 17226)
	AND YEAR(ped.DataEntrega) = 2016
	AND MONTH(ped.DataEntrega) = 10

-- Exercício 8
SELECT *
FROM Produto
WHERE IDProduto not in (select IDProduto from ProdutoMaterial)

-- Exercício 9
SELECT TOP 1 with ties count(1) as QuantidadeNomesIguais, listaNomes.PrimeiroNome
FROM (SELECT SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1) as PrimeiroNome
	FROM Cliente
	) listaNomes
group by listaNomes.PrimeiroNome
order by QuantidadeNomesIguais desc


-- Exercício 10
UPDATE p
SET p.situacao='F'
from Produto p
INNER JOIN ProdutoMaterial pm ON pm.IDProduto = p.IDProduto
INNER JOIN Material m ON m.IDMaterial = pm.IDMaterial
where m.IDMaterial IN (14650,15703,15836,16003,16604,17226)

UPDATE p
SET p.situacao='Q'
from Produto p
INNER JOIN PedidoItem pit ON pit.IDProduto = p.IDProduto
INNER JOIN Pedido ped ON ped.IDPedido = pit.IDPedido
where p.IDProduto not in
	(select pm.IDProduto
		FROM ProdutoMaterial pm
		INNER JOIN Material m ON m.IDMaterial = pm.IDMaterial
		where m.IDMaterial IN (14650,15703,15836,16003,16604,17226)
		)
	AND DATEDIFF(day, ped.DataPedido, GETDATE()) <= 60

UPDATE p
SET p.situacao='A'
FROM Produto p
WHERE p.IDProduto not in (select p.IDProduto
							from Produto p
							INNER JOIN PedidoItem pit ON pit.IDProduto = p.IDProduto
							INNER JOIN Pedido ped ON ped.IDPedido = pit.IDPedido
							where p.IDProduto not in
								(select pm.IDProduto
									FROM ProdutoMaterial pm
									INNER JOIN Material m ON m.IDMaterial = pm.IDMaterial
									where m.IDMaterial IN (14650,15703,15836,16003,16604,17226)
									)
								AND DATEDIFF(day, ped.DataPedido, GETDATE()) <= 60
								)
		AND p.IDProduto not in (select pm.IDProduto
									FROM ProdutoMaterial pm
									INNER JOIN Material m ON m.IDMaterial = pm.IDMaterial
									where m.IDMaterial IN (14650,15703,15836,16003,16604,17226)
									)
