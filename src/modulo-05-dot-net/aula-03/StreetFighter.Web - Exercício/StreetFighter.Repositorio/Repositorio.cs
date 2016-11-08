using System.Configuration;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class Repositorio
    {
        private readonly string connectionString;
                
        public Repositorio()
        {
            connectionString = ConfigurationManager.ConnectionStrings["StreetFighterCasa"].ConnectionString;
        }

        protected SqlConnection Conexao()
        {
            return new SqlConnection(connectionString);
        }
    }
}
