using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void FogueteNivel1Bonus1()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(1);
            Assert.AreEqual(1, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel50Bonus2()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(2);
            Assert.AreEqual(2, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel5NegativoBonus2()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(2);
            Assert.AreEqual(2, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel2Bonus2()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(2);
            Assert.AreEqual(2, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel3Bonus3()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(3);
            Assert.AreEqual(3, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel4Bonus4()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(4);
            Assert.AreEqual(4, fogueteDePlutonio.BonusDeVelocidade);
        }

        [TestMethod]
        public void FogueteNivel5Bonus5()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(5);
            Assert.AreEqual(5, fogueteDePlutonio.BonusDeVelocidade);
        }
    }
}
