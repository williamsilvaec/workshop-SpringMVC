package com.algaworks.cobranca.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by william on 02/06/2017.
 */
@Entity
@Data
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

}
