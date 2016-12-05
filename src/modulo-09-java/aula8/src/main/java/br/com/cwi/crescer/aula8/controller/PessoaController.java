package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maicon.loebens
 */
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public Iterable<Pessoa> list(@RequestBody  Pessoa p) {
        pessoaService.inserir(p);
        return pessoaService.list();
    }

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.GET)
    public Iterable<Pessoa> list() {
        return pessoaService.list();
    }
}
