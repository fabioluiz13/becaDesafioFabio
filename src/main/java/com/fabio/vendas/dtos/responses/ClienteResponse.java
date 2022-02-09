package com.fabio.vendas.dtos.responses;

import lombok.Data;

@Data
public class ClienteResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
}
