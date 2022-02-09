package com.fabio.vendas.dtos.requests;

import lombok.Data;

@Data
public class ClienteResquest {

    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
}
