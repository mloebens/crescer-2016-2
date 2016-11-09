using StreetFighter.Dominio;
using StreetFighter.Infra;
using System;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorioDB : Repositorio, IUsuarioRepositorio
    {

        public Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario usuario = null;
            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            using (var connection = Conexao())
            {

                connection.Open();
                string sql = $"SELECT idusuario, nome FROM Usuario WHERE nome = @param_nome AND senha = @param_senha";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("@param_nome", nome));
                command.Parameters.Add(new SqlParameter("@param_senha", senhaDeComparacao));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    int idUsuario = Convert.ToInt32(reader["idusuario"]);
                    string nomeUsuario = reader["nome"].ToString();
                    usuario = new Usuario(idUsuario, nomeUsuario);
                }
                connection.Close();
            }
            return usuario;

        }
    }
}
