using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioDB : Repositorio, IPersonagemRepositorio
    {
        //Listar Personagens
        //Caso nenhum parametro seja passado no filtroNome, retorna todos os personagens
        //Se não, retorna os personagens que contenham o nome passado pelo filtro
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> personagens = new List<Personagem>();

            using (var connection = Conexao())
            {
                connection.Open();
                string sql = $"SELECT idpersonagem, nome, nascimento,altura, peso, origem, golpesespeciais, personagemoculto, imagem FROM Personagem WHERE nome like @param_filtro";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("@param_filtro", $"%{filtroNome}%"));

                SqlDataReader reader = command.ExecuteReader();

                while(reader.Read())
                {
                    personagens.Add(this.ConverterReaderParaPersonagem(reader));
                }
                connection.Close();
            }
                return personagens;
        }

        public Personagem BuscarPersonagem(int id)
        {
            Personagem personagem = null;

            using (var connection = Conexao())
            {
                connection.Open();
                string sql = $"SELECT idpersonagem, nome, nascimento,altura, peso, origem, golpesespeciais, personagemoculto, imagem FROM Personagem WHERE idpersonagem = @param_id";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("@param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    personagem = this.ConverterReaderParaPersonagem(reader);
                }
                connection.Close();
            }
            return personagem;
        }


        //Incluir Personagem
        public void IncluirPersonagem(Personagem personagem)
        {
            IncluirEditarPersonagem(personagem);
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
            IncluirEditarPersonagem(personagem);
        }

        private void IncluirEditarPersonagem(Personagem personagem)
        {
            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = Conexao())
            {
                connection.Open();

                var sql = new StringBuilder();
                var parameters = new List<SqlParameter>();

                if(personagem.Id == 0)
                {
                    sql.Append($"INSERT INTO Personagem VALUES(");
                    sql.Append($"@param_nome,@param_nascimento,@param_altura,@param_peso,@param_origem,@param_golpesespeciais,@param_personagemoculto,@param_imagem)");
                    parameters.Add(new SqlParameter("@param_nome", personagem.Nome));
                    parameters.Add(new SqlParameter("@param_nascimento", personagem.Nascimento));
                    parameters.Add(new SqlParameter("@param_altura", personagem.Altura));
                    parameters.Add(new SqlParameter("@param_peso", personagem.Peso));
                    parameters.Add(new SqlParameter("@param_origem", personagem.Origem));
                    parameters.Add(new SqlParameter("@param_golpesespeciais", personagem.GolpesEspeciais));
                    parameters.Add(new SqlParameter("@param_personagemoculto", personagem.PersonagemOculto));
                    parameters.Add(new SqlParameter("@param_imagem", personagem.Imagem));
                    parameters.Add(new SqlParameter("@param_id", personagem.Id));
                }
                else
                {
                    sql.Append($"UPDATE Personagem SET ");
                    sql.Append($"nome=@param_nome, nascimento=@param_nascimento,altura=@param_altura,peso=@param_peso,");
                    sql.Append($"origem =@param_origem,golpesespeciais=@param_golpesespeciais,personagemoculto=@param_personagemoculto,imagem=@param_imagem ");
                    sql.Append($"WHERE idpersonagem = @param_id");
                    parameters.Add(new SqlParameter("@param_nome", personagem.Nome));
                    parameters.Add(new SqlParameter("@param_nascimento", personagem.Nascimento));
                    parameters.Add(new SqlParameter("@param_altura", personagem.Altura));
                    parameters.Add(new SqlParameter("@param_peso", personagem.Peso));
                    parameters.Add(new SqlParameter("@param_origem", personagem.Origem));
                    parameters.Add(new SqlParameter("@param_golpesespeciais", personagem.GolpesEspeciais));
                    parameters.Add(new SqlParameter("@param_personagemoculto", personagem.PersonagemOculto));
                    parameters.Add(new SqlParameter("@param_imagem", personagem.Imagem));
                    parameters.Add(new SqlParameter("@param_id", personagem.Id));
                }

                var command = new SqlCommand(sql.ToString(), connection);
                foreach (SqlParameter param in parameters)
                {
                    command.Parameters.Add(param);
                }
                command.ExecuteNonQuery();
                connection.Close();
                transaction.Complete();
            }
        }

        //Excluir Personagem
        public bool ExcluirPersonagem(Personagem personagem)
        {
            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = Conexao())
            {
                connection.Open();

                string sql = $"Delete FROM Personagem WHERE idpersonagem = @param_id";
                var command = new SqlCommand(sql.ToString(), connection);
                command.Parameters.Add(new SqlParameter("@param_id", personagem.Id));

                int resultado = command.ExecuteNonQuery();
                bool deletou = resultado > 0 ? true : false;

                connection.Close();
                transaction.Complete();

                return deletou;
            }
        }

        private Personagem ConverterReaderParaPersonagem(SqlDataReader reader)
        {
            return new Personagem(
                Convert.ToInt32(reader["idpersonagem"]),
                reader["nome"].ToString(),
                Convert.ToDateTime(reader["nascimento"]),
                Convert.ToInt32(reader["altura"]),
                Convert.ToDecimal(reader["peso"]),
                reader["origem"].ToString(),
                reader["golpesespeciais"].ToString(),
                Convert.ToBoolean(reader["personagemoculto"]),
                reader["imagem"].ToString());
        }  
    }
}
