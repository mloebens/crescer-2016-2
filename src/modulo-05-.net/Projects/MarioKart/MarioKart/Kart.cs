﻿using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; set; }

        public List<IEquipamento> Equipamentos { get; set; }

        public int Velocidade {
            get
            {
                int bonusDosEquipamentos = 0;

                foreach (IEquipamento equipamento in this.Equipamentos)
                {
                    bonusDosEquipamentos += equipamento.BonusDeVelocidade;
                }

                int velocidadeTotal = 3 + bonusDosEquipamentos + BonusPorNivelDeHabilidade();

                return velocidadeTotal;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        //Retorna o bônus de velocidade dependendo da habilidade do corredor
        //Caso o corredor seja Profissional, deve acrescentar 1 ponto de velocidade para cada equipamento.
        private int BonusPorNivelDeHabilidade()
        {
            Boolean EhCorredorProfissional = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Profissional;
            int quantidadeDeEquipamentos = this.Equipamentos.Count;
            int bonusNivelHabilidade = (int)this.Corredor.NivelDeHabilidade;

            bonusNivelHabilidade += EhCorredorProfissional ? quantidadeDeEquipamentos : 0;

            return bonusNivelHabilidade;
        }
    }


}
