package br.com.cwi.crescer.aula8.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
@RequestMapping(value = "/")
public class Exemplo {

    @RequestMapping(method = RequestMethod.GET)
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Máicon Loebens" : name);
        return "index";
    }
}
