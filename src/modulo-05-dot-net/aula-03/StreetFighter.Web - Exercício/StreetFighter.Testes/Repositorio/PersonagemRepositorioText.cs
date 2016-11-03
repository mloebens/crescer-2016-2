using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Repositorio;
using System.Collections.Generic;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Repositorio
{
    [TestClass]
    public class PersonagemRepositorioText
    {
        [TestMethod]
        public void TestMethod1()
        {

                    [TestMethod]
        public void ListarPersonagensPorNomeBlanka()
        {
            var pr = new PersonagemRepositorio();
            List<Personagem> personagens = pr.ListarPersonagens("Blanka");

            Assert.AreEqual(personagens[0].Id, 1);
            Assert.AreEqual(personagens[0].Nome, "Blanka");
        }

        [TestMethod]
        public void ListarPersonagensPorNomeBalrog()
        {
            var pr = new PersonagemRepositorio();
            List<Personagem> personagens = pr.ListarPersonagens("Balrog");

            Assert.AreEqual(personagens[0].Id, 2);
            Assert.AreEqual(personagens[0].Nome, "Balrog");
        }

        [TestMethod]
        public void ListarPersonagensPorNomeGokuENaoEncontrar()
        {
            var pr = new PersonagemRepositorio();
            List<Personagem> personagens = pr.ListarPersonagens("Goku");

            Assert.AreEqual(personagens.Count, 0);

        }

        [TestMethod]
        public void ListarPersonagensSemFiltroVoltaTodos()
        {
            var pr = new PersonagemRepositorio();
            List<Personagem> personagens = pr.ListarPersonagens();

            Assert.AreEqual(personagens.Count, 2);
            Assert.AreEqual(personagens[0].Nome, "Blanka");
            Assert.AreEqual(personagens[1].Nome, "Balrog");

        }

    }
    }
}
