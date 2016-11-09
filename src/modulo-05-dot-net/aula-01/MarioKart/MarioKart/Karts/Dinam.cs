using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                //soma o bonus por nivel de habilidade mais uma vez, dobrando assim o valor padrão.
                int novaVelocidade = base.Velocidade + this.BonusPorNivelDeHabilidade;
                
                return novaVelocidade;
            }
        }
    }
}
