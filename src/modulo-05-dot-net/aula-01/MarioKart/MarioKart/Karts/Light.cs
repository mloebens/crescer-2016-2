using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                int novaVelocidade = base.Velocidade;
                int bonusCorredorNoob = 3;
                int bonusCorredorProfissional = -1;

                bool corredorNivelNoob = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Noob;
                bool corredorNivelProfissional = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Profissional;

                if (corredorNivelNoob)
                {
                    return novaVelocidade += bonusCorredorNoob;
                }
                if (corredorNivelProfissional)
                {
                    return novaVelocidade + bonusCorredorProfissional;
                }

                return novaVelocidade;
            }
        }
    }
}
