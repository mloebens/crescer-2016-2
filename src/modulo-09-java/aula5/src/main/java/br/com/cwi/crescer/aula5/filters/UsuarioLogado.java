package br.com.cwi.crescer.aula5.filters;

import br.com.cwi.crescer.aula5.utils.UserDetails;

/**
 * @author Carlos H. Nonnemacher
 */
public class UsuarioLogado implements UserDetails {

    private String email;
    private String nome;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
