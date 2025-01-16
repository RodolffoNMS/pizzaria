package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String fomrmaPagamento;
    private double valorPago;
    private LocalDateTime dataHoraPagamento;


    public Pagamento(Long pedidoId, String fomrmaPagamento, double valorPago, LocalDateTime dataHoraPagamento) {
        this.pedidoId = pedidoId;
        this.fomrmaPagamento = fomrmaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public void validarPagamento(double valorPagoTotal){
        if(valorPago < valorPagoTotal){
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
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

    public String getFomrmaPagamento() {
        return fomrmaPagamento;
    }

    public void setFomrmaPagamento(String fomrmaPagamento) {
        this.fomrmaPagamento = fomrmaPagamento;
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
