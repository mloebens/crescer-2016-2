using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio usuarioRepositorio;
        private IServicoDeCriptografia servicoCriptografia;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio, IServicoDeCriptografia servicoCriptografia)
        {
            this.usuarioRepositorio = usuarioRepositorio;
            this.servicoCriptografia = servicoCriptografia;
        }

        public Usuario BuscarPorAutenticacao(Usuario usuario)
        {
            Usuario usuarioEncontrado = this.usuarioRepositorio.BuscarPorEmail(usuario.Email);

            string senhaCriptografada = this.servicoCriptografia.Criptografar(usuario.Senha);

            if(usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaCriptografada))
            {
                return usuarioEncontrado;
            }

            return null;
        }

        public void InserirUsuario(Usuario usuario)
        {
            ValidarUsuario(usuario);

            //TODO
        }

        private void ValidarUsuario(Usuario usuario)
        {
            bool emailInvalido = usuario.Email.Length < 5;
            if (emailInvalido)
                throw new UsuarioException("E-mail não pode ter menos que 5 caracteres.");

            Usuario usuarioEncontrado = this.usuarioRepositorio.BuscarPorEmail(usuario.Email);
            bool emailJaCadastrado = usuarioEncontrado != null;
            if(emailJaCadastrado)
                throw new UsuarioException("E-mail já cadastrado.")

        }
    }
}
