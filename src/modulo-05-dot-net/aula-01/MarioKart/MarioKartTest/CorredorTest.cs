using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorRecebeJoaoNivelDeHabilidadeProfissional() 
        {
            var corredor = new Corredor("João", NivelDeHabilidade.Profissional);

            Assert.AreEqual("João", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.Profissional, corredor.NivelDeHabilidade);
        }
    }
}
