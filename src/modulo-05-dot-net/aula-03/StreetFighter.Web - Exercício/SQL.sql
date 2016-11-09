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

CREATE TABLE Usuario
(
	IdUsuario			BIGINT IDENTITY,
	Nome				VARCHAR(80) NOT NULL,
	Senha				VARCHAR(255),
	constraint PK_Usuario primary key (IdUsuario)
)


INSERT INTO Personagem VALUES('Blanka','12/02/1966 00:00:00',192,96,'BR','Electric Thunder, Rolling Attack',1,'/Content/imagens/blanka.png')
INSERT INTO Usuario VALUES('joao','8283f6ae9d4a9747fff1c715672a0fc6')


SELECT idusuario, nome FROM Usuario WHERE nome = 'joao' AND senha = '8283f6ae9d4a9747fff1c715672a0fc6'