using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {

    [TestMethod]
    public void SalvarPersonagemComId0DeveInscluir()
    {

          var repositorioFake = A.Fake<IPersonagemRepositorio>();

        var aplicativo = new PersonagemAplicativo(repositorioFake);
        var personagem = new Personagem("Blanka", 
                new DateTime(1966,2,12), 
                192,
                96,
                "Brasil(lugar de nascença é provável como sendo Tailândia)",
                "Electric Thunder, Rolling Attack",
                false,
                @"/Content/imagens/blanka.png");

        aplicativo.Salvar(personagem);

        A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
            .MustHaveHappened();
             }

        [TestMethod]
        public void SalvarPersonagemComId1DeveEditar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(1,
                "Blanka",
                new DateTime(1966, 2, 12),
                192,
                96,
                "Brasil(lugar de nascença é provável como sendo Tailândia)",
                "Electric Thunder, Rolling Attack",
                false,
                @"/Content/imagens/blanka.png");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.EditarPersonagem(personagem))
                .MustHaveHappened();
        }

     
    }
}
