using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class LightTest
    {

        [TestMethod]
        public void CorredorNoobComKartLightSemEquipamentoTem9DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Light(corredor);

            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void CorredorNoobComKartLightCom1EquipamentoTem12DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Light(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(motor, kart.Equipamentos[0]);
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void CorredorNoobComKartLightCom2EquipamentoTem14DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            var kart = new Light(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
            Assert.AreEqual(14, kart.Velocidade);
        }

        [TestMethod]
        public void CorredorMedianoComKartLightCom1EquipamentoTem10DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Light(corredor);
            var pneus = new PneusDeCouroDeDragao();

            kart.Equipar(pneus);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(10, kart.Velocidade);
        }
        [TestMethod]
        public void CorredorProfissionalComKartLightCom2EquipamentosTem15DeVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            var kart = new Light(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(motor, kart.Equipamentos[1]);
            Assert.AreEqual(15, kart.Velocidade);
        }
    }
}
