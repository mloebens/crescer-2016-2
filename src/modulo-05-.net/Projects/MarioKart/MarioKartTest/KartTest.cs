using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {

        [TestMethod]
        public void CorredorSemEquipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);

            Assert.AreEqual(0, kart.Equipamentos.Count);
        }

        [TestMethod]
        public void CorredorCom1Equipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(motor, kart.Equipamentos[0]);
        }

        [TestMethod]
        public void CorredorCom2Equipamento()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
        }

        [TestMethod]
        public void CorredorNoob6DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);

            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void CorredorMedianoComPenusDeCouroDeDragaoTem10DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            kart.Equipar(new PneusDeCouroDeDragao());

            Assert.AreEqual(10, kart.Velocidade);
        }
        [TestMethod]
        public void CorredorProfissionalCom2EquipamentosTem16DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new Kart(corredor);
            kart.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(new MotorABaseDeLava());

            Assert.AreEqual(16, kart.Velocidade);
        }
    }
}
