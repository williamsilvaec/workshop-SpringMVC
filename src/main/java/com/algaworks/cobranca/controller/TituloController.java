package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by willi on 01/06/2017.
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    Titulos titulos;

    @RequestMapping("/novo")
    public ModelAndView novo() {

        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject(new Titulo());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {

        ModelAndView mv = new ModelAndView("CadastroTitulo");

        if (errors.hasErrors()) {
            return mv;
        }

        titulos.save(titulo);

        mv.addObject("mensagem", "Título salvo com sucesso!");
        return mv;
    }

    @RequestMapping
    public ModelAndView pesquisar(){

        List<Titulo> todosTitulos = titulos.findAll(); // esse método findAll() retorna uma lista com todos os títulos

        ModelAndView mv = new ModelAndView("PesquisaTitulos");
        mv.addObject("titulos", todosTitulos);
        return mv;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo(){

        return Arrays.asList(StatusTitulo.values());
    }
}
