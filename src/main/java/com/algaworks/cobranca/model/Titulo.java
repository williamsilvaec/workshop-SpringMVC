package com.algaworks.cobranca.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "Descrição é obrigatória")
    @Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres")
    private String descricao;

    @NotNull(message = "Data de vencimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
    @DecimalMax(value= "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

    public Boolean isPendente() {
        return StatusTitulo.PENDENTE.equals(this.status);
    }

}
