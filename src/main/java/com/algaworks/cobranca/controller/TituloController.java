package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by willi on 01/06/2017.
 */
@Controller
public class TituloController {

    @RequestMapping("/titulos/novo")
    public String novo() {

        return "CadastroTitulo";
    }
}
