﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioAutenticado(string nome, string senha);
    }
}
