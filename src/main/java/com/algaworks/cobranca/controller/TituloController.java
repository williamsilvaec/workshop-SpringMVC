package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import com.algaworks.cobranca.service.CadastroTituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by willi on 01/06/2017.
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;

    @Autowired
    private CadastroTituloService cadastroTituloService;

    @RequestMapping("/novo")
    public ModelAndView novo() {

        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject(new Titulo());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "CadastroTitulo";
        }

        try {
            cadastroTituloService.salvar(titulo);
            attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
            return "redirect:/titulos/novo";
        } catch (IllegalArgumentException e) {
            errors.rejectValue("dataVencimento",null, e.getMessage());
            return "CadastroTitulo";
        }
    }

    @RequestMapping
    public ModelAndView pesquisar(){

        List<Titulo> todosTitulos = titulos.findAll(); // esse método findAll() retorna uma lista com todos os títulos

        ModelAndView mv = new ModelAndView("PesquisaTitulos");
        mv.addObject("titulos", todosTitulos);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject(titulo);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {

        cadastroTituloService.excluir(codigo);

        attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
        return "redirect:/titulos";
    }

    @RequestMapping(value = "{codigo}/receber", method = RequestMethod.PUT)
    public @ResponseBody String receber(@PathVariable Long codigo) {
        return cadastroTituloService.receber(codigo);
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {

        return Arrays.asList(StatusTitulo.values());
    }
}
