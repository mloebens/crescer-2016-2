package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maicon.loebens
 */
@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Iterable<Pessoa> list(){
        return pessoaRepository.findAll();
    }
    
    public void inserir(Pessoa pessoa){
        pessoa.setNascimento(new Date());
        pessoaRepository.save(pessoa);
    }
    
}
