package com.fabio.vendas.errors.handle;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultException {

    private Integer status;
    private String mesagem;
    private LocalDateTime dataHora;
}
