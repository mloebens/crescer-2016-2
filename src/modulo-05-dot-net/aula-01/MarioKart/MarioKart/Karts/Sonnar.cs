using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return bonusDeEquipamento();
            }
        }

        private int bonusDeEquipamento()
        {
            bool aumentarVelocidade = this.Equipamentos.Count >= 1;
            int novaVelocidade = base.Velocidade += aumentarVelocidade ? 2 : 0;
            return novaVelocidade;
        }
    }
}
