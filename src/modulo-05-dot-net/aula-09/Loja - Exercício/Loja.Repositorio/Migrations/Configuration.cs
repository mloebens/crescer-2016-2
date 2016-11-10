namespace Loja.Repositorio.Migrations
{
    using Dominio;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<Loja.Repositorio.ContextoDeDados>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(Loja.Repositorio.ContextoDeDados context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //

            context.Usuario.AddOrUpdate(
                    u => u.Id,
                    new Usuario { Id = 1, Email = "teste@teste.com", Senha = "8c4fb7bf681156b52fea93442c7dffc9"},
                    new Usuario { Id = 2, Email = "joao@teste.com", Senha = "8c4fb7bf681156b52fea93442c7dffc9" }
                );

            context.Produto.AddOrUpdate(
                p => p.Id,
                new Produto() { Id = 1, Nome = "Ajax", Valor = 2.50M },
                new Produto() { Id = 2, Nome = "Mouse", Valor = 33.50M },
                new Produto() { Id = 3, Nome = "Teclado", Valor = 10M }
                );
        }
    }
}
