package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class Exemplo {
    
    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(method = RequestMethod.POST)
    String salvar(Pessoa pessoa) {
        pessoaService.inserir(pessoa);
        return "redirect:/";
    }
    @RequestMapping(method = RequestMethod.GET)
    String toIndex(Model model, Pessoa pessoa) {
        model.addAttribute("pessoa", pessoaService.list());
        return "index";
    }
}
