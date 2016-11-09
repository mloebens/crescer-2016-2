-- Exercício 1

SELECT NomeEmpregado,
    DATEDIFF(MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) MesesTrabalho
FROM Empregado
WHERE DataAdmissao BETWEEN convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103)

-- Exercício 2
select top(1) WITH TIES count(1) as total, cargo 
from  Empregado 
group by cargo
order by total desc

-- Exercício 3
select count(1), uf
from cidade
group by uf

-- Exercício 4
select nome, uf
from cidade
group by nome, uf
having count(1) > 1

-- Exercício 5
select isnull(max(IDAssociado),0) + 1
from associado

-- Exercício 6
select NomeEmpregado,
    Salario, percentual_irrf =
    CASE
        WHEN salario <= 1164 THEN 0.0
        WHEN salario <= 2326 THEN 15.0
        ELSE 27.5
    END
from empregado

-- Exercício 7
select e.NomeEmpregado,
	g.NomeEmpregado as NomeGerente,
	df.NomeDepartamento as DepartamentoFuncionario,
	dg.NomeDepartamento as DepartamentoGerente
from empregado e
LEFT JOIN empregado g ON g.IDEmpregado = e.IDGerente
LEFT JOIN departamento df ON df.IDDepartamento = e.IDDepartamento
LEFT JOIN departamento dg ON dg.IDDepartamento = df.IDDepartamento

-- Exercício 8
SELECT *
INTO EmpregadoAux
FROM Empregado

UPDATE EmpregadoAux
SET salario = (salario*14.5)/100 + salario
where IDDepartamento in (select IDDepartamento from departamento where localizacao = 'SAO PAULO' )


-- Exercício 9
SELECT (sum(salario) - (select sum(salario) from empregado))
FROM empregadoaux


-- Exercício 10
select top 1 WITH TIES d.NomeDepartamento,
	max(e.salario) as MaiorSalario
from departamento d
INNER JOIN empregado e ON e.IDDepartamento = d.IDDepartamento
group by d.NomeDepartamento,e.salario
order by e.salario desc