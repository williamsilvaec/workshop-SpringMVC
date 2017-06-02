package com.algaworks.cobranca.model;

import lombok.Data;

/**
 * Created by william on 02/06/2017.
 */
public enum StatusTitulo {
    RECEBIDO("Pendente"),
    PENDENTE("Recebido");

    private String descricao;

    StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
