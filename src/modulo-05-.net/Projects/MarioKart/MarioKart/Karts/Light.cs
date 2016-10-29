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
                bool corredorNivelHabilidadeNoob = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Noob;
                bool corredorNivelHabilidadeProfissional = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Profissional;

                if (corredorNivelHabilidadeNoob)
                {
                    novaVelocidade += 3;
                } else
                    if (corredorNivelHabilidadeProfissional)
                    {
                        novaVelocidade -= 1;
                    }

                return novaVelocidade;
            }
        }
    }
}
