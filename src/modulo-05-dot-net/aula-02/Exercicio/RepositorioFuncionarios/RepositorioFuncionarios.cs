﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo)
                .ThenBy(funcionario => funcionario.Nome)
                .ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            CultureInfo cultura = new CultureInfo("pt-BR");
            return Funcionarios.Where(funcionario =>
                cultura.CompareInfo.IndexOf(funcionario.Nome, nome, CompareOptions.IgnoreCase) >= 0)
                .ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            bool possuiTurno = turnos.Count() > 0;
            if (possuiTurno)
            {
                return Funcionarios.Where(funcionario => 
                    turnos.Any(turno => turno == funcionario.TurnoTrabalho)
                    ).ToList();
            } else
            {
                return Funcionarios;
            }
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            int desvioPadrao = 5;
            int idadeMaxima = idade + desvioPadrao;
            int idadeMinima = idade - desvioPadrao;
              
            return Funcionarios.Where(funcionario => 
            {
                int idadeFuncionario = funcionario.Idade();
                bool idadeValida = idadeFuncionario >= idadeMinima && idadeFuncionario <= idadeMaxima;
                return idadeValida;

            }).ToList();
        }        

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            List<Funcionario> novaListaDeFuncionarios;
            if(turno == null)
            {
                novaListaDeFuncionarios = Funcionarios;
            } else
            {
                novaListaDeFuncionarios = Funcionarios.Where(funcionario => funcionario.TurnoTrabalho == turno).ToList();
            }

            double totalSalarios = novaListaDeFuncionarios.Sum(funcionario => funcionario.Cargo.Salario);
            double mediaSalarios = totalSalarios / novaListaDeFuncionarios.Count();
            return mediaSalarios;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            DateTime dataAtual = DateTime.Now;
            return Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == dataAtual.Month)
                .ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            return Funcionarios.Select(funcionario =>
            (dynamic) new
            {
                NomeFuncionario = funcionario.Nome,
                TituloCargo = funcionario.Cargo.Titulo
            })
            .ToList();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            return Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                .Select(g =>
                (dynamic)new
                {
                    Turno = g.Key,
                    Quantidade = g.Count()
                }
                ).ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            throw new NotImplementedException();
        }
    }
}
