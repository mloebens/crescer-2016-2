using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class SonnarTest
    {

        [TestMethod]
        public void KartSonnarCorredorNoobComKartSonnarSemEquipamentoTem6DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Sonnar(corredor);

            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void KartSonnarCorredorNoobCom1EquipamentoTem11DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Sonnar(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(motor, kart.Equipamentos[0]);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartSonnarCorredorNoobCom2EquipamentoTem13DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Sonnar(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
            Assert.AreEqual(13, kart.Velocidade);
        }

      

        [TestMethod]
        public void KartSonnarCorredorMedianoCom1EquipamentoTem12DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Sonnar(corredor);
            var pneus = new PneusDeCouroDeDragao();

            kart.Equipar(pneus);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(12, kart.Velocidade);
        }
        [TestMethod]
        public void KartSonnarCorredorProfissionalCom2EquipamentosTem18DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new Sonnar(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
            Assert.AreEqual(18, kart.Velocidade);
        }
    }
}
