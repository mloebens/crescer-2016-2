CREATE TABLE Personagem
(
	IdPersonagem		BIGINT IDENTITY,
	Nome				VARCHAR(80) NOT NULL,
	Nascimento			Datetime NOT NULL,
	Altura				INT NOT NULL,
	Peso				DECIMAL(5,2) NOT NULL,
	Origem				VARCHAR(3) NOT NULL,
	GolpesEspeciais		VARCHAR(255) NOT NULL,
	PersonagemOculto	TINYINT,
	Imagem				VARCHAR(255),
	constraint PK_Personagem primary key (IdPersonagem)
)


INSERT INTO Personagem VALUES('Blanka','12/02/1966 00:00:00',192,96,'BR','Electric Thunder, Rolling Attack',1,'/Content/imagens/blanka.png')