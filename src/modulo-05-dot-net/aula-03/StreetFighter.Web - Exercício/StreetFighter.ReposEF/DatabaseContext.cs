using StreetFighter.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace StreetFighter.ReposEF
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext() : base("StreetFighterCasaEF")
        {

        }

        public DbSet<Personagem> Personagem { get; set; }
        public DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
