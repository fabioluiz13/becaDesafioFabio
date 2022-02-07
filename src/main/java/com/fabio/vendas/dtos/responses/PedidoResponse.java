package com.fabio.vendas.dtos.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoResponse {

    private Long id;
    private LocalDate data;
    private ClienteResponse cliente;

}
