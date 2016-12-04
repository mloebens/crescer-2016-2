package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class UsuarioBean extends AbstractBean<Usuario, Long, UsuarioDao> {

    private UsuarioDao dao;

    @Override
    public UsuarioDao getDao() {
        if (dao == null) {
            dao = new UsuarioDao(this.getEntityManager());
        }
        return dao;
    }
}
