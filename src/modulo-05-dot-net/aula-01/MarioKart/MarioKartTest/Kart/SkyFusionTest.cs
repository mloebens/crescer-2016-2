using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class SkyFusionTest
    {
        [TestMethod]
        public void KartSkyFusionCorredorNoobSemEquipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new SkyFusion(corredor);

            Assert.AreEqual(0, kart.Equipamentos.Count);
        }

        [TestMethod]
        public void KartSkyFusionCorredorNoobCom1Equipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new SkyFusion(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(motor, kart.Equipamentos[0]);
        }

        [TestMethod]
        public void KartSkyFusionCorredorNoobCom2Equipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new SkyFusion(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
        }

        [TestMethod]
        public void KartSkyFusionCorredorNoob6DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new SkyFusion(corredor);

            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void KartSkyFusionCorredorMedianoComPenusDeCouroDeDragaoTem10DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new SkyFusion(corredor);
            kart.Equipar(new PneusDeCouroDeDragao());

            Assert.AreEqual(10, kart.Velocidade);
        }
        [TestMethod]
        public void KartSkyFusionCorredorProfissionalCom2EquipamentosTem16DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(corredor);
            kart.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(new MotorABaseDeLava());

            Assert.AreEqual(16, kart.Velocidade);
        }

        [TestMethod]
        public void EquipamentoSkyFusionCorredorNoobTem2DeBonusDeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new SkyFusion(corredor);
            var equipamentoSkyFusion = new SkyFusion(corredor);

            kart.Equipar(equipamentoSkyFusion);


            Assert.AreEqual(0, equipamentoSkyFusion.Equipamentos.Count);
            Assert.AreEqual(1, equipamentoSkyFusion.BonusDeVelocidade);
        }
        [TestMethod]
        public void EquipamentoSkyFusionCorredorMedianoTem2DeBonusDeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new SkyFusion(corredor);
            var equipamentoSkyFusion = new SkyFusion(corredor);

            kart.Equipar(equipamentoSkyFusion);


            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(2, equipamentoSkyFusion.BonusDeVelocidade);
        }
        [TestMethod]
        public void EquipamentoSkyFusionCorredorProfissionalTem3DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(corredor);
            var equipamentoSkyFusion = new SkyFusion(corredor);

            kart.Equipar(equipamentoSkyFusion);


            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(3, equipamentoSkyFusion.BonusDeVelocidade);
        }

        [TestMethod]
        public void EquipamentoSkyFusionE9EquipamentoCorredorProfissionalTem18DeBonusDeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(corredor);
            var equipamentoSkyFusion = new SkyFusion(corredor);

            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            equipamentoSkyFusion.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(equipamentoSkyFusion);


            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(18, equipamentoSkyFusion.BonusDeVelocidade);
        }
    }
}
