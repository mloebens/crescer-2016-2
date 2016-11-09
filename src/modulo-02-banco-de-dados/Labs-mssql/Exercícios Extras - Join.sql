-- Exercício 1
SELECT top 1 with ties cid.UF,
	cli.IDCliente, 
	cli.nome as NomeCliente, 
	count(1) as Pedidos
FROM Cliente cli
INNER JOIN Pedido ped ON ped.IDCliente = cli.IDCliente
INNER JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
WHERE ped.DataPedido >  convert(datetime, '20/07/2016',103)
	AND cid.UF = 'SP'
GROUP BY cli.IDCliente, cid.UF, cli.nome
ORDER BY Pedidos DESC


-- Exercício 2
select cli.idcliente, cli.nome, cid.nome, cid.uf
from cidade cid
inner join cliente cli on cli.idcidade = cid.idcidade
where exists (SELECT 1 
				FROM Cidade c
				where c.nome = cid.nome
				GROUP BY nome, uf
				HAVING count(1) > 1)


-- Exercício 3
SELECT min(idcidade), Nome,UF FROM Cidade
GROUP BY Nome, UF
HAVING count(1) > 1
ORDER BY Nome, UF


-- Exercício 4
SELECT TOP 30
		pro.IDProduto,
		pro.Nome,
		FORMAT((pro.PrecoVenda - pro.PrecoCusto ) * sum(pit.quantidade),'C', 'pt-br') as Total_lucro
FROM Produto pro
INNER JOIN PedidoItem pit ON pit.IDProduto = pro.IDProduto
WHERE EXISTS (SELECT 1
				FROM Pedido ped
				WHERE ped.IDPedido = pit.IDPedido AND
				ped.DataPedido BETWEEN convert(datetime, '01/01/2016', 103) AND 
										convert(datetime, '31/12/2016', 103)+.99999)
GROUP BY pro.IDProduto, pro.Nome, pro.PrecoCusto,pro.PrecoVenda
ORDER BY (pro.PrecoVenda - pro.PrecoCusto ) * sum(pit.quantidade) desc