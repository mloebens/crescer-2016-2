SELECT NomeEmpregado
FROM Empregado
ORDER BY DataAdmissao

SELECT NomeEmpregado, 
	Salario*12 as SalarioAnual
FROM Empregado
WHERE Cargo = 'Atendente'
	OR (Salario*12) < 18500

SELECT IDCidade
FROM Cidade
WHERE Nome = 'Uberlândia'

SELECT IDCidade,
	Nome
FROM Cidade
WHERE UF = 'RS'