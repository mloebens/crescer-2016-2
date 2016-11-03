using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;
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
            var personagem = new Personagem("João", "São Leopoldo");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void SalvarPersonagemComId1DeveEditar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(1,"João", "São Leopoldo");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.EditarPersonagem(personagem))
                .MustHaveHappened();
        }
    }
}
