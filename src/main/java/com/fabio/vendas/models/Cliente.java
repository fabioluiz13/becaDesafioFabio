package com.fabio.vendas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "^[A-Z]+(.)*", message = "O campo nome deve começar com letra maiuscula!")
    private String nome;
    @CPF
    @NotBlank(message = "CPF inválido!")
    private String cpf;
    @NotBlank
    private String endereco;

}
