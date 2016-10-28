using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void UltraPackEquipamentoMotorABaseDeLavaBonus4()
        {
            var ultraPack = new UltraPack(new MotorABaseDeLava());
            Assert.AreEqual(4, ultraPack.BonusDeVelocidade);
        }

        [TestMethod]
        public void UltraPackEquipamentoFogueteDePlutonioNivel5Bonus6()
        {
            var ultraPack = new UltraPack(new FogueteDePlutonio(5));
            Assert.AreEqual(6, ultraPack.BonusDeVelocidade);
        }

        [TestMethod]
        public void UltraPackEquipamentoFogueteDePlutonioNivel1Bonus2()
        {
            var ultraPack = new UltraPack(new FogueteDePlutonio(1));
            Assert.AreEqual(2, ultraPack.BonusDeVelocidade);
        }
    }
}
