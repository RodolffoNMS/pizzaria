package com.zup.pizzaria.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PagamentoDTO {

    private Long id;

    @NotNull(message = "O ID do pedido é obrigatório.")
    private Long pedidoId;

    @NotBlank(message = "A forma de pagamento é obrigatória.")
    private String formaPagamento;

    @NotNull(message = "O valor pago é obrigatório.")
    private double valorPago;

    @JsonFormat(pattern = "HH:mm")
    private LocalDateTime dataHoraPagamento;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, Long pedidoId, String formaPagamento, double valorPago, LocalDateTime dataHoraPagamento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }
}