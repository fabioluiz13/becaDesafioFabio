package com.fabio.vendas.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoRequest {


    private LocalDate data;
    private ClienteResquest cliente;

}
