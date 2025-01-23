package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService( PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento savePay(PagamentoDTO pagamentoDTO){
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoDTO.getId());
        pagamento.setPedidoId(pagamentoDTO.getPedidoId());
        pagamento.setFormaPagamento(pagamentoDTO.getFormaPagamento());
        pagamento.setValorPago(pagamentoDTO.getValorPago());
        pagamento.setDataHoraPagamento(pagamentoDTO.getDataHoraPagamento());
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> findPay() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> findPayById(Long id) {
        return pagamentoRepository.findById(id);
    }


    public Pagamento updatePay(Long id, PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = findPayById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado!"));
        pagamento.setFormaPagamento(pagamentoDTO.getFormaPagamento());
        pagamento.setValorPago(pagamentoDTO.getValorPago());
        pagamento.setDataHoraPagamento(pagamentoDTO.getDataHoraPagamento());

        return pagamentoRepository.save(pagamento);
    }

    public void deletePay(Long id){
        pagamentoRepository.deleteById(id);
    }

}
