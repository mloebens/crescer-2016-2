package br.com.cwi.crescer.aula5.filters;

import br.com.cwi.crescer.aula5.utils.UserDetails;

/**
 * @author Carlos H. Nonnemacher
 */
public class UsuarioLogado implements UserDetails {

    private String email;
    private String senha;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
