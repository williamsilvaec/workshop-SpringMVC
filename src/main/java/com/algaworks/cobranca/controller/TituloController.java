package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by willi on 01/06/2017.
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    Titulos titulos;

    @RequestMapping("/novo")
    public String novo() {

        return "CadastroTitulo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Titulo titulo) {

        titulos.save(titulo);

        System.out.println("titulo: "+ titulo.getDescricao());

        return "CadastroTitulo";
    }
}
