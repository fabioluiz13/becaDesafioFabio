package com.fabio.vendas.models;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo não informado!")
    private String nome;
    @CPF(message = "Campo inválido!")
    @NotBlank(message = "O campo deve conter CPF válido!")
    private String cpf;
    @NotBlank(message = "O campo deve conter o endereço!")
    private String endereco;
}
